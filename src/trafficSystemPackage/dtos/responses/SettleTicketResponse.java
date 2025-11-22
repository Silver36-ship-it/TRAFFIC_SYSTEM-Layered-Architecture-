package trafficSystemPackage.dtos.responses;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@ToString
public class SettleTicketResponse {
    private String ticketId;
    private String vehicle;
    private String officer;
    private int amountPaid;
    private String hasPaid;
    @CreatedDate
    private Instant dateSettled;
}
