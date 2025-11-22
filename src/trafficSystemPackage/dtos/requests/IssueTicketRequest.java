package trafficSystemPackage.dtos.requests;

import trafficSystemPackage.data.models.Offence;
import lombok.Data;
import lombok.ToString;

import java.time.Year;

@Data
@ToString
public class IssueTicketRequest {
    private String vehicleId;
    private String vehicleName;
    private String vehicleModel;
    private String productionYear;
    private String vehicleColor;
    private String vehiclePlateNumber;
    private Offence offence;
    private String officerName;
    private String officerRank;
    private String officerEmail;


}
