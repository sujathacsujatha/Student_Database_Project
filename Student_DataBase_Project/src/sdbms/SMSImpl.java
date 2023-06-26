package sdbms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class SMSImpl implements StudentManagementSystem  
{
	//SCANNER
	//MAP DB=LINKEDHASGMAP  -->  <ID,STUDENTOBJECT>  --> <STRING,STUDENT>

	Scanner scan=new Scanner(System.in);
	Map<String,Student>db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent()
	// ACCEPT AGE, NAME, MARKS
	// STUDENT OBJECT
	// PUT() --> ID, STD
	// PRINT THE STUDENT ID 

	{
		System.out.println("Enter the Student Age: ");
		int age=scan.nextInt();

		System.out.println("Enter the Student Name: ");
		String name=scan.next();

		System.out.println("Enter the Student Marks: ");
		int marks=scan.nextInt();

		Student std=new Student(age,name,marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully!");
		System.out.println("Student Id is "+std.getId());
	}

	@Override
	public void displayStudent()
	// ACCEPT THE STUDENT ID --> JSP101 OR jsp101 or Jsp101
	// toUpperCase()
	// check if id is present or not
	// if id is present  --> get the value(student object)
	// getAge(), getName().......
	// else
	{
		System.out.println("Enter Student Id: ");
		String id=scan.next();       //String id=scan.next().toUpperCase();
		id=id.toUpperCase();

		if(db.containsKey(id))
		{
			Student std=db.get(id);   // getting value (student object)
			System.out.println("Student Detailes are as Follows");
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
		}
		else 
			// customexception --> StudentNotFoundException
			// invoke if & handle it 
		{
			try {
				String message="Student with the Id"+id+" is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent()
	{
		if(db.size()!=0) {
			System.out.println("Student Records are as follows: ");
			System.out.println("--------------------------------");
			Set<String> keys= db.keySet();   // JSP101 JSP102 JSP103
			for(String key: keys) {
				Student std=db.get(key);
				System.out.println(std) ;  //  System.out.println(db.get(key));
			}
		}
		else 
			// customexception --> StudentNotFoundException
			// invoke if & handle it 
		{
			try {
				String message="Student Database is Empty , Nothing to Display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent()
	//ACCEPT ID & UPPERCASE
	// IF ID IS PRESENT --> db.remove(id)
	// else --> SNFE -> invoke it & handle it 
	{
		System.out.println("Enter Student Id: ");
		String id=scan.next();       //String id=scan.next().toUpperCase();
		id=id.toUpperCase();

		if(db.containsKey(id))
		{
			System.out.println("Student Record Successfully");
			System.out.println(db.get(id));  // getting  std object  and print it    
			db.remove(id);
			System.out.println("Student Record Deleted Successfully!!");
		}
		else 
			// customexception --> StudentNotFoundException
			// invoke if & handle it 
		{
			try {
				String message="Student with the Id"+id+" is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudent()
	{
		if(db.size()!=0) {
			System.out.println("Available Student Records: "+db.size());
			db.clear();
			System.out.println("All the students records deleted Successfully");
		}
		else 
			// customexception --> StudentNotFoundException
			// invoke if & handle it 
		{
			try {
				String message="Student Database is Empty, Nothing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent()
	// Accept Id, convert uppercase
	// if the id is present ,get the value (student object)
	// display 1: Update Age 2: Update Name
	//switch --> setAge() setname()
	//else --> SNFE
	{
		{
			System.out.println("Enter Student Id: ");
			String id=scan.next();       //String id=scan.next().toUpperCase();
			id=id.toUpperCase();

			if(db.containsKey(id))
			{
				Student std=db.get(id);// getting student object
				System.out.println("1:Update Age \n2: Update Name\n3:Update Marks");
				System.out.println("Enter Choice:");
				int choice=scan.nextInt();

				switch (choice) {
				// switch --> setAge() setname()
				case 1:
					System.out.println("Enter Age:");
					int age=scan.nextInt();
					std.setAge(age);     //std.setAge(scan.nextInt());
					System.out.println("Age Updated Successfully");
					break;

				case 2:
					System.out.println("Enter Name:");
					String name=scan.next();
					std.setName(name);     //std.setName(scan.next());
					System.out.println("Name Updated Successfully");
					break;

				case 3:
					System.out.println("Enter Marks:");
					int marks=scan.nextInt();
					std.setMarks(marks);     //std.setMarks(scan.nextInt());
					System.out.println("Marks Updated Successfully");
					break;

				default:
					try
					{
						String message="Invalid Choice , Enter Valid Choice! ";
						throw new InvalidChoiceException(message);
					}
					catch(StudentNotFoundException e) 
					{
						System.out.println(e.getMessage());
					}
				}
			}
			else
			{
				try
				{
					String message="Student with Id "+id+"is not Found!";
					throw new StudentNotFoundException(message);
				}
				catch(StudentNotFoundException e)
				{
					System.out.println(e.getMessage());

				}
			}
		}
	}

	@Override
	public void countStudent()
	{
		System.out.println("Available Student Records: "+db.size());
	}

	@Override
	public void sortStudent()
	{
		// Map into Set --> keys --> keySet()
		// List & ArrayList --> upcasting
		// for each loop to traverse keys
		// --> get the value(student object)& add it into ArrayList
		if (db.size()>=2) {
			Set<String> keys=db.keySet();   // JSP101 JSP102
			List<Student >list =new ArrayList<Student>();
			for(String key:keys) 
			{
				list.add(db.get(key));   // adding student object into list
			}

			System.out.println("1: Sort Student By Id\n2:Sort Student By Age");
			System.out.println("3: Sort Student By Name\n4: Sort Student By Marks");
			System.out.println("Enter Choice:");
			int  choice =scan.nextInt();

			switch (choice)
			{
			case 1: 
				Collections.sort(list,new SortStudentById());
				display(list);
				break;

			case 2: 
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;

			case 3: 
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;

			case 4: 
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;

			default:
				try
				{
					String message="Invalid Choice , Enter Valid Choice! ";
					throw new InvalidChoiceException(message);
				}
				catch(StudentNotFoundException e) 
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else

		{
			try
			{
				String message="No Sufficient Student Records to Sort";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());

			}
		}
	}

	private static void display(List<Student> list)
	{
		for(Student s: list)
		{
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks()
	{
		if(db.size()>=2) {
			Set<String> keys=db.keySet();   // JSP101 JSP102
			List<Student >list =new ArrayList<Student>();
			for(String key:keys) 
			{
				list.add(db.get(key));   // adding student object into list
			}
			Collections.sort(list,new SortStudentByMarks());

			System.out.println(db.size()-1);
		}
		else 
		{
			try
			{
				String message="No Sufficient Student Records to Com[pare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());

			}
		}
	}

	@Override
	public void getStudentWithLowestMarks()
	{
		if(db.size()>=2) {
			Set<String> keys=db.keySet();   // JSP101 JSP102
			List<Student >list =new ArrayList<Student>();
			for(String key:keys) 
			{
				list.add(db.get(key));   // adding student object into list
			}
			Collections.sort(list,new SortStudentByMarks());

			System.out.println(list.get(0));
		}
		else 
		{
			try
			{
				String message="No Sufficient Student Records to Com[pare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());

			}
		}
	}

}




















