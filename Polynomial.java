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
		int max = 0;
		for (int i = 0; i < exponents.length; i++) {
			max = Math.max(max, exps[i]);
		}
		
		coefficients = new double[max + 1];
		exponents = new int[max + 1];
		
		int j = 0;
		for (int i = 0; i < coeffs.length(); i++) {
			if (coeffs[i] != 0) {
				coefficients[j] = coeffs[i];
				exponents[j] = exps[i];
				j++;
			}
		}
	}
	
	Polynomial(File file) {
		//Get the line into a string
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		
		//Swap - with +-
		line = line.replace("-", "+-");
		
		//Cut up input string
		String[] lineArr = line.split("+");
		
		//Get biggest exponent
		int max = 0;
		String[] temp;
		String[] tempStorage;
		for (int i = 0; i < lineArr.length(); i++) {
			temp = lineArr[i].split("x");
			if (temp.length() != 1) {
				//Got split, so exponent is non 0
				max = Math.max(max, temp[1]);
			}
		}
		
		//Make array
		double[] tempCoeff = new double[max + 1]
		double[] tempExp = new double[max + 1]
		
		for (int i = 0; i < tempExp.length(); i++) {
			tempExp[i] = i;
		}
		
		//Fill temp Coeffs
		for (int i = 0; i < lineArr.length(); i++) {
			temp = lineArr[i].split("x");
			if (lineArr.length() != 1) {
				tempCoeff[parseInt(temp(1))] = parseDouble(temp(0));
			} else {
				tempCoeff[0] = parseDouble(temp(0));
			}
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
