package teamV5;

import java.util.Iterator;

public class Team implements Iterable<Player> {
	private Player[] list; 
	private int size; 

	public Team(int maxSize) {
		list = new Player[maxSize];
		size = 0;
	}

	public boolean add(Player player) {
		if (size < list.length) {
			list[size++] = player;
			return true;
		}

		return false;
	}

	public String toString() {
		String answer = "";

		for (int i = 0; i < size; i++) {
			answer += list[i] + "\n";
		}

		return answer;
	}

	public Iterator<Player> iterator() {

		/* Relying on a local class (class within method in this case) */
		class TeamIterator implements Iterator<Player> {
			private int pos = 0;

			public boolean hasNext() {
				return pos < size;
			}

			public Player next() {
				return list[pos++];
			}
		}

		/* Create an instance and returns it */
		return new TeamIterator();
	}
}
