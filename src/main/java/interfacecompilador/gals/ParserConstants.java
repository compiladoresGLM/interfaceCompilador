package interfacecompilador.gals;

public interface ParserConstants
{
    int START_SYMBOL = 35;

    int FIRST_NON_TERMINAL    = 35;
    int FIRST_SEMANTIC_ACTION = 61;

    int[][] PARSER_TABLE =
    {
        { -1,  0, -1, -1, -1, -1,  0, -1, -1, -1, -1,  0, -1, -1,  0, -1,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        {  1,  2, -1, -1, -1, -1,  2, -1,  1,  1, -1,  2, -1, -1,  2, -1,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  3, -1, -1, -1, -1,  7, -1, -1, -1, -1,  6, -1, -1,  4, -1,  5,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 16, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 20, 20, 20, 20, 20, -1, -1, -1, -1, 20, -1, 20, -1, -1, 20, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, 20, 20, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, 24, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 26, 26, 26, 26, 26, -1, -1, -1, -1, 26, -1, 26, -1, -1, 26, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, 26, 26, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, 27, 27, -1, 27, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 30, 30, 30, 30, 30, -1, -1, -1, -1, 32, -1, 33, -1, -1, 31, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, 30, 30, -1, -1 },
        { -1, 34, 34, 34, 34, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, 34, 34, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, 35, 35, -1, 35, -1, 35, 36, 36, 36, 36, 36, 36, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, 38, 39, 40, 41, 42, -1, -1, -1, -1 },
        { -1, 43, 43, 43, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, 43, 43, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, 44, 44, -1, 44, -1, 44, 44, 44, 44, 44, 44, 44, 45, 46, -1, -1 },
        { -1, 47, 47, 47, 47, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, 47, 47, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, 48, 48, -1, 48, -1, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 50 },
        { -1, 51, 52, 53, 54, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, -1, -1, -1, -1, -1, -1, -1, 57, 58, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 37, 22, 36 },
        {  0 },
        { 35 },
        { 38 },
        { 40 },
        { 41 },
        { 42 },
        { 44 },
        { 48, 21, 50, 39 },
        { 20, 12, 50 },
        {  0 },
        { 15, 23, 48, 24 },
        { 17, 23, 46, 24 },
        { 18, 23, 46, 24 },
        { 12, 23, 50, 24, 35, 43 },
        { 10 },
        {  9, 35, 10 },
        {  7, 23, 50, 24, 20, 12, 45 },
        { 16, 35, 10 },
        { 11, 35, 10 },
        { 50, 47 },
        {  0 },
        { 19, 46 },
        {  2, 49 },
        {  0 },
        { 19, 48 },
        { 52, 51 },
        {  0 },
        {  8, 52, 51 },
        { 14, 52, 51 },
        { 53 },
        { 16 },
        { 11 },
        { 13, 52 },
        { 56, 54 },
        {  0 },
        { 55, 56 },
        { 25 },
        { 26 },
        { 27 },
        { 28 },
        { 29 },
        { 30 },
        { 58, 57 },
        {  0 },
        { 31, 58, 57 },
        { 32, 58, 57 },
        { 60, 59 },
        {  0 },
        { 33, 60, 59 },
        { 34, 60, 59 },
        {  2 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 23, 50, 24 },
        { 31, 60 },
        { 32, 60 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "esperado EOF",
        "esperado identificador",
        "esperado constante_int",
        "esperado constante_float",
        "esperado binario",
        "esperado string",
        "esperado check",
        "esperado and",
        "esperado else",
        "esperado end",
        "esperado false",
        "esperado if",
        "esperado not",
        "esperado or",
        "esperado read",
        "esperado true",
        "esperado write",
        "esperado writeln",
        "esperado ,",
        "esperado :",
        "esperado =",
        "esperado ;",
        "esperado (",
        "esperado )",
        "esperado ==",
        "esperado !=",
        "esperado <",
        "esperado <=",
        "esperado >",
        "esperado >=",
        "esperado +",
        "esperado -",
        "esperado *",
        "esperado /",
        "esperado identificador check if read write writeln", //<lista_de_comandos> inválido
        "esperado EOF identificador check else and if read write writeln", // <lista_de_comandos_1> inválido"
        "esperadoidentificador check if read write writeln",//<comando> inválido"
        "esperado identificador",//<comando_atribuicao> inválido"
        "esperado : ;",//<comando_atribuicao_1> inválido"
        "esperado read",//<comando_entrada_dados> inválido"
        "esperado write writeln",//<comando_saida_dados> inválido"
        "esperado if",//<comando_selecao> inválido"
        "esperado else and",//<comando_selecao_1> inválido"
        "esperado check",//<comando_repeticao> inválido"
        "esperado false true",//<comando_repeticao_1> inválido"
        "esperado identificador constante_int constante_float binario string false not true ( + -",//<lista_expressoes> invlido"
        "esperado , )",//<lista_expressoes_1> inv�lido"
        "esperado identificador",//<lista_identificadores> inválido"
        "esperado , = )",//<lista_identificadores_1> inválido"
        "esperado identificador constante_int constante_float binario string false not true ( + -",//<expressao> inválido"
        "esperado and or , : ; )",//<expressao_> inválido"
        "esperado identificador contante_int constante_float binario string false not true ( + -",//<elemento> inválido"
        "esperado identificador constante_int constante_float binario string ( + -",//<relacional> inválido"
        "esperado and or , : ; ) == != < <= > >=",//<relacional_> inválido"
        "esperado == != < <= > >=",//<operador_relacional> inválido"
        "esperado identificador constante_int constante_float binario string ( + -",//<aritmetica> inválido"
        "esperado and or , : ; ( ) == != < <= > >= + -",//<aritmetica_> inválido"
        "identificador constante_int constante_float binario string ( + -",//<termo> inválido"
        "esperado and or , : ; ) == != < <= > >= + - * /",//<termo_> inválido"
        "esperado identificador constante_int constante_float binario string ( + - ",//<fator> inválido"
    };
}
