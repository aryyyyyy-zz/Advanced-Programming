import java.util.ArrayList;

public class Image <T>{
	private ArrayList<ArrayList<T>> matrix = new ArrayList<>();
	
	Image() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image<colorImagePixel> colorpic = new Image<>();

	}
	
	public static <I> void getNegative(Image I) {
		
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