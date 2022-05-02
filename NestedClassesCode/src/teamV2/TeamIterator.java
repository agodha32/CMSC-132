package teamV2;

import java.util.Iterator;

public class TeamIterator implements Iterator<Player> {
	private Team team;
	private int pos;

	public TeamIterator(Team team) {
		this.team = team;
		pos = 0;
	}

	public boolean hasNext() {
		return pos < team.getSize();  
	}

	public Player next() {
		return team.getPlayer(pos++);
	}
}
