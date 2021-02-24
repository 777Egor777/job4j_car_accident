package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
@Service
public class AccidentService {
    private final AccidentRep accidentRep;
    private final AccidentTypeRep accidentTypeRep;
    private final RuleRep ruleRep;
    private final UserRep users;
    private final AuthorityRep auths;

    public AccidentService(AccidentRep accidentRep, AccidentTypeRep accidentTypeRep, RuleRep ruleRep, UserRep users, AuthorityRep auths) {
        this.accidentRep = accidentRep;
        this.accidentTypeRep = accidentTypeRep;
        this.ruleRep = ruleRep;
        this.users = users;
        this.auths = auths;
    }

    @Transactional
    public List<AccidentType> getALlTypes() {
        List<AccidentType> result = new ArrayList<>();
        accidentTypeRep.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public List<Rule> getAllRules() {
        List<Rule> result = new ArrayList<>();
        ruleRep.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public List<Accident> getAllAccidents() {
        List<Accident> result = new ArrayList<>();
        accidentRep.findAll().forEach(result::add);
        return result;
    }
    @Transactional
    public Accident addAccident(Accident acc) {
        return accidentRep.save(acc);
    }

    @Transactional
    public Accident addAccident(Accident acc, String[] ruleIds) {
        for (String idStr: ruleIds) {
            Rule rule = ruleRep.findById(Integer.parseInt(idStr)).orElse(null);
            acc.addRule(rule);
        }
        return addAccident(acc);
    }

    @Transactional
    public Accident getAccidentById(int id) {
        return accidentRep.findById(id).orElse(null);
    }

    @Transactional
    public void saveUser(User user) {
        users.save(user);
    }

    @Transactional
    public Authority findAuthorityByName(String name) {
        return auths.findByAuthority("ROLE_USER");
    }

}
