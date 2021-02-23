package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;

import java.util.Collection;
import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
@Service
public class AccidentService {
    private final AccidentHibernate store;

    public AccidentService(AccidentHibernate store) {
        this.store = store;
    }

    public Collection<AccidentType> getALlTypes() {
        return store.getAll(AccidentType.class);
    }

    public Collection<Rule> getAllRules() {
        return store.getAllRules();
    }

    public List<Accident> getAllAccidents() {
        return store.getAllAccidents();
    }

    public void addAccident(Accident acc, String[] ruleIds) {
        for (String idStr: ruleIds) {
            Rule rule = store.findById(Rule.class, Integer.parseInt(idStr));
            System.out.println("Rule: " + rule);
            acc.addRule(rule);
        }
        System.out.println("\n\n\n\nACCIDENT:\n" + acc + "\n\n\n\n\n");
        store.save(acc);
    }

    public Accident getAccidentById(int id) {
        return store.findById(Accident.class, id);
    }

    public void updateAccident(Accident acc) {
        store.update(acc);
    }

}
