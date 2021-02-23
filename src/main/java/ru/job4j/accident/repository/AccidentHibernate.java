package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 16.02.2021
 */
@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public <T> T save(T model) {
        try (Session session = sf.openSession()) {
            session.save(model);
            return model;
        }
    }

    public <T> void update(T model) {
        try (Session session = sf.openSession()) {
            session.update(model);
        }
    }

    public <T> List<T> getAll(Class<T> cl) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from " + cl.getName(), cl)
                    .list();
        }
    }

    public List<Accident> getAllAccidents() {
        try (Session session = sf.openSession()) {
            List<Accident> result = session
                    .createQuery("from Accident", Accident.class)
                    .getResultList();
            List<Rule> rules = result.get(0).getRules();
            return result;
        }
    }

    public List<Rule> getAllRules() {
        try (Session session = sf.openSession()) {
            List<Rule> result = session
                    .createQuery("from Rule", Rule.class)
                    .getResultList();
            return result;
        }
    }

    public <T> T findById(Class<T> cl, int id) {
        try (Session session = sf.openSession()) {
            return session.get(cl, id);
        }
    }
}