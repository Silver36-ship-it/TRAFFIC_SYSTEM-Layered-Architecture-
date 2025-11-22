package trafficSystemPackage.dtos.responses;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Data
@ToString
public class IssueTicketResponse {
    private String id;
    private String offence;
    private int amount;
    private String issuer;
    private String vehicle;
    @CreatedDate
    private Instant issueDate;

}
