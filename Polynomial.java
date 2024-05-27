import java.lang.Math;

public class Polynomial {
	//Fields
	double [] coefficients;
	int [] exponents;
	
	//Methods
	Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		exponents = new int[1];
		exponents[0] = 0;
	}
	
	Polynomial(double[] coeffs, int[] exps) {
		coefficients = new double[coeffs.length];
		for(int i = 0; i < coeffs.length; i++) {
			coefficients[i] = coeffs[i];
		}
		exponents = new int[exps.length];
		for(int i = 0; i < exps.length; i++) {
			exponents[i] = exps[i];
		}
	}
	
	Polynomial add(Polynomial added) {
		//Make a temporary array
		int max = 0;
		int temp = Math.max(exponents[exponents.length-1], added.exponents[added.exponents.length-1]) + 1;
		double [] tempCoeffs = new double[temp];
		for (int i = 0; i < temp; i++) {
			tempCoeffs[i] = i;
		}
		
		//Add to the Temp array
		for (int i = 0; i < exponents.length; i++) {
			tempCoeffs[exponents[i]] = coefficients[i];
		}
		
		for (int i = 0; i < added.exponents.length; i++) {
			tempCoeffs[added.exponents[i]] += added.coefficients[i];
		}
		
		//Convert to Final Array
		int len = 0;
		for (int i = 0; i < temp; i++) {
			if (tempCoeffs[i] != 0) {
				len++;
			}
		}
		
		double [] newCoeffs = new double[len];
		int [] newExponents = new int[len];
		
		int j = 0;
		for (int i = 0; i < temp; i++) {
			if (tempCoeffs[i] != 0) {
				newCoeffs[j] = tempCoeffs[i];
				newExponents[j] = i;
				j++;
			}
		}
		
		//Return Result
		return new Polynomial(newCoeffs, newExponents);
	}
	
	double evaluate(double point) {
		double result = 0;
		for(int i = 0; i < coefficients.length; i++) {
			result += coefficients[i] * Math.pow(point, exponents[i]);
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
