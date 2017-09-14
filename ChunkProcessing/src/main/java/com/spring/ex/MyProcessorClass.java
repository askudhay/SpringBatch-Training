package com.spring.ex;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.item.ItemProcessor;

public class MyProcessorClass implements ItemProcessor<String, String>, ItemProcessListener<String, String> {
String legnedName;
	public String process(String legend) throws Exception {
		// TODO Auto-generated method stub		 
		legnedName = legend + " is a great legend";
		return legnedName;
	}

	public void beforeProcess(String item) {
		// TODO Auto-generated method stub
		System.out.println("In Before PRocess: " + item);
	}

	public void afterProcess(String item, String result) {
		// TODO Auto-generated method stub
		System.out.println("In After Process: " + item);
	}

	public void onProcessError(String item, Exception e) {
		// TODO Auto-generated method stub
		
	}

}
