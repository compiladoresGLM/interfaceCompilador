package interfacecompilador.gals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class Semantico implements Constants
{
    private static final Stack<String> pilha = new Stack<>();
    private static StringJoiner sJoiner = new StringJoiner("\n");
    private String operador;
    private String pathToCompile;

    public void executeAction(int action, Token token) throws SemanticError, IOException {
        System.out.println("Ação #"+action+", Token: "+token);
        switch (action) {
           case 9:
               acao9(token);
               break;
           case 11:
               acao11();
               break;
           case 12:
                acao12();
                break;
           case 14:
                acao14();
                break;
           case 15:
                acao15();
                break;
           case 16:
                acao16();
                break;
           case 17:
                acao17();
                break;
           case 20:
                acao20();
                break;
        }

    }

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


    private void acao9 (Token token) {
        operador = token.getLexeme();
    }

    private void acao11() {
        pilha.push("bool");
        sJoiner.add("ldc.i4.1");
    }

    private void acao12() {
        pilha.push("bool");
        sJoiner.add("ldc.i4.0");
    }

    private void acao15() {
        sJoiner.add(".assembly extern mscorlib {}");
        sJoiner.add(".assembly _codigo_objeto{}");
        sJoiner.add(".module _codigo_objeto.exe");
        sJoiner.add("");
        sJoiner.add(".class public _UNICA{");
        sJoiner.add(".method static public void _principal() {");
        sJoiner.add(".entrypoint");
        sJoiner.add(".locals (int64 dividendo)");
        sJoiner.add(".locals (int64 divisor)");
    }

    private void acao14() {
        String tipo = pilha.pop();
        if (tipo.equals("int64")) {
            sJoiner.add("conv.i8");
        }
        if (tipo.equals("char")) {
            sJoiner.add("string");
        }
        sJoiner.add("call void [mscorlib]System.Console::Write(" + tipo + ")");
    }
    private void acao16() throws IOException {
        sJoiner.add("ret");
        sJoiner.add("}");
        sJoiner.add("}");

        pathToCompile = pathToCompile.replace(".txt", ".il");

        FileWriter writer = new FileWriter(pathToCompile, StandardCharsets.UTF_8, false);
        writer.write(sJoiner.toString());
        writer.close();
        sJoiner = new StringJoiner("\n");
    }
    private void acao17() {
        sJoiner.add("ldstr " + "\"\\n\"");
        sJoiner.add("call void [mscorlib]System.Console::Write(string)");
    }
    private void acao20() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        if (!tipo1.equals("int64") || !tipo2.equals("int64")) {
            throw new SemanticError("Tipo incompatível em expressão aritmética");
        }
        addAritimeticos(tipo1, tipo2);

        sJoiner.add("conv.i8");
        sJoiner.add("stloc divisor");

        sJoiner.add("conv.i8");
        sJoiner.add("stloc dividendo");

        sJoiner.add("ldloc dividendo");
        sJoiner.add("conv.r8");

        sJoiner.add("ldloc dividendo");
        sJoiner.add("conv.r8");

        sJoiner.add("ldloc divisor");
        sJoiner.add("conv.r8");

        sJoiner.add("div");
        sJoiner.add("conv.i8");
        sJoiner.add("conv.r8");

        sJoiner.add("ldloc divisor");
        sJoiner.add("conv.r8");

        sJoiner.add("mul");
        sJoiner.add("sub");
    }

}
