package com.cn.lamba;

public class Employees {
	private String name;
	private int salary;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employees(String name, int salary, int id) {
		super();
		this.name = name;
		this.salary = salary;
		this.id = id;
	}
	public  Employees(String name) {
		this.name = name;
	}
	public  Employees() {
	}
	@Override
	public String toString() {
		return "Employees [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}
	
}
