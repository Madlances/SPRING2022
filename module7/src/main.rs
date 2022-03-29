use std::f64::consts::PI;
/** 
 * Kassandra Madsen
 * CS 4450 Section 001
 * Module 7 HW
*/

/**
 * 1. Write a Rust function, compose, that takes 3 arguments: the first parameter is an i32, x, say,
 * the last two are functions, f and g, are of type fn(i32) -> i32. Your compose function should return f(g(x)).
 */
fn compose(x: i32, f: fn(i32)->i32, g: fn(i32)->i32) -> i32 {
    f(g(x))
}

/**
 * 2. Define an enumerated data type named Shape that can be either a Circle, holding a single f64 representing a radius,
 * or a Rectangle, holding two f64’s representing length and width. Then implement a method Shape::area( ) that returns the correct area.
 */

enum Shape {
    Circle(f64),
    Rectangle(f64, f64),
}

use Shape::*;

impl Shape {
    fn area(&self) -> f64 {
        match &self {
            Circle(r) => PI * r * r,
            Rectangle(l, w) => l * w,
        }
    }
}

/**
 * 3. Write a function, f2n, that takes a function parameter function with signature fn(i32) -> i32, a u32, n, and a variable x of type i32.
 * Your function should compute the value of f^n(x), meaning f is composed n times on x (=f(f(…f(x)…)).
 * You did this in ML for Module 5. If n is 0, return x.
 */

fn f2n(f: fn(i32)->i32, n: u32, x: i32)-> i32 {
    if n == 0 {
        x
    } else {
        f2n(f, n-1, f(x))
    }
}

/**
 * 4. Write a function named cycle with signature fn (&Vec<i32>, n: usize) -> Vec<i32> that does a left-circular shift of a vector n positions,
 * similar to the ML function cycle in the Chapter 5 homework.
 * It does not change the incoming vector but returns a new one. Do not use any of Rust's rotate functions.
 */

fn cycle(v: &Vec<i32>, n: usize)-> Vec<i32> {
    let mut new = v[n..].to_vec();
    new.extend(&v[..n]);
    return new;
}

fn main() {
    // This is for problem 1
    fn f(n: i32) -> i32 {
        n + 42
    }

    fn g(n: i32) -> i32 {
        n * 2
    }

    println!("{}", compose(5, f, g)); // 52

    // This is for problem 2
    let c = Circle(3.0);
    println!("Circle area: {}", c.area()); // 28.274333882308138
    let r = Rectangle(6.0, 7.0);
    println!("Rectangle area: {}", r.area()); // 42

    // This is for problem 3
    fn sq(x: i32) -> i32 {
        x * x
    }
    let x = 2;
    println!("{}", f2n(sq, 3, x));

    // This is for problem 4
    let v = vec![1, 2, 3, 4, 5];
    println!("{:?}", cycle(&v, 2));
    println!("{:?}", v);
}