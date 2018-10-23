import javax.swing.*;

public class limDisciplina {

    public String[] montaForm() {
        String infoUsuario[] = new String[2];
        infoUsuario[0] = JOptionPane.showInputDialog("Informe o código da Disciplina:");
        infoUsuario[1] = JOptionPane.showInputDialog("Informe o nome da Disciplina:");
        return infoUsuario;
    }
    
    public void imprimeMsg(String str) {
        JOptionPane.showMessageDialog(null, "Lista de Disciplinas\n\n" + str);
    }
    
    public int lerCodigo() {
        String dado;
        int cod;
        dado = JOptionPane.showInputDialog("Informe o código da disciplina para pesquisar:");
        cod = Integer.parseInt(dado);
        return cod;
    }
    
}
