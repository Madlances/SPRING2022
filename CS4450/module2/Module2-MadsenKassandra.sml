(* Kassandra Madsen, Module 2 HW *)

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

(* Excercise 14 *)

(* Excercise 15 *)