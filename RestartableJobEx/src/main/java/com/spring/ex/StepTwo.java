package com.spring.ex;


import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class StepTwo implements Tasklet, StepExecutionListener{

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am in Step Two !");
		String str = null;
		//str.toCharArray();
		return RepeatStatus.FINISHED;
	}

	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("Inside Step two");
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		return ExitStatus.COMPLETED;
	}

}
