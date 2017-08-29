package my.restaurant.booking.service;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.api.model.TableBooking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookingServices {

    public static void manageRequest(HttpServletRequest request, HttpServletResponse response, DAOManager daoManager) {
        selectCity(request, response, daoManager);
        Enumeration params = request.getParameterNames();

        while (params.hasMoreElements()) {
            String paramName = (String) params.nextElement();
            System.out.println(paramName + request.getParameter(paramName));
            switch (paramName) {
                case "selectCity":

                    selectRestaurant(request, response, daoManager);
                    request.setAttribute("selectCity", request.getParameter("selectCity"));
                    break;
                case "selectRestaurant":

                    selectBookedTables(request, response, daoManager);
                    request.setAttribute("selectRestaurant", request.getParameter("selectRestaurant"));
                    break;
                case "selectDate":

                    selectRestaurantTables(request, response, daoManager);
                    request.setAttribute("selectDate", request.getParameter("selectDate"));
                    break;
                case "selectTime":

                    request.setAttribute("selectTime", request.getParameter("selectTime"));
                    break;
                case "selectTable":

                    request.setAttribute("selectTable", request.getParameter("selectTable"));
                    break;
            }
        }
    }

    private static void selectCity(HttpServletRequest request, HttpServletResponse response, DAOManager daoManager) {

        List<City> cityList = null;
        try {
            cityList = daoManager.getAllCities();
        } catch (Exception e) {
            request.setAttribute("errorString", e.getMessage());
        }
        request.setAttribute("cityList", cityList);
    }

    private static void selectRestaurant(HttpServletRequest request, HttpServletResponse response, DAOManager daoManager) {
        if (!request.getParameter("selectCity").equals("0")) {
            List<Restaurant> restList = null;
            try {
                restList = daoManager.getRestaurantByCity(Long.parseLong(request.getParameter("selectCity")));
            } catch (Exception e) {
                request.setAttribute("errorString", e.getMessage());
            }
            request.setAttribute("restList", restList);
        }
    }

    private static void selectBookedTables(HttpServletRequest request, HttpServletResponse response, DAOManager daoManager) {
        if (!request.getParameter("selectDate").equals("")) {
            List<TableBooking> tableBookings = null;
            try {
                tableBookings = daoManager.getTableBookingOfRestaurantByDate(Long.valueOf(request.getParameter("selectRestaurant")),
                        LocalDate.parse(request.getParameter("selectDate")));
            } catch (Exception e) {
                request.setAttribute("errorString", e.getMessage());
            }
            request.setAttribute("tableBookings", tableBookings);
        }
    }

    private static void selectRestaurantTables(HttpServletRequest request, HttpServletResponse response, DAOManager daoManager) {
        List<Table> tables = null;
        try {
            tables = daoManager.getTablesByRestId(Long.valueOf(request.getParameter("selectRestaurant")));
        } catch (Exception e) {
            request.setAttribute("errorString", e.getMessage());
        }
        request.setAttribute("restTables", tables);
    }

}
