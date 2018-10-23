
import java.util.*;
import java.io.*;

public class ctrTurma {

    private entTurma objAEntTurma;
    private limTurma objALimTurma;
    private ctrPrincipal objCtrPrincipal;
    private Vector vecATurmas = new Vector();
    private Vector vecAListaEstudantes = new Vector();
    private Vector vecAListaDisciplinas = new Vector();
    private Vector vecADadosForm = new Vector();

    public ctrTurma(ctrPrincipal pCtrPrincipal) throws Exception {
        objCtrPrincipal = pCtrPrincipal;
        objALimTurma = new limTurma();
        desserializaTurma();
    }

    public boolean cadTurma() {
        objAEntTurma = new entTurma();
        cadastra();
        objAEntTurma.setCodigoTurma((String) vecADadosForm.elementAt(0));
        objAEntTurma.setNomeTurma((String) vecADadosForm.elementAt(1));
        objAEntTurma.setCodDisciplina((String) vecADadosForm.elementAt(2));
        objAEntTurma.setAlunos((Vector) vecADadosForm.elementAt(3));
        vecATurmas.add(objAEntTurma);
        return true;
    }

    private void cadastra() {
        vecADadosForm = objALimTurma.montaForm(objCtrPrincipal.getObjCtrDisciplina().getListaDisciplinas(),
                objCtrPrincipal.getObjCtrEstudante().getListaEstudantes());
    }

    private void salva() throws Exception {
        serializaTurma();
    }
    
    public Vector getListaTurmas() {
        return vecATurmas;
    }
    
    public String listaTurmas() {
        Vector _lista = getListaTurmas();
        String lista = "";
        
        if (_lista.isEmpty()) return "Sem Turmas Cadastradas!";
        
        for (int i = 0; i < _lista.size(); i++) {
            lista += ((entTurma) _lista.elementAt(i)).getNomeTurma();
            lista += "\n";
        }
        
        return lista;
    }

    public void addVetor(entTurma pTurma) {
        vecATurmas.add(pTurma);
    }

    private void serializaTurma() throws Exception {
        FileOutputStream arq = new FileOutputStream("turmas.dat");
        ObjectOutputStream out = new ObjectOutputStream(arq);
        out.writeObject(vecATurmas);
        out.flush();
        out.close();
    }

    private void desserializaTurma() throws Exception {
        File _arq = new File("turmas.dat");
        if (_arq.exists()) {
            FileInputStream arq = new FileInputStream("turmas.dat");
            ObjectInputStream in = new ObjectInputStream(arq);
            vecATurmas = (Vector) in.readObject();
            in.close();
        }
    }

    public void finalize() throws Exception {
        //serializaTurma();
        salva();
    }
    
    public String consultaTurma(int pCodigo) {
        Vector _lista = getListaTurmas();
        String info = "Turma não encontrada!", temp;
        int codigo;
        
        for (int i = 0; i < _lista.size(); i++) {
            temp = ((entTurma) _lista.elementAt(i)).getCodigoTurma();
            codigo = Integer.parseInt(temp);
            if (codigo == pCodigo) {
                info = "Turma Encontrada!\n\n";
                info += "Código: " + Integer.toString(codigo);
                info += "\nNome: " + ((entTurma) _lista.elementAt(i)).getNomeTurma();
                return info;
            } 
        }
        
        return info;
    }
}