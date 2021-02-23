package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.interfaces.AccidentRep;

import java.util.List;
import java.util.function.Function;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 16.02.2021
 */
//@Repository
public class AccidentHibernate implements AccidentRep {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    private <T> T tx(Function<Session, T> func) {
        T result = null;
        Session session = sf.openSession();
        result = func.apply(session);
//        try (Session session = sf.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            try {
//                result = func.apply(session);
//                transaction.commit();
//            } catch (Exception ex) {
//                transaction.rollback();
//                throw new IllegalStateException("Exception during transaction", ex);
//            }
//        }
        return result;
    }

    public <T> List<T> getAll(Class<T> cl) {
            return tx(session -> session
                    .createQuery("from " + cl.getName(), cl)
                    .getResultList());
    }

    @Override
    public Accident add(Accident accident) {
        return tx(session -> {
            session.saveOrUpdate(accident);
            return accident;
        });
    }

    @Override
    public Accident get(int id) {
        return tx(session -> session.get(Accident.class, id));
    }

    @Override
    public List<Accident> getAll() {
        return getAll(Accident.class);
    }
}