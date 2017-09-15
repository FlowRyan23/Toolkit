package basic;

public class Complex {

	private double real;
	private double complex;
	
	public Complex(double real, double complex) {
		this.real = real;
		this.complex = complex;
	}
	
	public Complex add(Complex c) {
		real = real+c.real;
		complex = complex+c.complex;
		return this;
	}
	
	public Complex sub(Complex c) {
		real = real-c.real;
		complex = complex-c.complex;
		return this;
	}
	
	public Complex multiply(Complex c) {
		double real = this.real*c.real - complex*c.complex;
		complex = complex*c.real + this.real*c.complex;
		this.real = real;
		return this;
	}
	
	public Complex pow(int exp) {
		if(exp==0) {
			real = 1;
			complex = 0;
		}
		else if(exp!=1) {
			Complex copy = new Complex(real, complex);
			for(int i=1; i<exp; i++)
				this.multiply(copy);
		}
		return this;
	}
	
	public double abs() {
		return Math.sqrt(real*real + complex*complex); 
	}
	
	public void set(Complex c) {
		real = c.real;
		complex = c.complex;
	}
	
	@Override
	public String toString() {
		return real + "+" + complex + "i";
	}
	
}

