package services;

import dtos.requests.VehicleRequest;
import dtos.responses.VehicleResponse;

public interface VehicleServices {
    VehicleResponse registerVehicle(VehicleRequest request);

}
