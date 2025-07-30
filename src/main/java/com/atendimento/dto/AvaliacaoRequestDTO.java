package com.atendimento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AvaliacaoRequestDTO {
    String idPaciente;
    String idSessao;
    int nota;
    String comentario;
}
