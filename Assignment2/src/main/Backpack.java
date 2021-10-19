package main;
import java.util.*;
/*
 * @author arya
 * @roll number 2020498
 */

interface LearningEnv {
	void displayMenu();
	void print();
	String getName();
	int getid();
	Comment addComments();
	
}

public class Backpack{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		int uni = 0;
		List<Instructor> instructorList = new ArrayList<Instructor>();
		List<Student> studentList = new ArrayList<Student>();
		List<Comment> comments = new ArrayList<Comment>();
		List<LectureMaterial> material = new ArrayList<LectureMaterial>();
		List<Material> assessment = new ArrayList<Material>();
		List<Material> openAssessment = new ArrayList<Material>();
		
		Instructor I0 = new Instructor(0, "I0");
		Instructor I1 = new Instructor(1, "I1");
		instructorList.add(I0);
		instructorList.add(I1);
		
		Student S0 = new Student(0, "S0");
		Student S1 = new Student(1, "S1");
		Student S2 = new Student(2, "S2");
		studentList.add(S0);
		studentList.add(S1);
		studentList.add(S2);
		int size = 3;
		
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
							LectureMaterial M = I.addMaterial();
							if (M!=null) material.add(M);
							break;
						case 2:
							Material [] arr = I.addAssessment(uni);
							uni++;
							assessment.add(arr[0]);
							for (int q =0; q<size; q++) {
								studentList.get(q).addWork(arr[q+1]);
							}
							break;
						case 3:
							for (int j=0; j<material.size(); j++) material.get(j).display();
							break;
						case 4:
							for (int j=0; j<assessment.size(); j++) {
								System.out.print("ID: " + j + " ");
								assessment.get(j).display();
							}
							break;
						case 5:
							System.out.println("List of assessments");
							for (int j=0; j<assessment.size(); j++) {
								System.out.print("ID: " + j + " ");
								assessment.get(j).display();
							}	
							System.out.print("Enter ID of assessment to view submissions: ");
							int id = sc.nextInt();
							int num = assessment.get(id).getid();
							
							System.out.println("Choose ID from these ungraded submissions");
							for (Student s: studentList) s.Ungraded(num);
							int num1 = sc.nextInt();
							for (Student student : studentList) {
								if (student.getid() == num1) {
									System.out.println("Submission");
									student.displaySol(assessment.get(id));
									System.out.println("Max marks: " + assessment.get(id).getMM());
									System.out.print("Marks secured: ");
									int marks = sc.nextInt();
									int num3 = assessment.get(id).getid();
									student.grade(marks, num3);
									break;
								}
							}
							break;
						case 6:
							System.out.println("List of open assessments");
							for (int j=0; j<assessment.size(); j++) {
								System.out.print("ID: " + j + " ");
								if (assessment.get(i).isOpen()) assessment.get(j).display();
							}
							System.out.print("Enter id of assignment to close: ");
							int num2 = sc.nextInt();
							assessment.get(num2).setClose();
							for (Student s: studentList) s.setAssClose(assessment.get(num2).getid());
							break;
						case 7:
							for (int k= 0; k< comments.size(); k++) comments.get(k).display();
							break;
						case 8:
							Comment c = I.addComments();
							comments.add(c);
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
				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).getid() == s_id) {
						Student S = studentList.get(i);
						int val=0;
						do {
						System.out.println("Welcome " + S.getName());
						S.displayMenu();
						val = sc.nextInt();
						switch(val) {
						case 1:
							for (int j=0; j<material.size(); j++) material.get(j).display();
							break;
						case 2:
							for (int j=0; j<assessment.size(); j++) {
								System.out.print("ID: " + j + " ");
								assessment.get(j).display();
							}
							break;
						case 3:
							S.pendingAss();
							break;
						case 4:
							S.viewGrades();
							break;
						case 5:
							for (int k= 0; k< comments.size(); k++) comments.get(k).display();
							break;
						case 6:
							Comment c = S.addComments();
							comments.add(c);
							break;
						case 7:
							System.out.println("Logging out " + S.getName());
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
			case 3:
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

class Comment {
	String statement;
	Date date;
	
	Comment(String person) {
		String comment; 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter comment: ");
		comment = sc.nextLine();
		this.statement = comment + " - " + person;
		this.date = java.util.Calendar.getInstance().getTime(); 
	}
	
	public void display() {
		System.out.println(this.statement);
		System.out.println(this.date + "\n");
	}
}

class Student implements LearningEnv {
	private String name;
	private int id;
	private List<Material> assessment = new ArrayList<Material>();
	
	public Student(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	
	public void grade(int marks, int id) {
		for (Material a: this.assessment) if(a.getid() == id) {
			a.grade(marks);
			break;
		}
	}
	
	public void setAssClose(int id) {
		for (Material a: this.assessment) if (a.getid() == id) {
			a.setClose();
			break;
		}
	}
	
	public void viewGrades() {
		System.out.println("Graded submissions");
		for (Material a: this.assessment) if (a.isSubmitted() && a.isGraded()) a.displayGrades();
		System.out.println("----------------");
		System.out.println("Ungraded submissions");
		for (Material a: this.assessment) if (a.isSubmitted() && !a.isGraded()) System.out.println("Submission:" + a.getsol());
		System.out.println("----------------");
	}
	
	public void displaySol(Material A) {
		for(Material a: this.assessment) if (a.isSubmitted() && a.getid() == A.getid()) System.out.println(a.getsol());
	}
	
	public void Ungraded(int id) {
		for(Material a: this.assessment) if (a.getid() == id && a.isSubmitted() && !a.isGraded()) this.print();
	}
	
	public void pendingAss() {
		boolean flag = false;
		for (int i=0; i<this.assessment.size(); i++) {
			if (!this.assessment.get(i).isSubmitted() && this.assessment.get(i).isOpen()){
				flag = true;
			}
		}
		if (!flag) System.out.println("No pending assignments");
		else {
		System.out.println("Pending assessments");
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<this.assessment.size(); i++) {
			if (!this.assessment.get(i).isSubmitted() && this.assessment.get(i).isOpen()){
			System.out.print("ID: " + i + " " );
			this.assessment.get(i).display();
		}
		}
		System.out.print("Enter id of assessment: ");
		int id = sc.nextInt();
		int num = this.assessment.get(id).getid();
		if (this.assessment.get(id).type() == 'A') {
			System.out.print("Enter filename of assignment: ");
			String sol = sc.next();
			if (!(sol.substring(sol.length()-4, sol.length()).equals(".zip"))) System.out.println("Invalid file format");
			else this.submit(num,  sol);	
		}
		else {
			this.assessment.get(id).display();
			System.out.print("Answer: ");
			String sol = sc.next();
			this.submit(num,  sol);
			
		}
	}
	}
	public void print() {
		System.out.println(this.id + " - " + this.name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addWork(Material A){ 
		this.assessment.add(A);
	}
	
	public void submit(int id, String sol) {
		for (int i =0; i<this.assessment.size(); i++) {
			if (this.assessment.get(i).getid() == id) {
				this.assessment.get(i).submit(sol);
				break;
			}
		}
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
	public Comment addComments() {
		Comment c = new Comment(this.name);
		return c;
	}
	
}

interface Material {
	void display();
	int getMM();
	int getid();
	void grade(int marks);
	char type();
	void submit(String solution);
	String getsol();
	boolean isGraded();
	boolean isSubmitted();
	void displayGrades();
	void setClose();
	boolean isOpen();
}

interface LectureMaterial {
	void display();
}

class Assignment implements Material {
	private int MM;
	private int marks;
	private String problem;
	private boolean graded = false;
	private boolean submitted =false;
	private boolean open = true;
	private String solution;
	private int id;
	
	Assignment(int marks, String problem, int count) {
		this.MM = marks;
		this.problem = problem;
		this.id = count;
		
	}
	public void setClose() {
		this.open = false;
	}
	
	public int getid() {
		return this.id;
	}
	
	public boolean isGraded() {
		return this.graded;
	}
	
	public boolean isSubmitted() {
		return this.submitted;
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	public void submit(String sub) {
		this.solution = sub;
		this.submitted = true;
	}
	
	public int getMM() {
		return this.MM;
	}
	
	public void grade(int marks) {
		this.marks = marks;
		this.graded = true;
	}
		
	public char type () {
		return 'A';
	}
	
	public void displayGrades() {
		System.out.println("Submission: " + this.solution);
		System.out.println("Marks: " + this.marks + "\n");
	}
	
	public void display() {
		System.out.println("Assignment: " + this.problem + " Max Marks: " + this.MM);
		System.out.println("----------------");
	}
	
	public String getsol() {
		return this.solution;
	}
}

class Quiz implements Material {
	private static int MM = 1;
	private int marks;
	private String problem;
	private boolean graded = false;
	private boolean submitted = false;
	private boolean open = true;
	private int id;
	private String solution;
	
	Quiz(String problem, int count) {
		this.problem = problem;
		this.id = count;
	}
	
	public void setClose() {
		this.open = false;
	}
	
	public int getid() {
		return this.id;
	}
	
	public String getsol() {
		return this.solution;
	}
	
	
	public boolean isGraded() {
		return this.graded;
	}
	
	public boolean isSubmitted() {
		return this.submitted;
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	
	public void submit(String sub) {
		this.solution = sub;
		this.submitted = true;
	}
	
	public int getMM() {
		return MM;
	}
	
	@Override
	public void grade(int marks) {
		this.marks = marks;
		this.graded = true;
	}
	
	public char type () {
		return 'Q';
	}
	
	public void displayGrades() {
		System.out.println("Submission: " + this.solution);
		System.out.println("----------------");
		System.out.println("Marks: " + this.marks + "\n");
	}
	
	public void display() {
		System.out.println("Question: " + this.problem );
		System.out.println("----------------");
	}
	

}

class Lectureslide implements LectureMaterial {
	private String title;
	private int count;
	private String[] content;
	private Date date;
	private String instructorName;
	
	public Lectureslide(String title, int num, String[] slides, Instructor I) {
		// TODO Auto-generated constructor stub
		this.date=java.util.Calendar.getInstance().getTime();  
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
		System.out.println("Uploaded by: " + this.instructorName + "\n");
		
	}
}

class Lecturevid implements LectureMaterial{
	private String title;
	private String file;
	private Date date;
	private String instructorName;
	
	public Lecturevid(String title, String file, Instructor I) {
		// TODO Auto-generated constructor stub
		this.date=java.util.Calendar.getInstance().getTime();  
		this.title = title;
		this.file = file;
		this.instructorName = I.getName();
	}
	
	public void display() {
		System.out.println("Title: " + this.title);
		System.out.println("Video file: " + this.file);
		System.out.println("Date of upload: " + this.date);
		System.out.println("Uploaded by: " + this.instructorName + "\n");
		
	}
}

class Instructor implements LearningEnv{
	
	private int id;
	private String name;
	
	public Instructor(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		
	}
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
	
	public LectureMaterial addMaterial() {
		LectureMaterial M = null;
		int choice, num;
		String title, file, dummy;
		String [] slides;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Lecture Slide\n" + 
				"2. Add Lecture Video");
		choice = sc.nextInt();
		dummy = sc.nextLine();
		
		if (choice==1) {
			System.out.print("Enter topic of slides: "); 
			title = sc.nextLine();
			System.out.print("Enter number of slides: ");
			num = sc.nextInt();
			dummy = sc.nextLine();
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
			if (!(file.substring(file.length()-4, file.length()).equals(".mp4"))) System.out.println("Invalid file format");
			else M = new Lecturevid(title, file, this);
		}	
		//error handling missed relating to choice =/= 1,2
		return M;	
	}
	
	public Material [] addAssessment(int id) {
		// TODO Auto-generated method stub
		Material M1, M2, M3, M4;
		int choice, marks;
		String problem;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Assignment\n" + 
				"2. Add Quiz");
		choice = sc.nextInt();
		String dummy = sc.nextLine();
		
		if (choice==1) {
			System.out.print("Enter problem statement: "); 
			problem = sc.nextLine();
			System.out.print("Enter max marks: ");
			marks = sc.nextInt();
			M1 = new Assignment(marks, problem, id);
			M2 = new Assignment(marks, problem, id);
			M3 = new Assignment(marks, problem, id);
			M4 = new Assignment(marks, problem, id);
		}
		else {
			System.out.print("Enter quiz question: "); 
			problem = sc.nextLine();
			M1 = new Quiz(problem, id);
			M2 = new Quiz(problem, id);
			M3 = new Quiz(problem, id);
			M4 = new Quiz(problem, id);
		}	
		Material [] arr = {M1, M2, M3, M4};
		//error handling missed relating to choice =/= 1,2
		return arr;
	}
	
	public Comment addComments() {
		Comment c = new Comment(this.name);
		return c;
		
	}
	
}