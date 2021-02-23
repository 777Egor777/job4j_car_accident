package ru.job4j.accident.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 16.02.2021
 */
//@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name, description, address) values (?,?,?)",
                accident.getName(), accident.getText(), accident.getAddress());
        return accident;
    }

    public void update(Accident accident) {
        jdbc.update("update accident set name=?, description=?, address=? where id=?",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getId());
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name, description, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("description"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    public Accident findById(int id) {
        return jdbc.query("select name, description, address from accident "
                + "where id=?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(id);
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("description"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                },
                id).get(0);
    }
}
