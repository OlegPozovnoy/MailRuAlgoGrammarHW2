grammar Exp;

stmt: v=Variable Eq e=expr;
expr : (l1=lterm r1=rsum | l2=lterm);
lterm : (t1=terminate p1=multdiv | t2=terminate);
rsum : (Plus e1=expr|Minus e2=expr);
multdiv : (Mult l=lterm | Div d=lterm);
terminate :  (Plus t1=terminate | Minus t2=terminate | v=Variable | n=Number | c=complex |OBracket e=expr CBracker);
signed_number: (Plus n1=Number| Minus n2=Number | n3=Number);
complex: RE re=signed_number IM im=signed_number;

Eq: '=';
Plus: '+';
Minus: '-';
Mult: '*';
Div:'/';
OBracket: '(';
CBracker: ')';
Number:    ('0'..'9')+ ('.' ('0'..'9')+)?;
Variable: ('a'..'z')+('0'..'9')*;
RE: 'Re';
IM: 'Im';
WS:   (' ' | '\t' | '\r'| '\n') -> skip;
