package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.AccidentTypes;
import ru.job4j.accident.repository.Rules;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 11.02.2021
 */
@Controller
public class AccidentControl {
    private final AccidentMem accidents;
    private final AccidentTypes types;
    private final Rules rules;

    public AccidentControl(AccidentMem accidents, AccidentTypes types, Rules rules) {
        this.accidents = accidents;
        this.types = types;
        this.rules = rules;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types.getAll());
        model.addAttribute("rules", rules.getAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        for (String idStr: ids) {
            accident.addRule(rules.getById(Integer.parseInt(idStr)));
        }
        accident.setType(types.getById(accident.getType().getId()));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.findById(id));
        return "accident/update";
    }
}
