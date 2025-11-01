grammar Calculator;

program: 
    stat* EOF;

stat:
    expr? NEWLINE;

expr:
    op =('+' | '-' | '*' | '/' | '%') expr expr  #ExprPrefix
    | Number                  
    ;

Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r' ? '\n';
WS: [ \t] -> skip;
COMMENT: '#' .*? '\n' -> skip;