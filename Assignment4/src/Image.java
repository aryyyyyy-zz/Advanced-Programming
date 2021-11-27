import java.util.ArrayList;
import java.util.Scanner;

public class Image <T>{
	private ArrayList<ArrayList<T>> matrix = new ArrayList<>();
	private int rows;
	private int cols;
	
	static {
		Scanner sc =new Scanner(System.in);
	}
	
	{
		System.out.print("Enter number of rows: ");
		this.rows = sc.nextInt();
		System.out.print("Enter number of cols: ");
		this.cols = sc.nextInt();
	}
	
	Image() {
		for (int i=0; i<rows; i++)
			for (int j=0; j<cols; j++) ;
				
	}
	
	public T getpixel() {
		return new T();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter 0 to enter image details and 1 to randomize it");
		System.out.println("Enter 0 to enter image details and 1 to randomize it");
		Image<colorImagePixel> colorpic = new Image<>();

	}
	
	public static <I> void getNegative(Image I) {
		
	}
	
	public static void displayMenu() {
		System.out.println("1. Create image/n2. Input image/n3. Update image/n4. Compute negative of image/n5. Display image/n");
	}

}

class colorImagePixel {
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
	
}

class grayscaleImagePixel {
	private int gray;
	
	grayscaleImagePixel() {
		this.gray = (int)Math.round(Math.floor(Math.random()*256));
	}
	
	grayscaleImagePixel(int g) {
		this.gray = g;
	}
	
}