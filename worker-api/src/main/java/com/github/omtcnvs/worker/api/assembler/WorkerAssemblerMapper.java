package com.github.omtcnvs.worker.api.assembler;

import com.github.omtcnvs.worker.api.model.Worker;
import com.github.omtcnvs.worker.api.record.WorkerRecord;
import org.springframework.stereotype.Component;

@Component
public class WorkerAssemblerMapper implements AssemblerMapper<WorkerRecord, Worker> {


    @Override
    public WorkerRecord toRecord(Worker worker) {
        throw new UnsupportedOperationException("Método não implementado.");
    }

    @Override
    public Worker toModel(WorkerRecord workerRecord) {
        return Worker.builder()
                .name(workerRecord.name())
                .dailyIncome(workerRecord.dailyIncome())
                .ativo(true)
                .build();
    }
}
