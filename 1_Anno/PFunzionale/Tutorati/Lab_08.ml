(*8.1*)
fun F((x:real)) = x*x;
fun derivata((x:real), (n:real), F) =
    let
      val inizio = F(x);
      val fine = F(x+n);
    in
      (fine-inizio)/n
    end;
derivata(1.0, 0.25, F);

(*8.2*)
fun F((x:real)) = x*x*x*x;
fun derivataNesima((x:real), (n:real), F, 0) = F(x)
    |derivataNesima((x:real), (n:real), F, (y:int)) = derivata(x, n, fn palle => derivataNesima(palle, n, F, y-1));
derivataNesima(1.0, 0.001, F, 4);

(*8.3*)
exception AHAHAHACOGLIONENONFUNZIONA
fun funzione(x,y) = x+y;
fun lreduce(F,nil) = raise AHAHAHACOGLIONENONFUNZIONA
    |lreduce(F,x::xs) = foldl F x xs;
lreduce(funzione, []);
lreduce(funzione, [1,2,3,4,5,6,7]);

(*8.4*)
fun checker(nil, y) = true
    |checker(x, nil) = false
    |checker((x::xs), (y::ys)) = (x = y) andalso checker(xs,ys);

fun ausiliary(nil,y) = true
    |ausiliary(x, nil) = false
    |ausiliary(x, y) = if(hd(x) = hd(y)) then(checker(x,y)) else(ausiliary(x, tl(y)));

fun substring x y = ausiliary(explode(x), explode(y));
substring "ale" "palle";
substring "alle" "palle";

(*8.5*)
fun makeFnList F nil = []
    |makeFnList F (x::xs) = F(x)::makeFnList F xs;

(*8.6*)
fun convertion(L) = map (fn x => if(x>0) then(real(x)) else(real(~x))) L;
convertion([~1,~1,0,3]);

(*8.7*)
fun concat(L) = foldr (fn (x,y) => x^y) "" L;
concat(["peace","hello"]);

(*8.8*)
fun acronym(L) = foldl (fn (x,y) => y^(str(Char.toUpper(hd(explode(x)))))^".") "" L;
acronym(["Sdjhb","Ddpfhoi","Hais"]);

(*8.9*)
fun new_acronym(L) = foldr (^) "" (map (fn x => x^".") (map (str o Char.toUpper o hd o explode) L));
new_acronym(["palle","molto","grosse"]);