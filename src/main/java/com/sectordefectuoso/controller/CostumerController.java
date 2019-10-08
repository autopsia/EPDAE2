package com.sectordefectuoso.controller;

import com.sectordefectuoso.model.Costumer;
import com.sectordefectuoso.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CostumerController implements GenericController<Costumer, String>{
    @Autowired
    CostumerService costumerService;

    @GetMapping("/costumers")
    public String getList(Model model) {
        List<Costumer> costumers = costumerService.findAll();
        model.addAttribute("costumers", costumers);
        return "costumer";
    }

    @PostMapping("/costumers/save")
    public String save(Costumer costumer, Model model) {
        costumerService.create(costumer);
        List<Costumer> costumers = costumerService.findAll();
        model.addAttribute("costumers", costumers);
        return "costumer";
    }

    @GetMapping("/costumers/add")
    public String add(Model model) {
        model.addAttribute("costumer", new Costumer());
        return "costumer-add";
    }

    @GetMapping("/costumers/edit/{id}")
    public String getForUpdate(@PathVariable String id, Model model) {
        Costumer currentObject = costumerService.findById(id);
        model.addAttribute("costumer", currentObject);
        return "costumer-edit";
    }

    @PostMapping("/costumers/update/{id}")
    public String update(@PathVariable String id, Costumer costumer, Model model) {
        //Update
        costumerService.update(costumer);

        //list
        List<Costumer> objetos = costumerService.findAll();
        model.addAttribute("costumers", objetos);
        return "costumer";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(Costumer customer,
                               Model model) {
        costumerService.register(customer);
        return "index";
    }

    @PostMapping("/customers/login")
    public String loginCustomer(Costumer customer,
                                Model model) {
        Costumer currentCustomer = costumerService.login(customer.getEmail(), customer.getPassword());
        if(currentCustomer != null){
            return "producto";
        }
        //go home
        return "index";
    }

    @GetMapping("/customers/login")
    public String gotToLogin(Model model){
        model.addAttribute("customer", new Costumer());
        return "login";
    }
    @GetMapping("/costumers/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        Costumer aBorrar = costumerService.findById(id);
        costumerService.delete(aBorrar);
        List<Costumer> costumers = costumerService.findAll();
        model.addAttribute("costumers", costumers);
        return "costumer";
    }
}