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

                // Realizar operaciones en las cuentas basadas en la entrada del usuario
                System.out.println("Operaciones en la cuenta corriente:");
                realizarOperaciones(cuentaCorriente, scanner);

                System.out.println("Operaciones en la cuenta de ahorros:");
                realizarOperaciones(cuentaAhorros, scanner);

                // Generar extractos mensuales para ambas cuentas
                cuentaCorriente.extractoMensual();
                cuentaAhorros.extractoMensual();

                // Imprimir la información de las cuentas
                System.out.println("Información de la cuenta corriente:");
                cuentaCorriente.imprimir();
                System.out.println();

                System.out.println("Información de la cuenta de ahorros:");
                cuentaAhorros.imprimir();

                // Cerrar el Scanner
                scanner.close();
        }

        /**
         * Método para realizar operaciones en una cuenta dada.
         * @param cuenta La cuenta en la que se realizarán las operaciones.
         * @param scanner El objeto Scanner para leer la entrada del usuario.
         */
        private static void realizarOperaciones(Cuenta cuenta, Scanner scanner) {
                boolean continuar = true;
                while (continuar) {
                        System.out.println("Elija una operación:");
                        System.out.println("1. Depositar");
                        System.out.println("2. Retirar");
                        System.out.println("3. Salir");

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
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        }
                }
        }
}
