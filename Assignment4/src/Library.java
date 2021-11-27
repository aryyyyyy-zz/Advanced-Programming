import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book{
	private String title;
	private int ISBN;
	private int barcode;
	private static int count = 100000;
	
	Book() {
		int index;
		title = "";
		for (int i=0; i<8; i++) {
			index = (int)Math.round(Math.floor(Math.random()*(90-65+1)+65));
			title += Character.toString((char)index);
		}
		ISBN = count++;
		barcode = count++;
		System.out.println("Added book details:\n" + this.displayInfo());
		System.out.println("-----------------------");
	}
	
	Book(String title, int ISBN, int barcode) {
		this.title = title;
		this.ISBN = ISBN;
		this.barcode = barcode;
		System.out.println("Added book details:\n" + this.displayInfo());
		System.out.println("-----------------------");
	}
	@Override
	public String toString() {
		return "{ Title: " + this.title + ", ISBN: " + String.valueOf(this.ISBN) + ", Barcode: " + String.valueOf(this.barcode) +" } ";
	}
	public String displayInfo()  {
		return "Title: " + this.title + "\nISBN: " + String.valueOf(this.ISBN) + "\nBarcode: " + String.valueOf(this.barcode) + "\n";
	}
	
	public String gettitle() {
		return this.title;
	}
	public int getISBN() {
		return ISBN;
	}
	
	public int getBarcode() {
		return this.barcode;
	}
}

class Sortbooks implements Comparator<Book> {
	public int compare(Book b1, Book b2) {
		int res = b1.gettitle().compareTo(b2.gettitle());
		if (res == 0) {
			res = b1.getISBN() - b2.getISBN();
			if (res == 0) res = b1.getBarcode() - b2.getBarcode();
		}
		return res;
	}
}

public class Library {
	private static int K;
	private static int N;
	private static int slots;
	private static ArrayList<Book> booklist = new ArrayList<Book>();
	private static ArrayList<Book> sorted_booklist = new ArrayList<Book>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		getNandK();
		for (int i = 0; i < N; i++ ) {
		System.out.print("Press 0 to enter the bill info and 1 to randomize it: ");
		int choice = sc.nextInt();
		switch(choice) {
			case 0:
				String title, dummy;
				boolean flag = false;
				int ISBN, barcode;
				System.out.print("Title: ");
				dummy = sc.nextLine();
				title = sc.nextLine();
				System.out.print("ISBN: ");
				ISBN = sc.nextInt();
				System.out.print("Barcode: ");
				barcode = sc.nextInt();
				for (Book b: booklist) if (b.getBarcode() == barcode) {
					System.out.println("Barcode entered is not unique");
					flag = true;
				}
				if (!flag) {
				Book b1 = new Book(title, ISBN, barcode);
				booklist.add(b1);
				sorted_booklist.add(b1);
				}
				break;
			case 1:
				Book b2 = new Book();
				booklist.add(b2);
				sorted_booklist.add(b2);
				break;
		}
		}
		Collections.sort(sorted_booklist, new Sortbooks());
		/*System.out.println("Sorted order of books: ");
		System.out.println(booklist);*/
		//q + 1 - rack, r - slot
		char opt;
		do {
		if (booklist.size()<1) {
			System.out.println("No books left on the floor");
			break;
		}
		System.out.print("Enter index of book (0-based) whose slot you want to know: \n");
		System.out.println(booklist);
		int s_no = sc.nextInt();
		int index = sorted_booklist.indexOf(booklist.get(s_no));
		System.out.println("Book has been placed on ");
		System.out.println("Rack: " + (index/slots +1));
		System.out.println("Slot number: " + (index%slots +1));
		booklist.remove(s_no);
		System.out.println("Do you wish to continue? y/n");
		opt = sc.next().charAt(0);
		}while(opt=='y');
	}
	
	public static void getNandK() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of books: ");
		N = sc.nextInt();
		System.out.print("Enter the number of racks: ");
		K = sc.nextInt();
		slots = N/K;
	}

}
