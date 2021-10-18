
package main;

/*
 * @author arya
 */

interface LearningEnv {
	void displayMenu();
	void viewLec();
	void viewAssessments();
	void viewComments();
	void addComments();
	void logout();
	
}
public class Backpack{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void displayMenu() {
		System.out.println("Welcome to Backpack\n" + 
				"1. Enter as instructor\n" + 
				"2. Enter as student\n" + 
				"3. Exit");
	}
	
}

class Student implements LearningEnv{
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

class Lectureslide {
	private String title;
	private int count;
	private String[] content = new String[100];
	
	public Lectureslide(String title, int num, String[] slides) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.count = num;
		
		
	}
}

class Lecturevid {
	private String title;
	
}
class Instructor implements LearningEnv{
	
	private int id;
	private String name;
	
	
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