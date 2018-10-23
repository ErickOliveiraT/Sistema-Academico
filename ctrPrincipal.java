import java.util.*;
import javax.swing.JOptionPane;

public class ctrPrincipal {

    private int intAOperacao = -1;
    private ctrDisciplina objACtrDisciplina;
    private limPrincipal objALimPrincipal;
    private ctrEstudante objACtrEstudante;
    private ctrTurma objACtrTurma;
    
    public ctrPrincipal() {
        objALimPrincipal = new limPrincipal();
        try {
            objACtrDisciplina = new ctrDisciplina();
            objACtrEstudante = new ctrEstudante();
            objACtrTurma = new ctrTurma(this);
        } catch (Exception e) {
            System.out.println("Erro!");
        }

    }

    public ctrEstudante getObjCtrEstudante() {
        return objACtrEstudante;
    }

    public ctrDisciplina getObjCtrDisciplina() {
        return objACtrDisciplina;
    }

    public void run() { //Roda o menu principal
        while (true) {
            intAOperacao = objALimPrincipal.montaMenu();
            switch (intAOperacao) {
                case 1:
                    cadDisciplina();
                    break;
                case 2:
                    cadEstudante();
                    break;
                case 3:
                    cadTurma();
                    break;
                case 4:
                    listaDisciplinas();
                    break;
                case 5:
                    listaEstudantes();
                    break;
                case 6:
                    listaTurmas();
                    break;
                case 7:
                    consultaDisc();
                    break;
                case 8:
                    consultaEst();
                    break;
                case 9:
                    consultaTurma();
                    break;
                case 10:
                    finalize();
            }
        }
    }
    
    private void listaDisciplinas() {
        String to_print = objACtrDisciplina.listaDisciplinas();
        limDisciplina limite = new limDisciplina();
        limite.imprimeMsg(to_print);
    }
    
    private void listaTurmas() {
        String to_print = objACtrTurma.listaTurmas();
        limTurma limite = new limTurma();
        limite.imprimeMsg(to_print);
    }
    
    private void listaEstudantes() {
        String to_print = objACtrEstudante.listaEstudantes();
        limEstudante limite = new limEstudante();
        limite.imprimeMsg(to_print);
    }
    
    private void consultaDisc() {
        limDisciplina limite = new limDisciplina();
        int cod = limite.lerCodigo();
        String to_print = objACtrDisciplina.consultaDisc(cod);
        objALimPrincipal.imprime(to_print);
    }
    
    private void consultaEst() {
        limEstudante limite = new limEstudante();
        int cod = limite.lerCodigo();
        String to_print = objACtrEstudante.consultaEst(cod);
        objALimPrincipal.imprime(to_print);
    }
    
    private void consultaTurma() {
        limTurma limite = new limTurma();
        int cod = limite.lerCodigo();
        String to_print = objACtrTurma.consultaTurma(cod);
        objALimPrincipal.imprime(to_print);
    }

    private boolean cadDisciplina() {
        return objACtrDisciplina.cadDisciplina();
    }

    private boolean cadEstudante() {
        return objACtrEstudante.cadEstudante();
    }

    private boolean cadTurma() {
        return objACtrTurma.cadTurma();

    }

    public void finalize() {
        try {
            objACtrEstudante.finalize();
            objACtrDisciplina.finalize();
            objACtrTurma.finalize();
        } catch (Exception e) {
            System.err.println("Erro ao fechar um ou mais arquivos!");
        }
        System.exit(0);
    }
}
