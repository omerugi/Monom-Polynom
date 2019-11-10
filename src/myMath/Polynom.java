package myMath;
import java.util.*;
import java.util.function.Predicate;

import myMath.Monom;
/**
 											**Class Explanation**
* ---------------------------------------------------------------------------------------------------------------------
* This class represents a Polynom OBJ- implemented by String of Monom objects .											|
* class implements the following methods: 																				|
* 																														|
* Polynom class works as following: 																					|
* *Receiving a String containing "Polynom". 																			|
* *Breaks down the String into separate Monoms- and add separately to a ArrayList that will contain the Polynom.	
*----------------------------------------------------------------------------------------------------------------------																														|
* 											**Methods implemented**
* ---------------------------------------------------------------------------------------------------------------------
* 1) 	Polynom(String)				-Constructor.	 																		|
* 2)	f					-Place x in the polynom.																|
* 3)	add(Polynom_able)	 		-Adding two Polynom_able objects into one.												|
* 4)	add(Monom)				-Adding Monom into the Polynom.															|
* 5)	substruct(Polnom_able) 	-Substruction of two Polnoms.															|
* 6)	multiply()				-Multiplying two Polynoms.																|
* 7)	equals()				-Check if two Polynoms are equal- by deviation of Epsilon.								|
* 8)	isZero					-Check if Polynom is equal to zero.														|
* 9)	root					-Calculate the point which the Polynom==zero between x0,x1 with deviation of Epsilon.	
* 10)	Copy					-Crates deep copy of Polynom.															|
* 11)	Derivative				-Derivative the Polynom.																|
* 12)	area					-Calculates the area size between the function to positive x axis.						|
* 13)	multiply				-Multiply Polynom by Monom. 															|
* 14) 	Iterator				-Returns Iterator from Class Iterator.													|
* 15) 	toString				-Returns a String of the Polynom.														|
* ---------------------------------------------------------------------------------------------------------------------
* 
*
*/
public class Polynom implements Polynom_able{

	double poly =0;
	private static final double EPSILON = 0.0000001;
	private ArrayList<Monom> polylist = new ArrayList<Monom>();

	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {

	}

	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {

		String temp = "";

		for (int i = 0; i < s.length(); i++) {

			if(s.charAt(i) == '+') {
				try {
					Monom m1 = new Monom(temp);
					this.add(m1);
					temp ="";
				}catch (Exception e) {
					throw new RuntimeException("Not valid poly");
				}
			}
			else if(s.charAt(i) == '-' && temp!="") {
				Monom m1 = new Monom(temp);
				this.add(m1);
				temp ="-";
			}

			else
				temp += s.charAt(i);
		}

		Monom m1 = new Monom(temp);
		this.add(m1);
		Comparator<Monom> monom_comp = new Monom_Comperator();
		polylist.sort(monom_comp);

	}

	@Override
	public double f(double x) {

		double ans = 0;

		for (int i = 0; i < polylist.size(); i++) {
			ans +=  polylist.get(i).f(x);
		}
		return ans;
	}

	@Override
	public void add(Polynom_able p1) {

		Iterator<Monom> new_monom = p1.iteretor() ;
		Monom monom1;

		while(new_monom.hasNext())
		{
			monom1=new_monom.next();
			this.add(monom1);
		}

	}

	@Override
	public void add(Monom m1) {

		if(m1.get_coefficient() == 0) {
			return;
		}

		int i;
		for (i = 0; i < polylist.size(); i++) {

			if(polylist.get(i).get_power() == m1 .get_power()) {
				polylist.get(i).add(m1);
				if(polylist.get(i).get_coefficient() == 0) {
					polylist.remove(i);
				}
				else if(polylist.get(i).get_coefficient()>0) {
					if(polylist.get(i).get_coefficient()<0+EPSILON) {
						polylist.remove(i);
					}
				}
				else if(polylist.get(i).get_coefficient()<0) {
					if(polylist.get(i).get_coefficient()>0-EPSILON) {

						polylist.remove(i);
					}
				}
				Comparator<Monom> monom_comp = new Monom_Comperator();
				polylist.sort(monom_comp);
				return;
			}	
		}

		if(i == polylist.size()) {
			polylist.add(m1);
		}

		Comparator<Monom> monom_comp = new Monom_Comperator();
		polylist.sort(monom_comp);

	}


	@Override
	public void substract(Polynom_able p1) {

		Iterator<Monom> new_monom = p1.iteretor() ;

		if(this==p1) {
			polylist = new ArrayList<Monom>();
		}
		while(new_monom.hasNext())
		{
			Monom monom0 = new Monom(new_monom.next());
			Monom monom1=new Monom(monom0.get_coefficient()*-1,monom0.get_power());
			this.add(monom1);
		}
	}

	@Override
	public void multiply(Polynom_able p1) {


		Polynom temp_poly = new Polynom();

		for (int i = 0; i < polylist.size(); i++) {

			for (Iterator<Monom> m1 = p1.iteretor(); m1.hasNext();) {
				Monom m2 = new Monom(m1.next());
				Monom m3 = new Monom(polylist.get(i));
				m3.multipy(m2);
				temp_poly.add(m3);
			}

		}

		polylist = temp_poly.polylist;

	}
	// maybe substruction?
	@Override
	public boolean equals(Polynom_able p1) {
		
		for(Iterator<Monom> m1 = p1.iteretor(); m1.hasNext();) {
			Monom temp = new Monom(m1.next());
			if(!polylist.contains(temp)) {return false;}
		}
		return true;
	}

	@Override
	public boolean isZero() {

		if(polylist.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public double root(double x0, double x1, double eps) {

		if (this.f(x0)*this.f(x1)>0) {
			System.out.println("Doesnt have root.");
			return Double.NEGATIVE_INFINITY; 
		}


		boolean flag = true;
		double mid = (x0+x1)/2;
		while(flag) {
			mid = (x0+x1)/2;
			if (this.f(mid)<0) {
				if (this.f(mid)>=0-eps) {
					return mid;
				}
				else if(this.f(mid)*this.f(x0)<=0) {
					x1 =mid;
				}
				else if(this.f(mid)*this.f(x1)<=0) {
					x0 = mid;
				}
			}
			else if (this.f(mid)>0) {
				if (this.f(mid)<=0-eps) {
					return mid; 
				}
				else if(this.f(mid)*this.f(x0)<=0) {
					x1 =mid;
				}
				else if(this.f(mid)*this.f(x1)<=0) {
					x0 = mid;
				}
			}
			
		}

		return 0;
	}

	@Override
	public Polynom_able copy() {
		Polynom_able new_poly = new Polynom();
		Iterator<Monom> m1 = this.iteretor();

		while(m1.hasNext()) {
			Monom temp = new Monom(m1.next());
			new_poly.add(temp);
		}

		return new_poly;
	}

	@Override
	public Polynom_able derivative() {

		Polynom_able deriv_poly = new Polynom();
		Iterator<Monom> m1 = this.iteretor();


		while(m1.hasNext()) {
			Monom temp = new Monom(m1.next());
			temp = temp.derivative();
			deriv_poly.add(temp);
		}
		return deriv_poly;

	}

	@Override
	public double area(double x0, double x1, double eps) {

		double positive_area =0;
		
		for(double i = x0; i<=x1; i+=eps) {
			if(this.f(i) > 0) {
				positive_area+= this.f(i)*eps;
			}
		}

		return positive_area;
	}

	@Override
	public void multiply(Monom m1) {

		for (int i = 0; i < polylist.size(); i++) {

			Monom temp = new Monom(polylist.get(i));
			temp.multipy(m1);
			polylist.set(i, temp);
		}

	}

	@Override
	public Iterator<Monom> iteretor() {

		return new PolyIterator() ;
	}

	public String toString() {

		String poly ="";
		Iterator<Monom> m1 = this.iteretor();

		for (int i = 0; i < polylist.size() && m1.hasNext(); i++) {
			Monom m2 = new Monom(m1.next());
			if(i == 0) {
				poly += m2.toString();
			}
			else {
				if(m2.get_coefficient()>0) {
					if(m2.get_coefficient()==1) {
						poly += "+"+"x";
						if(m2.get_power() != 0 && m2.get_power() != 1) {
							poly +="^"+m2.get_power();
						}
					}
					else
						poly += "+"+m2.toString();
				}
				else
					poly += m2.toString();
			}
		}

		if(poly == "") {
			return "";
		}
		return poly;
	}

	private class PolyIterator<Monom> implements Iterator<Monom>{

		private int index;

		public PolyIterator() {
			index =0;
		}

		public boolean hasNext() {

			return index < polylist.size();
		}


		@SuppressWarnings("unchecked")
		@Override
		public Monom next() {

			return (Monom) polylist.get(index++);
		}

	}



}
