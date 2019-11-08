package myMath;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;


/**                    **Monom Tester** 
 * 
 * table of contents: 
 * 
 * 1. Test 1,2 Boaz Naive test Lines.
 * 2. Test 3,4,5,6 methods tests. 
 * 
 *  (iii) Expected output: tests 1,2 
 *  
 * 						 ****  Test1:  *****  <br> -
 *   
0) 2.0    	isZero: false	 f(0) = 2.0  <br>
1) -1.0x    	isZero: false	 f(1) = -1.0  <br>
2) -3.2x^2    	isZero: false	 f(2) = -12.8  <br>
3) 0    	isZero: true	 f(3) = 0.0  <br>

 *****  Test2:  *****  <br>
 *
0) 0    	isZero: true  	eq: true  <br>
1) -1.0    	isZero: false  	eq: true  <br>
2) -1.3x    	isZero: false  	eq: true  <br>
3) -2.2x^2    	isZero: false  	eq: true  <br>

 * 							***test 3 :Monom Constructor***
	this test will check all the following situations: 
	3.1 Unvalid Monoms. 
	3.2 Valid Monoms.

	Expected Output: 	
 ***** Test 3 *****
 *****  3.1  *****
0) X Exception :javax.management.RuntimeErrorException: X not valid double
1) --x Exception :javax.management.RuntimeErrorException: -- not valid double
2) 3fx Exception :javax.management.RuntimeErrorException: 3f not valid double
3) 2+4 Exception :javax.management.RuntimeErrorException: 2+4 not valid double
4) 4x^x Exception :javax.management.RuntimeErrorException: x not valid int
5) 2^2x Exception :javax.management.RuntimeErrorException: 2^2 not valid double
6) 2(x) Exception :javax.management.RuntimeErrorException: 2( not valid double
7) 2x2 Exception :javax.management.RuntimeErrorException: 1not valid monom
8) 3x^3+2 Exception :javax.management.RuntimeErrorException: 3+2 not valid int
9) 4x^(3+2) Exception :javax.management.RuntimeErrorException: (3+2) not valid int
10) 4x^3i Exception :javax.management.RuntimeErrorException: 3i not valid int
11) 4x^3d Exception :javax.management.RuntimeErrorException: 3d not valid int
12) 4x^3f Exception :javax.management.RuntimeErrorException: 3f not valid int
13) x^-3 Exception :javax.management.RuntimeErrorException: -3 not valid int

 *****  3.2  *****
0) Valid:  x
1) Valid:  -1.0x^12
2) Valid:  12.03x^2
3) Valid:  3.0101x^3

 ****	Test 4  ****
 *Test add method:
 * in each sub test (1,2,3,4,5) only the number of the sub test should be ok.
 *  
1): 2.0
	value after adding :5.0
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add

2): x
	javax.management.RuntimeErrorException: Different Powers- cant add
	value after adding :4.0x
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add

3): -1.0x^2
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	value after adding :0
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add

4): 12.03x^4
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	value after adding :-0.9743000000000013x^4
	javax.management.RuntimeErrorException: Different Powers- cant add

5): 3.0101x^3
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	javax.management.RuntimeErrorException: Different Powers- cant add
	value after adding :4.5100999999999996x^3

 *****  test 5  *****
 *Tests multiply method
1): 2.0
	value after multiply :6.0
	value after multiply :6.0x
	value after multiply :2.0x^2
	value after multiply :-26.0086x^4
	value after multiply :3.0x^3

2): x
	value after multiply :3.0x
	value after multiply :3.0x^2
	value after multiply :x^3
	value after multiply :-13.0043x^5
	value after multiply :1.5x^4

3): -1.0x^2
	value after multiply :-3.0x^2
	value after multiply :-3.0x^3
	value after multiply :-1.0x^4
	value after multiply :13.0043x^6
	value after multiply :-1.5x^5

4): 12.03x^4
	value after multiply :36.089999999999996x^4
	value after multiply :36.089999999999996x^5
	value after multiply :12.03x^6
	value after multiply :-156.441729x^8
	value after multiply :18.044999999999998x^7

5): 3.0101x^3
	value after multiply :9.0303x^3
	value after multiply :9.0303x^4
	value after multiply :3.0101x^5
	value after multiply :-39.14424343x^7
	value after multiply :4.51515x^6

*****  test 6  *****
1): 2.0
	is equal :true
	is equal :false
	is equal :false
	is equal :false
	is equal :false

2): x
	is equal :false
	is equal :true
	is equal :false
	is equal :false
	is equal :false

3): -1.0x^2
	is equal :false
	is equal :false
	is equal :true
	is equal :false
	is equal :false

4): 12.03x^4
	is equal :false
	is equal :false
	is equal :false
	is equal :true
	is equal :false

5): 3.0101x^3
	is equal :false
	is equal :false
	is equal :false
	is equal :false
	is equal :true



 *
 */
public class MonomTest {
	public static void main(String[] args) {


		//Monom q = new Monom("2x^4");

		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
	}

	private static void test1() {
		System.out.println("*****  Test1:  *****");
		String[] monoms = {"2", "-x","-3.2x^2","0"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
		}
	}
	private static void test2() {
		System.out.println("*****  Test2:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));

		for(int i=0;i<monoms.size();i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
	}

	private static void test3() {
		System.out.println("***** Test 3 *****");

		System.out.println("*****  3.1  *****");
		String[] monoms = {"X", "--x","3fx","2+4","4x^x","2^2x","2(x)","2x2","3x^3+2",
				"4x^(3+2)", "4x^3i","4x^3d","4x^3f","x^-3"};

		for(int i=0;i<monoms.length;i++) {
			try {
				Monom m = new Monom(monoms[i]);
				String s = m.toString();
				m = new Monom(s);
				double fx = m.f(i);
				System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
			}
			catch (Exception e ) {
				System.out.println(i+") "+ monoms[i]+" Exception :"+e);
			}
		}
		System.out.println();
		System.out.println("*****  3.2  *****");
		String[] monoms1 = {"x","-x^12", "12.03x^2", "3.0101000x^3"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i+") Valid:  "+ m);
		}
	}

	private static void test4() {
		System.out.println("*****  test 4  *****");

		//valid monoms: 
		String[] monoms1 = {"2","x","-x^2", "12.03x^4", "3.0101000x^3"};
		String[] monoms2 = {"3","3x","x^2","-13.0043x^4","1.5x^3"};
		for(int i=0;i<monoms1.length;i++) {

			Monom m = new Monom(monoms1[i]);
			System.out.println(i+1 +"): "+ m);

			for (int j = 0; j < monoms2.length; j++) {
				Monom m1 = new Monom(monoms2[j]);
				try {
					m.add(m1);
					System.out.println("\t" +"value after adding :"+ m);
				}
				catch(Exception e) {
					System.out.println("\t" +e);
				}

			}
			System.out.println();
		}
	}

	private static void test5() {
		System.out.println("*****  test 5  *****");

		//valid monoms: 
		String[] monoms1 = {"2","x","-x^2", "12.03x^4", "3.0101000x^3"};
		String[] monoms2 = {"3","3x","x^2","-13.0043x^4","1.5x^3"};
		for(int i=0;i<monoms1.length;i++) {

			Monom m = new Monom(monoms1[i]);
			System.out.println(i+1 +"): "+ m);

			for (int j = 0; j < monoms2.length; j++) {
				Monom m1 = new Monom(monoms2[j]);
				Monom m2 = new Monom(m);
				try {
					m2.multipy(m1);
					System.out.println("\t" +"value after multiply :"+ m2);
				}
				catch(Exception e) {
					System.out.println("\t" +e);
				}

			}
			System.out.println();
		}
	}

	private static void test6() {
		System.out.println("*****  test 6  *****");

		//valid monoms: 
		String[] monoms1 = {"2","x","-x^2", "12.03x^4", "3.0101000x^3"};
		String[] monoms2 = {"2","x","-x^2", "12.0299999x^4", "3.0101x^3"};

		for(int i=0;i<monoms1.length;i++) {

			Monom m = new Monom(monoms1[i]);
			System.out.println(i+1 +"): "+ m);

			for (int j = 0; j < monoms2.length; j++) {
				Monom m1 = new Monom(monoms2[j]);
				Monom m2 = new Monom(m);
				try {
					System.out.println("\t" +"is equal :"+ m2.equals(m1));
				}
				catch(Exception e) {
					System.out.println("\t" +e);
				}

			}
			System.out.println();
		}
	}


}
