(*fact*)
fun sum(nil) = 0
    |sum(x::xs) = x+sum(xs);
fun fact(nil) = 0
    |fact(x::xs) = sum(x) + fact(xs);
fact([[1,2,3,4],nil,[5,6]]);