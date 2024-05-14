package org.example;

/**
 * Esta clase representa una cuenta corriente que es una subclase de la clase Cuenta.
 * La cuenta corriente permite el uso de sobregiro, donde se puede retirar más dinero del saldo actual.
 */
public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0; // Saldo negativo permitido como sobregiro

    /**
     * Constructor de la clase CuentaCorriente.
     *
     * @param saldo     El saldo inicial de la cuenta corriente.
     * @param tasaAnual La tasa anual de interés de la cuenta corriente.
     */
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual); // Llama al constructor de la clase base (Cuenta)
    }

    /**
     * Permite retirar dinero de la cuenta corriente, permitiendo el uso de sobregiro si es necesario.
     *
     * @param cantidad La cantidad de dinero a retirar.
     */
    @Override
    public void retirar(float cantidad) {
        if (cantidad <= getSaldo()) { // Si la cantidad a retirar es menor o igual al saldo actual
            super.retirar(cantidad); // Se realiza el retiro normalmente
        } else { // Si la cantidad a retirar supera el saldo actual
            float excedente = cantidad - getSaldo(); // Calcula el excedente que se retira como sobregiro
            super.retirar(getSaldo()); // Retiratodo el saldo disponible
            sobregiro += excedente; // La cantidad excedente queda como sobregiro
        }
    }

    /**
     * Permite depositar dinero en la cuenta corriente.
     * Si hay sobregiro, los depósitos primero se usan para cubrir el sobregiro antes de aumentar el saldo.
     *
     * @param cantidad La cantidad de dinero a depositar.
     */
    @Override
    public void depositar(float cantidad) {
        if (sobregiro > 0) { // Si hay sobregiro
            if (cantidad <= sobregiro) { // Si la cantidad a depositar es menor o igual al sobregiro
                sobregiro -= cantidad; // Se reduce el sobregiro
            } else { // Si la cantidad a depositar es mayor que el sobregiro
                cantidad -= sobregiro; // Se usa el sobregiro primero para cubrir el exceso
                sobregiro = 0; // El sobregiro se reduce a cero
                super.depositar(cantidad); // Se deposita el exceso restante en el saldo
            }
        } else { // Si no hay sobregiro
            super.depositar(cantidad); // Se deposita la cantidad directamente en el saldo
        }
    }

    /**
     * Genera el extracto mensual de la cuenta corriente.
     * Además, muestra el sobregiro si lo hay.
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual(); // Genera el extracto mensual base
        // Si hay sobregiro, imprimirlo
        if (sobregiro > 0) {
            System.out.println("Sobregiro: " + sobregiro);
        }
    }

    /**
     * Imprime la información de la cuenta corriente, incluyendo saldo, comisión mensual, número de transacciones y sobregiro (si lo hay).
     */
    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión Mensual: " + getComisionMensual());
        System.out.println("Número de transacciones realizadas: " + (getNumeroConsignacion() + getNumeroRetiro()));
        if (sobregiro > 0) { // Si hay sobregiro, imprimirlo
            System.out.println("Sobregiro: " + sobregiro);
        }
    }
}
