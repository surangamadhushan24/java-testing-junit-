package junit;

public class Calculate {
	public int sum(int var1, int var2) {
		System.out.println("Adding values: " + var1 + " + " + var2);
		return var1 + var2;
	}

	public int multiply(int var1, int var2) {
		System.out.println("Multiplying values: " + var1 + " * " + var2);
		return var1 * var2;
	}

	public int divide(int var1, int var2) {
		System.out.println("Dividing values: " + var1 + " / " + var2);
		return var1/var2;
	}
}
