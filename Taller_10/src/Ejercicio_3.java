

/**
 *Ejercicio 3
El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar 
* el periodo, la Dirección de la carrera de Computación a solicitado las siguientes 
* estadísticas de la materia INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios
* por estudiante, dichos promedios se deben calcular 
* (ponderar, ya que el docente ingresa todo sobre 10pts.) de 3 calificaciones 
* (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un peso del 30%).
* En resumen, los requerimientos son los siguientes:

Registre los nombres de cada estudiante de dicho paralelo.
Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
Obtenga el promedio del curso, del paralelo C.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 * @author: Johan Wang
 */
public class Ejercicio_3 {
    public static void main(String[] args) {
       
        String[] nombres = {
            "Juan ", "Alejandro", "Ricardo", "Carlos", "Ana", "Luis", "Marta", "Pedro", "Sofia", "Miguel",
            "Laura", "Andres", "Luis ", "Patricia", "Fernando", "Eva", "Clara", "Jose", "Carmen", "Daniel",
            "Beatriz", "Alejandro", "Sara", "David", "Raul", "Maria", "Hector", "Cristina", "Antonio", "Raquel"
        };

        
        double[][] calificaciones = new double[28][5];
        double sumaPromedios = 0;
        double promedio, ACD, APE, AA;

        
        for (int i = 0; i < 28; i++) {
            calificaciones[i][0] = i;  

           
            ACD = Math.round((Math.random() * 10) * 100.0) / 100.0;
            APE = Math.round((Math.random() * 10) * 100.0) / 100.0;
            AA = Math.round((Math.random() * 10) * 100.0) / 100.0;

            calificaciones[i][1] = ACD;
            calificaciones[i][2] = APE;
            calificaciones[i][3] = AA;

          
            promedio = (ACD * 0.35) + (APE * 0.35) + (AA * 0.30);
            calificaciones[i][4] = promedio;

            sumaPromedios += promedio;
        }


        double promedioCurso = sumaPromedios / 28;

        System.out.println("NUMERO | NOMBRE      | ACD   | APE   | AA    | PROMEDIOS");

      
        for (int i = 0; i < 28; i++) {
          
            System.out.printf("%-7d | %-10s | %.2f | %.2f | %.2f | %.2f\n", 
                (i + 1), nombres[i], calificaciones[i][1], calificaciones[i][2], calificaciones[i][3], calificaciones[i][4]);
        }

        // Promedio general del curso
        System.out.printf("\nPromedio general del curso: %.2f\n", promedioCurso);

      
        System.out.println("\nEstudiantes con promedio superior al promedio del curso:");
        for (int i = 0; i < 28; i++) {
            if (calificaciones[i][4] > promedioCurso) {
                System.out.printf("%-7d | %-10s - Promedio: %.2f\n", (i + 1), nombres[i], calificaciones[i][4]);
            }
        }

      
        System.out.println("\nEstudiantes con promedio inferior al promedio del curso:");
        for (int i = 0; i < 28; i++) {
            if (calificaciones[i][4] < promedioCurso) {
                System.out.printf("%-7d | %-10s - Promedio: %.2f\n", (i + 1), nombres[i], calificaciones[i][4]);
            }
        }

  
        int mayorPromedio = 0;
        for (int i = 1; i < 28; i++) {
            if (calificaciones[i][4] > calificaciones[mayorPromedio][4]) {
                mayorPromedio = i;
            }
        }
        System.out.printf("\nEstudiante con el mayor promedio: %-7d %s - Promedio: %.2f\n", 
            (mayorPromedio + 1), nombres[mayorPromedio], calificaciones[mayorPromedio][4]);

        int menorPromedio = 0;
        for (int i = 1; i < 28; i++) {
            if (calificaciones[i][4] < calificaciones[menorPromedio][4]) {
                menorPromedio = i;
            }
        }
        System.out.printf("\nEstudiante con el menor promedio: %-7d %s - Promedio: %.2f\n", 
            (menorPromedio + 1), nombres[menorPromedio], calificaciones[menorPromedio][4]);
    }
}

/*
Salida:
debug:
NUMERO | NOMBRE      | ACD   | APE   | AA    | PROMEDIOS
1       | Juan       | 4,20 | 6,35 | 7,53 | 5,95
2       | Alejandro  | 6,57 | 2,05 | 4,38 | 4,33
3       | Ricardo    | 3,15 | 0,11 | 0,82 | 1,39
4       | Carlos     | 1,79 | 9,97 | 3,66 | 5,21
5       | Ana        | 2,15 | 2,66 | 9,56 | 4,55
6       | Luis       | 3,41 | 3,36 | 9,67 | 5,27
7       | Marta      | 9,47 | 6,91 | 9,14 | 8,48
8       | Pedro      | 4,77 | 6,24 | 7,72 | 6,17
9       | Sofia      | 5,36 | 2,16 | 9,04 | 5,34
10      | Miguel     | 5,58 | 8,38 | 9,08 | 7,61
11      | Laura      | 2,15 | 6,46 | 7,21 | 5,18
12      | Andres     | 5,35 | 8,18 | 9,60 | 7,62
13      | Luis       | 2,51 | 4,75 | 6,49 | 4,49
14      | Patricia   | 1,24 | 6,01 | 7,67 | 4,84
15      | Fernando   | 0,25 | 8,36 | 6,28 | 4,90
16      | Eva        | 6,79 | 3,64 | 9,05 | 6,37
17      | Clara      | 1,97 | 4,98 | 5,66 | 4,13
18      | Jose       | 9,85 | 1,50 | 7,23 | 6,14
19      | Carmen     | 0,36 | 4,87 | 9,17 | 4,58
20      | Daniel     | 6,66 | 4,18 | 5,64 | 5,49
21      | Beatriz    | 1,15 | 7,85 | 9,79 | 6,09
22      | Alejandro  | 5,72 | 1,06 | 9,56 | 5,24
23      | Sara       | 2,53 | 8,85 | 4,50 | 5,33
24      | David      | 2,75 | 9,73 | 5,16 | 5,92
25      | Raul       | 3,51 | 9,33 | 5,67 | 6,19
26      | Maria      | 5,41 | 7,00 | 1,39 | 4,76
27      | Hector     | 4,63 | 9,42 | 0,86 | 5,18
28      | Cristina   | 0,97 | 2,63 | 1,06 | 1,58

Promedio general del curso: 5,30

Estudiantes con promedio superior al promedio del curso:
1       | Juan       - Promedio: 5,95
7       | Marta      - Promedio: 8,48
8       | Pedro      - Promedio: 6,17
9       | Sofia      - Promedio: 5,34
10      | Miguel     - Promedio: 7,61
12      | Andres     - Promedio: 7,62
16      | Eva        - Promedio: 6,37
18      | Jose       - Promedio: 6,14
20      | Daniel     - Promedio: 5,49
21      | Beatriz    - Promedio: 6,09
23      | Sara       - Promedio: 5,33
24      | David      - Promedio: 5,92
25      | Raul       - Promedio: 6,19

Estudiantes con promedio inferior al promedio del curso:
2       | Alejandro  - Promedio: 4,33
3       | Ricardo    - Promedio: 1,39
4       | Carlos     - Promedio: 5,21
5       | Ana        - Promedio: 4,55
6       | Luis       - Promedio: 5,27
11      | Laura      - Promedio: 5,18
13      | Luis       - Promedio: 4,49
14      | Patricia   - Promedio: 4,84
15      | Fernando   - Promedio: 4,90
17      | Clara      - Promedio: 4,13
19      | Carmen     - Promedio: 4,58
22      | Alejandro  - Promedio: 5,24
26      | Maria      - Promedio: 4,76
27      | Hector     - Promedio: 5,18
28      | Cristina   - Promedio: 1,58

Estudiante con el mayor promedio: 7       Marta - Promedio: 8,48

Estudiante con el menor promedio: 3       Ricardo - Promedio: 1,39
BUILD SUCCESSFUL (total time: 0 seconds)
*/