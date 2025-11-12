package utils;

import data.models.Owner;
import data.models.Vehicle;
import dtos.requests.VehicleRequest;

public class Mapper {
    public static Vehicle map(VehicleRequest request){
        Vehicle vehicle = new Vehicle();

        vehicle.setName(request.getVehicleName());
        vehicle.setYear(request.getProductionYear());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setChasisNumber(request.getChasisNumber());

        Owner owner = new Owner();
        owner.setFullName(request.getOwnerFullName());
        owner.setEmail(request.getOwnerEmail());
        owner.setPhoneNumber(request.getOwnerPhoneNumber());
        owner.setAddress(request.getOwnerAddress());

        vehicle.setOwner(owner);

        return vehicle;

    }
}
