package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 13.02.2021
 */
//@Repository
public class AccidentTypes {
    private final Map<Integer, AccidentType> types = new HashMap<>();

    public AccidentTypes() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public Collection<AccidentType> getAll() {
        return types.values();
    }

    public AccidentType getById(int id) {
        return types.get(id);
    }
}
