package com.spring.ex;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class StepTwo implements Tasklet {

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am in Step Two !");
		return RepeatStatus.FINISHED;
	}

}
