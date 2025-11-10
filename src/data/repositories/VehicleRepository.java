package data.repositories;

import data.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    List<Vehicle> findall();
    void delete(Vehicle  vehicle);
    void deleteAll();
    void deleteById(int id);
    long count();
}
