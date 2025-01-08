package com.example.controle.controller;

import com.example.controle.model.Tratamento;
import com.example.controle.service.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TratamentoController {

    @Autowired
    private TratamentoService tratamentoService;

    @GetMapping("/tratamentos")
    public String listarTratamentos(Model model) {
        model.addAttribute("tratamentos", tratamentoService.getAllTratamentos());
        return "tratamentos";
    }

    @GetMapping("/tratamento/{id}")
    public String detalhesTratamento(@PathVariable Long id, Model model) {
        Tratamento tratamento = tratamentoService.getTratamentoById(id);
        if (tratamento != null) {
            model.addAttribute("tratamento", tratamento);
            return "tratamento-detalhes"; // Página detalhada
        }
        return "404"; // Página de erro
    }
}
