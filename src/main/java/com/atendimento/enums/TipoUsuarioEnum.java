package com.atendimento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuarioEnum {
    PACIENTE("Paciente"), 
    PSICOLOGO("Psicológo");

    private final String tipo;

}