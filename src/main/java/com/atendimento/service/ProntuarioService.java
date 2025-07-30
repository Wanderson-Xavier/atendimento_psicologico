package com.atendimento.service;

import com.atendimento.exceptionsApp.AtendimentoPsicologicoException;
import com.atendimento.model.Prontuario;
import com.atendimento.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public Prontuario preencher(String idSessao, String texto, boolean restrito) {
        Prontuario prontuario = new Prontuario();
        prontuario.setIdSessao(idSessao);
        prontuario.setTexto(texto);
        prontuario.setRestrito(restrito);
        prontuarioRepository.save(prontuario);
        return prontuario;
    }

    public List<Prontuario> listar(String idSessao) {
        List<Prontuario> prontuarios = prontuarioRepository.findProntuarioByIdSessao(idSessao);

        if (prontuarios.isEmpty()) {
            throw new AtendimentoPsicologicoException("Agenda não encontrada para o psicólogo", HttpStatus.NOT_FOUND.value());
        } else {
            return prontuarios;
        }
    }
}
