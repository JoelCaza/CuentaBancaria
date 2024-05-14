package org.example;
public class CuentaAhorros extends Cuenta {
    /* Atributo que identifica si una cuenta está activa;
     * la cuenta está activa si su saldo es mayor a 10$ */
    private boolean estado;

    /* Constructor de la clase cuenta Ahorros
     * @param saldo, parametro que define el saldo de la cuenta
     * @param tasa Parametro que define la tasa anual */
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);

        // Condicional para saber si la cuenta se encuentra activa o inactiva
        if (saldo <= 10) {
            // Se desactiva la cuenta
            estado = false;
        } else {
            estado = true;
        }
    }

    /* Método que recibe una cantidad de dinero a retirar
     * y actualizar el estado de la cuenta
     * @param cantidad, parametro que define la cantidad a retirar
     * de una cuenta de ahorros */
    @Override
    public void retirar(float cantidad) {
        // Si la cuenta está activa, se realiza el retiro
        if (estado) {
            // Invocamos el método retirar de la clase padre
            super.retirar(cantidad);
        }
    }

    /* Método que genera un extracto mensual de la cuenta de ahorros
     * Verifica si el número de retiros es mayor a 4 y cobra 1 dólar por cada retiro adicional */
    @Override
    public void extractoMensual() {
        // Verifica si el número de retiros es mayor a 4
        if (getNumeroRetiro() > 4) {
            // Cobra 1 dólar por cada retiro adicional
            super.retirar((getNumeroRetiro() - 4) * 1);
        }
        // Actualiza el saldo aplicando la comisión mensual y calculando el interés mensual
        super.extractoMensual();
        // Verifica si la cuenta sigue activa después del extracto
        if (getSaldo() <= 10) {
            estado = false;
        } else {
            estado = true;
        }
    }

    /* Método que imprime en pantalla el saldo de la cuenta,
     * la comisión mensual y el número de transacciones realizadas */
    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión Mensual: " + getComisionMensual());
        System.out.println("Estado de la cuenta: " + (estado ? "Activa" : "Inactiva"));

        System.out.println("Número de transacciones realizadas: " + (getNumeroConsignacion() + getNumeroRetiro()));
    }
}


