/* package data.repositories;

 import data.models.Owner;
import data.models.Vehicle;
import exceptions.VehicleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class VehiclesTest {
    private Vehicles vehicles;
    @BeforeEach
    void setUp() {
        vehicles = new Vehicles();
    }
    @Test
    void testThatVehiclesAreCreated(){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        Vehicle saveVehicle = vehicles.save(vehicle);
        Vehicle checkVehicle =  vehicles.findById(1);
        assertEquals(saveVehicle,checkVehicle);
        }
    @Test
    void testThatVehiclesCanDelete(){
        Owner owner = new Owner();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.delete(vehicle);
        assertThrows(VehicleNotFoundException.class, ()  -> vehicles.findById(1));
    }
    @Test
    void testThatVehiclesCanFindAll(){
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle();
        Vehicle vehicle4 = new Vehicle();
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        vehicles.save(vehicle2);
        vehicles.save(vehicle3);
        vehicles.save(vehicle4);
        assertEquals(5,vehicles.count());
    }
    @Test
    void testThatVehicleCanDeleteById(){
        Owner owner = new Owner();
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        vehicles.deleteById(2);
        assertThrows(VehicleNotFoundException.class, ()  -> vehicles.findById(2));

    }
    @Test
    void testThatVehicleCanFindById(){
        Owner owner = new Owner();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(3);

        vehicle1.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        Vehicle foundId = vehicles.findById(2);
        assertEquals(vehicle,foundId);
    }
    @Test
        void testThatVehicleCanUpdate(){
        Owner owner = new Owner();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(3);
        vehicle1.setOwner(owner);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(3);
        vehicle2.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        vehicles.save(vehicle2);
        Vehicle foundId = vehicles.findById(3);
        assertEquals(vehicle2,foundId);
    }

} */