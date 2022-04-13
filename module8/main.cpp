// Kassandra Madsen
// Module 8 HW
// using multimeth.cpp file from module 8 slides
#include <iostream>
using namespace std;

/* Possible combinations (in ascending "most derived" order); existing methods marked*: (reversed from original)
    Y V A *
    Y V B
    Y V C
    Y W A
    Y W B *
    Y W C
    Y X A
    Y X B
    Y X C *
    
    Z V A *
    Z V B
    Z V C *
    Z W A
    Z W B
    Z W C
    Z X A *
    Z X B *
    Z X C
*/

class A { public: virtual ~A(){} };
class B : public A {};
class C : public B {};
class V { public: virtual ~V(){} };
class W : public V {};
class X : public W {};
class Y { public: virtual ~Y(){} };
class Z : public Y {};

/* this is where I rework the problem
    to the order of the parameters in the function f is reversed 
    (i.e., the Y argument comes first, then the V argument, then the A argument)
*/
string dispatch(const Y& y, const V& v, const A& a) {
    const Z* pz = dynamic_cast<const Z*>(&y);
    const X* px = dynamic_cast<const X*>(&v);
    const W* pw = dynamic_cast<const W*>(&v);
    const C* pc = dynamic_cast<const C*>(&a);
    const B* pb = dynamic_cast<const B*>(&a);

    if (pz)
    {
        if (px)
        {
            if (pb)
                return "(Z X B)";
            return "(Z X A)";
        }
        if (pc)
            return "(Z V C)";
        return "(Z V A)";
    }

    if (px && pc)
        return "(Y X C)";
    if (pw && pb)
        return "(Y W B)";
    return "(Y V A)";
}

void f(const Y& y, const V& v, const A& a) {
    cout << dispatch(y,v,a) << "\n";
}

int main() {
    A a;
    B b;
    C c;
    V v;
    W w;
    X x;
    Y y;
    Z z;
    
    f(y,v,a);
    f(y,v,b);
    f(y,v,c);
    f(y,w,a);
    f(y,w,b);
    f(y,w,c);
    f(y,x,a);
    f(y,x,b);
    f(y,x,c);
    f(z,v,a);
    f(z,v,b);
    f(z,v,c);
    f(z,w,a);
    f(z,w,b);
    f(z,w,c);
    f(z,x,a);
    f(z,x,b);
    f(z,x,c);
}