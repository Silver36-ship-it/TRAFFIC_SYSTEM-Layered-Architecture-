package services;

import data.models.Vehicle;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;
import static utils.Mapper.map;

public class VehicleServicesImpl implements VehicleServices {
    private final VehicleRepository vehicles;

    public VehicleServicesImpl(VehicleRepository vehicles){
        this.vehicles = vehicles;
    }

    @Override
    public VehicleResponse registerVehicle(VehicleRequest request) {
        if(vehicles.findByChasisNumber(request.getChasisNumber()) != null){
            throw new IllegalArgumentException("Vehicle already exist");
        }
       Vehicle vehicle = map(request);
        this.vehicles.save(vehicle);
        return new VehicleResponse();

    }
}
