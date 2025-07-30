package com.atendimento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProntuarioRequestDTO {
    String idSessao;
    String texto;
    Boolean restrito;
}
