package com.atendimento.model;

import java.time.LocalDateTime;

import com.atendimento.enums.StatusSessaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Sessao {
    private String id;
    private String idPaciente;
    private String idPsicologo;
    private String idAgenda;
    private String idSlot;
    private LocalDateTime dataHora;
    private StatusSessaoEnum status;
    private String observacoes;
}