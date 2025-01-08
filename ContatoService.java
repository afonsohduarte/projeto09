package com.example.controle.service;

import com.example.controle.model.Consulta;
import com.example.controle.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void salvarConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
        enviarEmailConfirmacao(consulta);
    }

    private void enviarEmailConfirmacao(Consulta consulta) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(consulta.getEmail());
        message.setSubject("Confirmação de Consulta");
        message.setText("Olá " + consulta.getNome() + ", sua consulta foi agendada com sucesso!");
        message.setFrom("no-reply@santiskin.com");

        mailSender.send(message);
    }
}
