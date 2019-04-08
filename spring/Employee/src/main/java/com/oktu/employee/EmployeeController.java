package com.oktu.employee;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String submit(Locale locale, Model model) {
        return "employee";
    }

    private Map<Long, Employee> employeeMap = new HashMap<>();

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "employee";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());

        employeeMap.put(employee.getId(), employee);
        
        return "employeeView";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

}
