package data.repositories;

import data.models.Gender;
import data.models.Owner;
import data.models.Vehicle;
import exceptions.VehicleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class VehiclesTest {
    private Vehicles vehicles;
    @BeforeEach
    void setUp() {
        vehicles = new Vehicles();
    }
    @Test
    void testThatVehiclesAreCreated(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        Vehicle saveVehicle = vehicles.save(vehicle);
        Vehicle checkVehicle =  vehicles.findById(1);
        assertEquals(saveVehicle,checkVehicle);
        }
    @Test
    void testThatVehiclesCanDelete(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.delete(vehicle);
        assertThrows(VehicleNotFoundException.class, ()  -> vehicles.findById(2));
    }
    @Test
    void testThatVehiclesCanFindAll(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle.setId(3);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        Map<Integer, Vehicle> checkAll = vehicles.findall();
        assertEquals(2,checkAll.size());
    }
    @Test
    void testThatVehicleCanDeleteById(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(3);
        vehicle1.setName("name");
        vehicle1.setModel("model");
        vehicle1.setYear(Year.of(2021));
        vehicle1.setColor("color");
        vehicle1.setPlateNumber("plateNumber");
        vehicle1.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        vehicles.deleteById(2);
        assertThrows(VehicleNotFoundException.class, ()  -> vehicles.findById(2));

    }
    @Test
    void testThatVehicleCanFindById(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setName("name");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(3);
        vehicle1.setName("name");
        vehicle1.setModel("model");
        vehicle1.setYear(Year.of(2021));
        vehicle1.setColor("color");
        vehicle1.setPlateNumber("plateNumber");
        vehicle1.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        Vehicle foundId = vehicles.findById(2);
        assertEquals(vehicle,foundId);
    }
    @Test
        void testThatVehicleCanUpdate(){
        Owner owner = new Owner();
        owner.setFullName("fullName");
        owner.setAddress("address");
        owner.setEmail("email");
        owner.setPhoneNumber("phoneNumber");
        owner.setGender(Gender.MALE);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setName("fuulName");
        vehicle.setModel("model");
        vehicle.setYear(Year.of(2021));
        vehicle.setColor("color");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(3);
        vehicle1.setName("name");
        vehicle1.setModel("model");
        vehicle1.setYear(Year.of(2021));
        vehicle1.setColor("color");
        vehicle1.setPlateNumber("plateNumber");
        vehicle1.setOwner(owner);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(3);
        vehicle2.setName("name");
        vehicle2.setModel("model");
        vehicle2.setYear(Year.of(2021));
        vehicle2.setColor("color");
        vehicle2.setPlateNumber("plateNumber");
        vehicle2.setOwner(owner);
        vehicles.save(vehicle);
        vehicles.save(vehicle1);
        vehicles.save(vehicle2);
        Vehicle foundId = vehicles.findById(3);
        assertEquals(vehicle2,foundId);
    }

}