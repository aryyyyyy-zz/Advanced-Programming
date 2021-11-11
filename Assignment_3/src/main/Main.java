package main;

import jdk.jshell.Diag;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Matrix> matrixList = new ArrayList<Matrix>();
    private static ArrayList<Squarematrix> sqmatrixList = new ArrayList<Squarematrix>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Matrix m = takeInput();
                    break;
                case 2:
                    listOfTypes();
                    CreateType();
                    break;
                case 3:

                    break;
                case 4:
                    displayMatrices();
                    System.out.print("Enter ID of operand matrix: ");
                    int id = sc.nextInt();
                    for (Matrix mat1: matrixList) {
                        if (mat1.id==id) {
                            mat1.displayLabels();
                            break;
                        }
                    }
                    for (Matrix mat2: sqmatrixList) {
                        if (mat2.id==id) {
                            mat2.displayLabels();
                            break;
                        }
                    }
                    break;
                case 5:
                    displayMatrices();
                    boolean flag3 = false;
                    System.out.println("Enter IDs of operand matrices");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i=0; i<matrixList.size(); i++) {
                        if (matrixList.get(i).id==x) {
                            for (int j=i+1; j<matrixList.size(); j++) {
                                if (matrixList.get(j).id==y) {
                                    operations(matrixList.get(i), matrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                            if (!flag3) for(int j=0; j<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==y) {
                                    operations(matrixList.get(i), sqmatrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                        }
                        if (matrixList.get(i).id==y && (!flag3)) {
                            if (!flag3) for (int j=i+1; j<matrixList.size(); j++) {
                                if (matrixList.get(j).id==x) {
                                    operations(matrixList.get(i), matrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                            if (!flag3) for(int j=0; j<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==x) {
                                    operations(matrixList.get(i), sqmatrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                        }

                        if (flag3) break;

                    }

                    for (int i=0; i<sqmatrixList.size(); i++) {
                        if (sqmatrixList.get(i).id==x) {
                            for (int j=i+1; j<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==y) {
                                    operations(sqmatrixList.get(i), sqmatrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                            if (!flag3) for(int j=0; j<matrixList.size(); j++) {
                                if (matrixList.get(j).id==y) {
                                    operations(sqmatrixList.get(i), matrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                        }
                        if (sqmatrixList.get(i).id==y && (!flag3)) {
                            for (int j=i+1; j<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==x) {
                                    operations(sqmatrixList.get(i), sqmatrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }
                            if (!flag3) for(int j=0; j<matrixList.size(); j++) {
                                if (matrixList.get(j).id==x) {
                                    operations(sqmatrixList.get(i), matrixList.get(j));
                                    flag3 = true;
                                    break;
                                }
                            }

                        }
                        if (flag3) break;
                    }
                    break;
                case 6:
                    displayMatrices();
                    System.out.println("Enter IDs of operand matrices");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    for (int i=0; i<matrixList.size(); i++) {
                        if (matrixList.get(i).id==x) {
                            for (int j=i+1; i<matrixList.size(); j++) {
                                if (matrixList.get(j).id==y) {
                                    eleoperations(matrixList.get(i), matrixList.get(j));
                                    break;
                                }
                            }
                            for(int j=0; i<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==y) {
                                    eleoperations(matrixList.get(i), matrixList.get(j));
                                    break;
                                }
                            }
                            break;
                        }
                        if (matrixList.get(i).id==y) {
                            for (int j=i+1; i<matrixList.size(); j++) {
                                if (matrixList.get(j).id==x) {
                                    eleoperations(matrixList.get(i), matrixList.get(j));
                                    break;
                                }
                            }
                            for(int j=0; i<sqmatrixList.size(); j++) {
                                if (sqmatrixList.get(j).id==x) {
                                    eleoperations(matrixList.get(i), matrixList.get(j));
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    break;
                case 7:
                    displayMatrices();
                    System.out.print("Enter ID of operand matrix: ");
                    int j = sc.nextInt();
                    for (Matrix mat1: matrixList) {
                        if (mat1.id==j) {
                            mat1.trans().display();
                            break;
                        }
                    }
                    for (Matrix mat2: sqmatrixList) {
                        if (mat2.id==j) {
                            mat2.trans().display();
                            break;
                        }
                    }
                    break;
                case 8:
                    displayMatrices();
                    System.out.print("Enter ID of operand matrix: ");
                    int d = sc.nextInt();
                    boolean flag = true;
                    for (Squarematrix mat1: sqmatrixList) {
                        if (mat1.id==d) {
                            mat1.inverse();
                            flag = false;
                        }
                    }
                    if (flag) System.out.println("Matrix is not invertible");
                    break;
                case 9:
                    break;
                case 10:
                    displayMatrices();
                    System.out.print("Enter index of operand matrix: ");
                    int e = sc.nextInt();
                    boolean flag1 = true;
                    for (Squarematrix mat1: sqmatrixList) {
                        if (mat1.id==e) {
                            System.out.println(mat1.determinant);
                            flag1 = false;
                        }
                    }
                    if (flag1) System.out.println("Determinant is not defined, matrix is not a square matrix");
                    break;
                case 11:
                    System.out.println("Use singleton matrix in matrix operations. Do you allow using singleton matrices as a scalar value? Enter 1 to proceed");
                    int option = sc.nextInt();
                    if (option!=1) break;
                    else {
                        System.out.print("Enter index of operand matrix: ");
                        int i = sc.nextInt();
                        System.out.println("Choose a singleton matrix now.");
                        int h = sc.nextInt();
                        System.out.println("Enter 1 to multiply by scalar, 0 to divide by scalar");
                        int op = sc.nextInt();
                        if (op==0) {
                            Squarematrix mat;
                            if (matrixList.get(h) instanceof Squarematrix && ((Squarematrix) matrixList.get(h)).isSingleton()){
                                mat = ((Squarematrix) matrixList.get(h));
                                matrixList.get(i).divbyscalar(mat.getScalar()).display();
                            }

                        }
                        else if (op==1) {
                            Squarematrix mat;
                            if (matrixList.get(h) instanceof Squarematrix && ((Squarematrix) matrixList.get(h)).isSingleton()){
                                mat = ((Squarematrix) matrixList.get(h));
                                matrixList.get(i).mulbyscalar(mat.getScalar()).display();
                            }
                        }
                        else System.out.println("Invalid input");
                    }
                    break;
                case 12:
                    displayMatrices();
                    System.out.print("Enter index of operand matrix: ");
                    int u = sc.nextInt();
                    boolean flag2 = true;
                    for (Squarematrix mat1: sqmatrixList) {
                        if (mat1.id==u) {
                            mat1.addTranspose();
                            flag2 = false;
                        }
                    }
                    if (flag2) System.out.println("operation is not defined, matrix is not a square matrix");
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    listOfTypes();
                    System.out.print("Enter matrix label: ");
                    String dummy = sc.nextLine();
                    String str = sc.nextLine();
                    for (Matrix p : matrixList) {
                        for (String label : p.label) if (str.equals(label)) p.display();
                    }
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
    public static void eleoperations(Matrix m1, Matrix m2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to add, 2 to subtract, 3 to multiply and 4 to divide");
        int val = sc.nextInt();
        switch (val) {
            case 1:
                m1.add(m2);
                break;
            case 2:
                m1.sub(m2);
                break;
            case 3:
                m1.elementwiseMul(m2);
                break;
            case 4:
                m1.elementwiseDiv(m2);
                break;
        }
    }

    public static void operations(Matrix m1, Matrix m2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to add, 2 to subtract, 3 to multiply and 4 to divide");
        int val = sc.nextInt();
        switch(val) {
            case 1:
                m1.add(m2);
                break;
            case 2:
                m1.sub(m2);
                break;
            case 3:
                m1.Mul(m2);
                break;
            case 4:
                if (sqmatrixList.contains(m2)) m1.Div((Squarematrix) m2);
                else System.out.println("Division not possible, divisor is not a square matrix (not invertible)");
                break;
        }
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

        if (rows==cols &&rows==1) {
            m = new Squarematrix(matrix);
            Squarematrix s = (Squarematrix)m;
            s = new Singletonmatrix(matrix.get(0).get(0));
            sqmatrixList.add(s);
            return s;
        }
        else if (nullFlag) {
            m = new Nullmatrix(rows,cols);
            matrixList.add(m);
            return m;
        }
        else if (onesFlag) {
            m = new Onesmatrix(rows,cols);
            matrixList.add(m);
            return m;
        }
        else if (rows == 1) {
            m = new Rowmatrix(matrix);
            matrixList.add(m);
            return m;
        }
        else if (cols == 1) {
            m = new Columnmatrix(matrix);
            matrixList.add(m);
            return m;
        }
        else if (rows==cols) {
            //square matrix
            Squarematrix w;
            m = new Squarematrix(matrix);
            Squarematrix s = (Squarematrix)m;
            if (s.isIdentity()) w = new Identitymatrix(rows);
            else if (s.isScalar()) w = new Scalarmatrix(rows);
            else if (s.isDiagonal()) w = new Diagonalmatrix(matrix);
            else if (s.isLowTriangular()) w = new LowTrimatrix(matrix);
            else if (s.isUppTriangular()) w = new UppTrimatrix(matrix);
            else if (s.isSymmetric()) w = new Symmmatrix(matrix);
            else if (s.isSkewSymmetric()) w = new Skewmatrix(matrix);
            else if (s.isSingular())  w = new Singularmatrix(matrix);
            else w = new Squarematrix(matrix);

            sqmatrixList.add(w);
            return w;
        }
        else {
            m = new Rectangularmatrix(matrix);
            matrixList.add(m);
            return m;
        }

    }

    public static void CreateType() {
        Scanner sc = new Scanner(System.in);
        Matrix m;
        Squarematrix s;
        System.out.print("Enter index of matrix that is to be created: ");
        String str = sc.nextLine();
        int choice = Integer.parseInt(str);
        switch(choice) {
            case 1:
                m = new Rectangularmatrix();
                System.out.println("following matrix created: ");
                m.display();
                matrixList.add(m);
                break;
            case 2:
                m = new Rowmatrix();
                System.out.println("following matrix created: ");
                m.display();
                matrixList.add(m);
                break;
            case 3:
                m = new Columnmatrix();
                System.out.println("following matrix created: ");
                m.display();
                matrixList.add(m);
                break;
            case 4:
                s = new Squarematrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 5:
                s = new Symmmatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 6:
                s = new Skewmatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 7:
                s = new UppTrimatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 8:
                s = new LowTrimatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 9:
                s = new Singularmatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
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
                s = new Singletonmatrix();
                System.out.println("following matrix created: ");
                s.display();
                sqmatrixList.add(s);
                break;
            case 14:
                m = new Onesmatrix();
                System.out.println("following matrix created: ");
                m.display();
                matrixList.add(m);
                break;
            case 15:
                m = new Nullmatrix();
                System.out.println("following matrix created: ");
                m.display();
                matrixList.add(m);
                break;
            default:
                m = null;
                System.out.println("Invalid input");
                break;

        }

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

    public static void displayMatrices() {
        for (Matrix m: matrixList) {
            System.out.println("ID: " + m.id);
            m.display();
        }
        for (Matrix m: sqmatrixList) {
            System.out.println("ID: " + m.id);
            m.display();
        }
    }

}
