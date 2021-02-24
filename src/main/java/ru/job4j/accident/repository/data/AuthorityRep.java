package ru.job4j.accident.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Authority;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
public interface AuthorityRep extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
