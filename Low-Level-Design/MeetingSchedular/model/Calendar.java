package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Calendar {

    List<Meeting> meetingList;
    MeetingRoom meetingRoom;
    long count = 1;

    public List<Meeting> getMeetingList() {
        return this.meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    public Calendar() {
        this.meetingList = new ArrayList<>();
    }

    public boolean checkAvailableMeetingRooms(int start, int end) {
        for (Meeting meeting : meetingList) {
            //consider case where meeting is already from 2 to 5 and the request comes for 3 to 4
            if (start < meeting.endTime || start < meeting.startTime) return false;
        }
        return true;
    }


    public Meeting scheduleMeeting(int start, int end, User user) {
        Meeting meeting = Meeting.builder().meetingId(generateId()).startTime(start).endTime(end).bookedBy(user).build();
        meetingList.add(meeting);
        return meeting;
    }


    private long generateId() {
        return count++;

    }

}
