package trafficSystemPackage.services;

import org.springframework.stereotype.Service;
import trafficSystemPackage.data.models.Vehicle;
import trafficSystemPackage.data.repositories.VehicleRepository;
import trafficSystemPackage.dtos.requests.VehicleRequest;
import trafficSystemPackage.dtos.responses.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import static trafficSystemPackage.utils.Mapper.map;

@Service
public class VehicleServicesImpl implements VehicleServices {
    @Autowired
    private VehicleRepository vehicles;

    public VehicleServicesImpl(VehicleRepository vehicles){
        this.vehicles = vehicles;
    }


    @Override
    public VehicleResponse registerVehicle(VehicleRequest request) {
        if(vehicles.existsByChasisNumber(request.getChasisNumber())){
            throw new IllegalArgumentException("Vehicle already exist");
        }
       Vehicle vehicle = map(request);
        if(vehicle.getOwner() == null){
            throw new IllegalArgumentException("Owner is null");
        }
        Vehicle vehicleSaved = vehicles.save(vehicle);
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setVehicleId(vehicleSaved.getId());
        vehicleResponse.setOwnerName(vehicleSaved.getOwner().getFullName());
        vehicleResponse.setVehicleFullDetails(vehicleSaved.getName() + " " + vehicleSaved.getModel() + " " + vehicleSaved.getYear());
         return vehicleResponse;
    }
}
