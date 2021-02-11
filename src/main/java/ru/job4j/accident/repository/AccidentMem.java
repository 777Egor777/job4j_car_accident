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
    private int curKey = 0;

    private AccidentMem() {
        accidents.put(++curKey, new Accident(1, "Egor", "dtp", "Saratov"));
        accidents.put(++curKey, new Accident(2, "Ivan", "text", "Moscow"));
        accidents.put(++curKey, new Accident(3, "Nick", "speed", "NY"));
        accidents.put(++curKey, new Accident(4, "Alex", "parking", "Seattle"));
    }

    private static final class Holder {
        public static final AccidentMem INSTANCE = new AccidentMem();
    }

    public static AccidentMem instOf() {
        return Holder.INSTANCE;
    }

    public Collection<Accident> getAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accident.setId(++curKey);
        accidents.put(accident.getId(), accident);
    }
}
