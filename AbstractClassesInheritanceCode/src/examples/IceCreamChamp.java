package examples;

public class IceCreamChamp implements InternationalIceCreamStore {
	
	@Override
	public double getIceCreamPrice() {
		return 4;
	}

	@Override
	public String getCountry() {
		return "France";
	}
}
