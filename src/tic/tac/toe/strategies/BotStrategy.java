package tic.tac.toe.strategies;

import tic.tac.toe.entity.Board;
import tic.tac.toe.entity.Cell;
import tic.tac.toe.entity.Move;

public interface BotStrategy {
	
	Cell makeMove(Board board);

}
