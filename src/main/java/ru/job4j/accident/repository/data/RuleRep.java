package ru.job4j.accident.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Rule;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 23.02.2021
 */
public interface RuleRep extends CrudRepository<Rule, Integer> {
}
