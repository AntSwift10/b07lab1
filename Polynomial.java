import java.lang.Math;

public class Polynomial {
	//Fields
	double [] coefficients;
	double [] exponents;
	
	//Methods
	Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		exponents = new double[1];
		exponents[0] = 0;
	}
	
	Polynomial(double[] coeffs, double[] exps) {
		coefficients = new double[coeffs.length];
		for(int i = 0; i < coeffs.length; i++) {
			coefficients[i] = coeffs[i];
		}
		exponents = new double[exps.length];
		for(int i = 0; i < exps.length; i++) {
			exponents[i] = exps[i];
		}
	}
	
	Polynomial add(Polynomial added) {
	//Get length of new Exponent Array
		int len = 0;
		
	}
	
	double evaluate(double point) {
		double result = 0;
		for(int i = 0; i < coefficients.length; i++) {
			result += coefficients[i] * Math.pow(point, i);
		}
		return result;
	}
	
	boolean hasRoot(double point) {
		if (evaluate(point) == 0) {
			return true;
		}
		return false;
	}
}
