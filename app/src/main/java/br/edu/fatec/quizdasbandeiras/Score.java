package br.edu.fatec.quizdasbandeiras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Score {

    private ArrayList<Player> playersList;

    private String playerName;
    private static Score singleInstance = null;
    private int scorePoints = 0;
    private Player auxiliarPlayer;

    private int counterIndex = 0;
    public Score(){
        playersList = new ArrayList<>();
    }


    public static Score getInstance() {
        if (singleInstance == null)
            singleInstance = new Score();
        return singleInstance;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(int scorePoints) {
        this.scorePoints = scorePoints;
        if (isNameNew(playerName))
            playersList.get(playersList.size() - 1).setScore(scorePoints);
        else
            playersList.get(counterIndex).setScore(scorePoints);
    }

    public String getPlayerName() { return playerName; }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;

        if (isNameNew(playerName)){
            playersList.add(new Player(playerName, scorePoints));
        }
    }

    public boolean isNameNew (String newName){
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getName().equals(newName)){
                counterIndex = i;
                return false;
            }
        }
        return true;
    };

}
