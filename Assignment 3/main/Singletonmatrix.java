package main;

import java.util.*;

public class Singletonmatrix extends Squarematrix{
	private float scalar;
	
	public Singletonmatrix(float scalar, int id) {
		// TODO Auto-generated constructor stub
		super(id);
		this.id = id;
		this.scalar = scalar;
		this.determinant = scalar;
		label.add("Rectangular matrix");
		label.add("Singleton matrix");
		label.add("Sqaure matrix");
		label.add("Row matrix");
		label.add("Column matrix");
		label.add("Symmetric matrix");
		label.add("Skew symmetrix matrix");
		label.add("Lower triangular matrix");
		label.add("Upper triangular matrix");
		label.add("Diagonal matrix");
		label.add("Scalar matirx");
		
		if (this.scalar == 0) {
			label.add("Null matrix"); 
			label.add("Singular matrix");
		}
		else if (this.scalar == 1) {
			label.add("Ones matrix");
			label.add("Identity matrix");
		}
		
	}

}
