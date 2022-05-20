package model;

import lombok.Data;

import java.util.List;

@Data
public class Calendar {

    List<Meeting> meetingList;
    MeetingRoom meetingRoom;

    public boolean checkAvailableMeetingRooms(int start, int end) {
        for (Meeting meeting : meetingList) {
            //consider case where meeting is already from 2 to 5 and the request comes for 3 to 4
            if (meeting.endTime > start || meeting.startTime < end)
                return false;
        }
        return true;
    }


    public Meeting scheduleMeeting(int start, int end, User user) {
        Meeting meeting = Meeting.builder().meetingId(1).startTime(start).endTime(end).bookedBy(user).build();
        meetingList.add(meeting);
        return meeting;
    }

}
