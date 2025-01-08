package com.example.controle.controller;

import com.example.controle.model.Consulta;
import com.example.controle.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/marcar-consulta")
    public String marcarConsulta(@RequestParam String nome, @RequestParam String email, 
                                 @RequestParam String telefone, @RequestParam String mensagem) {
        Consulta consulta = new Consulta();
        consulta.setNome(nome);
        consulta.setEmail(email);
        consulta.setTelefone(telefone);
        consulta.setMensagem(mensagem);
        
        contatoService.salvarConsulta(consulta);

        return "redirect:/"; // Redireciona para a home após o envio
    }
}
