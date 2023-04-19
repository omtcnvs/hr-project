package com.github.omtcnvs.worker.api.controller;

import com.github.omtcnvs.worker.api.record.DetailedWorkerRecord;
import com.github.omtcnvs.worker.api.record.WorkerRecord;
import com.github.omtcnvs.worker.api.record.crud.responses.SaveResponseRecord;
import com.github.omtcnvs.worker.api.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.created(uriBuilder.path("v1/workers/{id}").buildAndExpand(workerSaved.id()).toUri())
                .body(SaveResponseRecord.builder()
                .success(true)
                .workerSaved(workerSaved)
                .build());
    }

}
