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

    @GetMapping("/")
    public String listarTratamentos(Model model) {
        List<Tratamento> tratamentos = tratamentoService.buscarTodosTratamentos();
        model.addAttribute("tratamentos", tratamentos);
        return "index";
    }

    @GetMapping("/tratamento/{id}")
    public String detalhesTratamento(@PathVariable Long id, Model model) {
        Tratamento tratamento = tratamentoService.buscarTratamentoPorId(id);
        model.addAttribute("tratamento", tratamento);
        return "tratamento";
    }

    @PostMapping("/contato")
    public String enviarContato(String nome, String email, String mensagem, RedirectAttributes redirectAttributes) {
        // Lógica de envio (e.g., salvar em banco ou enviar email)
        redirectAttributes.addFlashAttribute("message", "Consulta agendada com sucesso!");
        return "redirect:/";
    }
}
