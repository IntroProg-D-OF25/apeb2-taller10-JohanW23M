



/**
 *Ejercicio 6
Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. 
* Permita a dos jugadores marcar sus movimientos alternativamente. El juego 
* debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 * @author Johan Wang
 */


import java.util.Scanner;

public class Ejercicio_6 {
    
    public static void main(String[] args) {
        // Creamos la matriz  para el tablero del juego
        char[][] tablero = new char[3][3];
        // Iniciamos el tablero con espacios en blanco
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Variables para el juego
        char jugadorActual = 'X';  // Comienza el jugador 'X'
        boolean juegoTerminado = false;
        Scanner tcl = new Scanner(System.in);

        // El juego estara en un bucle hasta que termine gana o empata
        while (!juegoTerminado) {
            // Mostramos el tablero en cada turno
            System.out.println("\nTablero:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + tablero[i][j] + " ");
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
                if (i < 2) System.out.println("---|---|---");
            }

            // Pedimos al jugador actual que ingrese una posición
            System.out.println("\nJugador " + jugadorActual + ", ingrese la fila y columna (1-3) para su movimiento: ");

            int fila, columna;
            while (true) {
                // Pedir las coordenadas de la jugada
                System.out.print("Fila (1-3): ");
                fila = tcl.nextInt() - 1;  // Restamos 1 para que las posiciones empiecen desde 0
                System.out.print("Columna (1-3): ");
                columna = tcl.nextInt() - 1; 

                // Verificamos si la posición está ocupada
                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                    break;  // Si la posición es válida y está vacía tiene que salir del bucle
                } else {
                    System.out.println("Posición inválida. Intente nuevamente.");
                }
            }

            // Realizamos el movimiento
            tablero[fila][columna] = jugadorActual;

            // Verificamos si el jugador actual ha ganado
            boolean victoria = false;
           
            for (int i = 0; i < 3; i++) {
                // Verifica si gano por las filas desde donde se pone la ultima X u O
                if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                    victoria = true;
                    break;
                }
                // Verifica si gano en la columna  desde donde se pone la ultima X u O
                if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                    victoria = true;
                    break;
                }
            }
            // Verificamos las diagonales  desde donde se pone la ultima X u O
            if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
                victoria = true;
            }
            if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
                victoria = true;
            }

            // Si hay victoria terminar el juego
            if (victoria) {
                System.out.println("\nEl jugador " + jugadorActual + " ha ganado!");
                juegoTerminado = true;
                break;
            }

            // Verifica si hay un empate osea todas las casillas ocupadas
            boolean empate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == ' ') {
                        empate = false;
                        break;
                    }
                }
            }

            if (empate) {
                System.out.println("\nHan empatado!");
                juegoTerminado = true;
           
            } else {
            // para cambiar de jugador
                if (jugadorActual == 'X') {
                    jugadorActual = 'O';  // Si es el turno de X, cambia a O
                } else {
                    jugadorActual = 'X';  // Si es el turno de O, cambia a X
                }
            }
        }
     
    }
}
/**
 * debug:

Tablero:
   |   |   
---|---|---
   |   |   
---|---|---
   |   |   

Jugador X, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 1
Columna (1-3): 1

Tablero:
 X |   |   
---|---|---
   |   |   
---|---|---
   |   |   

Jugador O, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 2
Columna (1-3): 1

Tablero:
 X |   |   
---|---|---
 O |   |   
---|---|---
   |   |   

Jugador X, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 2
Columna (1-3): 2

Tablero:
 X |   |   
---|---|---
 O | X |   
---|---|---
   |   |   

Jugador O, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 3
Columna (1-3): 1

Tablero:
 X |   |   
---|---|---
 O | X |   
---|---|---
 O |   |   

Jugador X, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 3
Columna (1-3): 2

Tablero:
 X |   |   
---|---|---
 O | X |   
---|---|---
 O | X |   

Jugador O, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 1
Columna (1-3): 2

Tablero:
 X | O |   
---|---|---
 O | X |   
---|---|---
 O | X |   

Jugador X, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 1
Columna (1-3): 3

Tablero:
 X | O | X 
---|---|---
 O | X |   
---|---|---
 O | X |   

Jugador O, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 3
Columna (1-3): 3

Tablero:
 X | O | X 
---|---|---
 O | X |   
---|---|---
 O | X | O 

Jugador X, ingrese la fila y columna (1-3) para su movimiento: 
Fila (1-3): 2
Columna (1-3): 3

Han empatado!
BUILD SUCCESSFUL (total time: 2 minutes 16 seconds)
 */
