package com.batch.SpringBatchArraylist.controller;

import com.batch.SpringBatchArraylist.entity.Customer;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    Job job;
    @Autowired
    JobLauncher jobLauncher;

    @GetMapping("/runJob")
    public BatchStatus readAndPersistFile() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Map<String, JobParameter> param = new HashMap<>();
        param.put("time", new JobParameter(new Date().getTime()));
        JobParameters jobParameters = new JobParameters(param);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        System.out.println(jobExecution.getStatus());

        while (jobExecution.isRunning()) {
            System.out.println("Running ===>");
        }
        return jobExecution.getStatus();
    }


}
