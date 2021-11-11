package main;

public class Nullmatrix extends Matrix{
    private int rows;
    private int cols;
    private static int count = 300;

    Nullmatrix() {
        this.id = count;
        this.rows = 3;
        this.cols= 4;
        label.add("Null matrix");
        count++;
    }

    public Nullmatrix(int r, int c) {
        this.id = count;
        this.rows = r;
        this.cols= c;
        label.add("Null matrix");
        if (r==1) label.add("Row matrix");
        if (c==1) label.add("Column matrix");
        if (r==c) {
            label.add("Square matrix");
            label.add("Symmetric matrix");
            label.add("Skew Symmetric matrix");
            //cant be singleton
            label.add("Singular matrix");
            label.add("Lower triangular matrix");
            label.add("Upper triangular matrix");
            label.add("Diagonal matrix");
            label.add("Scalar matrix");
        }
        count++;
    }

    @Override
    public void display() {
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) System.out.print("0" + " ");
            System.out.println();
        }
    }

    @Override
    public Matrix add(Matrix m) {
        Matrix result = new Matrix();
        if (cols != m.getcols() || rows!= m.getrows()) {
            System.out.println("Cant be added, dimensions not compatible");
            return result;
        }
        result = m;
        result.display();
        return result;
    }
    @Override
    public Matrix sub(Matrix m) {
        //null-m
        Matrix result = new Matrix();
        if (cols != m.getcols() || rows!= m.getrows()) {
            System.out.println("Cant be subtracted, dimensions not compatible");
            return result;
        }
        result = m.divbyscalar(-1);
        result.display();
        return result;
    }
    @Override
    public Matrix elementwiseMul(Matrix m) {
        Matrix result = new Matrix();
        if (cols != m.getcols() || rows!= m.getrows()) {
            System.out.println("Cant be multiplied, dimensions not compatible");
            return result;
        }
        result = new Nullmatrix(this.rows, this.cols);
        result.display();
        return result;
    }
    @Override
    public Matrix elementwiseDiv(Matrix m) {
        Matrix result = new Matrix();
        if (cols != m.getcols() || rows!= m.getrows()) {
            System.out.println("Cant be added, dimensions not compatible");
            return result;
        }
        result = new Nullmatrix(this.rows, this.cols);
        result.display();
        return result;
    }

    @Override
    public Matrix divbyscalar(float k) {
        this.display();
        return this;
    }

    @Override
    public Matrix mulbyscalar(float k) {
        this.display();
        return this;
    }

    @Override
    public Matrix Mul(Matrix m) {
        Matrix result = new Matrix();
        if (this.getcols() != m.getrows()) {
            System.out.println("Cant be multiplied, dimensions not compatible");
            return result;
        }
        this.display();
        return this;
    }

    @Override
    public Matrix trans() {
        Matrix result = new Nullmatrix(this.cols, this.rows);
        return result;
    }
}
