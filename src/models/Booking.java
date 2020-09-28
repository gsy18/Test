package models;

import java.util.Date;
import java.util.List;

public class Booking {
    int bookedRoomId;
    List<String> participants;
    Date bookingStarttime;
    Date bookingEndtime;

    Booking(int bookedRoomId,
            List<String> participants,
            Date bookingStarttime,
            Date bookingEndtime) {
        this.bookedRoomId = bookedRoomId;
        this.participants = participants;
        this.bookingEndtime = bookingEndtime;
        this.bookingStarttime = bookingStarttime;
    }

    public void setTiming(Date bookingStarttime,
                          Date bookingEndtime) {

        this.bookingEndtime = bookingEndtime;
        this.bookingStarttime = bookingStarttime;

    }

}
