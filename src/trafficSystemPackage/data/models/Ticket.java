package trafficSystemPackage.data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@ToString
@Document(collection = "tickets")
public class Ticket {
    @Id
    private String id;
    private Vehicle vehicle;
    private Offence offence;
    private Officer issuer;
    @CreatedDate
    private Instant dateOfBooking;

    @CreatedDate
    private String dateOfPayment;
    private boolean settled;

    public void setDateOfBooking(LocalDateTime now) {
    }
}
