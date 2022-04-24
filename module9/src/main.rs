/*
    Kassandra Madsen
    CS 4450 Section 001
    Module 9 HW
 */
// /* Part A */
// fn squarelist(v: &Vec<i32>) -> Vec<i32>
// {
//    v.iter().map(|&x| x * x).collect()
// }

// fn sqsum(v: &Vec<i32>) -> i32
// {
//     v.iter().fold(0, |acc, x| acc + x * x)
// }

// fn compose_n<'a, T>(funs: &'a [fn(T) -> T]) -> impl Fn(T) -> T + 'a
// {
//     funs.iter().fold(Box::new(|x : T| x) as Box<dyn Fn(T) -> T>,
//         |f : Box<dyn Fn(T) -> T>, n : &fn(T) -> T| Box::new(move |x| f(n(x))) as Box<dyn Fn(T) -> T>)
// }

// fn main() {
//     let v = vec![1,2,3,4];
//     println!("{:?}", squarelist(&v));
//     println!("{:?}", sqsum(&v));

//     // Test compose_n
//     fn add1(n: i32) -> i32 {
//         n+1
//     }
//     fn square(n: i32) -> i32 {
//         n*n
//     }
//     fn div2(n: i32) -> i32 {
//         n / 2
//     }

//     // Use an array
//     let a: [fn(i32) -> i32; 3] = [add1, square, div2];
//     let f = compose_n(&a);
//     println!("{}", f(10)); // 26
//     let a: [fn(i32) -> i32; 0] = [];
//     let f = compose_n(&a);
//     println!("{}", f(10)); //10

//     // Use strings
//     fn add_s(s: String) -> String {
//         format!("{}s", s)
//     }
//     fn add_tick(s: String) -> String {
//         format!("{}'", s)
//     }

//     // Use a vector
//     let v: Vec<fn (String) -> String> = vec![add_s, add_tick];
//     let f = compose_n(&v);
//     println!("{}", f("John".to_string())); // John's
//     let v: Vec<fn (String) -> String> = vec![];
//     let f = compose_n(&v);
//     println!("{}", f("John".to_string())); // John
// }

// /* Output:
// [1, 4, 9, 16]
// 30
// 26
// 10
// John's
// John
// */

// /* Part B */
// use std::f64::EPSILON;
// #[derive(Debug)]
// struct Sqrt
// {
//     number : f64,
//     guess : f64
// }

// impl Sqrt
// {
//     fn new(number: f64, guess: f64) -> Sqrt
//     {
//         Sqrt { number, guess }
//     }
// }

// impl Iterator for Sqrt
// {
//     type Item = f64;

//     fn next(&mut self) -> Option<Self::Item>
//     {
//         let x0 = self.guess;
//         let x1 = (x0 + self.number / x0) / 2.0;

//         if (x1 - x0).abs() > EPSILON * x0.abs()
//         {
//             self.guess = x1;
//         }

//         Some(x0)
//     }
// }

// fn iterate(iter: &mut impl Iterator<Item = f64>) -> f64
// {
//     let mut last: f64 = iter.next().unwrap();
//     let mut curr: f64 = iter.next().unwrap();

//     while curr != last
//     {
//         last = curr;
//         curr = iter.next().unwrap();
//     }
//     last
// }

// fn main() {
//     let mut iter = Sqrt::new(2.0, 1.0);
//     for _ in 0..5 {
//         println!("{}", iter.next().unwrap());
//     }
//     println!("");
//     println!("{}", iterate(&mut iter)); // 1.414213562373095
//     println!("{:?}", iter);
// }

// /* Output: 
// 1 
// 1.5 
// 1.4166666666666665 
 
// 1.414213562373095 
// Sqrt { number: 2.0, guess: 1.414213562373095 } 
// */ 

/* Part C */
use std::collections::HashMap;
fn slens(stuff: &Vec<String>) -> HashMap<String, usize> {
    let mut var = HashMap::new(); // creating the hashmap

    // iterate through values in loop to find the length
    for val in stuff {
        var.insert(String::from(val), val.len());
    }
    return var;
}

fn main() {
    let stuff = vec![
        String::from("A"),
        String::from("fine"),
        String::from("mess"),
    ];
    println!("{:?}", slens(&stuff));
    println!("{:?}", stuff);
}

/* Output: 
{"fine": 4, "mess": 4, "A": 1} 
["A", "fine", "mess"] 
*/ 