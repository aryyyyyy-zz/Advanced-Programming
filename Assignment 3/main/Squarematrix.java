package main;

public class Squarematrix extends Matrix{
	protected float determinant;
	private static int count = 1000;
	public Squarematrix() {
		// TODO Auto-generated constructor stub
		this.id = count;
		this.determinant = this.determinant();
		count++;
	}
	
	public void adjoint(int p, int q) {
		int i = 0, j = 0;
		int n = this.getrows();
	    for (int row = 0; row < n; row++)
	    {
	        for (int col = 0; col < n; col++)
	        {
	            if (row != p && col != q)
	            {
	                this.matrix.get(i).add(j++,this.matrix.get(row).get(col));
	 
	                if (j == n - 1)
	                {
	                    j = 0;
	                    i++;
	                }
	            }
	        }
	    }
	}
	
	public void inverse() {
		int sign = 1;
		
		if (this.determinant == 0) {
			System.out.println("Not invertible");
			return;
		}
		int N = this.getrows();
		Squarematrix temp = new Squarematrix();
		Squarematrix adj = new Squarematrix();
	    
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	        {
	            // Get cofactor of A[i][j]
	            temp.adjoint(i, j);
	 
	            // sign of adj[j][i] positive if sum of row
	            // and column indexes is even.
	            sign = ((i + j) % 2 == 0)? 1: -1;
	 
	            // Interchanging rows and columns to get the
	            // transpose of the cofactor matrix
	            adj.matrix.get(j).add((sign)*(temp.determinant));
	        }
	    }
	    adj.divbyscalar(adj.determinant);
	}
	
	public float determinant() {
		float det =0 ;
		if (this.getrows()==1) det = matrix.get(0).get(0);
		else if (this.getrows()==2) {
			det = matrix.get(0).get(0) * matrix.get(1).get(1) - matrix.get(0).get(1) * matrix.get(1).get(0);
		}
		else if (this.getrows()==3) {
			float block1 = matrix.get(1).get(1) * matrix.get(2).get(2) - matrix.get(1).get(2) * matrix.get(2).get(1);
			float block2 = matrix.get(1).get(0) * matrix.get(2).get(2) - matrix.get(1).get(2) * matrix.get(2).get(0);
			float block3 = matrix.get(1).get(0) * matrix.get(2).get(1) - matrix.get(1).get(1) * matrix.get(2).get(0);
			
			det = matrix.get(0).get(0) * block1 - matrix.get(0).get(1) * block2 + matrix.get(0).get(2) * block3;
		}
		return det;
	}
	
}
