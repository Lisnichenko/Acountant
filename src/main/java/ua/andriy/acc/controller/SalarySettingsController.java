package ua.andriy.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.andriy.acc.entities.SalarySettings;
import ua.andriy.acc.repository.SalarySettingsRepository;

import javax.validation.Valid;

/**
 * Created by andriy on 12/23/16.
 */
@Controller
@RequestMapping(SalarySettingsController.BASE_URL)
public class SalarySettingsController {
    protected static final String BASE_URL = "salarySettings";

    @Autowired
    SalarySettingsRepository salarySettingsR;

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model){
        model.addAttribute("salarySettings", salarySettingsR.findAll());
        return "salary_settings_list";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable(value="id") Long id, Model model){

        SalarySettings salarySettings = salarySettingsR.findOne(id);
        if(salarySettings == null){ salarySettings = new SalarySettings(); }

        model.addAttribute("salarySettings",salarySettings);
        model.addAttribute("url","~/" + BASE_URL);

        return "salary_settings_form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute(value = "salarySettings") SalarySettings salarySettings,
                                   BindingResult result,
                                   Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
        }
        salarySettingsR.save(salarySettings);
        return "redirect:/" + BASE_URL;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") Long id, Model model){

        salarySettingsR.delete(id);

        return "salary_settings_list";
    }


}
