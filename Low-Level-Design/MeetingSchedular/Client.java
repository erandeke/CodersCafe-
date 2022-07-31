import model.Calendar;
import model.Meeting;
import model.MeetingRoom;
import model.User;
import schedular.MeetingSchedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        MeetingRoom meetingRoom = new MeetingRoom();
        Calendar calendar = new Calendar();
        User user = new User(1, "erande.kedar@gmail.com");


        //get the meetingList booked

        List<Meeting> meetingList = new ArrayList<>();
        meetingList.add(new Meeting(1, null, user, 8, 9));
        meetingList.add(new Meeting(2, null, user, 9, 10));
        meetingList.add(new Meeting(3, null, user, 10, 12));

        calendar.setMeetingList(meetingList);


        for (Meeting meeting : calendar.getMeetingList()) {
            System.out.println("Meeting started:" + " " + meeting.getStartTime());
            System.out.println("Meeting ended" + " " + meeting.getEndTime());
            System.out.println("Meeting booked-by" + " " + meeting.getBookedBy());
        }

        MeetingSchedular meetingSchedular = new MeetingSchedular();
        meetingSchedular.setMeetingRooms(Arrays.asList(MeetingRoom.builder().meetingRoomId(1).meetingList(meetingList).calendar(calendar).build()));
        Meeting meeting = meetingSchedular.bookMeetingRoom(12, 13, user);
        System.out.println("Meeting booked successfully at"  + meeting.getStartTime());


    }
}
