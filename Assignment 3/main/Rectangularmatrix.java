package main;

import java.util.ArrayList;

class Rectangularmatrix extends Matrix{
	

	Rectangularmatrix(int id, ArrayList<ArrayList<Float>> matrix) {
		// TODO Auto-generated constructor stub
		this.id = id;
		int i = 0;
		for (ArrayList<Float> rows : matrix) {
			for (Float ele : rows) {
				this.matrix.get(i).add(ele);
			}
			i++;
		}
		this.label.add("Rectangular matrix");
	}
	
	
}
