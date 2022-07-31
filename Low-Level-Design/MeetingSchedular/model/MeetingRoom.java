package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.support.ManagedList;
import schedular.MeetingSchedular;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MeetingRoom {

    private Calendar calendar;

    private long meetingRoomId;

    private List<Meeting> meetingList;

    public MeetingRoom() {
        this.calendar = new Calendar();
        this.meetingList = new ManagedList<>();
    }

    public boolean checkAvailabilityForMeetingRooms(int start, int end) {
        return calendar.checkAvailableMeetingRooms(start, end);
    }

    public Meeting scheduleMeeting(int start, int end, User user) {
        Meeting meeting = calendar.scheduleMeeting(start, end, user);
        return meeting;
    }

    public void populateMeetingList(Meeting meeting) {
        meetingList.add(meeting);
    }

    public List<Meeting> getTheMeetings() {
        return meetingList;
    }

}
