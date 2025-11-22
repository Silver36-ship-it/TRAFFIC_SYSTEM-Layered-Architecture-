package trafficSystemPackage.dtos.requests;

import lombok.Data;
import lombok.ToString;

import java.time.Year;

@Data
@ToString
public class VehicleRequest {

    private String vehicleName;
    private String vehicleModel;
    private String productionYear;
    private String vehicleColor;

    private String ownerFullName;
    private String ownerEmail;
    private String chasisNumber;
}
