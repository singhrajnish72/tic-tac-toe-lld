package tic.tac.toe.strategies;

import java.util.List;
import tic.tac.toe.entity.Board;
import tic.tac.toe.entity.Cell;
import tic.tac.toe.entity.CellStatus;
import tic.tac.toe.entity.Move;

public class BotEasy implements BotStrategy{

  @Override
  public Cell makeMove(Board board) {
    System.out.println("Bot has choosed easy mode :)");
    List<List<Cell>> cells = board.getCells();
    Cell botCell = null; 
    
    for(int i = 0; i < cells.size(); i++) {
      for(int j = 0; j < cells.get(i).size(); j++) {
        if(cells.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY_CELL)) {
          botCell = new Cell(i, j);
          return botCell;
        }
      }
    }
    return botCell;
  }
}
