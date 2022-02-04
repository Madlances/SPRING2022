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
fun eval(nil, number:real) = 0.0
  | eval(x::nil, number) = x
  | eval(x::k, number) = x + x*number + x*eval(k, x-1.0);

eval([1.0, 5.0, 3.0], 2.0);

(* Excercise 7 *)
fun quicksort nil = nil
|   quicksort (pivot::rest) =
let
    fun split nil = (nil,nil)
    |   split (x::rest) = 
        let
            val (left,right) = split rest
        in
            if x < pivot then (x::left,right) else (left,x::right)
        end
    val (left,right) = split rest
in
    quicksort left @ [pivot] @ quicksort right
end;

fun icmp (a, b) = a < b;
fun rcmp (a:real, b) = a < b;

(* Extra Problem *)
( * A: What does the funtion, g do? *)
