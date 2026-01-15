package app;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int intentos = 3;
        boolean autenticado = false;

        while (intentos > 0) {

            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Clave: ");
            String clave = sc.nextLine();

            if (usuario.equals("patmic") && clave.equals("123")) {
                autenticado = true;
                System.out.println("Acceso concedido");
                break;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos: " + intentos);
            }
        }

        if (!autenticado) {
            System.out.println("Sistema bloqueado");
            return;
        }

        // sigue el sistema
    }
}

