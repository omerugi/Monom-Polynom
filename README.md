# OOP - Project Ex0: Monom & Plynom.
## The project was to build a class's of monom and polynom using given interfaces.

### Monom:
This class represents a valid Monom OBJ.
Valid monom: ax^b - were a is a double and b is a non negative integer.

----------------------------------------------------------------------------------------------------------------------																														
**Methods implemented**       

***Required methods:***

1. ``public Monom(String s)``

receive a String and check if it is a valid Monom String: 
Valid monom is - ax^b : a=Double type , b=+Intager type;
the function examine the String into 3 main checks:
1) check if the coefficient is a valid double type using the method "isValidDouble".
		(by extract the substring from char 0 to 'x' or to the String length if 'x' is not existing.
2) check if the Monom have a degree power that greater then 1 
		(which means that after the coefficient should appear "x^").   
3)  check if the power is a valid Int type by using "isValidInt" method.
	  	(by extracts the substring from the char '^' to the String.length).

Valid Input:
valid input is a String containing only a valid Double type coefficient and a valid Int power.
meaning that the following cases will be cause to a RuntimeExeption:

case 1: any mathematical operations such as: "(2+3.5)x^2*2".
case 2: any typing error containing a none integer type rather then "x^" : "12fx^2e".
case 3: any mathematical expression for representing a rational numbers: "ex^2" , "pei*x".

@param s - String containing a Monom type; 

2. ``public void add(Monom m)``

recive a monom and check by comparator wither the powers are equal.
If so add the coefficients. 
Otherwise throw Exception.
@param m The monom wish to add.

3. ``public void multipy(Monom d)``

 recive a monom and multiplies.
 
 @param d monom.
 
 4. ``public String toString()``
 
 to string method returns the String of the given monom.
 
 5. ``public boolean equals(Monom m)``

recive a monom and check wither they are logically equals in deviation of epsilon.

@param m monom to be compare with.

@return



***Self added methods:***
1. ``private boolean isValidDouble(String s)``

Receive the coefficient substring and by Double.parse returns wither the substring is valid Double type.

@param s Substring contains coefficient.

@return true-if double,Exception otherwise.

2. ``private boolean isValidInt(String s)``

Receive the power substring and by Integer.parse returns wither the substring is valid positive Int type.
 
@param s Substring contains coefficient.

@return true-if Int,Exception otherwise.

 
---------------------------------------------------------------------------------------------------------------------
* @author omerugi


