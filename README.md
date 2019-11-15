# OOP - Project Ex0: Monom & Polynom.
Editors: Dor Getter & Omeri Rugi

Ariel university -Object-Oriented Programming course task 1. 


## About the project: 

This project is built to create and use Polynoms and Monom's mathematical expressions using given interfaces.
The program allows building Monoms And Polynoms objects, either with a String or by creating a new object which stands the characteristics of a valid polynomial expression.
The user of this project can add, subtract, multiply and derivate Monoms and Polynomials expressions.
Also, the user can find the root of a Polynomial expression in a close interval and sum the blocked area between the polynomial function and the positive x-axis using Riemann's Integral.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Monom Class #

#Class info: # 
This class represents a Monom mathematical expression.
Valid Monom OBJ  is in the form of ax^b.  
in which:  
+    a- Double type coefficient.                                                    
+    b-  Integer type power.                                                        

Monom class works as follows: 
*    1. Receiving a String containing mathematical expression according to Monom ax^b structure. 
*    2. Creating a Monom obj. using direct constructor inputs the coefficient and the power. 
    
*    the class validates that the inputs are forming a valid Monom, and supports the follows Methods
----------------------------------------------------------------------------------------------------------------------                                                                                                                        
**Methods implemented**      

----------------------------------------------------------------------------------------------------------------------

***Required methods:***

1. ``public Monom(String s)``
@param s - String containing a Monom type;
receive a String and check if it is a valid Monom String: 
Valid monom is - ax^b : a=Double type , b=+Intager type;
the function examines the String into 3 main checks:
1) check if the coefficient is a valid double type using the method "isValidDouble".
        (by extracting the substring from char 0 to 'x'  the String length if 'x' is not existing).
2) check if the Monom have a degree power that greater then 1 
        (which means that after the coefficient should appear "x^").   
3)  check if the power is a valid Int type by using "isValidInt" method.
          (by extracts the substring from the char '^' to the String.length).

Valid Input:
valid input is a String containing only a valid Double type coefficient and a valid Int power.
meaning that the following cases will be caused to a RuntimeExeption:

+    case 1: any mathematical operations such as: "(2+3.5)x^2*2".
+    case 2: any typing error containing a none integer type rather then "x^" : "12fx^2e".
+    case 3: any mathematical expression for representing a rational number: "ex^2" , "pei*x".

 

2. ``public void add(Monom m)``

receive a Monom and check by comparator wither the powers are equal.
If so add the coefficients. 
Otherwise, throw Exception.
@param m The Monom wish to add.

3. ``public void multiply(Monom d)``

 receive a Monom and multiplies.
 
 @param d Monom.
 
 4. ``public String toString()``
 
 to string, the method returns the String of the given Monom.
 
 5. ``public boolean equals(Monom m)``

receive a Monom and check to wither they are logical equals in deviation of epsilon.

@param m Monom to be compared with.

@return 

----------------------------------------------------------------------------------------------------------------------

***Self added methods:***
1. ``private boolean isValidDouble(String s)``

Receive the coefficient substring and by Double.parse returns wither the substring is valid Double type.

@param s Substring contains coefficient.

@return true-if double, Exception otherwise.

2. ``private boolean isValidInt(String s)``

Receive the power substring and by Integer.parse returns wither the substring is valid positive Int type.
 
@param s Substring contains coefficient.

@return true-if Int, Exception otherwise.

 
---------------------------------------------------------------------------------------------------------------------
# Polynom Class: #
#Class info: # 
This class represents a Polynom OBJ- implemented by String of Monom objects.                                
                                                            
Polynom class works as follows: 

+    Receiving a String containing "Polynom" / Monom OBJ.
+    case 1: Breaks down the String into separate Monoms- and add separately to an ArrayList that will contain the Polynom.
+    case 2: received a Monom OBJ. and adds it to a Polynom ArrayList.

----------------------------------------------------------------------------------------------------------------------                                                                                                                        
**Methods implemented**      

----------------------------------------------------------------------------------------------------------------------

***Required methods:***

1. ``public void add(Polynom_able p1)``

The function receives a Polynom_able (type) p1 and adding it into the Polynom object, "this", in the class.

Way of action:

Using an Iterator of type Monom, go over all the Monoms in the Polynom p1 by using a while loop.

Add each element in p1 to, "this", Polynom in the class.

@param p1 - Polynom to be added.                 

2.``public void add(Monom m1)``

The function receives a Monom and adds it to a Polynom by the following cases: 

* case 1: if the Monom's power is equal to a Monom in the Polynom-    sums the Monoms Coefficient.
* case 2: if the Monom's power is not equal to any of the Monom's in the Polynom-    add the Monom to Polynom List.        
 
Way of action:

Using a for loop goes over the Polynom.

in any Monom in the Polynom check if its a case 1 or case 2.   
if there is a Monom that its power is the same as m1 sum the coefficients and check: 
+    If the coefficient after adding is close to zero by Epsilon: remove the Monom from Polynom.
+    If the coefficient after adding is a number greater then 0+/-(Epsilon) add the Coefficients.            
    If there is none such Monoms with the same power as m1 in Polynom. 
+     Add the Monom as it is to the Polynom equation.
+    Sort the Polynom for convenient.

@param m1 - Monom to be added to the Polynom. 

3.``public void substract(Polynom_able p1)``

The function receives a Polynom and subtracts it from "this" Polynom Obj. in the class.   

Way of action:

+    Construct a new Iterator on p1. 
+    If p1 is the same as the Polynom Obj. (same pointer). the Polynom is initialized. 
+    Using a while loop- change the coefficients of every Monom in p1 to the opposite sign. (negative <--> Positive.)
+    Using add Monom method adding each Monom of p1 to the Polynom Obj.   

@param p1- Polynom for subtraction. 


4.``public void multiply(Monom m1)``

The function multiply Polynom by a Monom.

Way of action:
+    Using a for loop apply multiplication method of Monoms to each Monom in Polynom by m1.  
+    Sets the Polynom list Monom in index i to the Monom after multiplication.
 
 @param m1-     the Monom wish to multiply the Polynom with.         


5.``public void multiply(Polynom_able p1)``

The function receives a Polynom and multiplies it by the Polynom Obj. in the class.

Way of action:

+    Creating a temp Polynom.
+    Using a for loop go over each Monom in Polynom list.
+    Using nested loop multiply each one of the Monoms in Polynom list. by every Monom in p1.
+    Update the Polynom ArrayList pointer.  

 @param p1- Polynom for multiply. 


6.``public boolean equals (Polynom_able p1)``

The function receives a Polynom and checks to wither it equal Polynom Obj. in the class.

Way of action:
+    Using a for loop go over each Monom in the Polynom Obj. in the class.
+    Using a nested loop goes over each Monom in p1.
+    Check if there is a Monom in p1 that equals to Monom in Polynom m1 (Polynom list in the class).      

@param p1- Polynom to check if equal. 

6.``public boolean isZero();``

The function check if the Polynom is empty. 

Way of action:
+    check the length of the Polynom.
+    case 1: size==0 --> true.
+    case 2: size!=0 --> false.                


7.``public Polynom_able copy()``

The function creates a deep copy of the Polynom Obj.

Way of action:
+    Copying each Monom from Polynom Obj list to a new Polynom.  

@return a Deep copy of Polynom.

8.``public Polynom_able derivative()``

The function applies a derivative operation on the Polynom.
            
Way of action:
+    Using Polynom Iterator the function goes over each Monom and applies the derivative method of Monom.
+    Adds the new Monom after derivation to the new Polynom.      
@return The derivation of the Polynom.  


9.``public double root(double x0, double x1, double eps)``

The function in a given 2 x's points returns the x dot in which the function cuts the x-axis.   

Using the Intermediate Value Theorem
If f(x) is continuous on a closed interval [a,b], and c is any number between f(a) and f(b) inclusive
 then there is at least one number x in the closed interval such that f(x)=c.
 and if f(a)*f(b)<0 then there is at least one number x in the close interval such that f(x)=0.

Way of action:
+    Checking if applying x0 and x1 in the Polynom equation and multiply the result of the two, Provides a negative result.
+    Using while loop and "binary search" principal to locate the x in which f(x)=0 +/-(Epsilon).  
+    Every iteration advanced one side of the closed Interval according to the result of applying the midpoint.
+    When the result of applying the mid is close by Epsilon or less to 0. return that mid.      

param x0-     left  x dot. 

param x1-     right x dot.

param eps-     Epsilon step desired.

return X the point in which the function cuts the x-axis with an offset of a given eps. 

10.``public double area(double x0, double x1, double eps)``

Calculates the area in the close interval that blocks between the function and the Positive side of the x-axis using Riemann Sums role. 
            
Way of action:
+    From x0 to x1 moving in Epsilon steps.
+    sum the area if the f(x)>0 (Positive area).

@param eps     Epsilon step chosen by the user.

@param x1 Left-hand side of the interval.

@param x0 Right-hand side of the interval.

@return         The area between the function and the x-axis on given close Interval.         

11.``public Iterator<Monom> iteretor()``

+    This function will use a sub-class.

@return new PolyIterator. 

12.``public String toString()``

The function returns a string of the Polynom.
             
Way of action:
+    Using Polynom Iterator the function goes over each Monom and Uses the Monom toString Method.
+    Joint the Monoms by examining the sign of the next Monom coefficient. 
 
 @return String of the Polynom.         

13.``public double f(double x)``

 The function applies double type x on the Polynom and calculates the result.
 
 Ex. f(x)=2x^2+2x+2 , inputs: =2; , OutCome: 14.
   
Way of action:
+    Using a for loop - go over all the Monoms in the polynom.
+    Applying the x input into the equation.                                  
+    Adds the result in ans. 
+    Return ans.
 
@param x - Value of x.

@author Omer Rugi && Dor Getter


