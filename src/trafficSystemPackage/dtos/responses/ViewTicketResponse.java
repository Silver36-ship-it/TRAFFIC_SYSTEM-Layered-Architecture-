package trafficSystemPackage.dtos.responses;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@ToString
public class ViewTicketResponse {
    private String ticketId;
    private String vehicle;
    @CreatedDate
    private Instant createdDate;
    private String offence;
    private String hasPaid;
    private int amountPaid;
    private String officerName;


}
