package tic.tac.toe.controller;

import java.util.HashSet;
import java.util.List;
import tic.tac.toe.entity.Game;
import tic.tac.toe.entity.Player;
import tic.tac.toe.entity.PlayerType;
import tic.tac.toe.strategies.WinningStrategies;

public class GameBuilder {
     
	private int dimension;
	private List<Player> players;
	private List<WinningStrategies> winningStrategies;
	
	public Game build() {
		if(validateGame()) {
			return new Game(dimension,players,winningStrategies);
		}
		
		return null;	
	}
	
	private boolean validateGame() {
		
		if(this.players.size() < 2) {
			return false;
		}
		
		if(this.players.size() > dimension - 1) {
			return false;
		}
		
		long botcount = this.players.stream().filter(player -> player.getPlayerType().equals(PlayerType.BOT)).count();
		
		if(botcount > 1) {
			return false;
		}
		
		HashSet<Character> set = new HashSet<>();
		for(Player player : players) {
			if(set.contains(player.getPlayerSymbol().getSymbol())){
				return false;
			}	
			set.add(player.getPlayerSymbol().getSymbol());
		}
		return true;	
	}

	public int getDimension() {
		return dimension;
	}
	
	public GameBuilder setDimension(int dimension) {
		this.dimension = dimension;
		return this;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public GameBuilder setPlayers(List<Player> players) {
		this.players = players;
		return this;
	}
	public List<WinningStrategies> getWinningStrategies() {
		return winningStrategies;
	}
	public GameBuilder setWinningStrategies(List<WinningStrategies> winningStrategies) {
		this.winningStrategies = winningStrategies;
		return this;
	}
	
}
