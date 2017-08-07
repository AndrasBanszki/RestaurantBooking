
package my.restaurant.booking.servlet;

import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = { "/restaurantLogin"})
public class LoginServlet extends HttpServlet{
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAOManager daoManager = null;
        List<City> cityList = null;
        List<Restaurant> restList = null;
        
        try {daoManager =  new DAOManager();
             cityList = daoManager.getAllCities();
             restList = daoManager.getAllRestaurants();
        } catch (Exception e) {
            request.setAttribute("errorString", e.getMessage());
        }        
        request.getSession().setAttribute("cityList", cityList);
        request.getSession().setAttribute("restList", restList);
        
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bookingView.jsp");

        dispatcher.forward(request, response);
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }
    
}
