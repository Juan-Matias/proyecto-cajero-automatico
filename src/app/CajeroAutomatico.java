package app;

import modelo.*;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaDeAhorro("Tony Stark", "Ahorro", 1599.99, 0.05);

        int opcion = 0;

        System.out.println("*****************************************");
        System.out.println("\nNombre del cliente: " + cuenta.getTitular());
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        System.out.println("Saldo disponible: $" + cuenta.getSaldo());
        System.out.println("\n*****************************************");

        String menu = """
                ** Escriba el número de la opción deseada **
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                4 - Aplicar intereses
                9 - Salir
                """;

        while (opcion != 9) {
            System.out.println(menu);
            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: $" + cuenta.getSaldo());
                        break;
                    case 2:
                        System.out.println("¿Cuánto desea retirar?");
                        double retiro = Double.parseDouble(teclado.nextLine());
                        cuenta.retirar(retiro);
                        System.out.println("Retiro exitoso. Saldo actual: $" + cuenta.getSaldo());
                        break;
                    case 3:
                        System.out.println("¿Cuánto desea depositar?");
                        double deposito = Double.parseDouble(teclado.nextLine());
                        cuenta.depositar(deposito);
                        System.out.println("Depósito exitoso. Saldo actual: $" + cuenta.getSaldo());
                        break;
                    case 4:
                        if (cuenta instanceof CuentaDeAhorro ahorro) {
                            ahorro.aplicarInteresMensual();
                            System.out.println("Interés aplicado. Saldo actual: $" + ahorro.getSaldo());
                        } else {
                            System.out.println("La cuenta no es de ahorro.");
                        }
                        break;
                    case 9:
                        System.out.println("Gracias por usar nuestro cajero.");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
            } catch (EntradaInvalidaException | SaldoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        teclado.close();
    }
}
