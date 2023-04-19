package com.github.omtcnvs.worker.api.controller;

import com.github.omtcnvs.worker.api.record.DetailedWorkerRecord;
import com.github.omtcnvs.worker.api.record.WorkerRecord;
import com.github.omtcnvs.worker.api.record.crud.responses.SaveResponseRecord;
import com.github.omtcnvs.worker.api.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.github.omtcnvs.worker.api.utils.URIConstantsUtils.V1_WORKERS;

@RestController
@RequestMapping(V1_WORKERS)
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;

    @PostMapping("/save")
    public ResponseEntity<SaveResponseRecord> saveWorker(@RequestBody @Valid WorkerRecord workerRecord, UriComponentsBuilder uriBuilder) {
        DetailedWorkerRecord workerSaved = this.service.save(workerRecord);
        return handleResponseSave(uriBuilder, workerSaved);
    }

    private static ResponseEntity<SaveResponseRecord> handleResponseSave(UriComponentsBuilder uriBuilder, DetailedWorkerRecord workerSaved) {
        return ResponseEntity.created(uriBuilder.path("/v1/workers/{id}").buildAndExpand(workerSaved.id()).toUri())
                .body(SaveResponseRecord.builder()
                        .success(true)
                        .workerSaved(workerSaved)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedWorkerRecord> getWorkerById(@PathVariable Long id) {
        DetailedWorkerRecord workerGot = this.service.getReferenceById(id);
        return ResponseEntity.ok(workerGot);
    }

}
