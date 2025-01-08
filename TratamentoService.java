package com.example.controle.service;

import com.example.controle.model.Tratamento;
import com.example.controle.repository.TratamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamentoService {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    public List<Tratamento> getAllTratamentos() {
        return tratamentoRepository.findAll();
    }

    public Tratamento getTratamentoById(Long id) {
        return tratamentoRepository.findById(id).orElse(null);
    }
}
