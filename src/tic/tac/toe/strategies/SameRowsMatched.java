package tic.tac.toe.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tic.tac.toe.entity.Board;
import tic.tac.toe.entity.Cell;
import tic.tac.toe.entity.Move;
import tic.tac.toe.entity.Player;
import tic.tac.toe.entity.PlayerSymbol;

public class SameRowsMatched implements WinningStrategies{
  
  List<HashMap<Character, Integer>> rowMapList = new ArrayList<>();
  
  public SameRowsMatched(int size, List<Player> players) {    
    
    for(int i = 0; i < size; i++) {
       HashMap<Character, Integer> map = new HashMap<>();
       for(Player player : players) {
         map.put(player.getPlayerSymbol().getSymbol(), 0);
       }
       rowMapList.add(map);
    }
}

	@Override
	public boolean checkWinner(Board board, Move move) {
	    System.out.println("Check same rows are matching or not!");
	    Cell currentCell = move.getCell();
	    Player currentPlayer = move.getPlayer();
	    int currentRow = currentCell.getRow();
	    char currentSymbol = currentPlayer.getPlayerSymbol().getSymbol();
	    HashMap<Character, Integer> currentRowMap = rowMapList.get(currentRow);
	    currentRowMap.put(currentSymbol, currentRowMap.get(currentSymbol) + 1);
	    
	    if(currentRowMap.get(currentSymbol) == board.getSize()) {
	      return true;
	    } 
	    return false;
	}

  @Override
  public void undo(Board board, Move lastMove) {
    Player currentPlayer = lastMove.getPlayer();
    Cell currenCell = lastMove.getCell();
    HashMap<Character, Integer> map = rowMapList.get(currenCell.getRow());
    map.put(currentPlayer.getPlayerSymbol().getSymbol(), map.get(currentPlayer.getPlayerSymbol().getSymbol()) - 1);
  }
}
