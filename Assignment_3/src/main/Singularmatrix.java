package main;

import java.util.ArrayList;

public class Singularmatrix extends Squarematrix{
    private static int count = 600;

    Singularmatrix() {
        super();
        matrix.clear();
        ArrayList<Float> row1 = new ArrayList<Float>();
        row1.add(8f);
        row1.add(16f);
        ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(1f);
        row2.add(2f);
        this.matrix.add(row1);
        this.matrix.add(row2);
        label.add("Singular matrix");
        this.determinant = 0;

    }

    Singularmatrix(ArrayList<ArrayList<Float>> matrix) {
        super(matrix);
        label.add("Singular matrix");
        if (this.isSkewSymmetric()) label.add("Skew symmetric matrix");
        if (this.isSymmetric()) label.add("Symmetric matrix");
        if (this.isLowTriangular()) label.add("Lower triangular matrix");
        if (this.isUppTriangular()) label.add("Upper triangular matrix");
        this.determinant = 0;
    }

    @Override
    public Matrix inverse() {
        System.out.println("Not invertible");
        return null;
    }


}
