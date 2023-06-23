package tic.tac.toe.entity;

import java.util.ArrayList;
import java.util.List;

import tic.tac.toe.strategies.WinningStrategies;

public class Game {
	
	private Board board;
	private List<Player> players;
	private GameStatus gameStatus;
	private int playerIndex;
	private List<WinningStrategies> winningStrategies;
	private List<Move> moves;
	private Player winner;
	
	public Game(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) {
		this.board = new Board(dimension);
		this.players = players;
		this.gameStatus = GameStatus.IN_PROGRESS;
		this.playerIndex = 0;
		this.winningStrategies = winningStrategies;
		this.moves = new ArrayList<>();
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}


	public List<WinningStrategies> getWinningStrategies() {
		return winningStrategies;
	}

	public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
		this.winningStrategies = winningStrategies;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}

	public void makeMove() {
	  System.out.println("Player Move...");
		Player currentPlayer = players.get(playerIndex);
		
		Cell proposedCell = currentPlayer.makeMove(board);
		
		if(!validateCell(proposedCell)) {
			return;
		}
		
		Cell updateCell = board.getCells().get(proposedCell.getRow()).get(proposedCell.getCol());
		updateCell.setCellStatus(CellStatus.FILLED_CELL);
		updateCell.setPlayer(currentPlayer);
		
		Move move = new Move(updateCell,currentPlayer);
		moves.add(move);
		
		for(WinningStrategies winningStrategy : winningStrategies) {
			if(winningStrategy.checkWinner(board, move)) {
				gameStatus = GameStatus.END;
				winner = currentPlayer;
				return;
			}
		}
		
		if(moves.size() == board.getSize() * board.getSize()) {
			gameStatus = GameStatus.DRAW;
		}
		
		playerIndex += 1;
		playerIndex %= players.size(); 	
	}

	private boolean validateCell(Cell proposedCell) {
	  
	  if(proposedCell == null) return false;
	  
		int row = proposedCell.getRow();
		int col = proposedCell.getCol();
		
		if(row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
			return false;
		}
		
		if(proposedCell.getCellStatus().equals(CellStatus.FILLED_CELL)) {
			return false;
		}
		
		return true;
	}
	
  public void undo() {
    System.out.println("Player Move...");
    Move lastMove = moves.get(moves.size() - 1);
    Cell currentCell = lastMove.getCell();
    currentCell.setCellStatus(CellStatus.EMPTY_CELL);
    currentCell.setPlayer(null);
    moves.remove(lastMove);
    
    for(WinningStrategies winningStrategy : winningStrategies) {
        winningStrategy.undo(board, lastMove);
        gameStatus = GameStatus.IN_PROGRESS;
        winner = null;
    }
    
    playerIndex -= 1;
    playerIndex += players.size();
    playerIndex %= players.size();  
  }

  @Override
  public String toString() {
    return "Game [board=" + board + ", players=" + players + ", gameStatus=" + gameStatus + ", playerIndex=" +
        playerIndex + ", winningStrategies=" + winningStrategies + ", moves=" + moves + ", winner=" + winner + "]";
  }
}
