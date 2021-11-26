package main;

import java.util.*;

public class Squarematrix extends Matrix{
    protected float determinant;
    private static int count = 0;

    Squarematrix() {
        super();
        this.id = count;
            ArrayList<Float> row1 = new ArrayList<Float>();
            row1.add(1f);
            row1.add(2f);
            ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(3f);
        row2.add(4f);
            this.matrix.add(row1);
            this.matrix.add(row2);

        this.determinant = this.calcdeterminant();
        label.add("Square matrix");
        count++;
    }

    public Squarematrix(ArrayList<ArrayList<Float>> input) {
        // TODO Auto-generated constructor stub
        super();
        this.id = count;
        if (input!=null)
            for (int i=0; i<input.size(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<input.get(0).size(); j++) row.add((input.get(i).get(j)));
            this.matrix.add(row);
        }
        this.determinant = this.calcdeterminant();
        label.add("Square matrix");
        count++;
    }

    public void addTranspose() {
        this.add(this.trans());
    }

    public void adjoint(int p, int q) {
        int i = 0, j = 0;
        int n = this.getrows();
        for (int row = 0; row < n; row++)
        {   ArrayList<Float> rows = new ArrayList<Float>();
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    rows.add(j++,this.matrix.get(row).get(col));
                    this.matrix.add(i, rows);

                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public Matrix inverse() {
        int sign = 1;

        if (this.isSingular()) return null;

        int N = this.getrows();
        Squarematrix temp = new Squarematrix(null);
        Squarematrix adj = new Squarematrix(null);
        Float [][] temp_ = new Float[N][N];

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
                temp_[j][i]=(sign)*(temp.determinant);
            }
        }
        for (int a=0; a<temp_.length; a++) {
            ArrayList<Float> rows = new ArrayList<Float>();
            for (int b=0; b<temp_[0].length;b++) rows.add(temp_[a][b]);
            adj.matrix.add(rows);
        }

        return adj.divbyscalar(adj.determinant); //prints result also
    }

    public float calcdeterminant() {
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

    public float getScalar() {
        return 0f;
    }

    public boolean isSingleton() {
        if (this.id >= 1400) return true;
        return false;
    }

    public boolean isSymmetric() {
        if (this.equalMatrices(this.trans())) return true;
        return false;
    }

    public boolean isSkewSymmetric() {
        Matrix m = this.trans().mulbyscalar(-1);
        if (this.equalMatrices(m)) return true;
        return false;
    }
    public boolean isSingular() {
        if (this.determinant==0) return true;
        return false;
    }
    public boolean isLowTriangular() {
        if (this.getrows()==2 && this.matrix.get(0).get(1) == 0) return true;
        if (this.getrows()==3 && this.matrix.get(0).get(1) == 0 && this.matrix.get(0).get(2) == 0 && this.matrix.get(1).get(2) == 0) return true;
        return false;
    }

    public boolean isUppTriangular() {
        if (this.getrows()==2) if (this.matrix.get(1).get(0) == 0) return true;
        if (this.getrows()==3) if (this.matrix.get(1).get(0) == 0 && this.matrix.get(2).get(0) == 0 && this.matrix.get(2).get(1) == 0) return true;
        return false;
    }

    public boolean isDiagonal() {
        for (int i=0; i<this.getrows(); i++) {
            for (int j = 0; j <this.getrows(); j++) {
                if (i!=j && this.matrix.get(i).get(j) != 0) return false;
            }
        }
        return true;
    }

    public boolean isScalar() {
        if (this.getrows()==3 && this.matrix.get(1).get(1) == this.matrix.get(2).get(2) && this.matrix.get(0).get(0) == this.matrix.get(2).get(2)) return true;
        if (this.getrows()==2 && this.matrix.get(1).get(1) == this.matrix.get(0).get(0)) return true;
        return false;
    }

    public boolean isIdentity() {
        if (this.getrows()==3 && this.matrix.get(1).get(1) == this.matrix.get(2).get(2) && this.matrix.get(0).get(0) == this.matrix.get(2).get(2) && this.matrix.get(1).get(1) == 1) return true;
        if (this.getrows()==2 && this.matrix.get(1).get(1) == this.matrix.get(0).get(0) && this.matrix.get(1).get(1) == 1) return true;
        return false;
    }

}
