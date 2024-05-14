package org.example;
import java.util.Scanner;


/*
* Autor:Joel Caza
* Materia:lenguajes de Programacion 2
* Fecha: 13/05/2024
* */
public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Pedir al usuario que ingrese el saldo inicial y la tasa anual para la cuenta corriente
                System.out.println("Ingrese el saldo inicial de la cuenta corriente:");
                float saldoCorriente = scanner.nextFloat();
                System.out.println("Ingrese la tasa anual de la cuenta corriente:");
                float tasaCorriente = scanner.nextFloat();

                // Crear una cuenta corriente con los valores proporcionados por el usuario
                CuentaCorriente cuentaCorriente = new CuentaCorriente(saldoCorriente, tasaCorriente);

                // Pedir al usuario que ingrese el saldo inicial y la tasa anual para la cuenta de ahorros
                System.out.println("Ingrese el saldo inicial de la cuenta de ahorros:");
                float saldoAhorros = scanner.nextFloat();
                System.out.println("Ingrese la tasa anual de la cuenta de ahorros:");
                float tasaAhorros = scanner.nextFloat();

                // Crear una cuenta de ahorros con los valores proporcionados por el usuario
                CuentaAhorros cuentaAhorros = new CuentaAhorros(saldoAhorros, tasaAhorros);

                // Menú de operaciones
                boolean continuar = true;
                while (continuar) {
                        System.out.println("Menú de operaciones:");
                        System.out.println("1. Operaciones en la cuenta corriente");
                        System.out.println("2. Operaciones en la cuenta de ahorros");
                        System.out.println("3. Salir");

                        int opcion = scanner.nextInt();
                        switch (opcion) {
                                case 1:
                                        realizarOperaciones(cuentaCorriente, scanner);
                                        break;
                                case 2:
                                        realizarOperaciones(cuentaAhorros, scanner);
                                        break;
                                case 3:
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        }
                }

                // Cerrar el Scanner
                scanner.close();
        }

        private static void realizarOperaciones(Cuenta cuenta, Scanner scanner) {
                boolean continuar = true;
                while (continuar) {
                        System.out.println("Operaciones en la cuenta:");
                        System.out.println("1. Depositar");
                        System.out.println("2. Retirar");
                        System.out.println("3. Imprimir información de la cuenta");
                        System.out.println("4. Salir");

                        int opcion = scanner.nextInt();
                        switch (opcion) {
                                case 1:
                                        System.out.println("Ingrese la cantidad a depositar:");
                                        float cantidadDepositar = scanner.nextFloat();
                                        cuenta.depositar(cantidadDepositar);
                                        break;
                                case 2:
                                        System.out.println("Ingrese la cantidad a retirar:");
                                        float cantidadRetirar = scanner.nextFloat();
                                        cuenta.retirar(cantidadRetirar);
                                        break;
                                case 3:
                                        cuenta.imprimir();
                                        break;
                                case 4:
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        }
                }
        }
}
