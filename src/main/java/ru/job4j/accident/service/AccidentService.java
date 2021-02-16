package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.AccidentTypes;
import ru.job4j.accident.repository.Rules;

import java.util.Collection;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
@Service
public class AccidentService {
    private final AccidentMem mem;
    private final AccidentTypes types;
    private final Rules rules;

    public AccidentService(AccidentMem mem, AccidentTypes types, Rules rules) {
        this.mem = mem;
        this.types = types;
        this.rules = rules;
    }

    public Collection<AccidentType> getALlTypes() {
        return types.getAll();
    }

    public Collection<Rule> getAllRules() {
        return rules.getAll();
    }

    public void addAccident(Accident acc) {
        mem.create(acc);
    }

    public void addTypeToAccident(Accident acc) {
        acc.setType(types.getById(acc.getType().getId()));
    }

    public void setRulesForAccident(Accident accident, String[] ruleIds) {
        for (String idStr: ruleIds) {
            accident.addRule(rules.getById(Integer.parseInt(idStr)));
        }
    }

    public Accident getAccidentById(int id) {
        return mem.findById(id);
    }
}
