package LdBussinessLogic.LdEntities;

import LdBussinessLogic.LdInterfaces.ILdEntomologo;

public class LdEntomologoGenetista extends LdEntomologo {

    @Override
    public LdAlimento preparar(LdAlimento alimento, String genoma) {
        // Formato obligatorio: [ Preparado ]-( tipoAlimento + Genoma )--
        System.out.println("[ Preparado ]-( " + alimento.getLdTipo() + " + " + genoma + " )--");
        alimento.setLdGenoma(genoma);
        return alimento;
    }
}