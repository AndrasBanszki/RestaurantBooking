package my.restaurant.booking.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.restaurant.booking.service.BookingServices;
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
        
        BookingServices.manageRequest(request, response, daoManager);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bookingView.jsp");
        
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }
        
}
