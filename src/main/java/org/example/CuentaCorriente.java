package org.example;

/*
 * Esta clase representa una cuenta corriente que es una subclase de la clase Cuenta.
 * La cuenta corriente permite el uso de sobregiro, donde se puede retirar más dinero del saldo actual.
 */
public class CuentaCorriente extends Cuenta {
    /*Sobregiro de la cuenta corriente. */
    private float sobregiro = 0;

    /*
     * Constructor para crear una nueva cuenta corriente.
     * @param saldo El saldo inicial de la cuenta.
     * @param tasaAnual La tasa de interés anual de la cuenta en porcentaje.
     */
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    /*
     * Método para retirar una cantidad de dinero de la cuenta corriente.
     * Si la cantidad a retirar supera el saldo, el excedente se convierte en sobregiro.
     * @param cantidad La cantidad de dinero a retirar.
     */
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

    /**
     * Método para consignar una cantidad de dinero en la cuenta corriente.
     * Invoca al método heredado de la clase padre.
     * Si hay sobregiro, la cantidad consignada reduce el sobregiro.
     * @param cantidad La cantidad de dinero a consignar.
     */
    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad <= sobregiro) {
                sobregiro -= cantidad;
            } else {
                cantidad -= sobregiro;
                sobregiro = 0;
                super.consignar(cantidad);
            }
        } else {
            super.consignar(cantidad);
        }
    }

    /*
     * Método para generar el extracto mensual de la cuenta corriente.
     * Invoca al método heredado de la clase padre.
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    /*
     * Método para imprimir información detallada de la cuenta corriente.
     * Muestra el saldo, la comisión mensual, el número de transacciones realizadas,
     * y el valor del sobregiro si existe.
     */
    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión Mensual: " + getComisionMensual());
        System.out.println("Número de Transacciones Realizadas: " + (getNumeroConsignacion() + getNumeroRetiro()));
        if (sobregiro > 0) {
            System.out.println("Sobregiro: " + sobregiro);
        }
    }
}
