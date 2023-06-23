package tic.tac.toe.entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<List<Cell>> cells;
	private int size;
	
	public Board(int size) {
		this.size = size;	
		this.cells = new ArrayList<>();
		for(int i = 0; i < size; i++) {
		  List<Cell> cellList = new ArrayList<>();
			for(int j = 0; j < size; j++) {
			  cellList.add(new Cell(i,j));
			}
			cells.add(cellList);
		}
	}

	public List<List<Cell>> getCells() {
		return cells;
	}

	public void setCells(List<List<Cell>> cells) {
		this.cells = cells;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void print() {
	  System.out.println("!!!TIC TAC TOE!!!");
		for(List<Cell> cellList : cells) {
			System.out.print("|");
			for(Cell cell : cellList) {
				if(cell.getCellStatus() == CellStatus.EMPTY_CELL) {
					System.out.print(" - ");
				}else {
					System.out.print(" " + cell.getPlayer().getPlayerSymbol().getSymbol() + " ");
				}
				System.out.print("|");
			}
			
			System.out.println();
		}	
	}
	
//	| - | - | - |
//	| # | 0 | - |
//	| - | - | - |

}
