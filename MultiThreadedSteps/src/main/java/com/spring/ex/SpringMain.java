package com.spring.ex;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		String[] str = { "jobConfig.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(str);
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		Job job = (Job) ctx.getBean("dummyJob");
		try {
			JobParametersBuilder jobBuilder = new JobParametersBuilder();
			JobExplorer jobExplorer = (JobExplorer) ctx.getBean("jobExplorer");
			Optional<JobInstance> oldInstance = jobExplorer
					.getJobInstances(job.getName(), 0, 1).stream().findFirst();
			if (oldInstance.isPresent()) {
				JobInstance instance = oldInstance.get();
				if (instance != null) {
					List<JobExecution> exList = jobExplorer
							.getJobExecutions(instance);
					JobExecution je = exList.get(0);
					System.out.println("LAST EXEUTION STATUS:"
							+ je.getExitStatus().getExitCode());
					/* To check if job instance is having status as FAILED */
					if (je.getExitStatus().getExitCode()
							.equalsIgnoreCase("FAILED")) {
						System.out
								.println("LAST EXECUTION WAS UNSCUCCESSFUL SO EXECUTING THE JOB FROM THE FAILED STEP");
						jobBuilder.addString("Date", je.getJobParameters()
								.getString("Date"));
					} else {// This block will execute when the job last
							// execution was successful
						System.out
								.println("EXECUTING THE JOB FROM THE FIRST STEP");
						jobBuilder.addString("Date", (new Date()).toString());
					}
				}
			} else {// This block will execute if the job is running for the
					// first time
				jobBuilder.addString("Date", (new Date()).toString());
			}
			//List<JobExecution> exList = jobExplorer.getJobExecutions(instance);
			// JobExecution je = exList.get(0);
			// System.out.println(je.getJobParameters().getString("Date"));
			JobParameters jobParams = jobBuilder.toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParams);
			System.out.println("Job Execution Status: " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((ClassPathXmlApplicationContext) ctx).close();
		}
	}

}
