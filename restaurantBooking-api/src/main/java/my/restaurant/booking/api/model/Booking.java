package my.restaurant.booking.api.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class Booking  {
    
    private final long id;
    private final LocalDateTime dateTime;
    private final int duration;
    private final int numberOfPeople;

    public Booking(long id, LocalDateTime dateTime, int duration, int numberOfPeople) {
        
        this.id = id;
        this.dateTime = dateTime;
        this.duration = duration;
        this.numberOfPeople = numberOfPeople;
    }

    public long getId() {
        
        return id;
    }

    public LocalDateTime getDateTime() {
        
        return dateTime;
    }

    public int getDuration() {
        
        return duration;
    }

    public int getNumberOfPeople() {
        
        return numberOfPeople;
    }

    @Override
    public int hashCode() {
        
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.dateTime);
        hash = 47 * hash + this.duration;
        hash = 47 * hash + this.numberOfPeople;
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
        final Booking other = (Booking) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (this.numberOfPeople != other.numberOfPeople) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.dateTime, other.dateTime);
    }

    @Override
    public String toString() {
        
        return "Booking{" + "id=" + id + ", dateTime=" + dateTime + ", duration=" + duration + ", numberOfPeople=" + numberOfPeople + '}';
    }

}
