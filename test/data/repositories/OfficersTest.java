package data.repositories;

import data.models.Officer;
import exceptions.OfficerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OfficersTest {

    private Officers officers;
    @BeforeEach
        void setUp() {
        officers = new Officers();
    }
    @Test
        void testThatOfficersCanBeCreated(){
            Officer officer = new Officer(1,"name","rank");
            Officer savedOfficer = officers.save(officer);
            Officer checkOfficer = officers.findById(1);
            assertEquals(savedOfficer,checkOfficer);
    }
    @Test
        void testThatOfficersCanFindAllOfficers(){
            Officer officer = new Officer(1,"name","rank");
            Officer officer1  = new Officer(2,"name","rank");
            Officer officer2  = new Officer(3,"name","rank");
            officers.save(officer);
            officers.save(officer1);
            officers.save(officer2);
            Map<Integer, Officer> checkAll = officers.findall();
            assertEquals(3,checkAll.size());
    }
    @Test
        void testThatOfficersCanBeDeleted(){
        Officer officer = new Officer(1,"name","rank");
        Officer officer1  = new Officer(2,"name","rank");
        officers.save(officer);
        officers.save(officer1);
        officers.delete(officer1);
        assertThrows(OfficerNotFoundException.class, () -> officers.findById(2));
    }
    @Test
        void testThatOfficersCanBeUpdated(){
        Officer officer = new Officer(1,"name","rank");
        Officer officer1  = new Officer(2,"name","rank");
        Officer officer2  = new Officer(2,"fullName","rank");
        officers.save(officer);
        officers.save(officer1);
        officers.save(officer2);
        Officer checkOfficer = officers.findById(2);
        assertEquals(officer2,checkOfficer);
    }
    @Test
        void testThatOfficersAppCanDeleteAll() {
        Officer officer = new Officer(1, "name", "rank");
        Officer officer1 = new Officer(2, "name", "rank");
        Officer officer2 = new Officer(3, "name", "rank");
        officers.save(officer);
        officers.save(officer1);
        officers.save(officer2);
        officers.deleteAll();

        assertEquals(0, officers.count());
    }
}
