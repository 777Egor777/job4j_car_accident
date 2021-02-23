package ru.job4j.accident.repository.mem;

import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.interfaces.RuleRep;

import java.util.*;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 15.02.2021
 */
//@Repository
public class Rules implements RuleRep {
    private final Map<Integer, Rule> rules = new HashMap<>();
    private int keyId = 3;

    public Rules() {
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }

    @Override
    public Rule add(Rule rule) {
        if (rule.getId() == 0) {
            rule.setId(++keyId);
        }
        rules.put(rule.getId(), rule);
        return rule;
    }

    @Override
    public Rule get(int id) {
        return rules.get(id);
    }

    @Override
    public List<Rule> getAll() {
        return new ArrayList<>(rules.values());
    }

    public Rule getById(int id) {
        return rules.get(id);
    }
}
