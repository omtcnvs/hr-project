package com.github.omtcnvs.worker.api.record.crud.responses;

import com.github.omtcnvs.worker.api.record.DetailedWorkerRecord;
import lombok.Builder;

@Builder
public record SaveResponseRecord(

        Boolean success,
        DetailedWorkerRecord workerSaved

) {
}
