package sintactico;
import sintactico.model.Tokens;
%%
%public
%class Lexer
%type Tokens
L=[a-zA-Z]+[_]?[a-zA-Z0-9]*
D=[0-9]*[.]?[0-9]*

espacio=[ ,\t,\r,\n]+
%{
    public String lexema;
%}
%%
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {lexema=yytext(); return Tokens.IGUAL;}
"+" {lexema=yytext(); return Tokens.SUMA;}
"-" {lexema=yytext(); return Tokens.RESTA;}
"*" {lexema=yytext(); return Tokens.MULTIPLICACION;}
"++" {lexema=yytext(); return Tokens.INCREMENT;}
";" {lexema=yytext(); return Tokens.P_COMA;}
(var) {lexema=yytext(); return Tokens.P_RESERVADA;}
{D}+ {lexema=yytext(); return Tokens.NUMERO;}
{L}+ {lexema=yytext(); return Tokens.VARIABLE;}
 . {return Tokens.ERROR;}