package LdBussinessLogic.LdEntities;

import java.util.Scanner;

public class LdAutomata {

    static final int LdEr = -1;
    static final int ESTADO_FINAL = 5;
    static final String LdAlfabeto = "a,b,c,d,t, ";

    static final int[][] mt = {
        // a   b   c   d   t   esp
        { 1, -1, -1, -1, -1, -1 }, // 0
        { -1, 2, -1, -1, -1, -1 }, // 1
        { -1, 2,  3, -1, -1, -1 }, // 2
        { -1, -1, -1, 4, -1, -1 }, // 3
        { -1, -1, -1, -1, 5, -1 }, // 4
        { -1, -1, -1, -1, 5, -1 }  // 5 (estado final)
    };

    private int getIndexAlfabeto(String c) {
        String[] alfa = LdAlfabeto.split(",");
        for (int i = 0; i < alfa.length; i++) {
            if (alfa[i].equals(c)) {
                return i;
            }
        }
        return LdEr;
    }

    public boolean checkTipoArsenal(String LdArsenal) {
        int q = 0;

        for (int i = 0; i < LdArsenal.length(); i++) {
            int index = getIndexAlfabeto(LdArsenal.charAt(i) + "");

            if (index == LdEr || mt[q][index] == LdEr) {
                return false;
            }

            q = mt[q][index];
        }

        return q == ESTADO_FINAL;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LdAutomata automata = new LdAutomata();

        System.out.print("Ingrese la cadena: ");
        String cadena = sc.nextLine();

        if (automata.checkTipoArsenal(cadena)) {
            System.out.println("BOOM");
        } else {
            System.out.println("NO BOOM");
        }

        sc.close();
    }
}
