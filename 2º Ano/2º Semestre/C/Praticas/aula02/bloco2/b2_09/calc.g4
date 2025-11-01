grammar calc;

program
    : stat* EOF
    ;

stat
    : assignment
    | statement
    | expr
    ;

assignment
    : expr '->' ID ';'                  # AssignmentExpr
    ;

statement
    : 'print' expr ';'                  # PrintExpr
    ; 

expr
    : expr OP('+'|'-'|'*'|'/') expr     # BinaryExpr
    | reduce expr                       # ReduceExpr
    | '(' + expr + ')'                  # ParenthesisExpr
    | NUMBER                            # NumberExpr
    | FRACTION                          # FractionExpr
    ;


ID  
    : [a-zA-Z_][a-zA-Z0-9_]*   
    ;

STRING
    : '"' (~["\r\n])* '"'
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

FRACTION:
    NUMBER '/' NUMBER
    ;

COMMENT:
    '//' ~[\r\n]* -> skip
    ;

NEWLINE:
    [\r\n]+ -> skip
    ;

WS:
    [ \t]+ -> skip
    ;

