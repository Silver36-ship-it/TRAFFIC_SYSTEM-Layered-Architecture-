package data.repositories;

import data.models.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    Map<Integer,Vehicle> findall();
    void delete(Vehicle  vehicle);
    void deleteAll();
    void deleteById(int id);
    long count();
    Vehicle findByChasisNumber(String chasisNumber);
}
