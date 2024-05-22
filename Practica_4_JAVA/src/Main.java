import java.util.Scanner;

public class Main {

    public static void Imprimir_Menu() {
        System.out.println("""
                            \n\t\t~ MENÚ ~
                            1) Crear cuenta corriente.
                            2) Crear cuenta ahorro.
                            3) Depositar dinero.
                            4) Retirar dinero.
                            5) Información de la cuenta.
                            6) Extracto mensual.
                            7) Salir.
                            """);
    }

    public static int Validar_Menu(Scanner input, int menu){
        while(menu < 1 || menu > 7) {
            System.out.print("El término ingresado no es válido. Por favor, inténtelo nuevamente: ");
            menu = input.nextInt();
        }
        return menu;
    }

    public static Cuenta_Corriente Crear_Cuenta_Corriente(Scanner input){
        System.out.print("Ingrese su saldo inicial: $");
        float saldo = input.nextFloat();
        System.out.println("\nCuenta Corriente creada correctamente.");
        return new Cuenta_Corriente(saldo, 50);

    }

    public static Cuenta_Ahorros Crear_Cuenta_Ahorro(Scanner input){
        System.out.print("Ingrese su saldo inicial: $");
        float saldo = input.nextFloat();
        System.out.println("\nCuenta Ahorro creada correctamente.");
        return new Cuenta_Ahorros(saldo, 82);
    }

    public static void Depositar_Dinero(Scanner input, Cuenta cuenta) {
        System.out.print("Ingrese el monto de dinero a depositar: $");
        float cantidad = input.nextFloat();
        cuenta.consignar(cantidad);
    }

    public static void Retirar_Dinero(Scanner input, Cuenta cuenta) {
        System.out.print("Ingrese el monto de dinero a extraer: $");
        float cantidad = input.nextFloat();
        cuenta.retirar(cantidad);
    }

    public static void Mostrar_Informacion_Cuenta(Cuenta cuenta) {
        if (cuenta instanceof Cuenta_Corriente) {
            ((Cuenta_Corriente) cuenta).imprimir();
        }
        else if (cuenta instanceof Cuenta_Ahorros){
            ((Cuenta_Ahorros) cuenta).imprimir();
        }
    }

    public static void Imprimir_Error() {
        System.out.println("""
                            \nNo se encontraron cuentas registradas.
                            Por favor, cree una cuenta para empezar.
                            """);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int continuar = 0;
        Cuenta cuenta = null;

        while(continuar == 0) {
            Imprimir_Menu();

            System.out.print("Ingrese el número correspondiente a la acción que quiera realizar: ");
            int menu = input.nextInt();
            menu = Validar_Menu(input, menu);

            switch (menu) {
                case 1: /*CREAR CUENTA CORRIENTE*/
                    if (cuenta != null) {
                        System.out.println("Ya existe una cuenta registrada.");
                    }
                    else {
                        cuenta = Crear_Cuenta_Corriente(input);
                    }
                    break;
                case 2: /*CREAR CUENTA AHORRO*/
                    if (cuenta != null) {
                        System.out.println("Ya existe una cuenta registrada.");
                    }
                    else {
                        cuenta = Crear_Cuenta_Ahorro(input);
                    }
                    break;
                case 3: /*DEPOSITAR DINERO*/
                    if (cuenta == null) {
                        Imprimir_Error();
                    }
                    else {
                        Depositar_Dinero(input, cuenta);
                    }
                    break;
                case 4: /*RETIRAR DINERO*/
                    if (cuenta == null) {
                        Imprimir_Error();
                    }
                    else {
                        Retirar_Dinero(input, cuenta);
                    }
                    break;
                case 5: /*INFORMACIÓN DE LA CUENTA*/
                    if (cuenta == null) {
                        Imprimir_Error();
                    }
                    else {
                        Mostrar_Informacion_Cuenta(cuenta);
                    }
                    break;
                case 6: /*EXTRACTO MENSUAL*/
                    if (cuenta == null) {
                        Imprimir_Error();
                    }
                    else {
                        cuenta.extracto_mensual();
                        System.out.println("Extracto mensual procesado correctamente.");
                    }
                    break;
                case 7: /*SALIR*/
                    continuar++;
                    break;
            }
        }
        System.out.println("Saliendo...");
        input.close();
    }
}