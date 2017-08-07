package my.restaurant.booking.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.TableBooking;
import my.restaurant.booking.service.DAOManager;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@WebServlet(urlPatterns = { "/restaurantBooking"})
public class BookingServlet extends HttpServlet{
    
    @Inject DAOManager daoManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //getting data for the form
        this.manageRequest(request, response);   
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bookingView.jsp");
        
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }
    
    private void manageRequest(HttpServletRequest request, HttpServletResponse response){
        this.selectCity(request, response);
        Enumeration params = request.getParameterNames(); 
        
        while(params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            switch(paramName) {
                case "selectCity" : this.selectRestaurant(request, response);
                                    System.out.println(paramName);
                                    request.setAttribute("selectCity", request.getParameter("selectCity"));
                                    break;
                case "selectRestaurant" : this.selectBookedTables(request, response);
                                          System.out.println(paramName);
                                          request.setAttribute("selectRestaurant", request.getParameter("selectRestaurant")); 
                                          break;
                case "selectDate" : System.out.println(paramName);
                                    request.setAttribute("selectDate", request.getParameter("selectDate"));
                                    break;
            }
        
        }
    }
    
    private void selectCity(HttpServletRequest request, HttpServletResponse response){
        
        List<City> cityList = null;
        try { 
            cityList = this.daoManager.getAllCities();
        } catch (Exception e) {
            request.setAttribute("errorString", e.getMessage());
        }
        request.getSession().setAttribute("cityList", cityList);
    }
    
    private void selectRestaurant(HttpServletRequest request, HttpServletResponse response){
        
            List<Restaurant> restList = null;
            try{
                restList = this.daoManager.getRestaurantByCity( Long.parseLong(request.getParameter("selectCity")));
            } catch (Exception e) {
                request.setAttribute("errorString", e.getMessage());
            }
            request.getSession().setAttribute("restList", restList);
       
    }
    
    private void selectBookedTables(HttpServletRequest request, HttpServletResponse response){
        if( !request.getParameter("selectDate").equals("") ) {
            
            List<TableBooking> tableBookings = null;
            try{
                tableBookings = this.daoManager.getTableBookingOfRestaurantByDate(Long.valueOf(request.getParameter("selectRestaurant")), 
                                                                                 LocalDate.parse(request.getParameter("selectDate")));
            } catch (Exception e){
                request.setAttribute("errorString", e.getMessage());
            }
            request.getSession().setAttribute("tableBookings", tableBookings);
            //System.out.println("Lefutott ...... " + Long.valueOf(request.getParameter("selectCity")) + " " + request.getParameter("selectDate") + " LIST size: " + tableBookings.size());

        }
        
    }
    
}
