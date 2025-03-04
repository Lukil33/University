(*7.1*)
fun aus((x:real)) = x*x;
fun tabulate((a:real), (delta:real), 1, F) = print(Real.toString(F(a))^"\n")
    |tabulate(a, delta, (n:int), F) =
    let
        val palle = real(n-1);
    in
      (tabulate(a, delta, n-1, F); print(Real.toString(F(a+(palle)*delta))^"\n"))
    end;
tabulate(1.0, 2.0, 10, aus);

(*7.2*)
fun trap (a,b,n,F) =
    if n<=0 orelse b-a<=0.0 then 0.0 else
    let
        val delta = (b-a)/real(n)
    in
        delta * (F(a)+F(a+delta))/2.0 + trap (a+delta,b,n-1,F)
    end;
trap(0.0, 1.0, 8, aus);