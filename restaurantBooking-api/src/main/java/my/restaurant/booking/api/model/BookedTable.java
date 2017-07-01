

package my.restaurant.booking.api.model;

import java.util.Objects;



/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */

public class BookedTable {

    private final Long id;
    private final Booking booking;
    private final Table table;

    public BookedTable(Long id, Booking booking, Table table) {
        this.id = id;
        this.booking = booking;
        this.table = table;
    }

    public Long getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.booking);
        hash = 53 * hash + Objects.hashCode(this.table);
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
        final BookedTable other = (BookedTable) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.booking, other.booking)) {
            return false;
        }
        return Objects.equals(this.table, other.table);
    }

    @Override
    public String toString() {
        return "BookedTable{" + "id=" + id + ", booking=" + booking + ", table=" + table + '}';
    }



}
