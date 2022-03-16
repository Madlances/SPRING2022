(* Kassandra Madsen *)
(* Module 5 HW *)

(* Chapter 11: 3, 4, 5, 9, 10 *)

(* Excercise 3 *)
(* Using slide 12 from module 5 lecture slides *)
datatype number = x of int | value of real;

(* Excercise 4 *)
(* Using pre-defined Real function that was mention on slide 9 from module 5 lecture slides *)
fun plus (x k) (x y) = x(k + y)
  | plus (value k) (value y) = value(k + y)
  | plus (x k) (value y) = value(Real.fromInt(k) + y)
  | plus (value k) (x y) = value(k + Real.fromInt(y));

plus (x 1) (x 2);
plus (value 1.0) (value 2.0);
plus (x 1) (value 2.0);
plus (value 1.0) (x 2);

(* Excercise 5 *)
datatype intnest = INT of int | LIST of intnest list;

(* Using slide 38 from module 5 lecture slides, noticed that if you put NIL at the beginning then it will ignore everything after
   so we have to put it at the end *)
fun addup (LIST((INT k)::ks)) = k + addup(LIST(ks))
  | addup (LIST(NIL)) = 0;

addup (LIST[INT 1, INT 2, INT 3]);
addup (LIST[]);

(* Excercise 9 *)
datatype 'data tree = Empty | Node of 'data tree * 'data * 'data tree;

(* Using slide 50 from module 5 lecture slides
   Also using the following output from the homework description:
   - val tree = Node(Node(Empty,[1,2],Empty),[3,4],Node(Empty,[5,6],Empty));
   val tree = Node (Node (Empty,[#,#],Empty),[3,4],Node (Empty,[#,#],Empty)): int list tree
   - appendall tree;
   val it = [1,2,3,4,5,6] : int list

   We notice that empty is at the beginning and ending so we will need to account for that
   in our code as well *)
fun appendall (Node(Empty, root, right)) = root
  | appendall (Node(left, root, Empty)) = root
  | appendall (Node(left, root, right)) = appendall(left) @ root @ appendall(right);

val tree = Node(Node(Empty,[1,2],Empty),[3,4],Node(Empty,[5,6],Empty));
appendall tree;

(* Excercise 10 *)
(* Use same idea as in Excercise 9 
   And the ouput given to us in the homework description:
   - val tree1 = Node(Node(Empty,1,Empty),2,Node(Empty,3,Empty));
  val tree1 = Node (Node (Empty,1,Empty),2,Node (Empty,3,Empty)) : int tree
  - val tree2 = Node(Node(Empty,1,Empty),2,Empty);
  val tree2 = Node (Node (Empty,1,Empty),2,Empty) : int tree
  - isComplete tree1;
  val it = true : bool
  - isComplete tree2;
  val it = false : bool
  - isComplete Empty;   (* An Empty tree is vacuously complete *)
  val it = true : bool
  *)
fun isComplete (Empty) = true
  | isComplete (Node(Empty, root, Empty)) = true
  | isComplete (Node(Empty, root, right)) = false
  | isComplete (Node(left, root, Empty)) = false
  | isComplete (Node(left, root, right)) = true;

val tree1 = Node(Node(Empty,1,Empty),2,Node(Empty,3,Empty));
val tree2 = Node(Node(Empty,1,Empty),2,Empty);
isComplete tree1;
isComplete tree2;
isComplete Empty;

(* Extra Problems *)
(* A - Using directory.sml and slides 63-64 from module 5 lecture slides *)
datatype entry = File of string | Folder of string * entry list
val files = Folder("d1",
	[File "f1",
	Folder("d2",
		[File "f2",
		Folder("d3",
			[File "f3"])]),
	File "f4",
	Folder("d3",
		[File "f5"])]);

fun print_entries (File fname) = print(fname ^ "\n")
  | print_entries (Folder(dname, cnts)) = (print(dname ^ "\n");print_contents cnts)
and
 print_contents k = foldl(fn (e, sofar) => print_entries e) () k;
(* noticed that foldr did the wrong order that we wanted so
   instead used foldl *)
print_entries files;

(* B - What does the following function do? Explain how it works.

fun f _ [] = []
|   f g (x::xs) = g x :: f (fn y => g (g y)) xs; 
 *)

(* This is definitely a curried function. To explain
How this works I will evaluate the call f (fn x => x+1) [1,1,1,1]. First we know our first parameter is g and the second parameter is of type 'a list. With the return type being 'a list as well. With the call f (fn x => x+1) [1,1,1,1] it is mostly using f (fn y => g (g y)) xs in our function, the last part of it, to determine what to add next and what our element in the list will be. So f (fn x => x+1) [1,1,1,1] = f (fn x => x+1) (1::[1,1,1]) = (fn 1 => 1+1)::f(fn y => g (g y)) [1,1,1] = 1+1 for the first element, for the first call. When it gets called again then f (fn x => (fn y => y+1)) (1::[1,1]) = (fn 1 => (fn 2 => 2+1))::f(fn y => g(g y)) [1,1] for the second call, which then equals 2+1 for the second element in our list. Basically this function takes each previous call or recursive call to create a new function that will be passed into g which when called will make another g ontop of that. So in our example the first call had the first initial g so that ended up being 1+1 = 2 for the first element in the list. In the second call it took that g and stuck it into this call with another g and that's how we got 2+1 = 3 for our second element. In the third call, if we take both previous g's and stick it into this call, then the third element in the list will be 2+3 = 5.
*)