package com.github.omtcnvs.worker.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record WorkerRecord(
        @NotBlank(message = "Nome do colaborador(a) não informado.")
        String name,
        @NotNull(message = "Comissão diária do colaborador(a) não informada.")
        Double dailyIncome
) {
}
