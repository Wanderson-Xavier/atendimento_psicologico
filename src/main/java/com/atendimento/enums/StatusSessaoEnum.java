package com.atendimento.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusSessaoEnum {
    AGENDADA("Agendada"), CONCLUIDA("Concluída"), CANCELADA("Cancelada");

  private final String status;

}