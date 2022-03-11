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