package test;

public class Student extends Person {
	private String dept;
	
	public Student(String name, int num, String dept) {
		super(name, num);
		this.dept=dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public void print() {
		System.out.println(name);
		System.out.println(getNum());
		System.out.println(dept);
	}
}
