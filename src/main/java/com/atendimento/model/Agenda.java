package com.atendimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Agenda {
    private String id;
    private String idPsicologo;
    private List<SlotAgenda> slots = new ArrayList<>();
}