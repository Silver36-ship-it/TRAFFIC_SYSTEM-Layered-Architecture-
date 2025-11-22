/* package data.repositories;

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
            Officer officer = new Officer();
            officer.setId(1);
            Officer savedOfficer = officers.save(officer);
            Officer checkOfficer = officers.findById(1);
            assertEquals(savedOfficer,checkOfficer);
    }
    @Test
        void testThatOfficersCanFindAllOfficers(){
            Officer officer = new Officer();
            officer.setId(1);
            Officer officer1  = new Officer();
            officer1.setId(2);
            Officer officer2  = new Officer();
            officer2.setId(3);
            officers.save(officer);
            officers.save(officer1);
            officers.save(officer2);
            Map<Integer, Officer> checkAll = officers.findall();
            assertEquals(3,checkAll.size());
    }
    @Test
        void testThatOfficersCanBeDeleted(){
        Officer officer = new Officer();
        officer.setId(1);
        Officer officer1  = new Officer();
        officer.setId(1);
        officers.save(officer);
        officers.save(officer1);
        officers.delete(officer1);
        assertThrows(OfficerNotFoundException.class, () -> officers.findById(2));
    }
    @Test
        void testThatOfficersCanBeUpdated(){
        Officer officer = new Officer();
        officer.setId(1);
        Officer officer1  = new Officer();
        officer.setId(2);
        officer.setName("name");
        Officer officer2  = new Officer();
        officer.setId(2);
        officer.setName("fullName");
        officers.save(officer);
        officers.save(officer1);
        officers.save(officer2);
        Officer checkOfficer = officers.findById(2);
        assertEquals(officer2,checkOfficer);
    }
    @Test
        void testThatOfficersAppCanDeleteAll() {
        Officer officer = new Officer();
        Officer officer1 = new Officer();
        Officer officer2 = new Officer();
        officers.save(officer);
        officers.save(officer1);
        officers.save(officer2);
        officers.deleteAll();

        assertEquals(0, officers.count());
    }
}
*/