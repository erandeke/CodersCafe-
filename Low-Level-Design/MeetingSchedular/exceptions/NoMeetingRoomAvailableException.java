package exceptions;

public class NoMeetingRoomAvailableException extends RuntimeException {

    String message;

    public NoMeetingRoomAvailableException(String message) {
        super(message);

    }

}
