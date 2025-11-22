package trafficSystemPackage.data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection ="owners")
public class Owner {
    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;
    private Gender gender;

}

