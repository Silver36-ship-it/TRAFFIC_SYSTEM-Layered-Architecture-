package exceptions;

public class VehicleNotFoundException extends TrafficSystemException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
