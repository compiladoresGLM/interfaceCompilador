package interfacecompilador.gals;

public interface ParserConstants {
    int START_SYMBOL = 35;

    int FIRST_NON_TERMINAL = 35;
    int FIRST_SEMANTIC_ACTION = 62;

    int[][] PARSER_TABLE =
            {
                    {-1, 0, -1, -1, -1, -1, 0, -1, -1, -1, -1, 0, -1, -1, 0, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {2, 3, -1, -1, -1, -1, 3, -1, 2, 2, -1, 3, -1, -1, 3, -1, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 4, -1, -1, -1, -1, 8, -1, -1, -1, -1, 7, -1, -1, 5, -1, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, 17, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 21, 21, 21, 21, 21, -1, -1, -1, -1, 21, -1, 21, -1, -1, 21, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, 25, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 27, 27, 27, 27, 27, -1, -1, -1, -1, 27, -1, 27, -1, -1, 27, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, 28, 28, -1, 28, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 31, 31, 31, 31, 31, -1, -1, -1, -1, 33, -1, 34, -1, -1, 32, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1},
                    {-1, 35, 35, 35, 35, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, 36, 36, -1, 36, -1, 36, 37, 37, 37, 37, 37, 37, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, 39, 40, 41, 42, 43, -1, -1, -1, -1},
                    {-1, 44, 44, 44, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, 45, 45, -1, 45, -1, 45, 45, 45, 45, 45, 45, 45, 46, 47, -1, -1},
                    {-1, 48, 48, 48, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, 49, 49, -1, 49, -1, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 51},
                    {-1, 52, 53, 54, 55, 56, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1}
            };

    int[][] PRODUCTIONS =
            {
                    {77, 36, 78},
                    {38, 22, 37},
                    {0},
                    {36},
                    {39},
                    {41},
                    {42},
                    {43},
                    {45},
                    {49, 21, 51, 40},
                    {20, 12, 51},
                    {0},
                    {15, 23, 49, 24},
                    {17, 23, 47, 24},
                    {18, 23, 47, 24, 79},
                    {12, 23, 51, 24, 36, 44},
                    {10},
                    {9, 36, 10},
                    {7, 23, 51, 24, 20, 12, 46},
                    {16, 36, 10},
                    {11, 36, 10},
                    {51, 76, 48},
                    {0},
                    {19, 47},
                    {2, 50},
                    {0},
                    {19, 49},
                    {53, 52},
                    {0},
                    {8, 53, 80, 52},
                    {14, 53, 81, 52},
                    {54},
                    {16, 73},
                    {11, 74},
                    {13, 53, 75},
                    {57, 55},
                    {0},
                    {56, 71, 57, 72},
                    {25},
                    {26},
                    {27},
                    {28},
                    {29},
                    {30},
                    {59, 58},
                    {0},
                    {31, 59, 63, 58},
                    {32, 59, 64, 58},
                    {61, 60},
                    {0},
                    {33, 61, 65, 60},
                    {34, 61, 66, 60},
                    {2},
                    {3, 67},
                    {4, 68},
                    {5},
                    {6, 82},
                    {23, 51, 24, 31, 61},
                    {32, 61, 70}
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
                    "esperado identificador check if read write writeln",//<comando> inválido"
                    "esperado identificador",//<comando_atribuicao> inválido"
                    "esperado : ;",//<comando_atribuicao_1> inválido"
                    "esperado read",//<comando_entrada_dados> inválido"
                    "esperado write writeln",//<comando_saida_dados> inválido"
                    "esperado if",//<comando_selecao> inválido"
                    "esperado else and",//<comando_selecao_1> inválido"
                    "esperado check",//<comando_repeticao> inválido"
                    "esperado false true",//<comando_repeticao_1> inválido"
                    "esperado expressão",//<lista_expressoes> invlido"
                    "esperado , )",//<lista_expressoes_1> inv�lido"
                    "esperado identificador",//<lista_identificadores> inválido"
                    "esperado , = )",//<lista_identificadores_1> inválido"
                    "esperado identificador constante_int constante_float binario string false not true ( + -",//<expressao> inválido"
                    "esperado expressao",//<expressao_> inválido"
                    "esperado identificador contante_int constante_float binario string false not true ( + -",//<elemento> inválido"
                    "esperado identificador constante_int constante_float binario string ( + -",//<relacional> inválido"
                    "esperado and or , : ; ) == != < <= > >=",//<relacional_> inválido"
                    "esperado == != < <= > >=",//<operador_relacional> inválido"
                    "esperado identificador constante_int constante_float binario string ( + -",//<aritmetica> inválido"
                    "esperado expressão",//<aritmetica_> inválido"
                    "identificador constante_int constante_float binario string ( + -",//<termo> inválido"
                    "esperado and or , : ; ) == != < <= > >= + - * /",//<termo_> inválido"
                    "esperado identificador constante_int constante_float binario string ( + - ",//<fator> inválido"
            };
}
