package org.example;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= getSaldo()) {
            super.retirar(cantidad);
        } else {
            float excedente = cantidad - getSaldo();
            super.retirar(getSaldo());
            sobregiro += excedente; // La cantidad excedente queda como sobregiro
        }
    }

    @Override
    public void depositar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad <= sobregiro) {
                sobregiro -= cantidad;
            } else {
                cantidad -= sobregiro;
                sobregiro = 0;
                super.depositar(cantidad);
            }
        } else {
            super.depositar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
        // Si hay sobregiro, imprimirlo
        if (sobregiro > 0) {
            System.out.println("Sobregiro: " + sobregiro);
        }
    }

    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión Mensual: " + getComisionMensual());
        System.out.println("Número de transacciones realizadas: " + (getNumeroConsignacion() + getNumeroRetiro()));
        if (sobregiro > 0) {
            System.out.println("Sobregiro: " + sobregiro);
        }
    }
}
