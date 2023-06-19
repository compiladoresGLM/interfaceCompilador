package interfacecompilador.gals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Semantico implements Constants {
    private static final Stack<String> pilha = new Stack<>();
    private static final Stack<String> pilhaRotulo = new Stack<>();
    private Map<String, String> tabelaSimbolos = new HashMap<>();
    private int indexRotulo = 0;
    private int numeroRotulo = 0;
    private List<String> listaId = new ArrayList<>();
    private String tipoVariavel;
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
                acao10(token);
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
            case 27:
                acao27();
                break;
            case 28:
                acao28();
                break;
            case 30:
                acao30(token);
                break;
            case 31:
                acao31();
                break;
            case 33:
                acao33(token);
                break;
        }

    }

    private void validaTiposAritimeticos(String tipo1, String tipo2) throws SemanticError {
        List<String> tiposValidos = Arrays.asList(FLOAT_64, INT_64);
        if (!tiposValidos.contains(tipo1) || !tiposValidos.contains(tipo2)) {
            throw new SemanticError("tipo(s) incompatível(is) na expressão aritmética");
        }
    }

    private void addAritimeticos(String tipo1, String tipo2) {
        if (tipo1.equals(INT_64) || tipo2.equals(INT_64)) {
            pilha.push(INT_64);
        } else {
            pilha.push(FLOAT_64);
        }
    }

    private void isBool(String tipo) throws SemanticError {
        if (!tipo.equals("bool")) {
            throw new SemanticError("tipo(s) incompatível(is) na expressão lógica");
        }
    }

    private void validaTiposLogicos(String tipo1, String tipo2) throws SemanticError {
        if (!(tipo1.equals("bool") && tipo2.equals("bool"))) {
            throw new SemanticError("tipo(s) incompatível(is) na expressão lógica");
        }
    }

    private String converterConstantesNumericas(String num) {
        return num.replace(".", "").replace(",",".");
    }
    private String converteTokenString(Token token) {
        return token.getLexeme().replace("\\s", " ");
    }
    private String converterId(String lexeme) {
        if (lexeme.equals("dividendo") || lexeme.equals("divisor")) {
            return lexeme.concat("_compiled");
        }
        return lexeme;
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
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("add");
    }

    private void acao2() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("sub");
    }

    private void acao3() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("mul");
    }

    private void acao4() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposAritimeticos(tipo1, tipo2);
        addAritimeticos(tipo1, tipo2);
        sJoiner.add("div");
    }

    private void acao5(Token token) {
        pilha.push(INT_64);
        sJoiner.add("ldc.i8 ".concat(converterConstantesNumericas(token.getLexeme())));
        sJoiner.add("conv.r8");
    }


    private void acao6(Token token) {
        pilha.push(FLOAT_64);
        sJoiner.add("ldc.r8 ".concat(converterConstantesNumericas(token.getLexeme())));
    }

    private void acao8() {
        String tipo = pilha.pop();

        if (INT_64.equals(tipo) || FLOAT_64.equals(tipo)) {
            pilha.add(tipo);
        } else {
            //todo throw exceprion?
        }

        sJoiner.add("ldc.i8 -1");
        sJoiner.add("conv.r8");
        sJoiner.add("mul");
    }

    private void acao9(Token token) {
        operador = token.getLexeme();
    }

    private void acao10(Token token) {

        pilha.pop();
        pilha.pop();
        
        pilha.add("bool");

        switch (token.getLexeme()) {
            case ">":
                sJoiner.add("cgt");
            case ">=":
                sJoiner.add("cgt");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
            case "<":
                sJoiner.add("clt");
            case "<=":
                sJoiner.add("clt");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
            case "==":
                sJoiner.add("ceq");
            case "!=":
                sJoiner.add("ceq");
                sJoiner.add("ldc.i4.0");
                sJoiner.add("ceq");
        }

    }

    private void acao11() {
        pilha.push("bool");
        sJoiner.add("ldc.i4.1");
    }

    private void acao12() {
        pilha.push("bool");
        sJoiner.add("ldc.i4.0");
    }

    private void acao13() throws SemanticError {
        String tipo = pilha.pop();
        isBool(tipo);
        sJoiner.add("ldc.i4.1");
        sJoiner.add("xor");
    }

    private void acao14() {
        String tipo = pilha.pop();
        if (tipo.equals(INT_64)) {
            sJoiner.add("conv.i8");
        }
        if (tipo.equals("char")) {
            sJoiner.add(STRING);
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
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposLogicos(tipo1, tipo2);
        pilha.push("bool");
        sJoiner.add("and");
    }

    private void acao19() throws SemanticError {
        String tipo1 = pilha.pop();
        String tipo2 = pilha.pop();
        validaTiposLogicos(tipo1, tipo2);
        pilha.push("bool");
        sJoiner.add("or");
    }

    private void acao20(Token token) {
        pilha.push(STRING);
        sJoiner.add("ldstr".concat(token.getLexeme()));
    }

    private void acao21() {
        sJoiner.add(".locals(int64 _temp_int, float64 _temp_float, string _temp_str, bool _temp_bool)");
    }

    private void acao22(Token token) {
        listaId.add(converterId(token.getLexeme()));
    }

    private void acao23(Token token) throws SemanticError {

        if (listaId.contains(token.getLexeme())) {
            sJoiner.add("ldloc " + token.getLexeme());

            if (INT_64.equals(tabelaSimbolos.get(token.getLexeme()))) {
                sJoiner.add("conv.r8");
            }

            pilha.push(tabelaSimbolos.get(token.getLexeme()));

        } else {
            throw new SemanticError("identificador " + token.getLexeme() + " não declarado");
        }
    }

    private void acao24() throws SemanticError {

        String tipoExpressao = pilha.pop();
        String varTemp = listaId.get(listaId.size() - 1);


    }

    private void acao25(){

        String tipoExpressao = pilha.pop();

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

        String tipoExpressao = pilha.peek();
        sJoiner.add("brfalse novo_rotulo");



        String varTemp = listaId.get(listaId.size() - 1);
        listaId.remove(listaId.size() - 1);

        atribuicao(tipoExpressao, varTemp);



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

        }


    }

    private void acao28(){
        numeroRotulo++;
        sJoiner.add("brfalse nr_" + numeroRotulo);
        pilhaRotulo.push("nr_" + numeroRotulo);
    }

    // todo Maas
    private void acao29() {
        indexRotulo++;
        sJoiner.add("nr_" + numeroRotulo + ":");

        pilhaRotulo.pop();
    }

    private void acao30(Token token){
        if((token.getLexeme()).equals("int")) {
            tipoVariavel = INT_64;
        }
        if((token.getLexeme()).equals("float")) {
            tipoVariavel = FLOAT_64;
        }
    }

    private void acao31() {
        numeroRotulo++;
        sJoiner.add("nr_" + numeroRotulo + ":");
        pilhaRotulo.push("nr_" + numeroRotulo);
    }

    // todo Maas
    private void acao32() {}

    private void acao33(Token token){
        String id = converterId(token.getLexeme());
        String tipoId = tabelaSimbolos.get(id);
        pilha.push(tipoId);
        sJoiner.add("ldloc " + id);
        if (tipoId.equals(INT_64)){
            sJoiner.add("conv.r8");
        }
    }

}
