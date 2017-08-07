package my.restaurant.booking.servlet;

import java.io.IOException;
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
        this.selectCity(request, response);
        this.selectRestaurant(request, response);
 
        // Storing back the parameters
        request.setAttribute("selectCity", request.getParameter("selectCity"));
        request.setAttribute("selectRestaurant", request.getParameter("selectRestaurant"));
        request.setAttribute("selectDate", request.getParameter("selectDate"));
        
        //write out parameters for development testing
        Enumeration params = request.getParameterNames(); 
        while(params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            System.out.println("Request Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
        }
        Enumeration params2 = request.getSession().getAttributeNames();
        while(params2.hasMoreElements()){
            String paramName = (String)params2.nextElement();
            System.out.println("Session Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
        } 
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bookingView.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
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
    
}
