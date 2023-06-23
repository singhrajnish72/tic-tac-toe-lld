package tic.tac.toe.strategies;

import tic.tac.toe.entity.Board;
import tic.tac.toe.entity.Move;

public interface WinningStrategies {
     
	public boolean checkWinner(Board board, Move move);

  public void undo(Board board, Move lastMove);
}
