(* Kassandra Madsen *)
(* Chapter 7: 2,3,4,5,7 *)

(* Excercise 2 *)
fun member(element, nil) = false
 |  member(element, x::k) = if (element=x) then true else member(element, k);

member(5, []);

(* Excercise 3 *)
fun less(element, nil) = nil
  | less(element, x::k) = if (x < element) then x::k else less(element, k);

less(10, [1, 2]);

(* Excercise 4 *)
fun repeats(nil) = false
  | repeats(x::nil) = false
  | repeats(x::k) = if (x=hd(k)) then true else repeats(k);

repeats([1,1,5,6,7]);
repeats([1]);

(* Excercise 5 *)
fun pow (base:real, 0) = 1.0
    | pow (base:real, exp:int):real = base * pow(base, exp - 1);

fun elms ([], _, _) = 0.0
  | elms (x::xs, a, count) = (x * pow(a, count)) + elms(xs, a, count + 1);

fun eval ([], _) = 0.0 
  | eval (x::xs, a) = x + elms(xs, a, 1);

eval([1.0, 5.0, 3.0], 2.0);
eval([1.0, 1.0, 1.0], 1.0);

(* Excercise 7 *)
fun partition (pivot, nil, opLT) = (nil, nil)
  | partition (pivot, first::rest, opLT) =
      let
        val (small, large) = partition (pivot, rest, opLT)
      in
        if opLT (first, pivot)
          then (first::small, large)
          else (small, first::large)
      end;

fun quickSort (nil, opLT) = nil
  | quickSort ([single], opLT) = [single]
  | quickSort (first::rest, opLT) =
      let
        val (small, large) = partition(first, rest, opLT)
      in
        quickSort(small, opLT) @ [first] @ quickSort(large, opLT)
      end;

fun icmp (a, b) = a < b;
fun rcmp (a:real, b) = a < b;

quickSort ([1, 4, 2, 7, 11, 8, 5], icmp);
quickSort ([1.0, 4.5, 2.3, 7.0, 11.1, 8.2, 5.9], rcmp);

(* Extra Problems *)
(* A What does the funtion g, do? *)
(* The function g, has two parameters (n, and x) and is running through the let block n times, getting the rest of the input x as a list and outputting the result of the final iteration of the cocatenated list of x, y. *)

(* B: write a function, f2n(f,n,x)) that computes applying f n times to x *)
fun p p = p+1;
fun f2n (f, n, x) = if n=0 then x else f2n(f, n-1, x);
f2n(p,0,1);

(* Chapter 8: 3,5,6ab *)
(* Excercise 3 *)
(* Part a *)
(* We know Coercion automatically converts to the type, so for example 
if we define int x, int y, and int z; and x = 1 and y = 2 
then z = x+y, so z=3, and the type would automatically be an int.
There would be no overloading since we used coercion*)

(* Part b *)
(* Using the same example in part a, if we let x = 1.0 and y = 2
then z = x+y, then it would overload since you are trying to add
the type double and a int, which are unmatched types*)

(* Part c *)
(* 2.0 will end up impliciting with 1, aka implicit type conversion,
so converting it will end up being both overloading and coercion *)

(* Part d *)
(* 1.0 and 2.0 are of the same type, so no need for coercion or overloading *)

(* Excercise 5 *)
(* Part a *)
(* My guess is 'a -> int *)
fun f (x) = 1;

(* Part b *)
(* My guess is  'a*'b -> int *)
fun f (x,y) = 1;

(* Part c *)
(* My guess is  'a-> 'a *)
fun f (x) = x;

(* Part d *)
(* My guess is 'a*'b-> 'a *)
fun f (x,y) = x;

(* Part e *)
(* My guess is int->int *)
fun f g = g(1);

(* Part f *)
(* My guess is ('a-> 'a)-> 'a *)
fun f (g,x) = g(x);

(* Part g *)
(* My guess is ('a * 'b -> 'c) * ('a * 'b)-> 'c *)
fun f (g,x,y) = g(x,y);

(* Part h *)
(* My guess is ('a->'b) * ('a->'c)-> 'c *)
fun f (g,h,x) = g(h(x));

(* Part i *)
(* My guess is ('a-> 'b)*'b->'a *)
fun f (g,x) = g(g(x));

(* Excercise 6ab *)
(* Part a: Make char a subtype of string *)
(* We can do something similar like in excercise 4, where x="a" and y = 'b;.
where x is a string, and y is a char. This would cause overloading, but
if we instead made char a subtype of string then we wouldn't have to deal with overloading,
since it would use coercion instead, or it be the same type in the end, and
thus wouldn't need coercion. *)

(* Part b: Make int a subtype of real *)
(* In excercise 4, we had 1.0+2, which ended up overloading. If we instead
made int a subtype of real then we wouldn't have to deal with overloading,
since it would use coercion instead, or it be the same type in the end, and
thus wouldn't need coercion. *)