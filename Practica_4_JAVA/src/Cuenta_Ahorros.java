public class Cuenta_Ahorros extends Cuenta{
    /*ATRIBUTOS*/
    protected boolean activa = saldo > 10000;

    /*MÉTODOS*/
    @Override
    public double consignar(float cantidad) {
        if (activa) {
            return super.consignar(cantidad);
        }
        else {
            System.out.println("La cuenta se encuentra inactiva.");
            return saldo;
        }
    }

    @Override
    public double retirar(float cantidad) {
        if (activa) {
            return super.retirar(cantidad);
        }
        else {
            System.out.println("La cuenta se encuentra inactiva.");
            return saldo;
        }
    }

    @Override
    public double extracto_mensual() {
        if (numero_retiros > 4) {
            comision_mensual = numero_retiros * 1000;
            if (activa) {
                return comision_mensual += super.extracto_mensual();
            }
            else {
                System.out.println("La cuenta se encuentra inactiva.");
                return saldo;
            }
        }
        else {
            return comision_mensual = super.extracto_mensual();
        }
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
