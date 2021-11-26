package main;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    protected int id;
    protected ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>();
    protected List<String> label = new ArrayList<String>();

    Matrix() {
        label.add("Rectangular matrix");
    }

    public void displayLabels() {
        for (String item : this.label) System.out.println(item);
    }

    public int getcols() {
        return matrix.get(0).size();
    }

    public int getrows() {
        return matrix.size();
    }

    public void display() {
        for (ArrayList<Float> rows : matrix) {
            System.out.print("[ ");
            for (Float ele : rows) {
                System.out.print(ele + "\t\t");
            }
            System.out.println(" ]");
        }
    }

    public Matrix mulbyscalar(float k) {
        Matrix result = new Matrix();

        for (ArrayList<Float> rows : matrix) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (Float ele : rows) {
                if (ele*k==0) row.add(0f);
                else row.add(ele*k);
            }
            result.matrix.add(row);
        }
        return result;
    }

    public Matrix divbyscalar(float k) {
        Matrix result = new Matrix();
        if (k==0) {
            System.out.println("Division by zero error");
            return null;
        }
        for (ArrayList<Float> rows : matrix) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (Float ele : rows) {
                row.add(ele/k);
            }
            result.matrix.add(row);
        }
        return result;
    }

    public Matrix add(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) {
            System.out.println("Cant be added, dimensions not compatible");
            return null;
        }
        for (int i =0; i<this.getrows(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<this.getcols(); j++) row.add( this.matrix.get(i).get(j) + m.matrix.get(i).get(j));
            result.matrix.add(row);
        }
        result.display();
        return result;
    }

    public Matrix sub(Matrix m) {
        //m1-m2
        Matrix result = new Matrix();
        if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) {
            System.out.println("Cant be subtracted, dimensions not compatible");
            return null;
        }
        for (int i =0; i<this.getrows(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<this.getcols(); j++) row.add( this.matrix.get(i).get(j) - m.matrix.get(i).get(j));
            result.matrix.add(row);
        }
        result.display();
        return result;
    }

    public Matrix elementwiseMul(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) {
            System.out.println("Cant be multiplied, dimensions not compatible");
            return null;
        }
        for (int i =0; i<this.getrows(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<this.getcols(); j++) row.add( this.matrix.get(i).get(j) * m.matrix.get(i).get(j));
            result.matrix.add(row);
        }
        result.display();
        return result;
    }

    public Matrix elementwiseDiv(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) {
            System.out.println("Cant be divided, dimensions not compatible");
            return null;
        }
        for (int i =0; i<this.getrows(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();

            for (int j=0; j<this.getcols(); j++) {
                if (m.matrix.get(i).get(j)==0) {
                    System.out.println("Division by zero error.");
                    return result;
                }
                row.add( this.matrix.get(i).get(j) / m.matrix.get(i).get(j));
            }
            result.matrix.add(row);
        }
        result.display();
        return result;
    }

    public Matrix Mul(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getrows()) {
            System.out.println("Cant be multiplied, dimensions not compatible");
            return null;
        }
        else {

            for(int i=0;i<this.getrows();i++)		{
                ArrayList<Float> row = new ArrayList<Float>();
                for(int j=0;j<m.getcols();j++)		{
                    float sum = 0;
                    for (int k=0; k<this.getcols();k++) sum += this.matrix.get(i).get(k) * m.matrix.get(k).get(j);
                    row.add(sum);
                }
                result.matrix.add(row);
            }
            result.display();
        }
        return result;
    }

    public Matrix Div(Squarematrix m) {
        if (m.isSingular()) {
            System.out.println("Divisor is not invertible");
            return null;
        }
        return this.Mul(m.inverse());
    }

    public boolean equalMatrices(Matrix m) {
        if (this.getcols() != m.getcols() || this.getrows() != m.getrows()) return false;
        else {
            for (int i =0; i<this.getrows(); i++) {
                for (int j = 0; j < this.getcols(); j++) {
                    if (!(this.matrix.get(i).get(j).equals(m.matrix.get(i).get(j)))) return false;
                }
            }
        }
        return true;
    }

    public Matrix trans() {
        Matrix result = new Matrix();
        for (int i =0; i<this.getcols(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<this.getrows(); j++) {
                row.add(this.matrix.get(j).get(i));
            }
            result.matrix.add(row);
        }
        return result;
    }

}
