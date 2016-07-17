package array_algorithem;

public class Method_Calling_Method {

	public static void method2() {
		System.out.println("I am in method 2 first line");
	}

	public static void method1() {
		System.out.println("I am in method 1 first line");
		method2();
		System.out.println("I am in method 1 thrid line");
	}

	public static void main(String[] args) {
		System.out.println("Example of method calling method");
		method1();
	}
}
