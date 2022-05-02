package tcpServerClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Wisdom {
	private ArrayList<String> oneLiners = new ArrayList<String>();
	private SecureRandom random = new SecureRandom();

	public Wisdom() throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("one-liners.txt"));
		String oneLiner;

		while ((oneLiner = input.readLine()) != null) {
			oneLiners.add(oneLiner);
		}

		input.close();
	}

	public String getWisdom() {
		return oneLiners.get(random.nextInt(oneLiners.size()));
	}
}
