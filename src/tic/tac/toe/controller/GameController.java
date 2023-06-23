package tic.tac.toe.controller;

import tic.tac.toe.entity.Game;
import tic.tac.toe.entity.GameStatus;

public class GameController {
	
	
	public GameBuilder createGameBuilder() {
		return new GameBuilder();
	}
	
	public void printBoard(Game game) {
		game.getBoard().print();
	}
	
	public void nextMove(Game game) {
		game.makeMove();	
	}

  public void printGameStatus(Game game) {
    if(game.getGameStatus().equals(GameStatus.DRAW)) {
      System.out.println("Opps no is the winner!");
    }else if(game.getGameStatus().equals(GameStatus.END)){
      System.out.println("Hurray!"+game.getWinner().getName()+" has won the game!");
    } 
  }

  public void undo(Game game) {
    game.undo();
  }
	
	
}
