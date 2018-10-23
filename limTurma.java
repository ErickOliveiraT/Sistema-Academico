
import javax.swing.*;
import java.util.*;

public class limTurma {

    private String strACodigoTurma;
    private String strANomeTurma;
    private String strACodDisciplina;
    private Vector vecAAlunosSelecionados = new Vector();
    private Vector vecADadosForm = new Vector();

    public Vector montaForm(Vector vecDiscip, Vector vecAlunos) {
        montaFormDadosTurma();
        montaFormDadosDisciplina(vecDiscip);
        vecADadosForm.add(strACodigoTurma);
        vecADadosForm.add(strANomeTurma);
        vecADadosForm.add(strACodDisciplina);
        montaFormDadosEstudante(vecAlunos);
        return vecADadosForm;
    }

    private void montaFormDadosTurma() {
        strACodigoTurma = JOptionPane.showInputDialog("Informe o código da turma:");
        strANomeTurma = JOptionPane.showInputDialog("Informe o nome da turma:");
    }

    private void montaFormDadosDisciplina(Vector vecDiscip) {
        strACodDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private void montaFormDadosEstudante(Vector vecAlunos) {
        String infoUsuario;
        
        while (true) {
            infoUsuario = JOptionPane.showInputDialog("Informe o código do aluno ou digite S para sair:");
            if (infoUsuario.equalsIgnoreCase("S")) break;
            vecAAlunosSelecionados.add(infoUsuario);
        }
        vecADadosForm.add(vecAAlunosSelecionados);
    }
    
    public void imprimeMsg(String str) {
        JOptionPane.showMessageDialog(null, "Lista de Turmas\n\n" + str);
    }
    
    public int lerCodigo() {
        String dado;
        int cod;
        dado = JOptionPane.showInputDialog("Informe o código da turma para pesquisar:");
        cod = Integer.parseInt(dado);
        return cod;
    }
}
