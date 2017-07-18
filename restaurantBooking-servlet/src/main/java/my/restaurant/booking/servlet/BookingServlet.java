
package my.restaurant.booking.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.restaurant.booking.service.BookingServices;
import my.restaurant.booking.servlet.htmlformer.FormBuilder;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookingServlet extends HttpServlet {
    
    String title = "Restaurant Booking Services";
    String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
    String head = "<html>\n <head><title> " + title + "</title></head>\n <body>\n";
    
    StringBuilder sb;
    BookingServices bs = new BookingServices();
    FormBuilder fb = new FormBuilder();


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.sb = new StringBuilder();
        response.setContentType("text/html");
        
        int selectedCity = request.getParameter("selectCity") == null ? 0 : Integer.valueOf(request.getParameter("selectCity") );
        int selectedRestaurant = request.getParameter("selectRestaurant") == null ? 0 : Integer.valueOf(request.getParameter("selectRestaurant") );
        String selectedDate = request.getParameter("selectedDate");
        
        sb.append(docType)
          .append(head)
          .append("<h1 align = \"center\">").append(title).append("</h1>\n");
        
        try{
            sb.append(fb.buildForm( bs.getCityes(), selectedCity,
                                    bs.getRestaurants(selectedCity), selectedRestaurant, 
                                    selectedDate,
                                    bs.getBookedTables(selectedRestaurant, selectedDate == null ? LocalDate.now(): LocalDate.parse(selectedDate))));
        } 
        catch( DateTimeParseException dtpEx){
            sb.append(fb.buildForm( bs.getCityes(), selectedCity,
                                    bs.getRestaurants(selectedCity), selectedRestaurant, 
                                    selectedDate,
                                    bs.getBookedTables(selectedRestaurant, null)));
            sb.append("\nSelect a valid Date: Year.Moth.Day!");
        }
        
        sb.append("<h1 align = \"left\"> Selected City: ").append(selectedCity).append("</h1>\n");
        sb.append("<h1 align = \"left\"> Selected Restaurant: ").append(selectedRestaurant).append("</h1>\n");
        sb.append("<h1 align = \"left\"> Selected Date: ").append(selectedDate).append("</h1>\n");
        
        sb.append("</body>\n").append("</html>");

        response.getWriter().write(sb.toString());
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
