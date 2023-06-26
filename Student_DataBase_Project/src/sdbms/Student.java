package sdbms;

public class Student {
	// 4 private Data Members -> id, age, name, marks
	// constructor -> id has to be auto-generated
	// 3 setter & 4 getter 
	// toString() -> Id:101 Age:22 Name:Tom Marks:23

	private String id;
	private int  age;
	private String name;
	private int marks;
	static int count=101;
	public Student( int age, String name, int marks) {

		this.id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student.count = count;
	}
	@Override
	public String toString() {
		return "Id: "  +id+  "Age: "  +age+  "Name: "  +name+  "Marks: "  +marks ;
	}

}
