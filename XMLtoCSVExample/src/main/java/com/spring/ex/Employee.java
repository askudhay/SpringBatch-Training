package com.spring.ex;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Employee")
public class Employee {
private int empid;

public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}
}
