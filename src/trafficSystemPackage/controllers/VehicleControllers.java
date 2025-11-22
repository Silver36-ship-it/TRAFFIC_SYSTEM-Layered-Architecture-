package trafficSystemPackage.controllers;

import trafficSystemPackage.dtos.requests.VehicleRequest;
import trafficSystemPackage.dtos.responses.VehicleResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trafficSystemPackage.services.VehicleServices;

@RestController
@RequestMapping("/vehicle")
public class VehicleControllers {
    private VehicleServices vehicleServices;

    @Autowired
    public VehicleControllers(VehicleServices vehicleServices){
        this.vehicleServices = vehicleServices;
    }
    @PostMapping("/register-vehicle")
    public VehicleResponse vehicle(@RequestBody VehicleRequest vehicleRequest) {
        return vehicleServices.registerVehicle(vehicleRequest);
    }
}
