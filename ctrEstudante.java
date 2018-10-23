import java.util.*;
import java.io.*;

public class ctrEstudante {

    private limEstudante objALimEstudante = new limEstudante();
    private entEstudante objAEntEstudante;
    private String[] strADadosForm;
    private Vector vecAEstudantes = new Vector();

    public ctrEstudante() throws Exception {
        desserializaEstudante();
    }

    public boolean cadEstudante() {
        objAEntEstudante = new entEstudante();
        cadastra();
        objAEntEstudante.setCodigo(strADadosForm[0]);
        objAEntEstudante.setNome(strADadosForm[1]);
        addVetor(objAEntEstudante);
        return true;
    }

    private void cadastra() {
        strADadosForm = objALimEstudante.montaForm();
    }

    private void salva() throws Exception {
        serializaEstudante();
    }

    public void addVetor(entEstudante pEst) {
        vecAEstudantes.add(pEst);
    }

    private void serializaEstudante() throws Exception {
        FileOutputStream arq = new FileOutputStream("estudantes.dat");
        ObjectOutputStream out = new ObjectOutputStream(arq);
        out.writeObject(vecAEstudantes);
        out.flush();
        out.close();
    }

    private void desserializaEstudante() throws Exception {
        File _arq = new File("estudantes.dat");
        if (_arq.exists()) {
            FileInputStream arq = new FileInputStream("estudantes.dat");
            ObjectInputStream in = new ObjectInputStream(arq);
            vecAEstudantes = (Vector) in.readObject();
            in.close();
        }
    }

    public Vector getListaEstudantes() {
        return vecAEstudantes;
    }
    
    public String listaEstudantes() {
        Vector _lista = getListaEstudantes();
        String lista = "";
        
        if (_lista.isEmpty()) return "Sem Estudantes Cadastrados!";
        
        for (int i = 0; i < _lista.size(); i++) {
            lista += ((entEstudante) _lista.elementAt(i)).getNome();
            lista += "\n";
        }
        
        return lista;
    }

    public void finalize() throws Exception {
        //serializaEstudante();
        salva();
    }
    
    public String consultaEst(int pCodigo) {
        Vector _lista = getListaEstudantes();
        String info = "Estudante não encontrado!", temp;
        int codigo;
        
        for (int i = 0; i < _lista.size(); i++) {
            temp = ((entEstudante) _lista.elementAt(i)).getCodigo();
            codigo = Integer.parseInt(temp);
            if (codigo == pCodigo) {
                info = "Estudante Encontrado!\n\n";
                info += "Código: " + Integer.toString(codigo);
                info += "\nNome: " + ((entEstudante) _lista.elementAt(i)).getNome();
                return info;
            } 
        }
        
        return info;
    }
}