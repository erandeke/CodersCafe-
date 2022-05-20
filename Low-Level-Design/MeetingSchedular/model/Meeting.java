package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Meeting {
    private long meetingId;
    private List<Atendee> atendeeList;
    User bookedBy;
    int startTime;
    int endTime;


}
