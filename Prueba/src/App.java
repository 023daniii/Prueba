//import java.util.Scanner;

import LdAppComponent.LdConsoleApp.LdSistemaRuso;
//import LdBussinessLogic.LdEntities.LdAutomata;
//import LdDataAccess.LdDAOs.LdAlimentoTipoDAO;
//import LdDataAccess.LdDAOs.LdAntCiberDronDAO;
//import LdDataAccess.LdDAOs.LdHormigaDAO;
//import LdDataAccess.LdDTOs.LdAlimentoTipoDTO;
//import LdDataAccess.LdDTOs.LdVWHormigaDTO;
//import LdInfrastructure.AppException;

public class App {
    public static void main(String[] args) {

        LdSistemaRuso sistema = new LdSistemaRuso();
        sistema.ejecutar();
        /*try{
            LdAntCiberDronDAO dao = new LdAntCiberDronDAO();
            for(var dto : dao.readAll()){
                System.out.println(dto.toString());
            }
        }catch(Exception e){
            
        }
        */

        /*try{
            LdHormigaDAO dao = new LdHormigaDAO();
            for(LdVWHormigaDTO h : dao.readAllvwHormiga()){
                System.out.println(h.toString());
            }
        }catch(Exception e){
        }
        */

        /*LdAlimentoTipoDAO dao;
        try{
            dao = new LdAlimentoTipoDAO();
            LdAlimentoTipoDTO oDTO = dao.readBy(1);
            oDTO.setLdDescripcion("Salado"); // cambiar el dato de la tabla 
            dao.update(oDTO); // actualizar el registro 
            for(LdAlimentoTipoDTO dto : dao.readAll())
                System.out.println(dto.toString());
        }catch(AppException e){

        }
        */
        
        /*LdAutomata automata = new LdAutomata();
        Scanner TipoArsenal = new Scanner("a, ab, abc,abcd").useDelimiter(",");

        while(TipoArsenal.hasNext()){
            System.out.println(automata.checkTipoArsenal(TipoArsenal.next()) ? "OK" : "ERROR"  );
        }
        boolean boom = automata.checkTipoArsenal("abcdtttt");
        System.out.println(boom ? "BOOOM" : "NO BOOM");
        */

        /*LdSistemaRuso LdSistemaRuso = new LdSistemaRuso();
        try{
            LdSistemaRuso.readCoord("DataFile\\Molina_Jhanavi.csv");

        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }
}
