fun reverse_a_list(list) = if(tl(list) = nil) then(list) else(reverse_a_list(tl(list))@[hd(list)]);
reverse_a_list([1,2,3,4,5,6]);

fun binomio_di_newton(n, k) = if(k <> 0 andalso n<>k) then(binomio_di_newton(n-1,k)+binomio_di_newton(n-1,k-1)) else(1);
binomio_di_newton(10, 5);

fun factorial(n) = if(n > 1) then(factorial(n-1)*n) else(1);
factorial(5);

fun array_to_left(i, list) = if(i>0) then(array_to_left(i-1, tl(list)@[hd(list)])) else(list);
array_to_left(2, [1,2,3,4,5,6]);

fun duplicate_list(list) = if(list <> nil) then([hd(list), hd(list)]@duplicate_list(tl(list))) else(nil);
duplicate_list([1,2,3]);

fun len_list(list) = if(tl(list) = nil) then(1) else(len_list(tl(list))+1);
len_list([1,2,3,4]);

fun exp(x:real, i) = if(i>0) then(x*exp(x, i-1)) else(1.0);
exp(2.0, 3);

fun largest(list:string list) = if(tl(list) = nil) then(hd(list)) else(if(hd(list) > hd(tl(list))) then(largest([hd(list)]@tl(tl(list)))) else(largest(tl(list))));
largest(["a", "abc", "ab", "b"]);

fun string_to_left(i, string) = implode(array_to_left(i, explode(string)));
string_to_left(3, "abcdefgh");

fun fibonacci(i) = if(i<=1) then(1) else(fibonacci(i-1)+fibonacci(i-2));
fibonacci(50);