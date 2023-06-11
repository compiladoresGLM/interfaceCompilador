package interfacecompilador.gals;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class Semantico implements Constants
{
    private static final Stack<String> pilha = new Stack<>();
    private static StringJoiner sJoiner = new StringJoiner("\n");
    private void validaTiposAritimeticos(String tipo1, String tipo2)throws SemanticError{
        List<String> tiposValidos = Arrays.asList("float64","int64");
        if (!tiposValidos.contains(tipo1)||!tiposValidos.contains(tipo2)){
            throw new SemanticError("tipo(s) incompatível(is) na expressão aritmética");
        }
    }
    private void addAritimeticos(String tipo1, String tipo2){
        if (tipo1.equals("int64")||tipo2.equals("int64")){
            pilha.push("int64");
        }
        else {
            pilha.push("float64");
        }
    }

    private void isBool(String tipo) throws SemanticError{
        if (!tipo.equals("bool")){
            throw new SemanticError("tipo(s) incompatível(is) na expressão lógica");
        }
    }

    private void validaTiposLogicos(String tipo1, String tipo2) throws SemanticError{
        if (!(tipo1.equals("bool") && tipo2.equals("bool"))){
            throw new SemanticError("tipo(s) incompatível(is) na expressão lógica");
        }
    }
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
    }
    private void acionaToken1() throws SemanticError{
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1,tipo2);
        addAritimeticos(tipo1,tipo2);
        sJoiner.add("add");
    }
    private void acionaToken2() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("sub");
    }

    private void acionaToken3() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("mul");
    }
    private void acionaToken13() throws SemanticError{
        String tipo = pilha.pop();
        isBool(tipo);
        sJoiner.add("ldc.i4.1");
        sJoiner.add("xor");
    }
    private void acionaToken18() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposLogicos(tipo1, tipo2);
        pilha.push("bool");
        sJoiner.add("and");
    }

    private void acionaToken19() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposLogicos(tipo1, tipo2);
        pilha.push("bool");
        sJoiner.add("or");
    }



}
