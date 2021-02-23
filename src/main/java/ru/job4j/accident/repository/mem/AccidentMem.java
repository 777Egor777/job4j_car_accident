package ru.job4j.accident.repository.mem;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.interfaces.AccidentRep;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
//@Repository
public class AccidentMem implements AccidentRep {
    private final Map<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger key = new AtomicInteger(0);

    public AccidentMem() {
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Egor", "dtp", "Saratov"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Ivan", "text", "Moscow"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Nick", "speed", "NY"));
        accidents.put(key.incrementAndGet(), new Accident(key.get(), "Alex", "parking", "Seattle"));
    }

    @Override
    public Accident add(Accident accident) {
        if (accident.getId() == -1) {
            accident.setId(key.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
        return accident;
    }

    @Override
    public Accident get(int id) {
        return null;
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(accidents.values());
    }
}
