package org.example;


public class Main {
    public static void main(String[] args){

            // Crear una cuenta corriente con un saldo inicial de 1000 y una tasa anual del 5%
            CuentaCorriente cuentaCorriente = new CuentaCorriente(50, 12);

            // Crear una cuenta de ahorros con un saldo inicial de 500 y una tasa anual del 3%
            CuentaAhorros cuentaAhorros = new CuentaAhorros(500, 12);

            // Realizar algunas operaciones en las cuentas
            cuentaCorriente.depositar(500); // Depositar 500 en la cuenta corriente
            cuentaCorriente.retirar(200);   // Retirar 200 de la cuenta corriente
            cuentaCorriente.retirar(200);
            cuentaCorriente.retirar(200);
            cuentaCorriente.extractoMensual(); // Generar extracto mensual de la cuenta corriente

            cuentaAhorros.depositar(300);   // Depositar 300 en la cuenta de ahorros
            cuentaAhorros.retirar(100);    // Retirar 100 de la cuenta de ahorros
            cuentaAhorros.retirar(50);
            cuentaAhorros.retirar(50);
            cuentaAhorros.retirar(50);
            cuentaAhorros.retirar(50);

            cuentaAhorros.extractoMensual(); // Generar extracto mensual de la cuenta de ahorros

            // Imprimir la información de las cuentas
            System.out.println("Información de la cuenta corriente:");
            cuentaCorriente.imprimir();
            System.out.println();

            System.out.println("Información de la cuenta de ahorros:");
            cuentaAhorros.imprimir();
        }
    }