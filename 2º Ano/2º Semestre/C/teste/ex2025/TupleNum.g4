grammar TupleNum;

program
    :
    line* EOF
    ;

line
    :
    stat ';'
    ;


stat
    : 'print' expr                  #PrintStat
    | ID ':=' expr                  #AssignStat
    ;


expr
    : TYPE=('head'|'tail') expr     #ExprSlice
    | OP=('sum'|'average') expr     #ExprOperation
    | SIGNAL=('-'|'+') expr         #ExprSignal
    | e1=expr OP=('+'|'-') e2=expr  #ExprUnary
    | '(' expr ')'                  #ExprParenthesis 
    | '[' NUMBER? (',' NUMBER)* ']' #ExprTuple
    | expr ',' expr                 #ExprComma
    |                               #ExprEmpty
    | 'read'                        #ExprRead                        
    | ID                            #ExprID
    | NUMBER                        #ExprNumber
    ;


ID: [a-zA-Z][a-zA-Z_0-9]*;
COMMENT: '--' ~[\r\n]* -> skip;
NUMBER: [0-9]+('.'[0-9]+)?;
WS: [ \t\r\n] -> skip;
NEWLINE: '\r'? '\n' -> skip;
