package com.atendimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Psicologo {
    private String id;
    private String idUsuario;
    private String nome;
    private String crp;
    private String especialidade;
}