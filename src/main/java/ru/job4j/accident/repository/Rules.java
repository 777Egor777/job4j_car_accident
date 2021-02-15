package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 15.02.2021
 */
@Repository
public class Rules {
    private final Map<Integer, Rule> rules = new HashMap<>();

    public Rules() {
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }

    public Collection<Rule> getAll() {
        return rules.values();
    }

    public Rule getById(int id) {
        return rules.get(id);
    }
}
