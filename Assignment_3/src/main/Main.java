package main;

import jdk.jshell.Diag;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Matrix> matrixList = new ArrayList<Matrix>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Matrix m = takeInput();
                    matrixList.add(m);
                    m.display();
                    break;
                case 2:
                    listOfTypes();
                    Matrix n = CreateType();
                    matrixList.add(n);
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Enter indices of operand matrices");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    System.out.println("Enter 1 to add, 2 to subtract, 3 to multiply and 4 to divide");
                    int val = sc.nextInt();
                    switch(val) {
                        case 1:
                            matrixList.get(x).add(matrixList.get(y));
                            break;
                        case 2:
                            matrixList.get(x).sub(matrixList.get(y));
                            break;
                        case 3:
                            matrixList.get(x).Mul(matrixList.get(y));
                            break;
                        case 4:
                            Squarematrix s;
                            if (matrixList.get(y) instanceof Squarematrix) {
                                s = (Squarematrix)matrixList.get(x);
                                matrixList.get(x).Div(s);
                            }
                            else System.out.println("Division not possible, divisor is not a square matrix (not invertible)");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Enter indices of operand matrices");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("Enter 1 to add, 2 to subtract, 3 to multiply and 4 to divide");
                    int num = sc.nextInt();
                    switch(num) {
                        case 1:
                            matrixList.get(a).add(matrixList.get(b));
                            break;
                        case 2:
                            matrixList.get(a).sub(matrixList.get(b));
                            break;
                        case 3:
                            matrixList.get(a).elementwiseMul(matrixList.get(b));
                            break;
                        case 4:
                            matrixList.get(a).elementwiseDiv(matrixList.get(b));
                            break;
                    }
                    break;
                case 7:
                    System.out.print("Enter index of operand matrix: ");
                    int index = sc.nextInt();
                    matrixList.get(index).trans();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    System.out.print("Enter index of operand matrix: ");
                    int i = sc.nextInt();
                    Matrix o = matrixList.get(i);
                    if (o instanceof Squarematrix) ((Squarematrix) o).addTranspose();
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("------------------------------------------------");
        }while(choice != 16);


    }
    public static Matrix takeInput() {
        Scanner sc = new Scanner(System.in);
        Matrix m;
        ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>();
        boolean nullFlag = true, onesFlag = true;
        System.out.print("Enter no of rows: ");
        String st = sc.nextLine();
        int rows = Integer.parseInt(st);
        System.out.print("Enter no of columns: ");
        st = sc.nextLine();
        int cols = Integer.parseInt(st);
        for (int i =0 ; i<rows ; i++) {
            System.out.println("Enter elements for row " + (int)(i+1) +": ");
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j =0 ; j<cols; j++) {
                System.out.print("Enter elements for column " + (int)(j+1) +": ");
                String str = sc.nextLine();
                if (str.equals("")) {
                    System.out.println("Invalid input");
                    break;
                }
                float element = Float.parseFloat(str);
                row.add(element);
                if (element !=0 ) nullFlag = false;
                if (element !=1 ) onesFlag = false;
            }
            matrix.add(row);
        }
        if (rows==cols &&rows==1) m = new Singletonmatrix(matrix.get(0).get(0));
        else if (nullFlag) m = new Nullmatrix(rows,cols);
        else if (onesFlag) m = new Onesmatrix(rows,cols);
        else if (rows == 1) m = new Rowmatrix(matrix);
        else if (cols == 1) m = new Columnmatrix(matrix);
        else if (rows==cols) {
            //square matrix
            m = new Squarematrix(matrix);
            Squarematrix s = (Squarematrix)m;
            if (s.isIdentity()) s = new Identitymatrix(rows);
            if (s.isScalar()) s = new Scalarmatrix(rows);
            if (s.isDiagonal()) s = new Diagonalmatrix(matrix);
            if (s.isLowTriangular()) s = new LowTrimatrix(matrix);
            if (s.isUppTriangular()) s = new UppTrimatrix(matrix);
            if (s.isSymmetric()) s = new Symmmatrix(matrix);
            if (s.isSkewSymmetric()) s = new Skewmatrix(matrix);
            if (s.isSingular()) s = new Singularmatrix(matrix);
            return s;
        }
        else m = new Rectangularmatrix(matrix);
        return m;

    }

    public static Matrix CreateType() {
        Scanner sc = new Scanner(System.in);
        Matrix m;
        System.out.print("Enter index of matrix that is to be created: ");
        String str = sc.nextLine();
        int choice = Integer.parseInt(str);
        switch(choice) {
            case 1:
                m = new Rectangularmatrix();
                break;
            case 2:
                m = new Rowmatrix();
                break;
            case 3:
                m = new Columnmatrix();
                break;
            case 4:
                m = new Squarematrix();
                break;
            case 5:
                m = new Symmmatrix();
                break;
            case 6:
                m = new Skewmatrix();
                break;
            case 7:
                m = new UppTrimatrix();
                break;
            case 8:
                m = new LowTrimatrix();
                break;
            case 9:
                m = new Singularmatrix();
                break;
//            case 10:
//                //m = new Diagonalmatrix();
//                break;
//            case 11:
//                //m = new Scalarmatrix();
//                break;
//            case 12:
//                //m = new Identitymatrix();
//                break;
            case 13:
                m = new Singletonmatrix();
                break;
            case 14:
                m = new Onesmatrix();
                break;
            case 15:
                m = new Nullmatrix();
                break;
            default:
                m = null;
                System.out.println("Invalid input");
                break;

        }
        return m;
    }
    public static void displayMenu() {
        System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n" +
                "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n" +
                "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n" +
                "4. Display all the matrix-type labels of a requested matrix.\n" +
                "5. Perform addition, subtraction, multiplication & division.\n" +
                "6. Perform element-wise operations.\n" +
                "7. Transpose matrices.\n" +
                "8. Inverse matrices.\n" +
                "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n" +
                "10. Compute determinants.\n" +
                "11. Use singleton matrices as scalars, if requested.\n" +
                "12. Compute A+At for a matrix A.\n" +
                "13. Compute Eigen vectors and values.\n" +
                "14. Solve sets of linear equations using matrices.\n" +
                "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n" +
                "16. Exit program.\n");
    }

    public static void listOfTypes() {
        System.out.println("1. Rectangular Matrix\n" +
                "2. Row Matrix\n" +
                "3. Column Matrix\n" +
                "4. Square Matrix\n" +
                "5. Symmetric Matrix\n" +
                "6. Skew-symmetric Matrix\n" +
                "7. Upper-triangular Matrix\n" +
                "8. Lower-triangular Matrix\n" +
                "9. Singular Matrix\n" +
                "10. Diagonal Matrix\n" +
                "11. Scalar Matrix\n" +
                "12. Identity Matrix\n" +
                "13. Singleton Matrix\n" +
                "14. Ones Matrix\n" +
                "15. Null Matrix");
    }

}
