package data.repositories;

import data.models.Officer;
import exceptions.OfficerNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Officers implements OfficerRepository {
    Map<Integer, Officer> officers = new HashMap<>();
    int nextId = 1;

    @Override
    public Officer save(Officer officer) {
        if (officer.getId() == 0) {
            officer.setId(nextId++);
        }
        officers.put(officer.getId(), officer);
        return officer;
    }

    @Override
    public Officer findById(int id) {
        Officer officer = officers.get(id);
        if(officer == null) {
            throw new OfficerNotFoundException("Officer not found");
        }
        return officer;
    }

    @Override
    public Map<Integer, Officer> findall() {
        return officers;
    }

    @Override
    public void delete(Officer officer) {
        if(!officers.containsKey(officer.getId())){
            throw new OfficerNotFoundException("Officer not found");
        }
        officers.remove(officer.getId());
    }

    @Override
    public void deleteAll() {
        officers.clear();

    }

    @Override
    public void deleteById(int id) {
        officers.remove(id);
    }

    @Override
    public long count() {
        return officers.size();
    }
    @Override
    public Officer findByEmail(String email) {
        for (Officer officer : officers.values()) {
            if(officer.getEmail().equalsIgnoreCase(email)){
                return officer;
            }

        }
        return null;
    }
}
