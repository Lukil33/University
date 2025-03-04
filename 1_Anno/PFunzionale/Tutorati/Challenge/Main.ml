(* Parte di Lukil
fun isANum(z) = ord(z)-ord(#"0") >= 0 andalso ord(z)-ord(#"0") <= 9;

fun Fnum(nil) = 0
    |Fnum(y::ys) = if(isANum(y)) then(ord(y)-ord(#"0")) else (Fnum(ys));

fun Snum(x, nil) = x
    |Snum(x, y::ys) = if(isANum(y)) then(Snum(ord(y)-ord(#"0"), ys)) else(Snum(x,ys));

fun createNumber(L) = Fnum(L)*10+Snum(0,L);

fun extractNumber(nil) = nil
    |extractNumber(""::nil) = nil
    |extractNumber(x::xs) =
    let
      val number = createNumber(explode(x));
    in
      number::extractNumber(xs)
    end;

extractNumber([""]);
extractNumber(["1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet", ""]);

val input_file = TextIO.openIn("parole.txt");

fun check(#"\n") = true
    |check(_) = false;

fun deleteSpaces(L, T, nil) = L@[implode(T)]
  | deleteSpaces(L, T, y::ys) =
  if(check(y)) then(deleteSpaces(L@[implode(T)], [], ys)) else(deleteSpaces(L, T@[y], ys));

fun getList(x) =
  let
    val List = explode(TextIO.input(x));
  in
    deleteSpaces([], [], List)
  end;

*)

(* Parte del BOSS
fun reverse(nil)=nil|reverse(x::xs)=reverse(xs)@[x];

fun max(a:int,b)=if a>b then a else b;

fun maxOfList(L as l::ls)=foldr max l L;

fun indexOf(x,l::ls)=if x=l then 0 else 1+indexOf(x,ls);

fun listLength(nil)=0|listLength(l::ls)=1+listLength(ls);

fun maxIndex(L)=indexOf(maxOfList(L),L);

fun selectList(_,_,nil)=nil
|selectList(start,finish,l::ls)=if start>0
    then selectList(start-1,finish-1,ls)
    else (if finish<0 then nil else [l]@selectList(start,finish-1,ls));

fun reverseSelected(x,nil)=nil
|reverseSelected(x,L)=reverse(selectList(0,x,L))@selectList(x+1,listLength(L),L);

fun pancakeSort_aux(List,1)=List
|pancakeSort_aux(List,currsize)=
    let
        val indexofmax=maxIndex(selectList(0,currsize-1,List))
        val firststep=reverseSelected(indexofmax,List)
        val secondstep=reverseSelected(currsize-1,firststep)
    in
        pancakeSort_aux(secondstep,currsize-1)
    end;

fun pancakeSort(nil)=nil
|pancakeSort(List)=pancakeSort_aux(List,listLength(List));

pancakeSort(extractNumber(getList(input_file)));
TextIO.closeIn(input_file);
*)