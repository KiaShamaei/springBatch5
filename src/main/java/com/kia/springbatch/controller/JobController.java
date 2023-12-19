package com.kia.springbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JobController {
    @Autowired
    @Qualifier("productJob")
    private Job productJob;
    @Autowired
    private JobLauncher jobLauncher;

    @GetMapping("/load")
    public ResponseEntity productLoad(){
        try{
            JobParameters parameters = new JobParametersBuilder().addLong("Start-At" ,System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(productJob,parameters);
            return ResponseEntity.ok("job run");

        }catch (Exception e){
            return new ResponseEntity("job error " , HttpStatus.EXPECTATION_FAILED);
        }



    }
 }
