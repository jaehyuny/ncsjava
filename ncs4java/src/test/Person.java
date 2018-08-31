package test;

public class Person {

	protected String name;
	private int num;
	private double avg;
	public Person() {
		System.out.println("name = "+name);
		System.out.println("num = "+num);
		System.out.println("avg = "+avg);
	}
	public Person(String name, int num) {
		this.name=name;
		this.num=num;
	}
	public Person(String name, int num, double avg) {
		this.name=name;
		this.num=num;
		this.avg=avg;
	}
	public Person(int num, String name, double avg) {
		this.name=name;
		this.num=num;
		this.avg=avg;
	}
	public static void main(String[] args) {
		Person p = new Person(1000,"hong",100.000);
		int num=p.num;
		String name=p.name;
		double avg=p.avg;
//		p.name="hhhh";
		System.out.println(num+name+avg);
		Student s = new Student("hong",1000,"java");
//		String name="";
//		name="hong_main";
//		System.out.println(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

}
