package LdBussinessLogic.LdInterfaces;

import java.util.List;

import LdBussinessLogic.LdEntities.LdAlimento;
import LdBussinessLogic.LdEntities.LdHormiga;

public interface ILdEntomologo {
    List<LdHormiga> etlAntNest();

    LdAlimento preparar(LdAlimento alimento);

    LdAlimento preparar(LdAlimento alimento, String genoma);
}