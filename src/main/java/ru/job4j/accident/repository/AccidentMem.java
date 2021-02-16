package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
//@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger key = new AtomicInteger(0);

    public AccidentMem() {
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Egor", "dtp", "Saratov"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Ivan", "text", "Moscow"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Nick", "speed", "NY"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Alex", "parking", "Seattle"));
    }

    public Collection<Accident> getAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        if (accident.getId() == -1) {
            accident.setId(key.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
