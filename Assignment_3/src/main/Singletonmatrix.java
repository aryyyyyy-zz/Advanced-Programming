package main;
import java.util.*;

public class Singletonmatrix extends Squarematrix{
    private float scalar;
    private static int count = 1400;

    {
        label.add("Singleton matrix");
        label.add("Row matrix");
        label.add("Column matrix");
        label.add("Symmetric matrix");
        label.add("Skew symmetric matrix");
        label.add("Lower triangular matrix");
        label.add("Upper triangular matrix");
        label.add("Diagonal matrix");
        label.add("Scalar matrix");
    }

    Singletonmatrix() {
        super(null);
        this.scalar = 2;
        this.determinant = 2;
        this.id = count;

        count++;
    }

    public Singletonmatrix(float scalar) {
        // TODO Auto-generated constructor stub
        super(null);
        this.scalar = scalar;
        this.determinant = scalar;
        this.id = count;

        if (this.scalar == 0) {
            label.add("Null matrix");
            label.add("Singular matrix");
        }
        else if (this.scalar == 1) {
            label.add("Ones matrix");
            label.add("Identity matrix");
        }
        count++;

    }
    public void display() {
        System.out.println("[ " + scalar+ " ]");
    }

    public Matrix divbyscalar(float k) {
        if (k==0) {
            System.out.println("Division by zero error");
            return null;
        }
        Matrix result = new Singletonmatrix(scalar/k);
        return result;
    }

    public Matrix mulbyscalar(float k) {

        Matrix result = new Singletonmatrix(scalar*k);
        return result;
    }

    public Matrix add(Matrix m) {
        if (m instanceof Singletonmatrix) {
            Matrix result = new Singletonmatrix(((Singletonmatrix) m).getScalar()+this.scalar);
            result.display();
            return result;
        }
        else {
            System.out.println("Invalid matrices");
            return null;
        }
    }

    public Matrix sub(Matrix m) {
        if (m instanceof Singletonmatrix) {
            Matrix result = new Singletonmatrix(this.scalar - ((Singletonmatrix) m).getScalar());
            result.display();
            return result;
        }
        else {
            System.out.println("Invalid matrices");
            return null;
        }
    }

    public Matrix elementwiseMul(Matrix m) {
        if (m instanceof Singletonmatrix) {
            Matrix result = mulbyscalar(((Singletonmatrix) m).getScalar());
            result.display();
            return result;
        }
        else {
            System.out.println("Invalid matrices");
            return null;
        }
    }

    public Matrix elementwiseDiv(Matrix m) {
        if (m instanceof Singletonmatrix) {
            Matrix result = divbyscalar(((Singletonmatrix) m).getScalar());
            result.display();
            return result;
        }
        else {
            System.out.println("Invalid matrices");
            return null;
        }
    }


    public Matrix Mul(Matrix m) {
        return elementwiseMul(m);
    }

    public boolean equalMatrices(Matrix m) {
        if (m instanceof Singletonmatrix && ((Singletonmatrix) m).getScalar() == this.scalar) return true;
        return false;
    }

    public Matrix trans() {
        return this;
    }

    public void adjoint() {

    }

    public Matrix inverse() {
        if (scalar == 0) return null;

        Matrix inverse = new Singletonmatrix(1/scalar);
        return inverse;
    }

    public float calcDeterminant() {
        return this.scalar;
    }

    public float getScalar() {
        return scalar;
    }

    public Matrix Div(Squarematrix m) {
        if (m instanceof Singletonmatrix) {
            if (m.inverse()!=null) return this.Mul(m.inverse());
            else {
                System.out.println("Divisor is null");
                return null;
            }
        }
        else {
            System.out.println("Invalid matrices");
            return null;
        }
    }

    public boolean isSymmetric() {
        return true;
    }

    public boolean isSkewSymmetric() {
        return true;
    }

    public boolean isSingular() {
        if (this.scalar == 0) return true;
        return false;
    }

    public boolean isLowTriangular() {
        return true;
    }

    public boolean isUppTriangular() {
        return true;
    }

    public boolean isDiagonal() {
        return true;
    }

    public boolean isScalar() {
        return true;
    }

    public boolean isIdentity() {
        if (this.scalar == 1) return true;
        return false;
    }

}
