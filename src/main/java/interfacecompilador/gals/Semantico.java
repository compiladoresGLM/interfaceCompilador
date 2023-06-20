package interfacecompilador.gals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Semantico implements Constants {
    private static final Stack<String> pilhaTipoExpressao = new Stack<>();
    private static final Stack<String> pilhaRotulo = new Stack<>();
    private Map<String, String> tabelaSimbolos = new HashMap<>();
    private int numeroRotulo = 0;
    private List<String> listaId = new ArrayList<>();
    private static StringJoiner sJoiner = new StringJoiner("\n");
    private String operador;
    private String pathToCompile;

    private final String FLOAT_64 = "float64";
    private final String INT_64 = "int64";
    private final String STRING = "string";
    private final String BOOL = "bool";

    private final String TEMP_INT = "_temp_int";
    private final String TEMP_FLOAT = "_temp_float";
    private final String TEMP_STRING = "_temp_string";
    private final String TEMP_BOOL = "_temp_bool";

    public Semantico() {
        tabelaSimbolos.put(TEMP_INT, INT_64);
        tabelaSimbolos.put(TEMP_FLOAT, FLOAT_64);
        tabelaSimbolos.put(TEMP_STRING, STRING);
        tabelaSimbolos.put(TEMP_BOOL, BOOL);
    }

    public void setPathToCompile(String path) {
        pathToCompile = path;
    }

    public void executeAction(int action, Token token) throws SemanticError, IOException {
        System.out.println("Ação #" + action + ", Token: " + token);
        switch (action) {
            case 1:
                acao1();
                break;
            case 2:
                acao2();
                break;
            case 3:
                acao3();
                break;
            case 4:
                acao4();
                break;
            case 5:
                acao5(token);
                break;
            case 6:
                acao6(token);
                break;
            case 8:
                acao8();
                break;
            case 9:
                acao9(token);
                break;
            case 10:
                acao10();
                break;
            case 11:
                acao11();
                break;
            case 12:
                acao12();
                break;
            case 13:
                acao13();
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
            case 18:
                acao18();
                break;
            case 19:
                acao19();
                break;
            case 20:
                acao20(token);
                break;
            case 21:
                acao21();
                break;
            case 22:
                acao22(token);
                break;
            case 23:
                acao23(token);
                break;
            case 24:
                acao24();
                break;
            case 25:
                acao25();
                break;
            case 26:
                acao26();
                break;
            case 27:
                acao27();
                break;
            case 28:
                acao28();
                break;
            case 29:
                acao29();
                break;
            case 30:
                acao30(token);
                break;
            case 31:
                acao31();
                break;
            case 32:
                acao32();
                break;
            case 33:
                acao33(token);
                break;
        }

    }

    private void empilhaTipoAritimetico(String tipo1, String tipo2) {
        if (FLOAT_64.equals(tipo1) || FLOAT_64.equals(tipo2)) {
            pilhaTipoExpressao.push(FLOAT_64);
        } else {
            pilhaTipoExpressao.push(INT_64);
        }
    }

    private String converterConstantesNumericas(String num) {
        return num.replace(".", "").replace(",",".");
    }

    private boolean ehTipoCompativel(String tipoVar, String tipoValor) {
        if (FLOAT_64.equals(tipoVar)) {
            return Arrays.asList(FLOAT_64, INT_64).contains(tipoValor);
        } else if (INT_64.equals(tipoVar)) {
            return INT_64.equals(tipoValor);
        } else if (STRING.equals(tipoVar)) {
            return STRING.equals(tipoValor);
        } else if (BOOL.equals(tipoVar)) {
            return BOOL.equals(tipoValor);
        }

        return false;
    }

    private void atribuicao(String tipoExpressao, String varTemp) throws SemanticError {

        sJoiner.add("ldloc " + varTemp);

        for (int i = 1; i < listaId.size() - 1; i++) {
            sJoiner.add("dup");
        }

        for (String id : listaId) {

            if (tabelaSimbolos.get(id).isEmpty()) {
                sJoiner.add(".locals (%s %s)".formatted(tipoExpressao, id));
                tabelaSimbolos.put(id, tipoExpressao);
            } else {
                if (!ehTipoCompativel(tipoExpressao, tabelaSimbolos.get(id))) {
                    throw new SemanticError("Tipos incompatíveis em comando de atribuição");
                }
            }

            sJoiner.add("stloc " + id);
        }
    }

    private String getClasse(String tipoVariavel) {

        switch (tipoVariavel) {
            case INT_64 -> {
                return "Int64";
            }
            case FLOAT_64 -> {
                return "Double";
            }
            case STRING -> {
                return "String";
            }
            case BOOL -> {
                return "Boolean";
            }
        }

        throw new RuntimeException("O tipo de variável %s não possui uma classe definida".formatted(tipoVariavel));
    }

    private void acao1() throws SemanticError {
        empilhaTipoAritimetico(pilhaTipoExpressao.pop(), pilhaTipoExpressao.pop());
        sJoiner.add("add");
    }

    private void acao2() throws SemanticError {
        empilhaTipoAritimetico(pilhaTipoExpressao.pop(), pilhaTipoExpressao.pop());
        sJoiner.add("sub");
    }

    private void acao3() throws SemanticError {
        empilhaTipoAritimetico(pilhaTipoExpressao.pop(), pilhaTipoExpressao.pop());
        sJoiner.add("mul");
    }

    private void acao4() throws SemanticError {
        empilhaTipoAritimetico(pilhaTipoExpressao.pop(), pilhaTipoExpressao.pop());
        sJoiner.add("div");
    }

    private void acao5(Token token) {
        pilhaTipoExpressao.push(INT_64);
        sJoiner.add("ldc.i8 ".concat(converterConstantesNumericas(token.getLexeme())));
        sJoiner.add("conv.r8");
    }


    private void acao6(Token token) {
        pilhaTipoExpressao.push(FLOAT_64);
        sJoiner.add("ldc.r8 ".concat(converterConstantesNumericas(token.getLexeme())));
    }

    private void acao8() {

        sJoiner.add("ldc.i8 -1");
        sJoiner.add("conv.r8");
        sJoiner.add("mul");
    }

    private void acao9(Token token) {
        operador = token.getLexeme();
    }

    private void acao10() {

        pilhaTipoExpressao.pop();
        pilhaTipoExpressao.pop();
        
        pilhaTipoExpressao.add("bool");

        switch (operador) {
            case ">":
                sJoiner.add("cgt");
                break;
            case ">=":
                sJoiner.add("cgt");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
                break;
            case "<":
                sJoiner.add("clt");
                break;
            case "<=":
                sJoiner.add("clt");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
                break;
            case "==":
                sJoiner.add("ceq");
                break;
            case "!=":
                sJoiner.add("ceq");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
                break;
        }

    }

    private void acao11() {
        pilhaTipoExpressao.push("bool");
        sJoiner.add("ldc.i4.1");
    }

    private void acao12() {
        pilhaTipoExpressao.push("bool");
        sJoiner.add("ldc.i4.0");
    }

    private void acao13() {
        sJoiner.add("ldc.i4.1");
        sJoiner.add("xor");
    }

    private void acao14() {
        String tipo = pilhaTipoExpressao.pop();
        if (tipo.equals(INT_64)) {
            sJoiner.add("conv.i8");
        }
        sJoiner.add("call void [mscorlib]System.Console::Write(" + tipo + ")");
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

    private void acao18() throws SemanticError {
        String tipo1 = pilhaTipoExpressao.pop();
        String tipo2 = pilhaTipoExpressao.pop();
        pilhaTipoExpressao.push("bool");
        sJoiner.add("and");
    }

    private void acao19() throws SemanticError {
        String tipo1 = pilhaTipoExpressao.pop();
        String tipo2 = pilhaTipoExpressao.pop();
        pilhaTipoExpressao.push("bool");
        sJoiner.add("or");
    }

    private void acao20(Token token) {

            pilhaTipoExpressao.push(STRING);
            sJoiner.add("ldstr ".concat(token.getLexeme()));

    }

    private void acao21() {
        sJoiner.add(".locals(int64 _temp_int, float64 _temp_float, string _temp_str, bool _temp_bool)");
    }

    private void acao22(Token token) {
        listaId.add(token.getLexeme());
    }

    private void acao23(Token token) throws SemanticError {

        if (listaId.contains(token.getLexeme())) {
            sJoiner.add("ldloc " + token.getLexeme());

            if (INT_64.equals(tabelaSimbolos.get(token.getLexeme()))) {
                sJoiner.add("conv.r8");
            }

            pilhaTipoExpressao.push(tabelaSimbolos.get(token.getLexeme()));

        } else {
            throw new SemanticError("identificador " + token.getLexeme() + " não declarado");
        }
    }

    private void acao24() throws SemanticError {

        String varTemp = listaId.get(listaId.size() - 1);

        atribuicao(pilhaTipoExpressao.pop(), varTemp);

        listaId.clear();
    }

    private void acao25(){

        String tipoExpressao = pilhaTipoExpressao.pop();

        switch (tipoExpressao) {
            case INT_64 -> {
                sJoiner.add("conv.i8");
                sJoiner.add("stloc _temp_int");
                listaId.add(TEMP_INT);
            }
            case FLOAT_64 -> {
                sJoiner.add("stloc _temp_float");
                listaId.add(TEMP_FLOAT);
            }
            case STRING -> {
                sJoiner.add("stloc _temp_str");
                listaId.add(TEMP_STRING);
            }
            case BOOL -> {
                sJoiner.add("stloc _temp_bool");
                listaId.add(TEMP_BOOL);
            }
        }

    }

    // todo Verificar com a Prof
    private void acao26() throws SemanticError {

        numeroRotulo++;
        String rotulo = "r_" + numeroRotulo;

        String tipoExpressao = pilhaTipoExpressao.peek();
        sJoiner.add("brfalse " + pilhaRotulo.peek());

        String varTemp = listaId.get(listaId.size() - 1);
        listaId.remove(listaId.size() - 1);

        atribuicao(tipoExpressao, varTemp);

        sJoiner.add(rotulo + ":");
    }

    private void acao27() throws SemanticError {

        for (String id : listaId) {

            String tipoVar = tabelaSimbolos.get(id);

            // Verifica se a variável já foi declarada
            if (tipoVar.isEmpty()) {
                throw new SemanticError("Identificador %s não declarado".formatted(id));
            }

            sJoiner.add("call string [mscorlib]System.Console::ReadLine()");

            if (!tipoVar.equals(STRING)) sJoiner
                    .add("call " + tipoVar + " [mscorlib]System." + getClasse(tipoVar) + "::Parse(string)");

            sJoiner.add("stloc " + id);
        }

        listaId.clear();

    }

    private void acao28(){

        pilhaTipoExpressao.pop();

        numeroRotulo++;
        sJoiner.add("brfalse " + pilhaRotulo.peek());

        pilhaRotulo.push("r_" + numeroRotulo);

    }

    private void acao29() {
        sJoiner.add(pilhaRotulo.pop() + ":");
    }

    private void acao30(Token token){
        numeroRotulo++;
        sJoiner.add("br r_" + pilhaRotulo.peek());

        pilhaRotulo.pop();

        pilhaRotulo.add("r_" + numeroRotulo);

        sJoiner.add(pilhaRotulo.peek());
    }

    private void acao31() {

        pilhaTipoExpressao.pop();

        numeroRotulo++;
        pilhaRotulo.add("r_" + numeroRotulo);

        sJoiner.add(pilhaRotulo.peek() + ":");
    }

    private void acao32() {
        pilhaRotulo.add("r_" + numeroRotulo);
        sJoiner.add("brfalse " + pilhaRotulo.peek());
    }

    private void acao33(Token token){

        String r1 = pilhaRotulo.pop();
        String r2 = pilhaRotulo.pop();

        sJoiner.add("br " + r1);
        sJoiner.add(r2 + ":");
    }

}
