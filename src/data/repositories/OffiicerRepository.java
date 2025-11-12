package data.repositories;

import data.models.Officer;
import java.util.Map;

public interface OffiicerRepository {
        Officer save(Officer officer);
        Officer findById(int id);
        Map<Integer,Officer> findall();
        void delete(Officer officer);
        void deleteAll();
        void deleteById(int id);
        long count();

}

