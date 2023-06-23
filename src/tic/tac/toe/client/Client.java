package tic.tac.toe.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tic.tac.toe.controller.GameController;
import tic.tac.toe.entity.Bot;
import tic.tac.toe.entity.DifficultyLevel;
import tic.tac.toe.entity.Game;
import tic.tac.toe.entity.GameStatus;
import tic.tac.toe.entity.Player;
import tic.tac.toe.entity.PlayerType;
import tic.tac.toe.entity.PlayerSymbol;
import tic.tac.toe.strategies.SameColumnMatched;
import tic.tac.toe.strategies.SameDiagonalMatched;
import tic.tac.toe.strategies.SameRowsMatched;
import tic.tac.toe.strategies.WinningStrategies;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameController controller = new GameController();
		Player player1 = new Player("Rajnish", PlayerType.HUMAN, new PlayerSymbol('#'));
		Player player2 = new Bot("Anamika", new PlayerSymbol('0'), DifficultyLevel.EASY);
		List<Player> playerList = new ArrayList<>();
		playerList.add(player1);
		playerList.add(player2);
		
		WinningStrategies winningStrategy1 = new SameRowsMatched(3,playerList);
		WinningStrategies winningStrategy2 = new SameColumnMatched(3,playerList);
		//WinningStrategies winningStrategy3 = new SameDiagonalMatched();
		List<WinningStrategies> winningStrategies = new ArrayList<>();
		winningStrategies.add(winningStrategy1);
		winningStrategies.add(winningStrategy2);
		//winningStrategies.add(winningStrategy3);
		
		
		
		Game game = controller.createGameBuilder()
				              .setDimension(3)
				              .setPlayers(playerList)
				              .setWinningStrategies(winningStrategies)
				              .build();
		
		System.out.println(game);
		
		while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
			controller.printBoard(game);
			System.out.println("Do you want to do undo Y/N ?");
			String s = sc.nextLine();
			if(s.equalsIgnoreCase("Y")) {
			  controller.undo(game);
			}
			controller.nextMove(game);
		}
		controller.printBoard(game);
		controller.printGameStatus(game);
	}
}
