package main;
import java.util.*;
import java.io.*;

/*
 * @author arya
 */
/*
 * if (!(file.substring(file.length()-3, file.length()).contentEquals(".mp4"))) System.out.println("Invalid file format");
 */

interface LearningEnv {
	void displayMenu();
	void print();
	String getName();
	int getid();
	void viewLec();
	void viewAssessments();
	void viewComments();
	void addComments();
	void logout();
	
}

public class Backpack{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		List<Instructor> instructorList = new ArrayList<Instructor>();
		List<Student> studentList = new ArrayList<Student>();
		List<Material> material = new ArrayList<Material>();
		List<Material> assessment = new ArrayList<Material>();
		
		do {
			displayMenu();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				for (int i = 0; i < instructorList.size(); i++) {
					instructorList.get(i).print();
				}
				System.out.print("Choose id: ");
				int i_id = sc.nextInt();
				for (int i = 0; i < instructorList.size(); i++) {
					if (instructorList.get(i).getid() == i_id) {
						Instructor I = instructorList.get(i);
						int val=0;
						do {
						System.out.println("Welcome " + I.getName());
						I.displayMenu();
						val = sc.nextInt();
						switch(val) {
						case 1:
							Material M = I.addMaterial();
							material.add(M);
							break;
						case 2:
							Material A = I.addAssessment();
							assessment.add(A);
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						case 6:
							break;
						case 7:
							break;
						case 8:
							break;
						case 9:
							System.out.println("Logging out " + I.getName());
							break;
						default:
							System.out.println("Invalid choice");
							break;
						}
						} while(val!=9);
						break;
					}
				}
				
				break;
			case 2:
				for (int i = 0; i < studentList.size(); i++) {
					studentList.get(i).print();
				}
				System.out.print("Choose id: ");
				int s_id = sc.nextInt();
				for (int i = 0; i < instructorList.size(); i++) {
					if (instructorList.get(i).getid() == s_id) {
						Instructor I = instructorList.get(i);
						int val=0;
						do {
						System.out.println("Welcome " + I.getName());
						I.displayMenu();
						val = sc.nextInt();
						switch(val) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						case 6:
							break;
						case 7:
							System.out.println("Logging out " + I.getName());
							break;
						default:
							System.out.println("Invalid choice");
							break;
						}
						} while(val!=7);
						break;
					}
				}
				break;
			default: 
				System.out.println("Invalid choice");
				break;
			}
		} while(choice!=3);
	}

	public static void displayMenu() {
		System.out.println("Welcome to Backpack\n" + 
				"1. Enter as instructor\n" + 
				"2. Enter as student\n" + 
				"3. Exit");
	}
	
}

class Student implements LearningEnv{
	private String name;
	private int id;
	
	public void print() {
		System.out.println(this.id + " - " + this.name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getid() {
		return this.id;
	}
	
	@Override
	public void displayMenu() {
		System.out.println("STUDENT MENU\n" + 
				"1. View lecture materials\n" + 
				"2. View assessments\n" + 
				"3. Submit assessment\n" + 
				"4. View grades\n" + 
				"5. View comments\n" + 
				"6. Add comments\n" + 
				"7. Logout");
	}
	
	@Override
	public void viewLec() {
		
	}
	
	@Override
	public void viewAssessments() {
		
	}
	
	@Override
	public void viewComments() {
		
	}
	
	@Override
	public void addComments() {
		
	}
	
	@Override
	public void logout() {
		
	}
}

interface Material {
	void display();
}
class Assignment implements Material {
	private int MM;
	private String problem;
	
	Assignment(int marks, String problem) {
		this.MM = marks;
		this.problem = problem;
	}
	public void display() {
		System.out.println("Assignment: " + this.problem + "Max Marks: " + this.MM);
		System.out.println("----------------");
	}
}

class Quiz implements Material {
	private static int MM = 1;
	private String problem;
	
	Quiz(String problem) {
		this.problem = problem;
	}
	public void display() {
		System.out.println("Question: " + this.problem );
		System.out.println("----------------");
	}
}

class Lectureslide implements Material {
	private String title;
	private int count;
	private String[] content;
	private Date date;
	private String instructorName;
	
	public Lectureslide(String title, int num, String[] slides, Instructor I) {
		// TODO Auto-generated constructor stub
		date=java.util.Calendar.getInstance().getTime();  
		this.title = title;
		this.count = num;
		this.content = new String[num];
		System.arraycopy(slides, 0, content, 0, num);
		this.instructorName = I.getName();
	}
	
	public void display() {
		System.out.println("Title: " + this.title);
		for (int i=0; i<this.count; i++) System.out.println("Slide " + i + ": " + content[i]);
		System.out.println("Number of slides: " + this.count);
		System.out.println("Date of upload: " + this.date);
		System.out.println("Uploaded by: " + this.instructorName);
		
	}
}

class Lecturevid implements Material{
	private String title;
	private String file;
	private Date date;
	private String instructorName;
	
	public Lecturevid(String title, String file, Instructor I) {
		// TODO Auto-generated constructor stub
		date=java.util.Calendar.getInstance().getTime();  
		this.title = title;
		this.file = file;
		this.instructorName = I.getName();
	}
	
	public void display() {
		System.out.println("Title: " + this.title);
		System.out.println("Video file: " + this.file);
		System.out.println("Date of upload: " + this.date);
		System.out.println("Uploaded by: " + this.instructorName);
		
	}
	
}

class Instructor implements LearningEnv{
	
	private int id;
	private String name;
	
	public void print() {
		System.out.println(this.id + " - " + this.name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getid() {
		return this.id;
	}
	@Override
	public void displayMenu() {
		System.out.println("INSTRUCTOR MENU\n" + 
				"1. Add class material\n" + 
				"2. Add assessments\n" + 
				"3. View lecture materials\n" + 
				"4. View assessments\n" + 
				"5. Grade assessments\n" + 
				"6. Close assessment\n" + 
				"7. View comments\n" + 
				"8. Add comments\n" + 
				"9. Logout");
	}
	
	public Material addMaterial() {
		Material M;
		int choice, num;
		String title, file;
		String [] slides;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Lecture Slide\n" + 
				"2. Add Lecture Video");
		choice = sc.nextInt();
		
		if (choice==1) {
			System.out.print("Enter topic of slides: "); 
			title = sc.nextLine();
			System.out.print("Enter number of slides: ");
			num = sc.nextInt();
			slides = new String[num];
			System.out.println("Enter content of slides");
			for (int i=0; i<num; i++) {
			System.out.print("Content of slide "+ i + ": "); 
			slides[i] = sc.nextLine(); 
			}
			M = new Lectureslide(title, num, slides, this);
		}
		else {
			System.out.print("Enter topic of video: "); 
			title = sc.nextLine();
			System.out.print("Enter filename of video: ");
			file = sc.nextLine();
			M = new Lecturevid(title, file, this);
		}	
		//error handling missed relating to choice =/= 1,2
		return M;	
	}
	
	public Material addAssessment() {
		// TODO Auto-generated method stub
		Material M;
		int choice, marks;
		String problem;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Assignment\n" + 
				"2. Add Quiz");
		choice = sc.nextInt();
		
		if (choice==1) {
			System.out.print("Enter problem statement: "); 
			problem = sc.nextLine();
			System.out.print("Enter max marks: ");
			marks = sc.nextInt();
			M = new Assignment(marks, problem);
		}
		else {
			System.out.print("Enter quiz question: "); 
			problem = sc.nextLine();
			M = new Quiz(problem);
		}	
		//error handling missed relating to choice =/= 1,2
		return M;

	}
	@Override
	public void viewLec() {
		
	}
	
	@Override
	public void viewAssessments() {
		
	}
	
	@Override
	public void viewComments() {
		
	}
	
	public void addComments() {
		
	}
	
	@Override
	public void logout() {
		
	}
}