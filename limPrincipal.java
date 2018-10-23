import javax.swing.*;

public class limPrincipal {

    public int montaMenu() {
        int opcao = -1;
        String strOpcao;
        do {
           strOpcao = JOptionPane.showInputDialog("O que deseja fazer?\n\n" + "[1] Adicionar Disciplina\n" + "[2] Adicionar Estudante\n"
            + "[3] Adicionar Turma\n" + "[4] Listar Disciplinas\n" + "[5] Listar Estudantes\n" + "[6] Listar Turmas\n"
            + "[7] Consultar Disciplinas\n" + "[8] Consultar Estudantes\n" + "[9] Consultar Turmas\n" + "[10] Sair\n\n");
            opcao = Integer.parseInt(strOpcao);
        } while ((opcao < 1) || (opcao > 10));
        
        return opcao;
    }
    
    public void imprime(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
}
