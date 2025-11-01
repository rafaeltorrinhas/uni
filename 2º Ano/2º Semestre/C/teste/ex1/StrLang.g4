grammar StrLang;

program
    : line* EOF;


line
    : stat? NEWLINE;

stat
    : ID ':' expr               #assignStat
    | 'print' expr              #printStat
    ; 

expr
    : e1=expr '+' e2=expr                #ExprSum
    | e1=expr '-' e2=expr                #ExprSubtract
    | 'trim' expr                        #ExprTrim
    | '(' expr ')'                       #ExprParenthesis
    | e1=expr '/' e2=expr '/' e3=expr    #ExprSubstitute
    | ID                                 #ExprId
    | STRING                             #ExprString
    | 'input' '(' expr ')'               #ExprInput
    ;


ID
    : [a-zA-Z][a-zA-Z0-9]*
    ;

STRING
    : '"' .*? '"'
    ;

NEWLINE
    : '\r'?'\n'
    ;

WS
    : [ \t]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;



