/**
 * 
 */
package main;

/**
 * @author arya
 *
 */

interface LearningEnv {
	void displayMenu();
	
}
public class Backpack implements LearningEnv{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
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
}

class Instructor implements LearningEnv{
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
}