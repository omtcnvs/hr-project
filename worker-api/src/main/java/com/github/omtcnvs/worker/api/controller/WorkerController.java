package com.github.omtcnvs.worker.api.controller;

import com.github.omtcnvs.worker.api.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.omtcnvs.worker.api.utils.URIConstantsUtils.V1_WORKERS;

@RestController
@RequestMapping(V1_WORKERS)
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;

}
