package schedular;

import exceptions.NoMeetingRoomAvailableException;
import lombok.Data;
import model.Meeting;
import model.MeetingHistory;
import model.MeetingRoom;
import model.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class MeetingSchedular {

    public static final Integer MAX_HISTORY = 20;
    List<MeetingRoom> meetingRooms;
    List<MeetingHistory> meetingHistories;




    public Meeting bookMeetingRoom(int start, int end, User user) throws NoMeetingRoomAvailableException {
        //check for availability of meeting rooms;
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.checkAvailabilityForMeetingRooms(start, end)) {
                Meeting meeting = meetingRoom.scheduleMeeting(start, end, user);
                return meeting;


            }
        }
        throw new NoMeetingRoomAvailableException("Rooms are not available for the selected time slot");
    }


    public void saveToHistory(Meeting meeting) {
        if (meetingHistories.size() == MAX_HISTORY) {
            meetingHistories = new ArrayList<>();
        } else {
            meetingHistories.add(new MeetingHistory(meeting));
        }

    }

}
