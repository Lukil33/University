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
fun indexsmaller(nil, s, i, temp) = i
    |indexsmaller(x::xs, s, i, temp) = if(x < s) then(indexsmaller(xs, x, i+temp, 1)) else(indexsmaller(xs, s, i, temp+1));

fun reverse(L, 0) = nil
    |reverse(x::xs, num) = reverse(xs, num-1)@[x];

fun notreversed(L, 0) = L
    |notreversed(x::xs, num) = notreversed(xs, num-1);

fun pankakeSort(nil) = nil
    |pankakeSort(L) =
    let
        val index = indexsmaller(L, hd(L), 1, 0);
        val newList = reverse(L, index) @ notreversed(L, index);
    in
        hd(newList)::pankakeSort(tl(newList))
    end;

(*main*)
val input = TextIO.openIn("parole.txt");

fun Main(File) =
    let
      val listOfString = create_list(File);
      val listOfInt = divide_cases(listOfString);
    in
      (print("Palle");pankakeSort(listOfInt))
    end;

Main(input);

TextIO.closeIn(input);