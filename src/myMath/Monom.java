
package myMath;

import java.util.Comparator;
import java.util.StringTokenizer;

import javax.management.RuntimeErrorException;

import org.w3c.dom.ranges.RangeException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;

	public static final Comparator<Monom> _Comp = new Monom_Comperator();

	private double _coefficient; 
	private int _power;

	public static Comparator<Monom> getComp() {return _Comp;}

	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}

	// ***************** add your code below **********************

	/**
	 * receive a String and check if it is a valid Monom String: 
	 * Valid monom is - ax^b : a=Double type , b=+Intager type;
	 * the function examine the String into 3 main checks:
	 * 1) check if the coefficient is a valid double type using the method "isValidDouble".
	 * 		(by extract the substring from char 0 to 'x' or to the String length if 'x' is not existing.
	 * 2) check if the Monom have a degree power that greater then 1 
	 * 		(which means that after the coefficient should appear "x^").   
	 * 3)  check if the power is a valid Int type by using "isValidInt" method.
	 * 	  	(by extracts the substring from the char '^' to the String.length).
	 * 
	 * Valid Input:
	 * valid input is a String containing only a valid Double type coefficient and a valid Int power.
	 * meaning that the following cases will be cause to a RuntimeExeption:
	 * 
	 * case 1: any mathematical operations such as: "(2+3.5)x^2*2";
	 * case 2: any typing error containing a none integer type rather then "x^" : "12fx^2e";
	 * case 3: any mathematical expression for representing a rational numbers: "ex^2" , "pei*x";
	 * 
	 * @param s - String containing a Monom type; 
	 */

	public Monom(String s) {

		if(s == "") { // an empty string case.
			throw new RuntimeErrorException(null, "Empty string");
		}

		int i =0; 						// i=char index
		String coefficient_str = ""; 	// catch the coefficient subString
		double coefficient_temp =0;  	// temp that will contain the coefficient.
		String power_str = "";			// catch the power subString	
		int power_temp =0;				// temp that will contain the power.

		// create coefficient substring.
		while(i < s.length() && s.charAt(i) != 'x' ) { 
			coefficient_str += s.charAt(i++);
		}

	///--- 	check if the coefficient is valid ---\\\
		
		//case of '-x'.	
		if(coefficient_str.length()==1 && coefficient_str.charAt(0)== '-') { 
			coefficient_temp=-1;
		}
		//case of empty coefficient.
		else if(coefficient_str == "") {
			coefficient_temp=1;
		}
		//case of valid coefficient.
		else if(isValidDouble(coefficient_str)) {
			coefficient_temp = Double.parseDouble(coefficient_str);
		}
		//case of not valid coefficient.
		else {
			throw new RuntimeErrorException(null, "not valid string");
		}
		//case of only a number. 
		if(i == s.length()) {_coefficient = coefficient_temp; return;}
		
		//case of power eq to 1. ex: "2x".
		else if(i== s.length()-1 && s.charAt(i)== 'x') {
			_coefficient = coefficient_temp;
			_power = 1;
			return;
		}

	///--- 	check if the power is valid ---\\\
		
		//case of unvalid char power after x 
		if(s.charAt(i+1) != '^') {
			throw new RuntimeErrorException(null, "not valid monom");
		}

		i = i+2; // passing ^.
		while(i < s.length()) { //create power substring.
			power_str += s.charAt(i++);
		}
		//case of empty power ^"empty" .
		if(power_str == "") {
			throw new RuntimeErrorException(null, "not valid monom_power");
		}
		//case valid power.
		else if(isValidInt(power_str)) { 
			power_temp = Integer.parseInt(power_str);
		}
		//case of not valid power.
		else {
			throw new RuntimeErrorException(null, "not valid monom_power");
		}
		//imply the temps values after validations.
		_coefficient = coefficient_temp;
		_power = power_temp;

	}
	
/**
 * Receive the coefficient substring and by
 * Double.parse returns wither the substring is valid Double type.
 *  
 * @param s Substring contains coefficient.
 * @return true-if double,Exception otherwise.
 */
	private boolean isValidDouble(String s) {
		
		
		try {
			//Double parse edge cases check.
			if(s.contains("d")|| s.contains("f")) {
				throw new RuntimeErrorException(null, s+" "+"not valid double");
			}
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e) {
			throw new RuntimeErrorException(null, s+" "+"not valid double");
		}
		}

	/**
	 * Receive the power substring and by
	 * Integer.parse returns wither the substring is valid positive Int type.
	 *  
	 * @param s Substring contains coefficient.
	 * @return true-if Int,Exception otherwise.
	 */
	private boolean isValidInt(String s) {

		try { 
			if(Integer.parseInt(s)>0)
				return true;
			else 
				throw new RuntimeErrorException(null,s+ " "+ "not valid int");
		}
		catch (Exception e) {
			throw new RuntimeErrorException(null,s+ " "+ "not valid int");
		}
	}
/**
 * recive a monom and check by comparator wither the powers are equal. 
 * if so add the coefficients. 
 * otherwise throw Exception.
 * @param m The monom wish to add.
 */
	public void add(Monom m) {
		Monom_Comperator q = new Monom_Comperator();
		if(q.compare(m, new Monom(_coefficient,_power))==0) {
			this._coefficient += m._coefficient;
		}
		else {
			throw new RuntimeErrorException(null, "Different Powers- cant add");
		}
	}
	/**
	 * recive a monom and multiplies.
	 * @param d monom.
	 */
	public void multipy(Monom d) {	
		this._coefficient = this._coefficient*d._coefficient;
		this.set_power(this._power+d._power);
	}
	
	public void multipy(int num) {
		
		Monom m1 = new Monom(num,0);
		this.multipy(m1);
	
	}
	
/**
 * to string method returns the String of the given monom.
 */
	public String toString() {
		String ans = "";

		if(this._coefficient != 0 ) {
			if(this._coefficient != 1)
				ans += _coefficient;
		}
		else
			return "0";

		if(this._power == 1) {
			ans+="x";
		}
		else if(this._power > 1) {
			ans+="x^"+_power;
		}

		return ans;
	}
/**
 * recive a monom and check wither they are logically equals in deviation of epsilon.
 * @param m monom to be compare with.
 * @return
 */
	public boolean equals(Monom m) {
		//case of zero coefficient.
		if(m.get_coefficient() == 0 && this._coefficient == 0) { 
			return true;
		}
		//case compare coefficient&&power.
		else if(m.get_coefficient() == this._coefficient && m.get_power() == this._power) {
			return true;
		}
		//case offset -epsilon 
		else if(m.get_coefficient()-EPSILON == this._coefficient && m.get_power() == this._power) {
			return true;
		}
		//case offset +epsilon 
		else if(m.get_coefficient()+EPSILON == this._coefficient && m.get_power() == this._power) {
			return true;
		}
		return false;
	}
	
	//****************** Private Methods and Data *****************


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	
	

}
