package BusinessLogic;

public class ETLService {

    public void ejecutarETL(List<String> datos) {

        for (String d : datos) {

            System.out.print("Loading | Waiting... ");

            if (d != null && !d.isEmpty()) {
                System.out.println("\u001B[34mOK\u001B[0m");
            } else {
                System.out.println("\u001B[31mERROR\u001B[0m");
            }
        }
    }
}
