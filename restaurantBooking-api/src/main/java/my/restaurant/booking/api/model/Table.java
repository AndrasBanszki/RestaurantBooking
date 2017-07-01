

package my.restaurant.booking.api.model;

import java.util.Objects;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */

public class Table {

    private final Long id;
    private final int numberOfSeats;
    private final Restaurant restaurant;

    public Table(Long id, int numberOfSeats, Restaurant restaurant) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.numberOfSeats;
        hash = 67 * hash + Objects.hashCode(this.restaurant);
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
        if (this.numberOfSeats != other.numberOfSeats) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.restaurant, other.restaurant);
    }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", numberOfSeats=" + numberOfSeats + ", restaurant=" + restaurant + '}';
    }

 
}
