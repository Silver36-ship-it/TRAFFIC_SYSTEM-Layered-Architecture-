package trafficSystemPackage.dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OfficerResponse {
    private String id;
    private String officerEmail;
    private String officerName;

}
