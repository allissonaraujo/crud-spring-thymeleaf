package com.example.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crudspring.model.Pessoa;
import com.example.crudspring.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Pessoas", pessoaRepository.findAll());
        return "pessoas";
    }

    @GetMapping("/nova")
    public String novaPessoaForm(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "form";
    }
}
