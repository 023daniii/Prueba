package BusinessLogic.interfaces;

public class AlimentacionService {

    public void alimentarLarva(Larva larva) {
        larva.comer();
    }

    public void alimentarHormiga(HObrera obrera) {
        obrera.comer();
    }
}

//Refactorización