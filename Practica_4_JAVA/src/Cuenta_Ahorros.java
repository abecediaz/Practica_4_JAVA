public class Cuenta_Ahorros extends Cuenta{
    /*ATRIBUTOS*/
    protected boolean activa;

    /*MÉTODOS*/
    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        }
        else {
            System.out.println("La cuenta se encuentra inactiva.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        }
        else {
            System.out.println("La cuenta se encuentra inactiva.");
        }
    }

    @Override
    public void extracto_mensual() {
        if (numero_retiros > 4) {
            comision_mensual += (numero_retiros - 4) * 1000;
        }
        super.extracto_mensual();
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo +
                "\nComisión mensual: $" + comision_mensual +
                "\nTransacciones totales: " + (numero_consignaciones + numero_retiros));
    }

    @Override
    public String toString() {
        return "Cuenta_Ahorros{" +
                "activa=" + activa +
                ", saldo=" + saldo +
                ", numero_consignaciones=" + numero_consignaciones +
                ", numero_retiros=" + numero_retiros +
                ", tasa_anual=" + tasa_anual +
                ", comision_mensual=" + comision_mensual +
                '}';
    }

    /*CONSTRUCTOR*/
    public Cuenta_Ahorros(float saldo, float tasa_anual) {
        super(saldo, tasa_anual);
        this.activa = saldo > 10000;
    }

    /*SETTERS*/
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /*GETTERS*/
    public boolean isActiva() {
        return activa;
    }
}
