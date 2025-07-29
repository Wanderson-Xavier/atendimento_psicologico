package com.atendimento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateSlotRequest(
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate data,
        @JsonFormat(pattern = "HH:mm") LocalTime hora
) { }
