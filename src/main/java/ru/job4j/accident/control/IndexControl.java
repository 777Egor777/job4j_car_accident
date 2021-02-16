package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 10.02.2021
 */
@Controller
public class IndexControl {
    private final AccidentHibernate accidents;

    public IndexControl(AccidentHibernate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("acc", accidents.getAll());
        return "index";
    }
}