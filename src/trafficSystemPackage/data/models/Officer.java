package trafficSystemPackage.data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "officers")
public class Officer {
    @Id
    private String id;

    private String name;
    private String rank;
    private String email;

}
