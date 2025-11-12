package data.repositories;

import data.models.Vehicle;
import exceptions.AlreadySavedException;
import exceptions.VehicleNotFoundException;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Vehicles implements VehicleRepository {

    static Map<Integer, Vehicle> vehicles = new HashMap<>();
    int nextId = 1;

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            vehicle.setId(nextId++);
        }
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }
    @Override
    public Vehicle findById(int id) {
        Vehicle vehicle = vehicles.get(id);
        if(vehicle == null) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        return vehicle;
    }
    @Override
    public Map<Integer,Vehicle> findall() {
        return vehicles;
    }

    @Override
    public void delete(Vehicle vehicle) {
        if(!vehicles.containsKey(vehicle.getId())) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        vehicles.remove(vehicle.getId());
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public void deleteById(int id) {
        vehicles.remove(id);
    }

    @Override
    public long count() {
        return vehicles.size();
    }
    @Override
    public Vehicle findByChasisNumber(String chassisNumber) {
        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getChasisNumber() != null && vehicle.getChasisNumber().equalsIgnoreCase(chassisNumber)) {
                return vehicle;
            }
        }
        return null;
    }
}
