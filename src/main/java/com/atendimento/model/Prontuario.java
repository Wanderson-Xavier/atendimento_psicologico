package com.atendimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Prontuario {
    private String id;
    private String idSessao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String texto;
    private boolean restrito;
}