

package my.restaurant.booking.api.model;

import java.util.Objects;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TableBooking {
    
    private final long id;
    private final Table table;
    private final Booking booking;

    public TableBooking(long id, Table table, Booking booking) {
        this.id = id;
        this.table = table;
        this.booking = booking;
    }

    public long getId() {
        return id;
    }

    public Table getTable() {
        return table;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.table);
        hash = 17 * hash + Objects.hashCode(this.booking);
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
        final TableBooking other = (TableBooking) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.table, other.table)) {
            return false;
        }
        if (!Objects.equals(this.booking, other.booking)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TableBooking{" + "id=" + id + ", table=" + table + ", booking=" + booking + '}';
    }
    

}
