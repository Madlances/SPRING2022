fn compose(x: i32, f: fn(i32)->i32, g: fn(i32)->i32) {
    f(g(x))
}

fn main() {
    fn f(n: i32) -> i32 {
        n + 42
    }

    fn g(n: i32) -> i32 {
        n * 2
    }

    println!("{}", compose(5, f, g));
}
