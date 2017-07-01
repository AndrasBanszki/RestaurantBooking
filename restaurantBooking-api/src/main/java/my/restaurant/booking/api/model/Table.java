

package my.restaurant.booking.api.model;

import java.util.Objects;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */

public class Table {

    private final long id;
    private final int numberOfSeats;
    private final long restaurantId;

    public Table(long id, int numberOfSeats, long restaurantId) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.restaurantId = restaurantId;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + this.numberOfSeats;
        hash = 47 * hash + (int) (this.restaurantId ^ (this.restaurantId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Table other = (Table) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numberOfSeats != other.numberOfSeats) {
            return false;
        }
        return this.restaurantId == other.restaurantId;
    }



    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", numberOfSeats=" + numberOfSeats + ", restaurant=" + restaurantId + '}';
    }

 
}
