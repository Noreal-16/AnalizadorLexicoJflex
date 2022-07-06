package Analizador;

import jflex.Main;
import jflex.SilentExit;
import sintactico.Lexer;
import sintactico.model.Tokens;

import java.io.File;
import java.io.StringReader;

public class Analizador {
    public static void main(String[] args) {
        /**
         * Metodo para crear el documento Flex
         */
        /*String[]archivos = {("datos"+ File.separatorChar+"Lexer.flex")};
            try {
                Main.generate(archivos);
            } catch (SilentExit e) {
               throw new RuntimeException(e);
            }*/


        /**
         * Metodo para crear los lexemas y tokens
         */

        try {
            String cadena = " var aux_1 = 78.9; var aux = 9.0; var c = a + b; var f = a; f++;";
            StringReader input = new StringReader(cadena);
            Lexer lexer = new Lexer(input);
            String result = "";
            while (true){
                Tokens token = lexer.yylex();
                if (token ==null){
                    break;
                }
                switch (token){
                    case ERROR :
                        result += "[ "+ lexer.yytext() + " ] " + " SIMBOLO DESCONOCIDO " + "\n";
                        break;
                    default: result += "[ "+ lexer.lexema +" ] "+ " ES UN(A) -> " + token.toString() + "\n";
                        break;
                }
            }
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
