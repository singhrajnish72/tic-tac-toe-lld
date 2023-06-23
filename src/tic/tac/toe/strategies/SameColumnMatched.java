package tic.tac.toe.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tic.tac.toe.entity.Board;
import tic.tac.toe.entity.Cell;
import tic.tac.toe.entity.Move;
import tic.tac.toe.entity.Player;

public class SameColumnMatched implements WinningStrategies{

  List<HashMap<Character, Integer>> colMapList = new ArrayList<>();
  
  
  
	public SameColumnMatched(int size, List<Player> players) {    
	       
	       for(int i = 0; i < size; i++) {
	          HashMap<Character, Integer> map = new HashMap<>();
	          for(Player player : players) {
	            map.put(player.getPlayerSymbol().getSymbol(), 0);
	          }
	          colMapList.add(map);
	       }
  }
	
  @Override
	public boolean checkWinner(Board board, Move move) {
    System.out.println("Check same column are matching or not!");
	  Cell currentCell = move.getCell();
	  Player currentPlayer = move.getPlayer();
	  int currentCol = currentCell.getCol();
	  char currentSymbol = currentPlayer.getPlayerSymbol().getSymbol();
	  HashMap<Character, Integer> currentColMap = colMapList.get(currentCol);
	  currentColMap.put(currentSymbol, currentColMap.get(currentSymbol) + 1);
	  
	  if(currentColMap.get(currentSymbol) == board.getSize()) {
	    return true;
	  } 
	  return false;
	}

  @Override
  public void undo(Board board, Move lastMove) {
    Player currentPlayer = lastMove.getPlayer();
    Cell currenCell = lastMove.getCell();
    HashMap<Character, Integer> map = colMapList.get(currenCell.getCol());
    map.put(currentPlayer.getPlayerSymbol().getSymbol(), map.get(currentPlayer.getPlayerSymbol().getSymbol()) - 1);
  }
}
