(*5.1*)
val is_one = fn 1 => "One"
            | _ => "Anything else";
is_one(0);
is_one(1);

(*5.2*)
val is_lower_than_5 = fn x => case x>5 of
                         false => 1
                        |true => 2;
is_lower_than_5(6);
is_lower_than_5(1);

(*5.3*)
fun thousandthPower(x:real) =
    let
        val x = x*x*x*x*x;
        val x = x*x*x*x*x;
        val x = x*x*x*x;
        val x = x*x*x*x*x*x*x*x*x*x;
    in
        x*x
    end;
thousandthPower(2.0);
thousandthPower(1.01);

(*5.4*)
fun split (nil) = (nil,nil)
    | split ([a]) = ([a],nil)
    | split (a::b::cs) =
    let
        val x = split (cs);
    in
        (a::(#1(x)),b::(#2(x)))
    end;
split([1,2,3,4]);

(*5.5*)
fun insert_first(x, nil) = nil
    | insert_first(x, l::ls) = (x::l)::insert_first(x, ls);
fun powerSet(nil) = [nil]
    | powerSet(x::xs) =
    let
        val y = powerSet(xs);
    in
        y@insert_first(x,y)
    end;
powerSet([1,2,3]);

(*5.6*)
fun maximum(nil) = 0
    | maximum(L as (x:int)::nil) = x
    | maximum(L as x::xs) =
    let
        val M = maximum(xs);
    in
        if M>x then M else x
    end;
maximum([1,2,3,4,5]);

(*5.7*)
fun doubleExp((x:real), 0) = x
    | doubleExp(x, i) =
    let
        val x = doubleExp(x, i-1);
    in
        x*x
    end;
doubleExp(6.0, 3);

(*5.8*)
fun sumPairs(nil) = (0,0)
    | sumPairs(L as (a,b)::xs) =
    let
        val (M,N) = sumPairs(xs);
    in
        (a+M, b+N)
    end;
sumPairs([(1,1)]);
sumPairs([(1,1), (2,2)]);

(*5.9*)
fun sumList(nil) = (0,0)
    | sumList(L as x::nil) = (x, 0)
    | sumList(L as x::y::xs) =
    let
        val (M,N) = sumList(xs);
    in
        (x+M, y+N)
    end;
sumList([]);
sumList([1,2,3,4]);
sumList([1,2,3,4,5]);