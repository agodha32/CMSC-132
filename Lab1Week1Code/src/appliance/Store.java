package appliance;

import java.util.ArrayList;

public class Store {
	private String name;
	private Refrigerator[] refrigerators;
	private int numberOfRefrigerators;

	public Store(String name, int maxRefrigerators) {
		this.name = name;
		this.refrigerators = new Refrigerator[maxRefrigerators];
		this.numberOfRefrigerators = 0;
	}

	public Store addRefrigerator(String brand, int bins) {
		if (numberOfRefrigerators < refrigerators.length) {
			refrigerators[numberOfRefrigerators++] = new Refrigerator(brand, bins);
		}

		return this;
	}

	public int getCountWithBinsInRange(int lower, int upper) {
		int cnt = 0;

		for (int i = 0; i < refrigerators.length && refrigerators[i] != null; i++) {
			int bins = refrigerators[i].getBins();
			if (bins >= lower && bins <= upper) {
				cnt++;
			}
		}

		return cnt;
	}

	public Refrigerator[] getRefrigerators(int lower, int upper) {
		int cnt = getCountWithBinsInRange(lower, upper);

		Refrigerator[] answer = new Refrigerator[cnt];
		for (int i = 0, k = 0; i < numberOfRefrigerators; i++) {
			int bins = refrigerators[i].getBins();
			if (bins >= lower && bins <= upper) {
				answer[k++] = new Refrigerator(refrigerators[i]);
			}
		}

		return answer;
	}

	public static ArrayList<Refrigerator> getRefrigeratorsWithNumberOfBins(ArrayList<Appliance> appliances, int bins) {
		ArrayList<Refrigerator> answer = new ArrayList<Refrigerator>();

		for (int i = 0; i < appliances.size(); i++) {
			Appliance appliance = appliances.get(i);
			if (appliance instanceof Refrigerator) {
				Refrigerator ref = (Refrigerator) appliance;

				if (ref.getBins() == bins) {
					answer.add(ref);
				}
			}
		}

		return answer;
	}

	public String toString() {
		String answer = "";

		answer += "Name: " + name + "\n";
		answer += "Refrigerators:\n";
		for (int i = 0; i < numberOfRefrigerators; i++) {
			answer += refrigerators[i] + "\n";
		}

		return answer;
	}
}