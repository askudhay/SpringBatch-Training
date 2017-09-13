package com.spring.ex;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		String[] str = { "jobConfig.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(str);
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		Job job = (Job) ctx.getBean("StepListener");
		try {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
			JobExecution execution = jobLauncher.run(job,jobParameters);
			System.out
					.println("Job Execution Status: " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			((ClassPathXmlApplicationContext) ctx).close();
		}
	}
}
