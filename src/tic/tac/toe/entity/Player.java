package tic.tac.toe.entity;

import java.util.Scanner;

public class Player {
        
	private String name;
	private PlayerType playerType;
	private PlayerSymbol PlayerSymbol;
	private Scanner sc = new Scanner(System.in);
	
	public Player(String name, PlayerType playerType, PlayerSymbol symbol) {
		this.name = name;
		this.playerType = playerType;
		this.PlayerSymbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	/**
   * @return the playerSymbol
   */
  public PlayerSymbol getPlayerSymbol() {
    return PlayerSymbol;
  }

  /**
   * @param playerSymbol the playerSymbol to set
   */
  public void setPlayerSymbol(PlayerSymbol playerSymbol) {
    PlayerSymbol = playerSymbol;
  }

  public Cell makeMove(Board board) {	
    System.out.println("It's a Human Turn");
		System.out.print("Enter the row no:");
		int row = sc.nextInt();
		System.out.print("Enter the col no:");
		int col = sc.nextInt();
		return new Cell(row,col);		
	}	
}
