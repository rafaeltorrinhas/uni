grammar VectorLang;

program:
    stat* EOF;

stat
    : 'show' expr ';'             #StatShow
    | expr '->' ID ';'            #StatAssign
    ;

expr
    : SIGNAL=('+'|'-') expr        #ExprValue
    | e1=expr '*' e2=expr                #ExprMult
    | e1=expr '.' e2=expr                #ExprIntern
    | e1=expr OP=('+'|'-') e2=expr       #ExprSum
    | '(' expr ')'                 #ExprParenthesis
    | ID                           #ExprID
    | NUMBER                       #ExprNumber
    | vector                       #ExprVector
    ;

vector
    : '[' NUMBER (',' NUMBER)* ']'
    ;


COMMENT: 
    '#' ~[\r\n]* -> skip
;

ID:
    [a-zA-Z][a-zA-Z_0-9]*
;

WS:
    [ \t]+ -> skip
;

NEWLINE: 
    '\r'? '\n' -> skip
;

NUMBER:
    [0-9]+('.'[0-9]+)?
;