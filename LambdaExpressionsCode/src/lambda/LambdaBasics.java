package lambda;

public class LambdaBasics {
	public static void main(String[] args) {
		Task example1AnonymousClass = new Task() {
			public int compute(int x) {
				return x + x;
			}
		};
		System.out.println(example1AnonymousClass.compute(10));

		Task lambdaExample1Version1 = (int x) -> {
			return x + x;
		};
		System.out.println(lambdaExample1Version1.compute(10));

		Task lambdaExample1Version2 = (x) -> x + x;
		System.out.println(lambdaExample1Version2.compute(10));

		Task lambdaExample1Version3 = x -> x + x;
		System.out.println(lambdaExample1Version3.compute(10));

		AnotherTask lambdaExample2 = () -> 10;
		System.out.println(lambdaExample2.analyze());

		Processor lambdaExample3 = (int x, float y) -> x * y;
		System.out.println(lambdaExample3.increase(10, 5.0f));

		/* Passing lambda expression to method */
		pdata((x, y) -> x * y); /* Passing object with required method */
	}

	public static void pdata(Processor p) {
		System.out.println(p.increase(10, 60));
	}
}
