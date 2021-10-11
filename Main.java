package ap;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Hospital> hospitals = new ArrayList<Hospital>();
		List<Citizen> citizens = new ArrayList<Citizen>();
		List<Vaccine> vaccines = new ArrayList<Vaccine>();
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
			vac = sc.next();
			System.out.print("Number of doses: ");
			doses = sc.nextInt();
			System.out.print("Gap between doses: ");
			gap = sc.nextInt();
			Vaccine v = new Vaccine(vac,  doses, gap);
			vaccines.add(v);
			v.display();
			break;
		case 2 :
			String h_name;
			int h_pin;
			System.out.print("Hospital name: ");
			h_name = sc.next();
			System.out.print("Pin code: ");
			h_pin = sc.nextInt();
			Hospital h = new Hospital();
			h.createHospital(h_name, h_pin);
			hospitals.add(h);
			break;
		case 3 :
			String name;
			int age;
			long c_id;
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("Age: ");
			age = sc.nextInt();
			System.out.print("Unique id: ");
			c_id = sc.nextLong();
			Citizen c = new Citizen(name, age, c_id);
			if (age<18) System.out.println("Only above 18 are allowed");
			else citizens.add(c);
			break;
		case 4 :
			int h_id, num;
			System.out.print("Enter hospital ID: ");
			h_id = sc.nextInt();
			for (int i=0; i<hospitals.size(); i++) {
				if (hospitals.get(i).getID() == h_id) {
					h = hospitals.get(i);
					System.out.print("Enter number of slots to be added: ");
					num = sc.nextInt();
					for (int j=0; j<num; j++) {
						h.createSlot(vaccines);
					}
					break;
				}
			}			
			break;
			
		case 5 :
			int val;
			long id;
			System.out.print("Enter patient Unique ID: ");
			id = sc.nextLong();
			for (int j=0; j<citizens.size();j++) {
				if (citizens.get(j).getID() == id) {
					c = citizens.get(j);
					System.out.print("1. Search by area\n2. Search by Vaccine\n3. Exit\nEnter option: ");
						val = sc.nextInt();
						int hosp_id;
						if (val==1) {
							int pin;
							System.out.print("Enter PinCode: ");
							pin = sc.nextInt();
							for(int i=0; i<hospitals.size(); i++ ) {
								if (hospitals.get(i).getpin() == pin) {
									hospitals.get(i).displayListByPin();
								}
							}
							System.out.print("Enter hospital id: ");
							hosp_id = sc.nextInt();
							for (int i=0; i<hospitals.size(); i++) {
								if (hospitals.get(i).getID() == hosp_id) {
									h = hospitals.get(i);
									h.displaySlot(c);
									break;
								}
							}
							
							
						}
						else if (val==2) {
							String v1;
							List<Integer> ids=new ArrayList<Integer>();  
							System.out.print("Enter Vaccine name: ");
							v1 = sc.next();
							for (int i=0; i<hospitals.size(); i++ ) hospitals.get(i).displayListByVac(v1);
								
							System.out.print("Enter hospital id: ");
							hosp_id = sc.nextInt();
							
							
							for (int i=0; i<hospitals.size(); i++) {
								if (hospitals.get(i).getID() == hosp_id) {
									h = hospitals.get(i);
									h.displaySlot(v1, c);
									
									break;
								}
							}
						}
						else if (val==3) break;
						else System.out.println("Invalid input");
				break;
				}
				
			}
			break;
		case 6 :
			int hospitalID;
			System.out.print("Enter hospital id: ");
			hospitalID = sc.nextInt();
			for (int i=0; i<hospitals.size(); i++) {
				if (hospitals.get(i).getID() == hospitalID) {
					hospitals.get(i).displaySlot();
				}
			}
			break;
		case 7 :
			long p_id;
			System.out.print("Enter patient id: ");
			p_id = sc.nextLong();
			for (int i=0; i<citizens.size(); i++) {
				if (citizens.get(i).getID() == p_id) {
					citizens.get(i).status(vaccines);
				}
			}
			break;
		case 8 :
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		System.out.println("---------------------------------");
		if (choice==8) {
			System.out.println("END");
			break;	
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
		System.out.println(this.slotNumber + "-> Day:"+ this.day +" Available Qty:" + this.quantity +" Vaccine:" +this.vac);
	}
	
	public boolean book(Citizen c) {
		if (this.quantity>0) {
			this.quantity--;
			System.out.println(c.getName() +" vaccinated with " + this.vac);
			c.update(this.day, this.vac);
		}
		
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
	private long id;
	private int day;
	private String vaccine;
	private int dosesgiven;
	
	Citizen(String name, int age, long id) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.dosesgiven = 0;
		this.display();
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void update(int day, String vac) {
		this.day = day;
		this.vaccine = vac;
		this.dosesgiven++;
	}
	public void display() {
		System.out.println("Citizen Name: " + this.name +", Age: "+ this.age + ", Unique ID: "+ this.id);
	}
	
	public void status(List<Vaccine> vaccines) {
		int gap, dosesNeeded;
		if (this.dosesgiven==0) {
			System.out.println("Citizen REGISTERED");
			return;
		}
		for(int i=0; i<vaccines.size(); i++) {
			if (vaccines.get(i).getName() == this.vaccine) {
				gap = vaccines.get(i).getGap();
				dosesNeeded = vaccines.get(i).getDoses();
				if (this.dosesgiven < dosesNeeded) {
					System.out.println("PARTIALLY VACCINATED");
					System.out.println("Vaccine given: " + this.vaccine);
					System.out.println("Number of doses given: " + this.dosesgiven);
					int date;
					date  = this.day + gap;
					System.out.println("Next dose due date: " + date);
				}
				else {
					System.out.println("FULLY VACCINATED");
					System.out.println("Vaccine given: " + this.vaccine);
					System.out.println("Number of doses given: " + this.dosesgiven);
				}
				break;
			}
		}
		
		
	}
	
	public long getID () {
		return this.id;
	}
}

class Hospital {
	private String name;
	private int pin; 
	private int id;
	private static int count=100000;
	private List<Slot> slots = new ArrayList<Slot>();
	
	public static void counter() {
		count++;
	}
	
	public int getpin() {
		return this.pin;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void displayListByVac(String vac) {
		for (int i=0; i<this.slots.size();i++) {
			if (this.slots.get(i).getVaccineName().equalsIgnoreCase(vac)) {
				this.displayListByPin();
			}
		}
		
	}
	
	public void display() {
		System.out.println("Name: " + this.name);
		System.out.println("Pincode: " + this.pin);
		System.out.println("Unique ID: " + this.id);
	}
	
	public void displayListByPin() {
		System.out.println(this.id + " " + this.name);
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
			System.out.println(vaccines.get(i).getName());
		}
		vac = vaccines.get(sc.nextInt()).getName();
		
		Slot s = new Slot(day, quantity, vac);
		this.slots.add(s);
		
		System.out.println("Slot added by Hospital "+ this.id +" for Day: "+ day+ ", Available Quantity: " + quantity +" of Vaccine " + vac);

	}

	public void displaySlot() {
		
		for (int i =0; i<slots.size(); i++) slots.get(i).display();
		if (slots.size()==0) System.out.println("No slots available");
		
	}
	
	public void displaySlot(Citizen c) {
		
		for (int i =0; i<slots.size(); i++) slots.get(i).display();
		if (slots.size()==0) System.out.println("No slots available");
		else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Choose Slot: ");
			int slotChoice = sc.nextInt();
			this.bookSlot(slotChoice, c);
			
		}
	}
	
	public void displaySlot(String vac, Citizen c) {
		for (int i =0; i<slots.size(); i++) {
			if (slots.get(i).getVaccineName().equalsIgnoreCase(vac)) {
				slots.get(i).display();
			}
		}
		if (slots.size()==0) System.out.println("No slots available");
		else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Choose Slot: ");
			int slotChoice = sc.nextInt();
			this.bookSlot(slotChoice, c);
		}
	}
	public void bookSlot(int slotNumber, Citizen c) {
		for (int i =0; i<slots.size(); i++) {
			if (slots.get(i).getslotNumber() == slotNumber) {
				if (!slots.get(i).book(c)) slots.remove(i);
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
	
	public int getDoses() {
		return this.doses;
	}
	
	public int getGap() {
		return this.gap;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void display() {
		System.out.println("Vaccine Name: "+ this.name +", Number of Doses: "+ this.doses +", Gap Between Doses: " +this.gap);
	}

}
