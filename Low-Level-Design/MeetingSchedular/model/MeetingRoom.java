package model;

import lombok.Data;

@Data
public class MeetingRoom {

    private Calendar calendar;

    public boolean checkAvailabilityForMeetingRooms(int start, int end) {
        return calendar.checkAvailableMeetingRooms(start, end);
    }

    public Meeting scheduleMeeting(int start, int end, User user) {
        return calendar.scheduleMeeting(start, end, user);
    }


}
