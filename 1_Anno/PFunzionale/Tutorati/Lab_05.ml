(*5.1*)
fun acronym(nil) = ""
    | acronym(L as (x:string)::xs) =
    let
        val M = hd(explode(x));
        val Y = acronym(xs);
    in
        str(M)^Y
    end;
acronym(["hello", "World","sldgfp"]);

(*5.2*)
fun is_present(x, nil) = false
    | is_present(x, y::ys) = if(x=y) then(true) else(is_present(x, ys));
fun is_sublist(nil, Y) = true
    | is_sublist(x::xs, Y) =
    let
        val res = is_present(x, Y);
    in
        if(res) then(is_sublist(xs, Y)) else(false)
    end;
is_sublist([1,2,3,4,5,6],[1,2,3,4,5,6]);

(*5.3*)
fun is_equal(L, I) = is_sublist(L, I) andalso is_sublist(I, L);
is_equal([1,2,3,4,5,6],[1,4,6,5,2,3]);