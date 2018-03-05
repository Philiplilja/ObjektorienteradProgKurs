package se.his.a14phili;

import java.io.Serializable;

public class HighscoreItem implements Serializable {
	
	private static final long serialVersionUID = 7992625020846683081L;
	private String name;
	private int score;
	

	
	public HighscoreItem(String name, int score)
	{
		this.setName(name);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
