package com.github.omtcnvs.worker.api.record;

public record DetailedWorkerRecord (
    Long id,
    String name,
    Double dailyIncome,
    Boolean ativo
) {
}