package com.santiClinic.controller;

import com.santiClinic.model.Tratamento;
import com.santiClinic.service.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TratamentoController {

    @Autowired
    private TratamentoService tratamentoService;

    // Exibe todos os tratamentos na página inicial
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tratamentos", tratamentoService.listarTratamentos());
        return "index";
    }

    // Exibe detalhes de um tratamento específico
    @GetMapping("/tratamento/{id}")
    public String detalhesTratamento(@PathVariable Long id, Model model) {
        tratamentoService.buscarTratamentoPorId(id).ifPresent(tratamento -> model.addAttribute("tratamento", tratamento));
        return "tratamento";
    }

    // Envia o formulário de contato
    @PostMapping("/contato")
    public String enviarContato(String nome, String email, String mensagem, RedirectAttributes redirectAttributes) {
        // Lógica de processamento do formulário (ex: enviar email)
        redirectAttributes.addFlashAttribute("message", "Consulta agendada com sucesso!");
        return "redirect:/";
    }
}
