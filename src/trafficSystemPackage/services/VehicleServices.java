package trafficSystemPackage.services;

import trafficSystemPackage.dtos.requests.VehicleRequest;
import trafficSystemPackage.dtos.responses.VehicleResponse;

public interface VehicleServices {
    VehicleResponse registerVehicle(VehicleRequest request);

}
