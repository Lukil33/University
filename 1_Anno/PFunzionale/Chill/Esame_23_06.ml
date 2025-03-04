(*ESAME giugno 2023

    scrivere una curried function “f” che prenda in input una lista di stringhe[ai, ai+1, …] e un intero n, 
    e ritorni una lista di stringhe[bi, bi+1, …] in cui 
    bi è uguale ad ai solo se la lunghezza di ai è minore o uguale ad n, 
    altrimenti bi è uguale ad ai senza il primo carattere.

    Esempio:

    >f [" ", "ab", "abc", "abcd", "abcde"] 3;
    val it = [" ", "ab", "abc", "bcd", "bcde"]: string list
    
*)
fun len(nil) = 0
    |len(x::xs) = 1 + len(xs);

fun f L n = map (fn (x:string) => if(len(explode(x))>n) then(implode(tl(explode(x)))) else(x)) L;

f [" ", "ab", "abc", "abcd", "abcde", "a"] 3;