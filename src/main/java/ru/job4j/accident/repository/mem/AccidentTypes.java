package ru.job4j.accident.repository.mem;

import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.interfaces.AccidentTypeRep;

import java.util.*;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 13.02.2021
 */
//@Repository
public class AccidentTypes implements AccidentTypeRep {
    private final Map<Integer, AccidentType> types = new HashMap<>();
    private int keyId = 3;

    public AccidentTypes() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    @Override
    public AccidentType add(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(++keyId);
        }
        types.put(accidentType.getId(), accidentType);
        return accidentType;
    }

    @Override
    public AccidentType get(int id) {
        return types.get(id);
    }

    @Override
    public List<AccidentType> getAll() {
        return new ArrayList<>(types.values());
    }
}
