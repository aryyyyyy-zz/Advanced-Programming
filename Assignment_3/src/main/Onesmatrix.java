package main;

import java.util.ArrayList;

public class Onesmatrix extends Matrix{
    private int rows;
    private int cols;
    private static int count = 200;

    Onesmatrix() {
        this.id = count;
        this.rows = 3;
        this.cols= 4;
        label.add("Ones matrix");
        count++;
    }

    public Onesmatrix(int r, int c) {
        this.id = count;
        this.rows = r;
        this.cols= c;
        label.add("Ones matrix");
        if (r==1) label.add("Row matrix");
        if (c==1) label.add("Column matrix");
        if (r==c) {
            label.add("Square matrix");
            label.add("Symmetric matrix");
            //cant be singleton
            label.add("Singular matrix");
        }

        count++;
    }

    @Override
    public void display() {
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) System.out.print("1" + " ");
            System.out.println();
        }
    }

    @Override
    public Matrix Mul(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getrows()) System.out.println("Cant be multiplied, dimensions not compatible");
        else {

            for(int i=0;i<rows;i++)		{
                ArrayList<Float> row = new ArrayList<Float>();
                for(int j=0;j<m.getcols();j++)		{
                    float sum = 0;
                    for (int k=0; k<cols;k++) sum += m.matrix.get(k).get(j);
                    row.add(sum);
                }
                result.matrix.add(row);
            }
            result.display();
        }
        return result;
    }

    @Override
    public Matrix trans() {
        Matrix result = new Onesmatrix(this.cols, this.rows);
        return result;
    }
}

