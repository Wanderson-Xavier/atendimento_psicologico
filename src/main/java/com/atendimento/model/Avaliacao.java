package com.atendimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Avaliacao {
  private String id;
  private String idPaciente;
  private String idSessao;
  private String idPsicologo;
  private int nota;
  private String comentario;
}