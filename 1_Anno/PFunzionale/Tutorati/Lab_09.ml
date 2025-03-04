(*9.1
type 'a listaDiListe = 'a list list;

val a = [[1],[2,4],[1,2,3,4]]: int listaDiListe;

(*9.2*)
type ('a,'b) listaDiTuple = ('a * 'a * 'b) list;

val b = [(1,2,#"s"),(1,3,#"s")]: (int,char) listaDiTuple;

(*9.3*)
type ('c,'d) mapping = ('c * 'd) list;

val c = [(1,"palle"), (2,"nere"), (3,"grosse"), (4,"e"), (5,"rotonde")]: (int,string) mapping;

(*9.4*)
signature SET =
  sig
    type ''a t
    val empty: ''a t
    val membership: ''a * ''a list -> bool
    val add: ''a * ''a list -> ''a list
    val remove: ''a * ''a list -> ''a list
  end;

(*9.5/9.9*)
structure set =
  struct
    type ''a t = ''a list
    val empty = []: ''a t
    fun membership(a, nil) = false
        |membership(a, x::xs) = if(a = x) then(true) else(membership(a, xs))
    fun add(x, L) = if(membership(x, L)) then(L) else(L@[x])
    fun remove(x, nil) = nil
        |remove(x, l::ls) = if(x = l) then(ls) else(l::remove(x,ls))
  end:> SET;
set.remove(1,[1,2,3,4,5,6,1]);
*)

(*9.10/9.11*)
signature TREES =
  sig
    datatype 'a T = Lf | Br of 'a * 'a T * 'a T
    val count: 'a T -> int
    val depth: 'a T -> int
    val mirror : 'a T -> 'a T
  end;

structure trees =
  struct
    fun count Lf = 1
        |count(Br(_, left, right)) = 1 + count(left) + count(right)
    fun depth Lf = 0
        |depth(Br(_, left, right)) = if(depth(left)>depth(right)) then(1+depth(left)) else(1+depth(right))
    fun mirror Lf = Lf
        |mirror(Br(value, left, right)) = (value, mirror(right), mirror(left))
  end:> TREES;