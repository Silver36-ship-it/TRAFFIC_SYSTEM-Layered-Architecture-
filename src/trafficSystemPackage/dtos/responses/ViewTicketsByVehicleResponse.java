package trafficSystemPackage.dtos.responses;

import trafficSystemPackage.data.models.Ticket;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ViewTicketsByVehicleResponse {
    private String vehicleId;
    private List<Ticket> tickets;

}
