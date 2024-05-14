package org.example;

/*
 */
/* Esta clase se denomina cuenta
 * Cuenta modela una cuenta bancaria con los
 *atributos saldo, numero de consignaciones,
 *numero de retiros, tasa anual
 */
public class Cuenta {
    //atributo que define el sueldo
    //de una cuenta bancaria
    private float saldo;
    //Atributo que define el numero de
    // consignaciones realizadas en una
    // cuenta bancaria
    private int numeroConsignacion=0;

    /*Atributo que define el numero de retiros
     * de una cuenta bancaria
     */
    private int numeroRetiro=0;
    /*Atributos que define la tasa anual de intereses
     *de una cuenta bancaria
     */
    private float tasaAnual;
    /*Atributo que defina la comision
     *mensual que se cobra a una cuenta bancaria.
     */
    private float comisionMensual=0;

    /*constructor de la clase cuenta
     * @param saldo Parametro que define el saldo de la cuenta
     * @param tasaAnual parametro que define la
     * tasa anual de la cuenta.
     * */
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;

    }

    /*
     * Metodo que recibe una cantidad de dinero a
     * depositar y actualiza el saldo de la cuenta
     * @param saldo Parametro que define la cantidad
     * de dimero a depositar en la cuenta
     * */
    public void depositar(float cantidad) {
        /*Se actualiza el saldo con la cantidad
         * depositada*/
        saldo=saldo+cantidad;
        /*Se actualiza el numero de depositos realizadas
         * a la cuenta*/
        numeroConsignacion=numeroConsignacion+1;
    }

    /*Metodo que recibe una cantidad de dinero
     * a retirar y actualizar su saldo disponile y el valor a retirar
     * no superara el saldo actual
     * @param saldo Parametro que define la cantiad de dinero a retirar de tu cuenta
     * */
    public void retirar(float cantidad) {
        float nuevoSaldo=saldo-cantidad;
        /*Si la cantidad a retirar supera el saldo
         * el retiro no se puede actualizar*/
        if(nuevoSaldo>=0){
            saldo-=cantidad;
            numeroRetiro=numeroRetiro+1;
        }
        else {
            System.out.println("La cantidad a retirar exede el saldo actual");
        }
    }

    /*Metodo que Calcula el interes mensual y
     * actualizar el saldo */
    public void calcularInteres(){
        /*convertimos la tasa anual a tasa
         * mensual*/
        float tasaMensual=tasaAnual/12;
        /*convertimos a inero el interes*/
        float interesMensual=saldo+tasaMensual;
        /*actualizamos el saldo aplicado
         * el interes mensual*/
        saldo+=interesMensual;
    }

    /*Metodo que genera un extracto aplicando
     * al saldo actual una comision y calculando
     * su interes*/
    public void extractoMensual(){
        saldo-=comisionMensual;
        calcularInteres();

    }



    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConsignacion() {
        return numeroConsignacion;
    }

    public int getNumeroRetiro() {
        return numeroRetiro;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión Mensual: " + comisionMensual);
        System.out.println("Número de transacciones realizadas: " + (numeroConsignacion + numeroRetiro));
    }
}
