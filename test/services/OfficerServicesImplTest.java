/* package services;

import data.repositories.OfficerRepository;
import dtos.requests.OfficerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServicesImplTest {
    private OfficerRepository officers;
    private OfficerServicesImpl officerServices;

    @BeforeEach
    void setUp() {
        officers = new Officers();
        officerServices = new OfficerServicesImpl(officers);
    }
    @Test
        void testThatOfficersCanCountWhenAdded(){
            OfficerRequest request = new OfficerRequest();
            officerServices.registerOfficer(request);
            assertEquals(1, officers.count());
    }
} */