//Main Class

public class Main {
	public static void main(String[] args) {
		int player1, difficulty, playerTurn;
		SelectPlayer player = new SelectPlayer();
		player.display();
		player1 = SelectPlayer.retPlayer();
		if (player1 == 1)
		{
			SetAttributes myAttributes = new SetAttributes();
			myAttributes.display();
			difficulty = SetAttributes.retDifficulty();
			playerTurn = SetAttributes.retTurn();
			System.out.println("Playing against AI Opponent with difficulty = " + difficulty);
			if(playerTurn == 1) //choose human or computer goes first
			{
				MachinePlayer game = new MachinePlayer(difficulty);
			}
			else
			{
				MachinePlayer2 game = new MachinePlayer2(difficulty);
			}
				
		}
		if (player1 == 2)// 2 Human Player Game
		{
			System.out.println("Playing against Human Opponent");
			HumanPlayer game = new HumanPlayer();
		}
	}
}