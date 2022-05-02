package teamV3;

import java.util.Iterator;

public class Team {
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

		/*
		 * We no longer need getMethods to access team components.
		 * They can be accessed directly from the inner class.
		 */

		public boolean hasNext() {
			return pos < size;
		}

		public Player next() {
			return list[pos++];
		}
	}
}
