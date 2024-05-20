public class Cuenta_Corriente extends Cuenta {
    /*ATRIBUTOS*/
    protected float sobregiro = 0;

    /*MÉTODOS*/
    @Override
    public double retirar(float cantidad) {
        if (saldo - cantidad < 0) {
            sobregiro += (float) (saldo - cantidad);
        }
        numero_retiros++;
        return (saldo -= cantidad);
    }

    @Override
    public double consignar(float cantidad) {
        if (sobregiro != 0) {
            cantidad += sobregiro;
        }
        return super.consignar(cantidad);
    }

    @Override
    public double extracto_mensual() {
        return super.extracto_mensual();
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo +
                "\nComisión mensual: $" + comision_mensual +
                "\nTransacciones totales: " + (numero_consignaciones + numero_retiros) +
                "\nSobregiro: $" + (sobregiro));
    }

    @Override
    public String toString() {
        return "Cuenta_Corriente{" +
                "sobregiro=" + sobregiro +
                ", saldo=" + saldo +
                ", numero_consignaciones=" + numero_consignaciones +
                ", numero_retiros=" + numero_retiros +
                ", tasa_anual=" + tasa_anual +
                ", comision_mensual=" + comision_mensual +
                '}';
    }

    /*CONSTRUCTOR*/
    public Cuenta_Corriente(float saldo, float tasa_anual) {
        super(saldo, tasa_anual);
    }

    /*SETTERS*/
    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    /*GETTERS*/
    public float getSobregiro() {
        return sobregiro;
    }
}
