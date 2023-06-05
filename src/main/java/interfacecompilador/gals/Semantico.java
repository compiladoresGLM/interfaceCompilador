package interfacecompilador.gals;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants
{
    private static final Stack<String> pilha = new Stack<>();

    private void validaTiposAritiméticos(String tipo1, String tipo2)throws SemanticError{
        List<String> tiposValidos = Arrays.asList("float64","int64");
        if (!tiposValidos.contains(tipo1)||!tiposValidos.contains(tipo2)){
            throw new SemanticError("tipo(s) incompatível(is) na expressão aritmética");
        }
    }
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
    }
    private void acionaToken1() throws SemanticError{
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();


    }

}
