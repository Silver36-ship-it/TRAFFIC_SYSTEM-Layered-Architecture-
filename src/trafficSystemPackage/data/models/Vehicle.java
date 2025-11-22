package trafficSystemPackage.data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Data
@ToString
@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private String id;
    private String name;
    private String model;
    private String year;
    private String color;
    private String plateNumber;
    private Owner owner;
    private String chasisNumber;
    private List<Ticket> tickets = new ArrayList<>();


}
