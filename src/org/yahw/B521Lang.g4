grammar B521Lang;

@header {

}

file : form* ;

form : '(' form* ')'            # list
    | '\'' form                 # quote
    | INT                       # number
    | BOOLEAN                   # bool
    | STRING                    # string
    | SYMBOL                    # symbol
    ;

INT : [0-9]+ ;
BOOLEAN : ('#f'|'#t') ;
STRING : '"' ( ~'"' | '\\' '"')* '"' ;
SYMBOL : [<=>a-zA-Z+-]+[0-9]*'?'*;

COMMENT : ';' ~[\r\n]* -> skip ;
WS : [ \t\r\n] -> skip ;