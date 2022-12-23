package com.example.warehouse.controller;

import com.example.warehouse.entity.Providers;
import com.example.warehouse.repository.ProvidersRepository;
import com.example.warehouse.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ProvidersController {

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private ProvidersService providersService;


    @GetMapping("/provider/add")
    public String addProvider(Model model){
        Providers providers = new Providers();
        model.addAttribute("provider", providers);
        return "addProvider";
    }

    @PostMapping("/provider/add")
    public String addProviders(@Valid Providers provider,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            Map<String, String> errMap = ControllerUtils.getErrors(bindingResult);

            model.addAttribute("message", provider);
        }else {
            model.addAttribute("message", null);

            providersService.addProvider(provider);
        }

        return "redirect:/orders";
    }




}
