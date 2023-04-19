package com.github.omtcnvs.worker.api.record;

import lombok.Builder;

@Builder
public record DetailedWorkerRecord (
    Long id,
    String name,
    Double dailyIncome,
    Boolean ativo
) {
}