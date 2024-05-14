package org.example;

/*
 * Clase que representa una cuenta de ahorros bancaria, que hereda de la clase Cuenta.
 * Además de los atributos y métodos heredados, incluye un atributo para determinar si la cuenta está activa.
 */
public class CuentaAhorros extends Cuenta {
    /** Indica si la cuenta de ahorros está activa. */
    private boolean activa;

    /*
     * Constructor para crear una nueva cuenta de ahorros.
     * @param saldo El saldo inicial de la cuenta.
     * @param tasaAnual La tasa de interés anual de la cuenta en porcentaje.
     */
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo > 10;
    }

    /*
     * Método para consignar una cantidad de dinero en la cuenta de ahorros.
     * Se puede consignar dinero si la cuenta está activa.
     * @param cantidad La cantidad de dinero a consignar.
     */
    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("No se puede consignar en una cuenta inactiva.");
        }
    }

    /*
     * Método para retirar una cantidad de dinero de la cuenta de ahorros.
     * Se puede retirar dinero si la cuenta está activa y se invoca al método heredado de la clase padre.
     * @param cantidad La cantidad de dinero a retirar.
     */
    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("No se puede retirar de una cuenta inactiva.");
        }
    }

    /*
     * Método para generar el extracto mensual de la cuenta de ahorros.
     * Si el número de retiros es mayor que 4, se cobra 1 dólar por cada retiro adicional.
     * Además, se determina si la cuenta está activa después del extracto.
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
        if (getNumeroRetiro() > 4) {
            float comision = (getNumeroRetiro() - 4) * 1;
            super.retirar(comision);
        }
        activa = getSaldo() > 10;
    }

    /*
     * Método para imprimir información detallada de la cuenta de ahorros.
     * Muestra el saldo, la comisión mensual, el número de transacciones realizadas y el estado de la cuenta.
     */
    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión Mensual: " + getComisionMensual());
        System.out.println("Número de Transacciones Realizadas: " + (getNumeroConsignacion() + getNumeroRetiro()));
        System.out.println("Estado de la Cuenta: " + (activa ? "Activa" : "Inactiva"));
    }
}
