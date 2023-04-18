package com.github.omtcnvs.worker.api.repository;

import com.github.omtcnvs.worker.api.model.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Page<Worker> findByAtivoTrue(Pageable pageable);
}
