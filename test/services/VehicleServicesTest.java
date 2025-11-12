package services;

import data.models.Vehicle;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.VehicleRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleServicesTest {
    VehicleServicesImpl vehicleServices;
    VehicleRepository vehicles;

    @BeforeEach
    void setUp() {
        vehicles = new Vehicles();
        vehicleServices = new VehicleServicesImpl(vehicles);}

    @Test
        void testThatVehicleCanCountOne(){
         VehicleRequest request = new VehicleRequest();
         vehicleServices.registerVehicle(request);
         assertEquals(1, vehicles.count());
    }
    @Test
       void testThatVehicleCanBeFoundByChasisNumber(){
        VehicleRequest request = new VehicleRequest();
        request.setChasisNumber("chasisNumber");
        vehicleServices.registerVehicle(request);

        Vehicle found = vehicles.findByChasisNumber("chasisNumber");
        assertEquals("chasisNumber", found.getChasisNumber());
    }
    @Test
        void testThatVehicleCanStillCountOneForTheSameVehicle(){
            VehicleRequest request = new VehicleRequest();
        request.setChasisNumber("chasisNumber");
        request.setChasisNumber("chasisNumber1");
            vehicleServices.registerVehicle(request);

            assertThrows(IllegalArgumentException.class, () -> vehicleServices.registerVehicle(request));
          assertEquals(1, vehicles.count());
    }


}