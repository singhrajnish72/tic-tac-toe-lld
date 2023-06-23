package tic.tac.toe.factory;

import tic.tac.toe.entity.DifficultyLevel;
import tic.tac.toe.strategies.BotEasy;
import tic.tac.toe.strategies.BotMedium;
import tic.tac.toe.strategies.BotStrategy;

public class BotFactory {
   
      public BotStrategy getBotInstance(DifficultyLevel difficultyLevel) {
             if(difficultyLevel.equals(difficultyLevel.MODERATE)) {
               return new BotMedium();
             }else if(difficultyLevel.equals(difficultyLevel.HARD)) {
               return new BotMedium();
             }else {
               return new BotEasy();
             }
      }
  
}
