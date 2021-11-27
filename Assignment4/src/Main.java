import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.comp.Enter;

public class Main {
	private static ArrayList<Image> images = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;
		Scanner sc =new Scanner(System.in);
		do {
			displayMenu();
			int opt = sc.nextInt();
			switch(opt) {
			case 1:
				System.out.print("Enter number of rows: ");
				int rows = sc.nextInt();
				System.out.print("Enter number of cols: ");
				int cols = sc.nextInt();
				System.out.print("Enter 0 to create a color image and 1 to create a grayscale image: ");
				int val = sc.nextInt();
				switch(val) {
				case 0: 
					ArrayList<ArrayList<colorImagePixel>> matrix = new ArrayList<>();
					for (int i=0; i<rows; i++) {
						ArrayList<colorImagePixel> row = new ArrayList<>();
						for (int j=0; j<cols; j++) {
							row.add(new colorImagePixel());
						}
						matrix.add(row);
					}
					Image<colorImagePixel> C = new Image<>(matrix, rows, cols);
					images.add(C);
					break;
				case 1:
					ArrayList<ArrayList<grayscaleImagePixel>> matrix2 = new ArrayList<>();
					for (int i=0; i<rows; i++) {
						ArrayList<grayscaleImagePixel> row = new ArrayList<>();
						for (int j=0; j<cols; j++) {
							row.add(new grayscaleImagePixel());
						}
						matrix2.add(row);
					}
					Image<grayscaleImagePixel> G = new Image<>(matrix2, rows, cols);
					images.add(G);
					break;
				default:
					System.out.println("Invalid entry");
					break;
				}
				break;
			case 2:
				System.out.print("Enter number of rows: ");
				int r = sc.nextInt();
				System.out.print("Enter number of cols: ");
				int c = sc.nextInt();
				System.out.print("Enter 0 to create a color image and 1 to create a grayscale image: ");
				int v = sc.nextInt();
				switch(v) {
				case 0: 
					ArrayList<ArrayList<colorImagePixel>> matrix = new ArrayList<>();
					for (int i=0; i<r; i++) {
						ArrayList<colorImagePixel> row = new ArrayList<>();
						for (int j=0; j<c; j++) {
							row.add(takeColor());
						}
						matrix.add(row);
					}
					Image<colorImagePixel> C = new Image<>(matrix, r, c);
					images.add(C);
					break;
				case 1:
					ArrayList<ArrayList<grayscaleImagePixel>> matrix2 = new ArrayList<>();
					for (int i=0; i<r; i++) {
						ArrayList<grayscaleImagePixel> row = new ArrayList<>();
						for (int j=0; j<c; j++) {
							row.add(takeGray());
						}
						matrix2.add(row);
					}
					Image<grayscaleImagePixel> G = new Image<>(matrix2, r, c);
					images.add(G);
					break;
				default:
					System.out.println("Invalid entry");
					break;
				}
				break;
			case 3:
				System.out.print("Enter index (0-based) of image you want too update: ");
				System.out.println(images);
				int index = sc.nextInt();
				System.out.println("Enter pixel location to be edited ");
				System.out.print("Row: ");
				int x = sc.nextInt();
				System.out.print("Col: ");
				int y = sc.nextInt();
				
				break;
			case 4: 
				break;
			case 5:
				System.out.println(images);
				break;
			default:
				System.out.println("Invalid entry");
				break;				
			}
			
			System.out.println("Do you wish to continue? y/n");
			ch = sc.next().charAt(0);
		}while(ch=='y');
	}
	
	public static grayscaleImagePixel takeGray() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter intensity of gray: ");
		int g = sc.nextInt();
		return new grayscaleImagePixel(g);
	}
	
	public static colorImagePixel takeColor() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter intensity of red: ");
		int r = sc.nextInt();
		System.out.print("Enter intensity of green: ");
		int g = sc.nextInt();
		System.out.print("Enter intensity of blue: ");
		int b = sc.nextInt();
		return new colorImagePixel(r, g, b);
	}
	
	public static void displayMenu() {
		System.out.println("1. Create image/n"
				+ "2. Input image/n"
				+ "3. Update image/n"
				+ "4. Compute negative of image/n"
				+ "5. Display image/n");
	}
}


class Image <T extends pixel>{
	private ArrayList<ArrayList<T>> matrix = new ArrayList<>();
	private int rows;
	private int cols;
		
	Image(ArrayList<ArrayList<T>> matrix, int rows, int cols) {
		
	}
	
	public static <I> void getNegative(Image I) {
		
	}

	@Override
	public String toString() {
		String str = "";
		for (ArrayList<T> row : matrix) {
			for (T ele : row) {
				str += ele;
			}
			str += "\n";
		}
		return str;
	}
}

interface pixel{
	String displaypixel(); 
	pixel update(int[] list);
	pixel getPixel();
}

class colorImagePixel implements pixel{
	private int red;
	private int green;
	private int blue;
	
	colorImagePixel() {
		this.red = (int)Math.round(Math.floor(Math.random()*256));
		this.green = (int)Math.round(Math.floor(Math.random()*256));
		this.blue =(int)Math.round(Math.floor(Math.random()*256));
	}
	
	colorImagePixel(int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	@Override
	public String displaypixel() {
		return "*r:" + this.red+ "*g:" + this.green +"*b:" + this.blue+ "*/t";
	}
	
	@Override
	public pixel update(int [] list) {
		return new colorImagePixel(list[0], list[1], list[2]);
	}
	
	@Override
	public pixel getPixel() {
		return new colorImagePixel();
	}
	
	@Override
	public String toString() {
		return ":" + this.red+ ":" + this.green +":" + this.blue+ ":/t";
	}
}

class grayscaleImagePixel implements pixel{
	private int gray;
	
	grayscaleImagePixel() {
		this.gray = (int)Math.round(Math.floor(Math.random()*256));
	}
	
	grayscaleImagePixel(int g) {
		this.gray = g;
	}
	
	@Override
	public String displaypixel() {
		return "*gray:" + this.gray;
	}
	
	@Override
	public pixel update(int [] list) {
		return new grayscaleImagePixel(list[0]);
	}
	
	@Override
	public pixel getPixel() {
		return new grayscaleImagePixel();
	}
	
	@Override
	public String toString() {
		return ":" + this.gray+ ":/t" ;
	}
	
}