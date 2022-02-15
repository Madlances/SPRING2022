(* Kassandra Madsen *)
(* Module 4 HW *)

(* Chapter 9: 5, 9, 10, 14, 19, 22 *)

(* Problem 5 *)
fun inclist x y = map (fn a => a + y) x;
inclist [1,2,3,4] 10;

(* Problem 9 *)
fun boxr x =
  let
    fun or (a, b) = a orelse b
in 
  foldr (op or) false x
end;

boxr [];
boxr [true, false];

(* Problem 10 *)

(* Problem 14 *)
fun maxpairs x = map (fn (a,b) => if a > b then a else b) x;
maxpairs [(1,3), (4,2), (~3, ~4)];

(* Problem 19 *)

(* Problem 22 *)
fun evens [] = []
  | evens (x::xs) =
      if x mod 2 = 0 then x::evens(xs)
      else evens(xs);
evens [1,2,3,4];

(* Chapter 10: 3, 4 *)

(* Problem 3 *)

(* Problem 4 *)

(* Extra Problem *)
(* B - Name two examples from C/C++ where a variable is “live” (in use) but not in scope (i.e.. not visible in some places in code). *)
(* One place would be if the variable is private, then it can only be used within that class/function that it was created in.
   The second one would be local variables, they can only be used within the block of code they were created in.
*)