package trafficSystemPackage.dtos.responses;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class VehicleResponse {
    private String vehicleId;
    private String ownerName;
    private String vehicleFullDetails;

}
