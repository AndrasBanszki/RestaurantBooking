

package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.City;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IBookingCityDao {

        public List<City> getCities();
}
