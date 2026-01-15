package LdBussinessLogic.LdEntities;

import java.util.ArrayList;
import java.util.List;
import LdBussinessLogic.LdInterfaces.ILdEntomologo;

public class LdEntomologo implements ILdEntomologo {
    
    @Override
    public List<LdHormiga> etlAntNest() {
        return new ArrayList<>();
    }

    @Override
    public LdAlimento preparar(LdAlimento alimento) {
        System.out.println("[ Preparado ]-( " + alimento.getLdTipo() + " )--");
        return alimento;
    }

    @Override
    public LdAlimento preparar(LdAlimento alimento, String genoma) {
        System.out.println("[ Preparado ]-( " + alimento.getLdTipo() + " + " + genoma + " )--");
        alimento.setLdGenoma(genoma);
        return alimento;
    }
}