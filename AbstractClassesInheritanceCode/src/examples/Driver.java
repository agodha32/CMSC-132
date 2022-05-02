package examples;

public class Driver {
	public static void main(String[] args) {
		TerpStore terpStore = new TerpStore();

		System.out.println("Price: " + terpStore.getIceCreamPrice());
		System.out.println("Calories: " + IceCreamStore.CHOCOLATE_CALORIES);

		IceCreamChamp iceCreamChamp = new IceCreamChamp();
		System.out.println("Country: " + iceCreamChamp.getCountry());
		System.out.println("Price: " + iceCreamChamp.getIceCreamPrice());
		System.out.println("Vanilla Calories: " + IceCreamChamp.VANILLA_CALORIES);
	}
}
