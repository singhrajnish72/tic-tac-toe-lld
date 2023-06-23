package tic.tac.toe.entity;

import java.util.Scanner;
import tic.tac.toe.factory.BotFactory;
import tic.tac.toe.strategies.BotStrategy;

public class Bot extends Player{
	
	private DifficultyLevel difficultyLevel;
	private BotStrategy botStrategy;
	private BotFactory botFactory;
	
	Scanner scanner = new Scanner(System.in);

	public Bot(String name, PlayerSymbol symbol, DifficultyLevel difficultyLevel) {
		super(name, PlayerType.BOT, symbol);
		this.difficultyLevel = difficultyLevel;
		this.botFactory = new BotFactory();
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	@Override
	public Cell makeMove(Board board) {
	  System.out.println("It's a Bot turn...");
    botStrategy = botFactory.getBotInstance(this.difficultyLevel);
		return botStrategy.makeMove(board);
	}
	
}
