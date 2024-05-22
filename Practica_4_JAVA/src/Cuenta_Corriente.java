public class Cuenta_Corriente extends Cuenta {
    /*ATRIBUTOS*/
    protected float sobregiro = 0;

    /*MÉTODOS*/
    @Override
    public void retirar(float cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
        }
        else {
            sobregiro += (float) (cantidad - saldo);
            saldo = 0;
        }
        numero_retiros++;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                cantidad = 0;
            }
        }
        super.consignar(cantidad);
    }

    @Override
    public void extracto_mensual() {
        super.extracto_mensual();
        if (sobregiro > 0) {
            saldo -= sobregiro;
        }
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