package com.spring.ex;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class StepOne implements Tasklet, StepExecutionListener {
	boolean moveToThirdStep = false;
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am inside Step one execute");
		moveToThirdStep = true;
		return RepeatStatus.FINISHED;
	}

	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("I am inside Step One BEfore Step");
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("I am inside Step one After Step");
		if(moveToThirdStep){
			return ExitStatus.FAILED;
		}
		else{
			return ExitStatus.COMPLETED;
		}
	}

}
