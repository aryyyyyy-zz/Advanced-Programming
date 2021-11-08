package main;

import java.util.*;

public class Matrix {
	protected int id;
	protected ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>(); 
	protected List<String> label = new ArrayList<String>();
	
	public void displayLabels() {
		for (String item : this.label) System.out.println(item + "\n");
	}
	
	public int getcols() {
		return matrix.get(0).size();
	}
	
	public int getrows() {
		return matrix.size();
	}
	
	public void display() {
		int i = 0;
		for (ArrayList<Float> rows : matrix) {
			for (Float ele : rows) {
				System.out.print(ele + " ");
			}
			System.out.println();
			i++;
		}
	}
	
	public void divbyscalar(float k) {
		int i = 0;
		for (ArrayList<Float> rows : matrix) {
			for (Float ele : rows) {
				System.out.print(ele/k + " ");
			}
			System.out.println();
			i++;
		}
	}
	
	public Matrix add(Matrix m) {
		Matrix result = new Matrix(); 
		if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
		for (int i =0; i<this.getrows(); i++) {
			for (int j=0; j<this.getcols(); j++) {
				result.matrix.get(i).add( this.matrix.get(i).get(j) + m.matrix.get(i).get(j));
			}
		}
		result.display();
		return result;
	}
	
	public Matrix sub(Matrix m) {
		//m1-m2
		Matrix result = new Matrix(); 
		if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
		for (int i =0; i<this.getrows(); i++) {
			for (int j=0; j<this.getcols(); j++) {
				result.matrix.get(i).add( this.matrix.get(i).get(j) - m.matrix.get(i).get(j));
			}
		}
		result.display();
		return result;
	}
	
	public Matrix elementwiseMul(Matrix m) {
		Matrix result = new Matrix(); 
		if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
		for (int i =0; i<this.getrows(); i++) {
			for (int j=0; j<this.getcols(); j++) {
				result.matrix.get(i).add( this.matrix.get(i).get(j) * m.matrix.get(i).get(j));
			}
		}
		result.display();
		return result;
	}
	
	public Matrix elementwiseDiv(Matrix m) {
		Matrix result = new Matrix(); 
		if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
		for (int i =0; i<this.getrows(); i++) {
			for (int j=0; j<this.getcols(); j++) {
				if (m.matrix.get(i).get(j)==0) {
					System.out.println("Division by zero error.");
					return result;
				}
				result.matrix.get(i).add( this.matrix.get(i).get(j) / m.matrix.get(i).get(j));
			}
		}
		result.display();
		return result;
	}
	
	public Matrix Mul(Matrix m) {
		Matrix result = new Matrix();
		if (this.getcols() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
		else {
			
			for(int i=0;i<this.getrows();i++)		{    
				for(int j=0;j<m.getcols();j++)		{ 
					float sum = 0;
					for (int k=0; k<this.getcols();k++) sum += this.matrix.get(i).get(k) * m.matrix.get(k).get(j);
					result.matrix.get(i).add(sum);
					}   
				}
			result.display();
		}
		return result;
	}
	
	public Matrix trans() {
		Matrix result = new Matrix(); 
		for (int i =0; i<this.getcols(); i++) {
			for (int j=0; j<this.getrows(); j++) {
				result.matrix.get(i).add(this.matrix.get(j).get(i));
			}
		}
		result.display();
		return result;
	}
}
