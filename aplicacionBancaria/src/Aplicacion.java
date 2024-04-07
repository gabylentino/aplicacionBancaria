import java.util.Scanner;

public class Aplicacion {
    static double saldo = 1599.99; // Saldo inicial


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre="Toni Stark";
        String mensaje=", ¿que deseas hacer hoy?";
        String cuenta="Corriente";
        System.out.println("*******************************************************************************\nBienvendio "+ nombre + "\nEl saldo de tu cuenta "+ cuenta +" es: $"+saldo+ mensaje+"\n*******************************************************************************");

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();//permite al usuario escribir su opcion

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirar(scanner);
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 9:
                    System.out.println("Finalizando el programa. ¡Gracias por usar nuestros servicios!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar");
        System.out.println("3. Depositar");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    static void retirar(Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();//el usuario escribe el monto
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se ha retirado $" + cantidad + ". Saldo restante: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente. No se puede retirar esa cantidad.");
        }
    }

    static void depositar(Scanner scanner) {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();//el usuario escribe el monto
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se ha depositado $" + cantidad + ". Saldo actual: $" + saldo);
        } else {
            System.out.println("No se puede depositar una cantidad negativa.");
        }
    }
}
