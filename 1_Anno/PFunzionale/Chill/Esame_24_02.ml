(*Si scriva una funzione prefix che riceve come argomento una stringa e restituisce
  una lista di stringhe contenente tutti i prefissi della stringa
Es: "Ciao" -> ["Ciao","Cia","Ci,"C"]*)

fun notlast(x::nil) = nil
    |notlast(x::xs) = x::notlast(xs);

fun prefix("") = nil
    |prefix((x:string)) = x::prefix(implode(notlast(explode(x))));

prefix("Ciao0");