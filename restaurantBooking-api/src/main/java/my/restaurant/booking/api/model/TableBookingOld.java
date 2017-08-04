

package my.restaurant.booking.api.model;


import java.time.LocalDateTime;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TableBookingOld {
    
    private long tableid;
    private long restTableId;
    private long restaurantId;
    private LocalDateTime date;
    private int duration;
    private int numberOfperson;

    public TableBookingOld(long tableid, long restTableId, long restaurantId, LocalDateTime date, int duration, int numberOfperson) {
        this.tableid = tableid;
        this.restTableId = restTableId;
        this.restaurantId = restaurantId;
        this.date = date;
        this.duration = duration;
        this.numberOfperson = numberOfperson;
    }

    public long getTableid() {
        return tableid;
    }

    public void setTableid(long tableid) {
        this.tableid = tableid;
    }

    public long getRestTableId() {
        return restTableId;
    }

    public void setRestTableId(long restTableId) {
        this.restTableId = restTableId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfperson() {
        return numberOfperson;
    }

    public void setNumberOfperson(int numberOfperson) {
        this.numberOfperson = numberOfperson;
    }

    @Override
    public String toString() {
        return "TableBooking{" + "tableid=" + tableid + ", restTableId=" + restTableId + ", restaurantId=" + restaurantId + ", date=" + date + ", duration=" + duration + ", numberOfperson=" + numberOfperson + '}';
    }

  
    
}
