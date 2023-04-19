package com.github.omtcnvs.worker.api.assembler;

public interface AssemblerMapper<RECORD, MODEL> {
    RECORD toRecord(MODEL model);
    MODEL toModel(RECORD record);
}
