fun simpleMap(F, nil) = nil
    |simpleMap(F, (x:real)::xs) = F(x)::simpleMap(F,xs);

fun reduce(F, nil) = 0.0
    |reduce(F, (x:real)::nil) = x
    |reduce(F, (x:real)::xs) =
    let
      val palle = reduce(F, xs);
    in
      F(x,palle)
    end;

fun filter(F, nil) = nil
    |filter(F, (x:real)::xs) = if(F(x)) then(x::filter(F,xs)) else(filter(F,xs));

(*8.1*)
fun rmNegrative((x:real)) = if(x > 0.0) then(x) else(0.0);
simpleMap(rmNegrative, [0.0,1.0,~2.1,~2.3]);

(*8.2*)
fun maximum((x:real), (y:real)) = if(x > y) then(x) else(y);
reduce(maximum, [1.1,2.2,4.4,3.3]);

(*8.3*)
fun notNegrative((x:real)) = x>0.0;
filter(notNegrative, [1.1,~1.2,~1.3,1.4]);

(*8.4*)
reduce(op -, [1.1,2.2,4.4,3.3]);

(*8.5*)
fun applyList nil _ = nil
    |applyList (F::Fs) a = F(a)::(applyList Fs a);
applyList [fn x=> x*2, fn x=> x*x, fn x=> x*x*x] 4;

(*8.6*)
fun curry F x1 x2 x3 = F(x1,x2,x3);

(*8.7*)
fun transform((x:int)) = real(x);
map (transform) [1,2,3];

(*8.8*)
fun logic(x, y) = x andalso y;
foldr (logic) true [true, false, true];

(*8.9*)
fun implodes(nil) = ""
    |implodes(l) = foldl (fn (y,x) => x^(str(y))) "" l;
implodes([#"b",#"c",#"d"])