
/**
 *Ejercicio 4
Crea un programa que gestione el inventario de una tienda. Utiliza una matriz
* bidimensional para almacenar los productos disponibles en la tienda, con 
* información como nombre, precio y cantidad. El programa debe permitir 
* agregar nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 * @author Johan Wang.
 */

import java.util.Scanner;

public class Ejercicio_4 {

    public static void main(String[] args) {
        String[][] inventario = new String[100][3];  // Creamos la matriz para los productos  asumindo que ingresare 100 productos
        int totalProductos = 0;  // Número de productos en el inventario
        Scanner sc = new Scanner(System.in);
        String nombre;
        // Cree un menu para que el usuario se le haga mas facil realizar cambios en el inventario
        while (true) {
            System.out.println("\n--- MENU DE INVENTARIO ---");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar existencias de un producto");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Ver inventario completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion (1-6): ");
            
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiamos el buffer de entrada para evitar el problema con nextLine()

            switch (opcion) {
                case 1:
                    // Hice el agregado de productos dentro de un if else para
                    //que en caso de llenar el inventario me avise que ya se llenó
                    if (totalProductos >= inventario.length) {
                        System.out.println("Inventario está lleno, no se pueden agregar mas productos.");
                        break;
                    } else {
                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = sc.nextLine();
                    
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = sc.nextDouble();
                    
                        System.out.print("Ingrese la cantidad disponible: ");
                        int cantidad = sc.nextInt();
                    
                        // Almacenamos el producto en el inventario
                        inventario[totalProductos][0] = nombre;
                        inventario[totalProductos][1] = String.format("%.2f", precio);  // Convertimos el precio a String con 2 decimales
                        inventario[totalProductos][2] = String.valueOf(cantidad);  // Convertimos la cantidad a String
                    
                        totalProductos++;  // Incrementamos el contador de productos
                        System.out.println("Producto agregado correctamente.");
                        break;
                    }
                case 2:
                    // para actualizar utilizamos el nombre y con un ciclo for buscamos el que coincida donde i es el
                    //indice de las filas y es el unico que cambiara ya que en posicion 0 de las columnas siempre se guardaran
                    //nombres, en caso de no encontrarlo avisa al usuario de que no fue encontrado
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    nombre = sc.nextLine();
                    
                    boolean encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombre)) {
                            System.out.print("Ingrese la nueva cantidad disponible: ");
                            int nuevaCantidad = sc.nextInt();
                            
                            // Actualizamos la cantidad, el índice de columnas no cambia ya que
                            //en la posición 2 se guardan cantidades de producto
                            inventario[i][2] = String.valueOf(nuevaCantidad);
                            System.out.println("Cantidad actualizada correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 3:
                    // Para buscar utilizamos nombre y utilizando un for vamos viendo
                    // con cual coincida usamos equalsIgnoreCase por si utiliza alguna 
                    // mayúscula o minúscula en la búsqueda. Esto significa que si
                    // el usuario ingresa "manzana", "MANZANA" o "Manzana" igual lo 
                    // encontrará.
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    nombre = sc.nextLine();
                    
                    encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombre)) {
                            System.out.println("\nProducto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 4:
                    // Eliminar producto lo hacemos con el nombre
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    nombre = sc.nextLine();
                    
                    encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombre)) {
                            // Desplazamos todos los productos siguientes una posición hacia atrás 
                            for (int j = i; j < totalProductos - 1; j++) {
                                inventario[j] = inventario[j + 1];
                            }
                         
                            // Reducimos el total de productos
                            totalProductos--;
                            System.out.println("Producto eliminado correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 5:
                    // Ver inventario completo lo hacemos en formato de tabla, de manera
                    // que el usuario se le haga fácil de leer.
                    if (totalProductos == 0) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        System.out.println("\n--- INVENTARIO ---");
                        System.out.println("Nombre          | Precio   | Cantidad");
                        System.out.println("--------------------------------------");
                        for (int i = 0; i < totalProductos; i++) {
                            System.out.printf("%-15s | %-8s | %-8s\n", inventario[i][0], inventario[i][1], inventario[i][2]);
                        }
                    }
                    break;

                case 6:
                    // Salir del programa
                    System.out.println("Has salido del sistema de inventario");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }
}
/**
 * debug:

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 1
Ingrese el nombre del producto: Queso
Ingrese el precio del producto: 2,50
Ingrese la cantidad disponible: 5
Producto agregado correctamente.

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 1
Ingrese el nombre del producto: Arroz
Ingrese el precio del producto: 0,70
Ingrese la cantidad disponible: 50
Producto agregado correctamente.

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 1
Ingrese el nombre del producto: Manzana
Ingrese el precio del producto: 0,50
Ingrese la cantidad disponible: 20
Producto agregado correctamente.

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 5

--- INVENTARIO ---
Nombre          | Precio   | Cantidad
--------------------------------------
Queso           | 2,50     | 5       
Arroz           | 0,70     | 50      
Manzana         | 0,50     | 20      

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 2
Ingrese el nombre del producto a actualizar: Manzana
Ingrese la nueva cantidad disponible: 80
Cantidad actualizada correctamente.

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 3
Ingrese el nombre del producto a buscar: arroz

Producto encontrado:
Nombre: Arroz
Precio: 0,70
Cantidad: 50

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 4
Ingrese el nombre del producto a eliminar: Arroz
Producto eliminado correctamente.

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 5

--- INVENTARIO ---
Nombre          | Precio   | Cantidad
--------------------------------------
Queso           | 2,50     | 5       
Manzana         | 0,50     | 80      

--- MENU DE INVENTARIO ---
1. Agregar nuevo producto
2. Actualizar existencias de un producto
3. Buscar producto por nombre
4. Eliminar producto
5. Ver inventario completo
6. Salir
Seleccione una opcion (1-6): 6
Has salido del sistema de inventario
BUILD SUCCESSFUL (total time: 1 minute 55 seconds)

 */
