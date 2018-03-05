import java.util.ArrayList;

public class Game {

	private int gameArray[][];

	private ArrayList<GameListener> gameListenerArray = new ArrayList<GameListener>();
	
	Game() {
		gameArray = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameArray[i][j] = 0;
			}
		}
	}

	private void Winning(int selection) { // checking the array index

		if ((gameArray[0][0] == selection && gameArray[0][1] == selection && gameArray[0][2] == selection)
				|| (gameArray[1][0] == selection && gameArray[1][1] == selection && gameArray[1][2] == selection)
				|| (gameArray[2][0] == selection && gameArray[2][1] == selection && gameArray[2][2] == selection)) {

			for(GameListener a : gameListenerArray){
				a.onGameOver(selection);
			}
		}

		else if ((gameArray[0][0] == selection && gameArray[1][0] == selection && gameArray[2][0] == selection)
				|| (gameArray[0][1] == selection && gameArray[1][1] == selection && gameArray[2][1] == selection)
				|| (gameArray[0][2] == selection && gameArray[1][2] == selection && gameArray[2][2] == selection)) {

			for(GameListener a : gameListenerArray){
				a.onGameOver(selection);
			}
		}

		else if ((gameArray[0][0] == selection && gameArray[1][1] == selection && gameArray[2][2] == selection)
				|| (gameArray[2][0] == selection && gameArray[1][1] == selection && gameArray[0][2] == selection)){

			for(GameListener a : gameListenerArray){
				a.onGameOver(selection);
			}
		}
	}
	
	public void ArrayIni(int i, int j, int selection) {
		gameArray[i][j] = selection;
		Winning(selection);

	}
	
	public void addListener(GameListener a){
		gameListenerArray.add(a);
	}
	


}