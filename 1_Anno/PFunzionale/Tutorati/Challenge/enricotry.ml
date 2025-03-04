(*read line from a file*)
fun line(SOME x) = x;

fun create_list(File) = if(TextIO.endOfStream(File)) then([]) else(line(TextIO.inputLine(File))::create_list(File));

(*generate number from string*)
fun isANum(x) = ord(x)-ord(#"0") >= 0 andalso ord(x)-ord(#"0") <= 9;

fun firstNum(nil) = 0
    |firstNum(x::xs) = if(isANum(x)) then(ord(x)-ord(#"0")) else(firstNum(xs));

fun secondNum(nil, n) = n
    |secondNum(x::xs, n) = if(isANum(x)) then(secondNum(xs, ord(x)-ord(#"0"))) else(secondNum(xs, n));

fun generateNum(x) = firstNum(explode(x))*10 + secondNum(explode(x), 0);

fun divide_cases(nil) = []
    |divide_cases(x::xs) = generateNum(x)::divide_cases(xs);

(*pankake sort*)
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

(*main*)
val input = TextIO.openIn("parole.txt");

fun Main(File) =
    let
      val listOfString = create_list(File);
      val listOfInt = divide_cases(listOfString);
    in
      (print("Palle");pancakeSort(listOfInt))
    end;

Main(input);

TextIO.closeIn(input);