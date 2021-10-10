package ap;
import java.io.*;
import java.util.*;

public class Main {
	
	private static List<Hospital> hospitals;
	private static List<Citizen> citizens;
	private static List<Vaccine> vaccines;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc = new Scanner(System.in);
		while (true) {
		displayMenu();
		choice = sc.nextInt();
		switch(choice) {
		case 1 :
			String vac;
			int doses, gap;
			System.out.print("Vaccine name: ");
			vac = sc.nextLine();
			System.out.print("Number of doses: ");
			doses = sc.nextInt();
			System.out.println("Gap between doses: ");
			gap = sc.nextInt();
			Vaccine v = new Vaccine(vac,  doses, gap);
			vaccines.add(v);
			v.display();
			break;
		case 2 :
			String h_name;
			int h_pin;
			System.out.print("Hospital name: ");
			h_name = sc.nextLine();
			System.out.print("Pin code: ");
			h_pin = sc.nextInt();
			break;
		case 3 :
			//if age <18 "Only above 18 are allowed"
			break;
		case 4 :
			break;
		case 5 :
			int id, val;
			System.out.print("Enter patient Unique ID: ");
			id = sc.nextInt();
			while (true) {
				System.out.print("1. Search by area\n2. Search by Vaccine\n3. Exit\nEnter option: ");
				val = sc.nextInt();
				int hosp_id, slotChoice;
				if (val==1) {
					int pin;
					System.out.print("Enter PinCode: ");
					pin = sc.nextInt();
					//display hospitals
					System.out.print("Enter hospital id: ");
					hosp_id = sc.nextInt();
					//display slots->if available
					System.out.print("Choose Slot: ");
					slotChoice = sc.nextInt();
					//book slot
				}
				if (val==2) {
					String v1;
					System.out.println("Enter Vaccine name: ");
					v1 = sc.nextLine();
					//display hospitals
					System.out.print("Enter hospital id: ");
					hosp_id = sc.nextInt();
					//display slots->if available
					System.out.print("Choose Slot: ");
					slotChoice = sc.nextInt();
					//book slot
				}
				if (val==3) break;
				else {
					System.out.println("Invalid input");
				}
			}
			
			break;
		case 6 :
			break;
		case 7 :
			break;
		case 8 :
			break;
		default:
			System.out.println("Invalid input");
		}
		}
		
	}
	
	public static void displayMenu() {
		System.out.println("CoWin Portal initialized....\n" + 
				"---------------------------------\n" + 
				"1. Add Vaccine\n" + 
				"2. Register Hospital\n" + 
				"3. Register Citizen\n" + 
				"4. Add Slot for Vaccination\n" + 
				"5. Book Slot for Vaccination\n" + 
				"6. List all slots for a hospital\n" + 
				"7. Check Vaccination Status\n" + 
				"8. Exit\n" + 
				"---------------------------------");
	}

}

class Slot {
	private int day;
	private int quantity;
	private String vac;
	private int slotNumber;
	public static int count=0;
	
	Slot(int day, int quantity, String vac) {
		this.slotNumber = count;
		this.day = day;
		this.quantity = quantity;
		this.vac = vac;
		count++;
	}
	
	public String getVaccineName() {
		return this.vac;
	}
	
	public int getslotNumber() {
		return this.slotNumber;
	}
	
	public void display() {
		System.out.println(this.slotNumber + "-> Day: "+ this.day +"Available Qty:" + this.quantity +"Vaccine:" +this.vac);
	}
	
	public boolean book() {
		if (this.quantity>0) this.quantity--;
		
		if (this.quantity == 0) {
			count--;
			return false;
		}
		else return true;
	}
}

class Citizen {

	private String name;
	private int age;
	private int id;
	private String status;
	
	Citizen(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.status = "REGISTERED";
		
	}
	
	public String getStatus() {
		return this.status;		
	}
}

class Hospital {
	private String name;
	private int pin; 
	private int id;
	private static int count=100000;
	private List<Slot> slots;
	
	public static void counter() {
		count++;
	}
	
	public void display() {
		System.out.println("Name: " + this.name);
		System.out.println("Pincode: " + this.pin);
		System.out.println("Unique ID: " + this.id);
	}
	public void createHospital(String name, int pincode) {
		this.name = name;
		this.pin = pincode;
		this.id = count;
		//not declaring empty slots list
		counter();
		display();
	}
	
	public void createSlot(List<Vaccine> vaccines) {
		int day, quantity;
		String vac;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Day Number: ");
		day = sc.nextInt();
		System.out.print("Enter Quantity: ");
		quantity = sc.nextInt();
		System.out.println("Select vaccine: ");
		for (int i=0; i<vaccines.size(); i++ ) {
			System.out.print(i +" ");
			System.out.println(vaccines.get(i));
		}
		vac = vaccines.get(sc.nextInt()).getName();
		
		Slot s = new Slot(day, quantity, vac);
		this.slots.add(s);
	}

	public void displaySlot() {
		
		for (int i =0; i<slots.size(); i++) slots.get(i).display();
		if (slots.size()==0) System.out.println("No slots available");
	}
	
	public void displaySlot(String vac) {
		for (int i =0; i<slots.size(); i++) {
			if (slots.get(i).getVaccineName() == vac) {
				slots.get(i).display();
			}
		}
		if (slots.size()==0) System.out.println("No slots available");
	}
	public void bookSlot(int slotNumber) {
		for (int i =0; i<slots.size(); i++) {
			if (slots.get(i).getslotNumber() == slotNumber) {
				if (!slots.get(i).book()) slots.remove(i);
			}
		
		}
	}
}

class Vaccine {
	private String name;
	private int doses;
	private int gap;

	Vaccine(String x, int d, int g) {
		this.name = x;
		this.doses = d;
		this.gap = g;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void display() {
		System.out.println("Vaccine Name: "+ this.name +", Number of Doses: "+ this.doses +", Gap Between Doses: " +this.gap);
	}

}
