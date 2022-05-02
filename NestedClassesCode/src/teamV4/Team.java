package teamV4;

import java.util.Iterator;

/* 
 * The only difference between this class and the one in package
 * teamV3 is that the class now implements Iterable<Player>.
 */
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

	/* We need this method to provide access to the Iterator object */
	public Iterator<Player> iterator() {
		return new TeamIterator();
	}

	private class TeamIterator implements Iterator<Player> {
		private int pos = 0;

		public boolean hasNext() {
			return pos < size;
		}

		public Player next() {
			return list[pos++];
		}
	}
}
