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
		for (int i = 0; i < exponents.length; i++) {
			max = Math.max(max, exponents[i]);
		}
		for (int i = 0; i < added.exponents.length; i++) {
			max = Math.max(max, added.exponents[i]);
		}
		int temp = max + 1;
		double [] tempCoeffs = new double[temp];
		for (int i = 0; i < temp; i++) {
			tempCoeffs[i] = 0;
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
	
	Polynomial multiply(Polynomial added) {
		//Create the base
		Polynomial base = new Polynomial();
		
		//Do Main Logic
		double tempCoeff = 0;
		int tempExp = 0;
		for (int i = 0; i < exponents.length; i++) {
			//Iterate through caller terms
			tempCoeff = coefficients[i];
			tempExp = exponents[i];
			for (int j = 0; j < added.exponents.length; j++) {
				//Iterate through parameter terms, adding each term to Base
				double[] tempArr1 = {added.coefficients[j] * tempCoeff};
				int[] tempArr2 = {added.exponents[j] + tempExp};
				base = base.add(new Polynomial(tempArr1, tempArr2));
			}
		}
		
		//Return Base
		return base;
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
