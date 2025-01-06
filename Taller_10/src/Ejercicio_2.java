

/**
 * Ejercicio 2
Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, 
* desarrollar su procesamiento para calcular y presentar:

La suma de las dos matrices (considerar las restricciones matemáticas para ello).
La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 * @author: Johan Wang
 */
import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        System.out.println("De que dimensiones desea la primera matriz?");
        int m1 = tcl.nextInt();  
        int n1 = tcl.nextInt();  

       
        System.out.println("De que dimensiones desea la segunda matriz?");
        int m2 = tcl.nextInt();  
        int n2 = tcl.nextInt();  

        int[][] matriz1 = new int[m1][n1];
        int[][] matriz2 = new int[m2][n2];

        System.out.println("Matriz 1: ");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matriz1[i][j] = (int) (Math.random() * 10); 
                System.out.printf("%3d ", matriz1[i][j]);
            }
            System.out.println();
        }

        // Llenar la segunda matriz con números aleatorios
        System.out.println("Matriz 2: ");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matriz2[i][j] = (int) (Math.random() * 10); 
                System.out.printf("%3d ", matriz2[i][j]);
            }
            System.out.println();
        }

        // Verificar y realizar la suma de matrices
        if (m1 == m2 && n1 == n2) {
            System.out.println("Suma de matrices: ");
            int[][] suma = new int[m1][n1]; // Matriz para almacenar la suma
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    suma[i][j] = matriz1[i][j] + matriz2[i][j];
                    System.out.printf("%3d ", suma[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Las matrices no tienen las mismas dimensiones, no se puede realizar la suma.");
        }

        if (n1 == m2) {
            System.out.println("Multiplicacion de matrices: ");
            int[][] multiplicacion = new int[m1][n2]; 
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    multiplicacion[i][j] = 0;  
                    for (int k = 0; k < n1; k++) {
                        multiplicacion[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                    System.out.printf("%3d ", multiplicacion[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Las matrices no tienen las dimensiones adecuadas para multiplicarse.");
        }
    }
}
/*
debug:
De que dimensiones desea la primera matriz?
3
4
De que dimensiones desea la segunda matriz?
3
4
Matriz 1: 
  6   5   6   9 
  8   8   4   5 
  3   6   4   9 
Matriz 2: 
  0   6   9   5 
  2   5   4   1 
  7   1   1   0 
Suma de matrices: 
  6  11  15  14 
 10  13   8   6 
 10   7   5   9 
Las matrices no tienen las dimensiones adecuadas para multiplicarse.
BUILD SUCCESSFUL (total time: 12 seconds)

debug:
De que dimensiones desea la primera matriz?
3
2
De que dimensiones desea la segunda matriz?
2
3
Matriz 1: 
  1   1 
  1   1 
  5   3 
Matriz 2: 
  5   8   5 
  4   8   7 
Las matrices no tienen las mismas dimensiones, no se puede realizar la suma.
Multiplicaci0n de matrices: 
  9  16  12 
  9  16  12 
 37  64  46 
BUILD SUCCESSFUL (total time: 5 seconds)
debug:
De que dimensiones desea la primera matriz?
4
4
De que dimensiones desea la segunda matriz?
4
4
Matriz 1: 
  5   1   4   1 
  5   1   8   3 
  0   0   4   1 
  9   9   1   1 
Matriz 2: 
  1   5   1   3 
  8   4   2   3 
  7   1   9   9 
  9   5   6   7 
Suma de matrices: 
  6   6   5   4 
 13   5  10   6 
  7   1  13  10 
 18  14   7   8 
Multiplicaci0n de matrices: 
 50  38  49  61 
 96  52  97 111 
 37   9  42  43 
 97  87  42  70 
BUILD SUCCESSFUL (total time: 3 seconds)
debug:
De que dimensiones desea la primera matriz?
4
3
De que dimensiones desea la segunda matriz?
5
8
Matriz 1: 
  9   1   8 
  9   0   7 
  5   8   6 
  4   6   7 
Matriz 2: 
  4   6   8   6   6   5   8   8 
  8   8   4   9   9   0   7   4 
  8   2   8   2   5   6   3   4 
  1   9   3   9   4   8   5   2 
  9   3   4   3   5   2   3   7 
Las matrices no tienen las mismas dimensiones, no se puede realizar la suma.
Las matrices no tienen las dimensiones adecuadas para multiplicarse.
BUILD SUCCESSFUL (total time: 10 seconds)

*/
