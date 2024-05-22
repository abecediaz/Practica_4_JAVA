public class Cuenta {
    /*ATRIBUTOS*/
    protected double saldo;
    protected int numero_consignaciones = 0;
    protected int numero_retiros = 0;
    protected double tasa_anual; //PORCENTAJE
    protected double comision_mensual = 0;

    /*MÉTODOS*/
    public void consignar(float cantidad) {
        saldo += cantidad;
        numero_consignaciones++;
    }

    public void retirar(float cantidad) {
        if (saldo - cantidad < 0) {
            System.out.println("La cantidad ingresada supera el saldo en cuenta.");
        }
        else {
            saldo -= cantidad;
            numero_retiros++;
        }
    }

    public void calcular_interes() {
        saldo += saldo * ((tasa_anual/12)/100);
    }

    public void extracto_mensual() {
        calcular_interes();
        saldo -= comision_mensual;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numero_consignaciones=" + numero_consignaciones +
                ", numero_retiros=" + numero_retiros +
                ", tasa_anual=" + tasa_anual +
                ", comision_mensual=" + comision_mensual +
                '}';
    }

    /*CONSTRUCTOR*/
    public Cuenta(float saldo, float tasa_anual) {
        this.saldo = saldo;
        this.tasa_anual = tasa_anual;
    }

    /*SETTERS*/
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumero_consignaciones(int numero_consignaciones) {
        this.numero_consignaciones = numero_consignaciones;
    }

    public void setNumero_retiros(int numero_retiros) {
        this.numero_retiros = numero_retiros;
    }

    public void setTasa_anual(double tasa_anual) {
        this.tasa_anual = tasa_anual;
    }

    public void setComision_mensual(double comision_mensual) {
        this.comision_mensual = comision_mensual;
    }

    /*GETTERS*/
    public double getSaldo() {
        return saldo;
    }

    public int getNumero_consignaciones() {
        return numero_consignaciones;
    }

    public int getNumero_retiros() {
        return numero_retiros;
    }

    public double getTasa_anual() {
        return tasa_anual;
    }

    public double getComision_mensual() {
        return comision_mensual;
    }
}
