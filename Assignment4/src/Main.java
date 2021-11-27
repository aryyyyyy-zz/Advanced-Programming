import java.util.ArrayList;
import java.util.Scanner;

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
				System.out.print("Enter 0 to input a color image and 1 to input a grayscale image: ");
				int v = sc.nextInt();
				switch(v) {
				case 0: 
					ArrayList<ArrayList<colorImagePixel>> matrix = new ArrayList<>();
					for (int i=0; i<r; i++) {
						ArrayList<colorImagePixel> row = new ArrayList<>();
						for (int j=0; j<c; j++) {
							System.out.println("Row " + String.valueOf(i+1) + ", column" + String.valueOf(j+1));
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
							System.out.println("Row " + String.valueOf(i+1) + ", column " + String.valueOf(j+1));
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
				System.out.println("Enter index (0-based) of image you want to update: ");
				System.out.println(images);
				int index = sc.nextInt();
				Image I = images.get(index);
				pixel p;
				System.out.println("Enter pixel location to be edited ");
				System.out.print("Row: ");
				int x = sc.nextInt();
				System.out.print("Col: ");
				int y = sc.nextInt();
				if (I.isGrayScale()) {
					p = takeGray();
				}
				else {
					p = takeColor(); 
				}
				Image.update(I, p, x, y);
				break;
			case 4: 
				System.out.println("Enter index (0-based) of image you want to compute negative of: ");
				System.out.println(images);
				int index2 = sc.nextInt();
				Image I2 = images.get(index2);
				I2.getNegative(I2);
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
		System.out.println("1. Create image\n"
				+ "2. Input image\n"
				+ "3. Update image\n"
				+ "4. Compute negative of image\n"
				+ "5. Display image");
		System.out.println("---------------------");
	}
}


class Image <T extends pixel>{
	private ArrayList<ArrayList<T>> matrix = new ArrayList<>();
	private int rows;
	private int cols;
		
	Image(ArrayList<ArrayList<T>> matrix, int rows, int cols) {
		this.rows= rows;
		this.cols = cols;
		for (ArrayList<T> row: matrix) {
			ArrayList<T> newRow = new ArrayList<>();
			for (T ele : row) {
				newRow.add(ele);
			}
			this.matrix.add(newRow);
		}
	}
	
	public boolean isGrayScale() {
		return this.matrix.get(0).get(0).isGray();
	}
	
	public static <T extends pixel> void getNegative(Image<T> I) {
		ArrayList<ArrayList<pixel>> matrix = new ArrayList<>();
		Image <pixel> negImg = new Image<>(matrix, I.getrows(), I.getcols());
		for (ArrayList<T> row: I.matrix) {
			ArrayList<pixel> newRow = new ArrayList<>();
			for (T ele : row) {
				newRow.add(ele.getNeg());
			}
			negImg.matrix.add(newRow);
		}
		System.out.println("The negative of the image will be: ");
		System.out.println(negImg);
	}

	public static <T extends pixel> Image update(Image<T> I, T p, int x, int y) {
		I.matrix.get(x).add(y, p);
		I.matrix.get(x).remove(y+1);
		return I;
	}
	@Override
	public String toString() {
		String str = "\n";
		for (ArrayList<T> row : matrix) {
			for (T ele : row) {
				str += ele;
			}
			str += "\n";
		}
		return str;
	}
	
	public int getrows() {
		return this.rows;
	}
	
	public int getcols() {
		return this.cols;
	}
}

interface pixel{ 
	pixel getPixel();
	boolean isGray();
	pixel getNeg();
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
	public String toString() {
		return "*r:" + this.red+ "*g:" + this.green +"*b:" + this.blue+ "*\t";
	}
	
	@Override
	public pixel getPixel() {
		return new colorImagePixel();
	}
	
	@Override
	public pixel getNeg() {
		return new colorImagePixel(255-this.red, 255-this.green, 255-this.blue);
	} 
	
	@Override
	public boolean isGray() {
		return false;
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
	public String toString() {
		return "*gray:" + this.gray +"*\t";
	}
	
	@Override
	public pixel getPixel() {
		return new grayscaleImagePixel();
	}
	@Override
	public pixel getNeg() {
		return new grayscaleImagePixel(255- this.gray);
	} 
	
	@Override
	public boolean isGray() {
		return true;
	}
	
}