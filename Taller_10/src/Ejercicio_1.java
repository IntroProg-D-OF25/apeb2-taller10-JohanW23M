

/**
 *Ejercicio 1
Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su 
*procesamiento para presentar los elementos:

De la diagonal principal.
De la diagonal segundaria.
Ubicados bajo la diagonal principal.
Ubicados sobre la diagonal principal.
Ubicados bajo la diagonal secundaria.
Ubicados sobre la diagonal secundaria.
 * @author: Johan Wang
 */
public class Ejercicio_1 {
    public static void main(String[] args) {
        int m = 5; 
        int[][] matriz = new int[m][m];

        //Llena la matriz con valores aleatorios de 0 a 100
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = (int) (Math.random() * 100); 
            }
        }
        //Imprime la matriz usando printf y asignandole "%3d" para que la 
        //matriz se alinie y sea facil de observar
        System.out.println("Matriz Generada:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d ", matriz[i][j]);
            }
            System.out.println();
        }
        
        //para impirmir elementos de la diagonal principal use la misma variable asi 
        //solo se presentan los elementos con el mismo indice
        System.out.println("Elementos de la diagonal principal:");
        for (int i = 0; i < m; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println("");
        
        //para la matriz secundaria use: [m - 1 - i] como indice de la columna ,
        //esto me permite ir leyendo desde la posicion [0][4] hacia abajo
        System.out.println("Elementos de la diagonal secundaria: ");
        for (int i = 0; i < m; i++) {
            System.out.print(matriz[i][m - 1 - i] + " ");
        }
        System.out.println("");
        

        //Para ir leyendo lo que esta bajo la diagonal principal hacemos que 
        //  j < i, con la finalidad de solo ir leyendo lo que este bajo, ay que
        // i siempre sera mayor que j y solo leera lo que esta anterior a ella
        // por ejemplo: Cuando Cuando i = 3 el bucle recorrera 0, 1, 3

        System.out.println("Elementos bajo la diagonal principal: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println("");
        // Ahora para los elementos sobre la diagonal ise que j = i + 1, para que
        //vaya leyendo lo que este en la fila pero como ise, j = i + 1 leera solo lo de arriba
        // por ejemplo i = 1 entonces j valdra 2 y asi solo presentara lo que este arriba de la diagonal.
        System.out.println("Elementos sobre la diagonal principal: ");
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        
        System.out.println("");
        //Hacemos el mismo proceso que con la principal pero use j = m - i,  para que
        // precente lo que esta bajo la segunda diagonal, como esta al otro lado entonces
        // irian de 4 hasta 0 entonces si i vale 0, j valdra 5 - 0 y como la condicion es: j < m
        // no se cumple y no se precenta nada en la osicion i = a 0 y asi continua en toda al matriz
        System.out.println("Elementos bajo la diagonal secundaria: ");
        for (int i = 0; i < m; i++) {
            for (int j = m - i; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println("");
        // Como la diagonal secunadaria la cree usando m - 1 - i, la use la misma condicion
        // para que dentro del bucle interno solo presente si j es menor que m - 1 - i
        // por ejemplo tenemos que i = 0 y j = 0 entonces m = 4, y como se cumple se presentan 
        //los elementos de la matriz en posicion j: 0, 1, 2, 3
        System.out.println("Elementos sobre la diagonal secundaria: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println("");
    }
}
/*
debug:
Matriz Generada:
 93  82  60  71  99 
 28  26  57  42   8 
  3  34   8  70   5 
 63  64  80  58  55 
 70  73  40  43  43 
Elementos de la diagonal principal:
93 26 8 58 43 
Elementos de la diagonal secundaria: 
99 42 8 64 70 
Elementos bajo la diagonal principal: 
28 3 34 63 64 80 70 73 40 43 
Elementos sobre la diagonal principal: 
82 60 71 99 57 42 8 70 5 55 
Elementos bajo la diagonal secundaria: 
8 70 5 80 58 55 73 40 43 43 
Elementos sobre la diagonal secundaria: 
93 82 60 71 28 26 57 3 34 63 
BUILD SUCCESSFUL (total time: 1 second)

*/
