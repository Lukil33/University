(*6.1*)
fun print_list(nil) = print("")
    | print_list((x:int)::xs) = (print(Int.toString(x));print(" ");print_list(xs));
print_list([1,2,3,4]);

(*6.2*)
fun fact(1) = 1
    | fact(x) = x*fact(x-1);
fun print_binomio_di_newton((n:int), (m:int)) =
    let
      val M = div(fact(n),(fact(m)*fact(n-m)));
    in
      (print(Int.toString(n));print(" ");print(Int.toString(m));print(" ");print(Int.toString(M)))
    end;
print_binomio_di_newton(7,2);

(*6.3*)
fun print_n(0) = print("X")
    | print_n(n) = (print_n(n-1); print_n(n-1));
print_n(2);

(*6.4*)
val input_file = TextIO.openIn("zap.txt");
TextIO.inputN(input_file, 6);
TextIO.inputLine(input_file);
TextIO.lookahead(input_file);
TextIO.input(input_file);
TextIO.closeIn(input_file);


(*6.5*)
val infile = TextIO.openIn("Palle.txt");
val x = TextIO.input(infile);
val x = TextIO.input1 (infile);
val x = TextIO.inputN (infile,2);
val x = TextIO.inputN (infile,5);
val x = TextIO.inputLine (infile);
val x = TextIO.lookahead (infile);

(*6.6*)
val input_file = TextIO.openIn("zap.txt");

fun check(#" ") = true
    |check(#"\n") = true
    |check(#"\b") = true
    |check(_) = false;

fun deleteSpaces(nil) = nil
  | deleteSpaces(y::ys) = if(check(y)) then(deleteSpaces(ys)) else(y::deleteSpaces(ys));



fun getList(x) =
  let
    val List = explode(TextIO.input(x));
  in
    print(implode(deleteSpaces(List)))
  end;
getList(input_file);
TextIO.closeIn(input_file);

(*6.7*)
exception shortList of int;
fun thirdElement1 nil = raise shortList(0) 
  |thirdElement1[x] = raise shortList(1)
  |thirdElement1[x,y] = raise shortList(2)
  |thirdElement1 L = hd(tl(tl(L)));
fun thirdElement L = thirdElement1 L handle 
  shortList n => (
    print("List too short\n");
    print("It only contains ");
    print(Int.toString(n));
    print(" elements\n");
    0);

thirdElement([]);
thirdElement([1]);
thirdElement([1,2]);
thirdElement([1,2,3]);

(*6.8*)
exception Negative of int;
fun fact1(0) = 1
  |fact1(n) =
  if n>0 then n*fact1(n-1)
  else raise Negative(n);
fun fact(n) = fact1(n) handle Negative(n) => (
  print("Warning: negative argument ");
  print(Int.toString(n));
  print(" found\n");
  0);
fact(~3872);