package com.atendimento.model;

import com.atendimento.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Usuario {
    private String id;
    private String email;
    private String senha;
    private TipoUsuarioEnum tipo;
}