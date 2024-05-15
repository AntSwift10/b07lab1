import java.lang.Math;

public class Polynomial {
	//Fields
	double [] coefficients;
	
	//Methods
	Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	
	Polynomial(double[] coeffs) {
		coefficients = new double[coeffs.length];
		for(int i = 0; i < coeffs.length; i++) {
			coefficients[i] = coeffs[i];
		}
	}
	
	Polynomial add(Polynomial added) {
		double[] result = new double[Math.max(this.coefficients.length, added.coefficients.length)];
		for(int i = 0; i < added.coefficients.length; i++) {
			result[i] += added.coefficients[i];
		}
		for(int i = 0; i < this.coefficients.length; i++) {
			result[i] += this.coefficients[i];
		}
		Polynomial returned = new Polynomial(result);
		return returned;
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
