

package my.restaurant.booking.api.model;

import java.util.Objects;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */

public class Restaurant {

    private final Long id;
    private final String name;
    private final City city;

    public Restaurant(Long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.city);
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
        final Restaurant other = (Restaurant) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.city, other.city);
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", name=" + name + ", city=" + city + '}';
    }

    

}
