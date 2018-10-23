import java.util.*;
import java.io.*;

public class ctrDisciplina {

    private limDisciplina objALimDisciplina = new limDisciplina();
    private entDisciplina objAEntDisciplina;
    private String[] strADadosForm;
    private Vector vecADisciplinas = new Vector();

    public ctrDisciplina() throws Exception {
        desserializaDisciplina();
    }

    public boolean cadDisciplina() {
        objAEntDisciplina = new entDisciplina();
        cadastra();
        objAEntDisciplina.setCodigo(strADadosForm[0]);
        objAEntDisciplina.setNome(strADadosForm[1]);
        addVetor(objAEntDisciplina);
        return true;
    }

    private void cadastra() {
        strADadosForm = objALimDisciplina.montaForm();
    }

    private void salva() throws Exception {
        serializaDisciplina();
    }

    public void addVetor(entDisciplina pDiscip) {
        vecADisciplinas.add(pDiscip);
    }

    private void serializaDisciplina() throws Exception {
        FileOutputStream arq = new FileOutputStream("disciplinas.dat");
        ObjectOutputStream out = new ObjectOutputStream(arq);
        out.writeObject(vecADisciplinas);
        out.flush();
        out.close();
    }

    private void desserializaDisciplina() throws Exception {
        File _arq = new File("disciplinas.dat");
        if (_arq.exists()) {
            FileInputStream arq = new FileInputStream("disciplinas.dat");
            ObjectInputStream in = new ObjectInputStream(arq);
            vecADisciplinas = (Vector) in.readObject();
            in.close();
        }
    }

    public Vector getListaDisciplinas() {
        return vecADisciplinas;
    }
    
    public String listaDisciplinas() {
        Vector _lista = getListaDisciplinas();
        String lista = "";
        
        if (_lista.isEmpty()) return "Sem Disciplinas Cadastradas!";
        
        for (int i = 0; i < _lista.size(); i++) {
            lista += ((entDisciplina) _lista.elementAt(i)).getNome();
            lista += "\n";
        }
        
        return lista;
    }
    
    public String consultaDisc(int pCodigo) {
        Vector _lista = getListaDisciplinas();
        String info = "Disciplina não encontrada!", temp;
        int codigo;
        
        for (int i = 0; i < _lista.size(); i++) {
            temp = ((entDisciplina) _lista.elementAt(i)).getCodigo();
            codigo = Integer.parseInt(temp);
            if (codigo == pCodigo) {
                info = "Disciplina Encontrada!\n\n";
                info += "Código: " + Integer.toString(codigo);
                info += "\nNome: " + ((entDisciplina) _lista.elementAt(i)).getNome();
                return info;
            } 
        }
        
        return info;
    }

    public void finalize() throws Exception {
        //serializaDisciplina();
        salva();
    }
}