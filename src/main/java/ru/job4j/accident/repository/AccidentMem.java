package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident(1, "Egor", "dtp", "Saratov"));
        accidents.put(2, new Accident(2, "Ivan", "text", "Moscow"));
        accidents.put(3, new Accident(3, "Nick", "speed", "NY"));
        accidents.put(4, new Accident(4, "Alex", "parking", "Seattle"));
    }

    public Collection<Accident> getAll() {
        return accidents.values();
    }
}
