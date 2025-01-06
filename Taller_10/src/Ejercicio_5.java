

/**
 *Ejercicio 5
Crea un programa que gestione el inventario de una tienda, así como la emisión
* de facturas. Utiliza una matriz bidimensional para almacenar los productos 
* disponibles en la tienda, con información como nombre, precio y cantidad. 
* El programa debe permitir facturar un producto dado su código, y unidades 
* deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la compra
* superar los $100, se debe aplicar un descuento.

Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 * @author PC
 */
import java.util.Scanner;

public class Ejercicio_5 {
    
public static void main(String[] args) {
    // Creamos una matriz para almacenar productos con nombre, precio y cantidad
    String[][] inventario = new String[5][3];  // Suponemos un inventario con 5 productos
    inventario[0][0] = "Producto A"; inventario[0][1] = "20.0"; inventario[0][2] = "50";  
    inventario[1][0] = "Producto B"; inventario[1][1] = "30.0"; inventario[1][2] = "30";
    inventario[2][0] = "Producto C"; inventario[2][1] = "40.0"; inventario[2][2] = "20";
    inventario[3][0] = "Producto D"; inventario[3][1] = "50.0"; inventario[3][2] = "15";
    inventario[4][0] = "Producto E"; inventario[4][1] = "60.0"; inventario[4][2] = "10";

    Scanner sc = new Scanner(System.in);
    double iva = 0.15;  // IVA del 15%
    double descuento = 0.10;  // Descuento del 10% si la compra supera los $100
    double totalFactura = 0;  // Total de la factura

    // Mostramos el inventario inicial para poder facturar
    System.out.println("\n--- INVENTARIO ---");
    System.out.println("Codigo | Producto   | Precio  | Cantidad");
    System.out.println("----------------------------------------");
    for (int i = 0; i < inventario.length; i++) {
        System.out.printf("%-6d | %-10s | %-7s | %-8s\n", i + 1, inventario[i][0], inventario[i][1], inventario[i][2]);
    }

    // Cree un menu para realizar la factura de el producto que decee por codigo
    // y una opcion mas que me permite ver de manera simplificada el monto total
    // de la factura que realice
    while (true) {
        System.out.println("\n--- MENU DE FACTURACION ---");
        System.out.println("1. Facturar un producto");
        System.out.println("2. Ver factura");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion (1-3): ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                // Para la facturación de un producto usamos el codigo y restamos 1 para ajustar el índice de la matriz
                // ademas agrege algunas condiciones que permitiran avisar al usuario si el codigo es valido o no 
                System.out.print("Ingrese el codigo del producto a facturar (1-5): ");
                int codigo = sc.nextInt() - 1; 
                if (codigo < 0 || codigo >= inventario.length) {
                    System.out.println("Codigo de producto invalido.");
                    break;
                }else{
                
                    System.out.print("Ingrese la cantidad deseada: ");
                    int cantidadDeseada = sc.nextInt();
                    int cantidadDisponible = Integer.parseInt(inventario[codigo][2]);

                    // Verificamos si hay suficientes existencias
                    if (cantidadDeseada > cantidadDisponible) {
                        System.out.println("ERROR: No hay suficientes existencias del producto.");
                    } else {
                        // Calculamos el precio total antes de IVA
                        double precioUnitario = Double.parseDouble(inventario[codigo][1]);
                        double subtotal = precioUnitario * cantidadDeseada;

                        // Sumamos IVA
                        double totalConIVA = subtotal + (subtotal * iva);

                        // Aplicamos descuento si el total supera los $100 y presentamos la factira
                        if (totalConIVA > 100) {
                            double totalConDescuento = totalConIVA - (totalConIVA * descuento);
                            System.out.println("\nFactura:");
                            System.out.println("Producto: " + inventario[codigo][0]);
                            System.out.println("Precio unitario: $" + precioUnitario);
                            System.out.println("Cantidad: " + cantidadDeseada);
                            System.out.println("Subtotal: $" + subtotal);
                            System.out.println("IVA (15%): $" + (subtotal * iva));
                            System.out.println("Descuento (10%): -$" + (totalConIVA * descuento));
                            System.out.println("Total: $" + totalConDescuento);
                            totalFactura += totalConDescuento;

                            // Actualizamos el inventario usamos valuesOf ya que estamos usando una matriz
                            //de tipo cadena pero la operacion de la resta se tiene que hacer en un formato numerico
                            inventario[codigo][2] = String.valueOf(cantidadDisponible - cantidadDeseada);
                        } else {
                            System.out.println("\nFactura:");
                            System.out.println("Producto: " + inventario[codigo][0]);
                            System.out.println("Precio unitario: $" + precioUnitario);
                            System.out.println("Cantidad: " + cantidadDeseada);
                            System.out.println("Subtotal: $" + subtotal);
                            System.out.println("IVA (15%): $" + (subtotal * iva));
                            System.out.println("Total: $" + totalConIVA);
                            totalFactura += totalConIVA;

                            // Actualizamos el inventario
                            inventario[codigo][2] = String.valueOf(cantidadDisponible - cantidadDeseada);
                        }
                    }
                }

                // Mostramos inventario actualizado después de realizar la facturación 
                System.out.println("\n--- INVENTARIO ACTUALIZADO ---");
                System.out.println("Codigo | Producto   | Precio  | Cantidad");
                System.out.println("----------------------------------------");
                for (int i = 0; i < inventario.length; i++) {
                    System.out.printf("%-6d | %-10s | %-7s | %-8s\n", i + 1, inventario[i][0], inventario[i][1], inventario[i][2]);
                }
                break;

            case 2:
                System.out.println("\n--- FACTURA ---");
                System.out.println("Total factura (con IVA y descuento si aplica): $" + totalFactura);
                break;

            case 3:
                System.out.println("Has salido del sistema de facturacion!");
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

--- INVENTARIO ---
Codigo | Producto   | Precio  | Cantidad
----------------------------------------
1      | Producto A | 20.0    | 50      
2      | Producto B | 30.0    | 30      
3      | Producto C | 40.0    | 20      
4      | Producto D | 50.0    | 15      
5      | Producto E | 60.0    | 10      

--- MENU DE FACTURACION ---
1. Facturar un producto
2. Ver factura
3. Salir
Seleccione una opcipn (1-3): 1
Ingrese el codigo del producto a facturar (1-5): 5
Ingrese la cantidad deseada: 3

Factura:
Producto: Producto E
Precio unitario: $60.0
Cantidad: 3
Subtotal: $180.0
IVA (15%): $27.0
Descuento (10%): -$20.700000000000003
Total: $186.3

--- INVENTARIO ACTUALIZADO ---
Codigo | Producto   | Precio  | Cantidad
----------------------------------------
1      | Producto A | 20.0    | 50      
2      | Producto B | 30.0    | 30      
3      | Producto C | 40.0    | 20      
4      | Producto D | 50.0    | 15      
5      | Producto E | 60.0    | 7       

--- MENU DE FACTURACION ---
1. Facturar un producto
2. Ver factura
3. Salir
Seleccione una opcion (1-3): 2

--- FACTURA ---
Total factura (con IVA y descuento si aplica): $186.3

--- MENU DE FACTURACION ---
1. Facturar un producto
2. Ver factura
3. Salir
Seleccione una opcion (1-3): 3
Has salido del sistema de facturacion!
BUILD SUCCESSFUL (total time: 33 seconds)

 */