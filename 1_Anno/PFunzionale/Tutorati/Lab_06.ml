(*6.1*)
fun check(x) = if(x>4) then true else false;
fun control_list(nil, control) = nil
    |control_list(x::xs, control) = if(control(x)) then(x::control_list(xs, control)) else(control_list(xs, control));
control_list([1,2,3,4,5,6,7,8], check);

(*6.2*)
val input = TextIO.openIn("file.txt");

fun controlli(#" ") = true
    | controlli(#"\n") = true
    | controlli(#"\t") = true
    | controlli(#"\r") = true
    | controlli(_) = false;

fun deleteSpaces(nil, (a:string)) = [a]
    | deleteSpaces(y::ys, (a:string)) = if(controlli(y)) then(a::deleteSpaces(ys,"")) else(deleteSpaces(ys, a^str(y)));

fun getList(x) =
    let
        val accumulatore = "";
        val List = explode(TextIO.input(x));
    in
        deleteSpaces(List, accumulatore)
    end;
getList(input);
TextIO.closeIn(input);

(*6.3*)
fun ausiliary(nil) = nil
    | ausiliary(x::xs) = hd(explode(x))::ausiliary(xs);
fun acronym(stringa) =
    let
        val accumulatore = "";
        val L = explode(stringa);
        val del = deleteSpaces(L, accumulatore);
    in
        implode(ausiliary(del))
    end;
acronym("Palle Piscio Putamadre");