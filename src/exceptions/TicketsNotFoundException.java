package exceptions;

public class TicketsNotFoundException extends TrafficSystemException{
    public TicketsNotFoundException(String message) {
        super(message);
    }
}
