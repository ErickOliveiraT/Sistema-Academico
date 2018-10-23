import javax.swing.*;

public class limEstudante {

    public String[] montaForm() {
        String infoUsuario[] = new String[2];
        infoUsuario[0] = JOptionPane.showInputDialog("Informe o código do aluno(a):");
        infoUsuario[1] = JOptionPane.showInputDialog("Informe o nome do aluno(a):");
        return infoUsuario;
    }
    
    public void imprimeMsg(String str) {
        JOptionPane.showMessageDialog(null, "Lista de Estudantes\n\n" + str);
    }
    
    public int lerCodigo() {
        String dado;
        int cod;
        dado = JOptionPane.showInputDialog("Informe o código do estudante para pesquisar:");
        cod = Integer.parseInt(dado);
        return cod;
    }
}