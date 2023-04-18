package com.github.omtcnvs.worker.api.controller;

import com.github.omtcnvs.worker.api.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;

}
