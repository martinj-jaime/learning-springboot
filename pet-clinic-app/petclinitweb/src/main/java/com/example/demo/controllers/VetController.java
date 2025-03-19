package com.example.demo.controllers;

import com.example.model.Vet;
import com.example.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
// @RequestMapping({ "/vets", "/vets.html" })
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({ "/vets", "/vets.html" })
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> listVetsJson() {
        Set<Vet> vets = vetService.findAll();
       // vets.add(new Vet(1L, "Vet name", "Vet surname"));
        return vets;
    }

}
