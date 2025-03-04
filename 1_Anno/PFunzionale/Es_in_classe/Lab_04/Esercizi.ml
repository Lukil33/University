(*L4.1*)
fun reverse(nil) = nil
    | reverse(x::xs) = reverse(xs) @ [x];
reverse([1,2,3]);
reverse([]);
reverse(explode("Palle"));

(*L4.2*)
fun factorial(0) = 1
    | factorial(x) = factorial(x-1)*x;
factorial(0);

(*L4.3*)
fun cycle(nil) = nil
    | cycle(L as x::xs) = xs @ [x];
cycle([]);

(*L4.4*)
fun cycle_i(nil, _) = nil
    | cycle_i(L, 0) = L
    | cycle_i(L, i) = cycle_i(cycle(L), i-1);
cycle_i(explode("Palle"), 4);

(*L4.5*)
fun duplicate(nil) = nil
    | duplicate(L as x::xs) = x::x::duplicate(xs);
duplicate(explode("Palle"));

(*L4.6*)
fun function(x:real, 0) = 1.00
    | function(x:real, i:int) = x * function(x, i-1);
function(2.34256, 5);

(*L4.7*)
fun biggest(nil) = 0.0
    | biggest((x:real)::nil) = x
    | biggest((x:real)::xs) = if(x > biggest(xs)) then(x) else(biggest(xs));
biggest([0.1, 0.2, 0.3, 0.4]);
biggest([~2.0]);

(*L4.8*)
fun swap_badly(L as nil) = nil
    | swap_badly(L as x::nil) = [x]
    | swap_badly(L as x::y::xs) = [y, x] @ swap_badly(xs);
swap_badly([1,2,3,4,5,6,7,8,9]);

(*L4.9*)
fun list_minus_element(L as x::xs, 0) = xs
    |list_minus_element(nil, _) = nil
    |list_minus_element(L as x::xs, i) = x::list_minus_element(xs, i-1);
list_minus_element(explode("Palle"), 0);
list_minus_element(explode("Palle"), 1);
list_minus_element(explode("Palle"), 6);

(*L4.10*)
fun square(0) = 0
    | square(n:int) = square(n-1)+2*n-1;
square(5);

(*L4.11*)
fun order(a, b) = if(a < b) then(a, b) else(b, a);
fun flip(nil) = nil
    |flip(L as x::xs) = order(x)::flip(xs);
flip([(2,1),(3,4)]);

(*L4.12*)
fun diff_cases(#"a"::l) = true
    |diff_cases(#"e"::l) = true
    |diff_cases(#"i"::l) = true
    |diff_cases(#"o"::l) = true
    |diff_cases(#"u"::l) = true
    |diff_cases(_) = false;
fun vowel(x) = diff_cases(explode(x));
vowel("palle");
vowel("allep");
vowel("");

(*L4.13*)
fun member(x, nil) = false
    |member(x, S as fe::xs) = if(x = fe) then(true) else(member(x, xs));
member(1, [1,2,3,4,5,6,7,8,9]);
member(7, [1,2,3,4,5,6,7,8,9]);
member(70, [1,2,3,4,5,6,7,8,9]);

(*L4.14*)
fun eliminate_member(x, nil) = nil
    |eliminate_member(x, S as fe::xs) = if(x = fe) then(eliminate_member(x,xs)) else(fe::eliminate_member(x,xs));
eliminate_member(1, [1,2,3,4,5,6,7,8,9]);
eliminate_member(7, [1,2,3,4,5,6,7,8,9]);
eliminate_member(70, [1,2,3,4,5,6,7,8,9]);

(*L4.15*)
fun insert(x, nil) = [x]
    |insert(x, S as fe::xs) = if(x = fe) then(fe::xs) else(fe::insert(x,xs));
insert(1, [1,2,3,4,5,6,7,8,9]);
insert(7, [1,2,3,4,5,6,7,8,9]);
insert(70, [1,2,3,4,5,6,7,8,9]);

(*L4.16*)
fun insert_first(x, nil) = nil
    |insert_first(x, l::ls) = (x::l)::insert_first(x, ls);
insert_first(1,[[2,3],[],[3]]);

(*L4.17*)
fun ausiliary(nil) = nil
    |ausiliary(L as x::xs) = [[x]]@insert_first(x, ausiliary(xs))@ausiliary(xs);
fun sigma_algebra(L) = []::ausiliary(L);
sigma_algebra([1,2,3]);

(*L4.18*)
fun wrapper((r:real), nil) = 1.0
    |wrapper((r:real), L as (x:real)::xs) = (r-x)*wrapper(r, xs);
fun prodDiff(nil) = 1.0
    |prodDiff(L as (x:real)::nil) = 1.0
    |prodDiff(L as (x:real)::xs) = wrapper(x, xs)*prodDiff(xs);
prodDiff([1.0,2.0,3.0]);
prodDiff([0.0]);