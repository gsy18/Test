import models.Booking;
import models.MeetingRoomSystem;
import models.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        MeetingRoomSystem meetingRoomSystem=new MeetingRoomSystem();
        Room room1=new Room(0,4, Arrays.asList("VC","Whiteboard"));
        Room room2=new Room(1,4, Arrays.asList(""));
        Room room3=new Room(2,4, Arrays.asList("Whiteboard"));
        meetingRoomSystem.addRooms(room1);
        meetingRoomSystem.addRooms(room2);
        meetingRoomSystem.addRooms(room3);
        Date firstbookingStart=new Date();
        Date firstbookingEnd=Date.from(new Date().toInstant().plusSeconds(30*60));
        System.out.println(meetingRoomSystem.checkAndReturnAvailability(Arrays.asList("VC"),firstbookingStart,firstbookingEnd, 3));

        meetingRoomSystem.doBooking("booking1",0, firstbookingStart,firstbookingEnd, Arrays.asList("p1","p2","p3"));
        meetingRoomSystem.cancelBooking("booking1");
        System.out.println(meetingRoomSystem.checkAndReturnAvailability(new ArrayList<>(),Date.from(new Date().toInstant().plusSeconds(15*60)),Date.from(new Date().toInstant().plusSeconds(60*60)), 3));

    }
}
