package trafficSystemPackage.data.repositories;

import trafficSystemPackage.data.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    boolean existsByChasisNumber(String chasisNumber);
}
