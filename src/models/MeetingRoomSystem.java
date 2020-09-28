package models;

import java.util.*;

public class MeetingRoomSystem {

    Set<Room> meetingRooms;
    public Map<String,Booking> bookingsMap;

    public MeetingRoomSystem(){
        meetingRooms=new HashSet<>();
        bookingsMap=new HashMap<>();
    }

    public void addRooms(Room room){
        meetingRooms.add(room);
    }

    public Set<Integer> checkAndReturnAvailability(List<String>propertiesNeeded,Date neededStartTime,Date neededEndTime, int participantNumber){
        Set<Integer>availableRooms=new HashSet<>();
        for(Room room:meetingRooms )
        {
            if(room.cap>=participantNumber && checkIfSatisfiedAllFeatures(propertiesNeeded,room.properties))
                availableRooms.add(room.id);
        }
        for(String key:bookingsMap.keySet()){
            Booking booking = bookingsMap.get(key);
            Date bookingStarttime=booking.bookingStarttime;
            Date bookingEndtime=booking.bookingEndtime;
            if ((neededStartTime.before(bookingStarttime) && (neededEndTime.after(bookingStarttime))) || (
                    neededStartTime.after(bookingStarttime) && neededStartTime.before(bookingEndtime)
            ))
            {
                availableRooms.remove(booking.bookedRoomId);
            }

        }
        return  availableRooms;
    }

    public boolean checkIfSatisfiedAllFeatures (List<String>requiredProps,List<String>availableProps){
        for(String feature: requiredProps){
            if(!availableProps.contains(feature)){
                return  false;
            }
        }
        return  true;
    }
    public void recheduleBooking(String bookingId,Date stattime,Date endTime,int roomId)
    {
        Booking oldbooking = bookingsMap.get(bookingId);
        oldbooking.bookingStarttime=stattime;
        oldbooking.bookingEndtime=endTime;
        oldbooking.bookedRoomId=roomId;
    }

    public void  doBooking(String bookingId, int roomId, Date stattime, Date endTime , List<String>participants){

        bookingsMap.put(bookingId,new Booking(roomId, participants, stattime,endTime));
    }

    public void cancelBooking(String bookingId)
    {
        bookingsMap.remove(bookingId);
    }
}
