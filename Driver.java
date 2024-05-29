import java.lang.Math;
import java.io.File;
import java.io.IOException;

public class Driver {
	public static void main(String [] args) throws java.io.FileNotFoundException, IOException {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6,0,0,5};
		int [] e1 = {0,1,2,3};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {0,-2,0,0,-9};
		int [] e2 = {0,1,2,3,4};
		Polynomial p2 = new Polynomial(c2, e2);
		Polynomial s = p1.add(p2);
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(1))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
		
		//Test Multiply
		double [] c3 = {1, 5};
		int [] e3 = {0, 3};
		double [] c4 = {-4, 1};
		int [] e4 = {3, 2};
		Polynomial p3 = new Polynomial(c3, e3);
		Polynomial p4 = new Polynomial(c4, e4);
		Polynomial s2 = p3.multiply(p4);
		System.out.println("s2(0.1) = " + s2.evaluate(0.1));
		System.out.println("s2(0.5) = " + s2.evaluate(0.5));
		
		//Test read and write to file
		s2.saveToFile("test.txt");
		File a = new File("test.txt");
		Polynomial s3 = new Polynomial();
	}
}
