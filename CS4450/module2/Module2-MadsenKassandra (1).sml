(* Kassandra Madsen, Module 2 HW *)

(* Chapter 5 *)
(* Excercise 3 *)
fun fourth x = hd (tl(tl(tl(x))));
fourth["hello", "my", "name", "is", "kassi"];

(* Excercise 4 *)
fun min3 (a, b, c) = 
    if a < b andalso a < c then a
        else if b < a andalso b < c then b
        else c;
min3(1, 2, 3);

(* Excercise 5 *)
fun red3 (a, b, c) = (a, c);
red3(15, 3, 5);

(* Excercise 6 *)
fun thirds s:char = hd (tl(tl(explode s)));
thirds "abc";

(* Excercise 7 *)
fun cycle1 x = tl(x) @ [hd(x)];
cycle1[1,2,3,4];

(* Excercise 8 *)
fun sort3 (a:real,b:real,c:real) = 
  if a < b andalso a < c andalso b < c then [a:real,b:real,c:real]
    else if a < b andalso a < c andalso c < b then [a:real,c:real,b:real]
    else if b < a andalso b < c andalso a < c then [b:real,a:real,c:real]
    else if b < a andalso b < c andalso c < a then [b:real,c:real,a:real]
    else if c < a andalso c < b andalso b < a then [c:real,b:real,a:real]
    else [c:real,a:real,b:real];
sort3(1.0,2.0,3.0);
sort3(2.0,5.0,1.0);
sort3(10.0,0.0,5.0);

(* Excercise 9 *)
fun del3 x = hd(x)::hd(tl(x))::tl(tl(tl(x)));
del3[1,2,3];
del3[1,2,3,4];

(* Excercise 10 *)
fun sqsum 0 = 0 
  | sqsum x = (x * x) + (sqsum (x - 1));
sqsum 5;

(* Excercise 11 *)
fun cycle(x: 'a list, 0) = x
  | cycle(x: 'a list, y:int) = cycle(cycle1(x), y-1);
cycle([1,2,3,4,5,6], 2);

(* Excercise 13 *)
fun maxhelper ([], n) = n
  | maxhelper (x::k, n) =
    if x > n then maxhelper (k, x)
      else maxhelper (k, n);
fun max x = maxhelper (tl x, hd x);
max [1,2,3,4,5];

(* Excercise 14 *)
fun isPrimeHelper (n, i) = 
  if i = n then true
    else if n = 1 then false
    else not(n mod i = 0) andalso isPrimeHelper (n, i+1);
fun isPrime x = isPrimeHelper (x, 2);
isPrime 1;
isPrime 2;
isPrime 5;
isPrime 15;

(* Excercise 15 *)
fun select_helper(x:'a list, f: 'a -> bool, i: int) = 
  if i < length x then
    if f (hd x) then
      select_helper(cycle1(x), f, i + 1)
    else select_helper(tl x, f, i)
    else x;

fun select (x:'a list, f: ('a -> bool)) = 
  select_helper(x, f, 0);

select ([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17], isPrime);


(* Chapter 6 *)

(* Excercise 1 *)
  (*part a
    * The size would be |X| + |Y|
  *)

  (*part b
    * The size would be |X| * |Y|
  *)

  (*part c
    * The size would be |X|
  *)

  (*part d
    * The size would be |X|
  *)

(* Excercise 2 *)
  (*part a
    * The type would be: bool
  *)

  (*part b
    * The type would be: bool -> bool
  *)

  (*part c
    * The type would be: bool * bool
  *)

(* Excercise 4 *)
  (*part a
    * X := Y
    * Y is a subset of X, so it is safe.
  *)

  (*part b
    * X := X
    * it is safe since X is still in X.
  *)

  (*part c
    * Y := Y + 1
    * Y + 1 does not stay within Y, so it is not safe.
  *)

  (*part d
    * Z := X
    * X is a subset of Z, so it is safe.
  *)

  (*part e
    * X := Z
    * Z is not a subset since X only takes integers that are divisble by 3, therefore it is not safe.
  *)

  (*part f
    * X := X + 3
    * It is safe since X + 3 is still in X.
  *)

  (*part g
    * X := X + Y
    * X + Y is a subset of X, so it is safe.
  *)