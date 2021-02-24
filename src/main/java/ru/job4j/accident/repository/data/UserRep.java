package ru.job4j.accident.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.User;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
public interface UserRep extends CrudRepository<User, Integer> {
}
