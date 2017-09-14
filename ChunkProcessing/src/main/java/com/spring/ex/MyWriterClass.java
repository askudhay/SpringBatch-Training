package com.spring.ex;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.ItemWriter;

public class MyWriterClass implements ItemWriter<String>, ItemWriteListener<String> {

	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(items);
	}

	public void beforeWrite(List<? extends String> items) {
		// TODO Auto-generated method stub
		System.out.println("In Before Write ");
	}

	public void afterWrite(List<? extends String> items) {
		// TODO Auto-generated method stub
		System.out.println("In After Write ");
	}

	public void onWriteError(Exception exception, List<? extends String> items) {
		// TODO Auto-generated method stub
		
	}

}
