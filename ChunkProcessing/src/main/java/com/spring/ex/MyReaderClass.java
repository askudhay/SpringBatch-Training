package com.spring.ex;

import java.util.List;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyReaderClass implements ItemReader<String>, ItemReadListener<String> {
	private List<String> Legends;
	public List<String> getLegends() {
		return Legends;
	}

	public void setLegends(List<String> legends) {
		Legends = legends;
	}

	private int legenNo = 0;
	private String legendName;

	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if (legenNo < Legends.size()) {
			legendName = Legends.get(legenNo++);			
			return legendName;
		}else{
			return null;
		}
		
	}

	public void beforeRead() {
		// TODO Auto-generated method stub
		System.out.println("In Before Raad: " + legendName);
	}

	public void afterRead(String item) {
		// TODO Auto-generated method stub
		System.out.println("In After Raad: " + legendName);
	}

	public void onReadError(Exception ex) {
		// TODO Auto-generated method stub
		
	}

}
