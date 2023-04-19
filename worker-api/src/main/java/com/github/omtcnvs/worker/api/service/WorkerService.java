package com.github.omtcnvs.worker.api.service;

import com.github.omtcnvs.worker.api.assembler.WorkerAssemblerMapper;
import com.github.omtcnvs.worker.api.model.Worker;
import com.github.omtcnvs.worker.api.record.DetailedWorkerRecord;
import com.github.omtcnvs.worker.api.record.WorkerRecord;
import com.github.omtcnvs.worker.api.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    private final WorkerAssemblerMapper assembler;

    @Transactional
    public DetailedWorkerRecord save(WorkerRecord workerRecord) {
        Worker workerToSave = this.assembler.toModel(workerRecord);
        Worker workerSaved = this.repository.save(workerToSave);
        return getDetailedWorkerRecord(workerSaved);
    }

    public DetailedWorkerRecord getReferenceById(Long id) {
        Worker workerGot = this.repository.getReferenceById(id);
        return getDetailedWorkerRecord(workerGot);
    }

    private DetailedWorkerRecord getDetailedWorkerRecord(Worker workerSaved) {
        return DetailedWorkerRecord.builder()
                .id(workerSaved.getId())
                .name(workerSaved.getName())
                .dailyIncome(workerSaved.getDailyIncome())
                .ativo(workerSaved.getAtivo())
                .build();
    }
}
