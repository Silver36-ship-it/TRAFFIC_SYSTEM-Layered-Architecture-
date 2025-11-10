package data.repositories;

import data.models.Vehicle;

import java.util.List;

public class Vehicles implements VehicleRepository {

    @Override
    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle findById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> findall() {
        return List.of();
    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public long count() {
        return 0;
    }
}
