package game;

public class computerAI {

	// Computer choosing scissor/rock/paper.
	public static String computerChoice() {
		String Choice = "scissor";
		int switchNum = (int) (Math.random() * 3);
		switch (switchNum) {
		case 1:
			Choice = "rock";
			break;
		case 2:
			Choice = "paper";
			break;
		}
		return Choice;
	}
}
