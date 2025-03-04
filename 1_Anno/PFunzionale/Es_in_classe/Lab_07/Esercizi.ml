(*7.1*)
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

(*7.2*)
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
fact(0);
fact(5);

(*7.3*)
fun aus((x:real)) = x*x*x*x;
fun tabulate((a:real), (delta:real), 1, F) = print(Real.toString(F(a))^"\n")
    |tabulate(a, delta, (n:int), F) =
    let
        val palle = real(n-1);
    in
      (tabulate(a, delta, n-1, F); print(Real.toString(F(a+(palle)*delta))^"\n"))
    end;
tabulate(1.0, 2.0, 10, aus);