package LdAppComponent.LdConsoleApp;

//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
import java.util.Scanner;
//import java.io.IOException;

//import LdBussinessLogic.LdEntities.LdCoordenadaUK;
import LdBussinessLogic.LdEntities.LdEntomologo;
import LdBussinessLogic.LdEntities.LdHLarva;
import LdBussinessLogic.LdEntities.LdHormiga;

public class LdSistemaRuso { //REFACTORIZACION

    public void ejecutar(){
        Scanner sc = new Scanner(System.in);
        int LdIntentos = 0;
        boolean LdAcceso = false;

        while(LdIntentos < 3){
            System.out.println("Usuario: ");
            String u = sc.nextLine();
            System.out.println("Contraseña: ");
            String c = sc.nextLine();

            if(u.equals("patmic") && c.equals("123")){
                LdAcceso = true;
                break;
            }
            LdIntentos++;
            System.out.println("Crendeciales incorrectas");
        }

        if(!LdAcceso){
            System.out.println("Ups, demasiados intentos :(");
            return;
        }

        // CAMBIO: Tu identificación real para el examen
        System.out.println("CEDULA: 1050149515"); // Verifica que este sea tu número
        System.out.println("NOMBRE: Lanchimba Danny"); 
        System.out.println();

        System.out.println("[+] Alimentos");
        System.out.println("\u001B[31m.o. Carnívoro\u001B[0m");
        System.out.println("\u001B[34m.o. Herbívoro\u001B[0m"); // AZUL: Tu alimento de Caso E
        System.out.println("\u001B[31m.o. Nectarívoro\u001B[0m"); 
        System.out.println();

        System.out.println("[+] Tipo Hormiga");
        System.out.println("\u001B[31m.o. Larva\u001B[0m");
        System.out.println("\u001B[34m.o. Obrera\u001B[0m"); // AZUL: Tu hormiga de Caso E
        System.out.println("\u001B[31m.o. Soldado\u001B[0m");
        System.out.println();

        // CORRECCIÓN DE COMPILACIÓN
        LdHormiga hormiga = new LdHLarva(); // Asegúrate de que el archivo se llame LdHLarva.java
        boolean vive = hormiga.vive("Herbívoro", "XY"); // Caso E usa Herbívoro
        if (vive) {
            System.out.println("La hormiga vive");
            // Se cambió getSuperHabilidad por getLdSuperHabilidad
            System.out.println("Superhabilidad: " + hormiga.getLdSuperHabilidad());
        } else {
            System.out.println("La hormiga muere");
        }

        LdEntomologo ent = new LdEntomologo();

        // Formato según rúbrica [ Preparado ]
        System.out.println("[ Preparado ]-( Herbívoro )--");
        System.out.println("[ Preparado ]-( Herbívoro + XY )--");
    }

    /*
    public List<LdCoordenadaUK> readCoord(String fileNamePath) throws IOException{
        List<LdCoordenadaUK> lstCoord = new java.util.ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(fileNamePath));
        for(String line : allLines){
            System.out.println(line);
            String [] coord = line.split(",");
            LdCoordenadaUK LdCoordenada = new LdCoordenadaUK(coord[0], coord[6], false);
            lstCoord.add(LdCoordenada);
        }
        return lstCoord;
    }
    */
}