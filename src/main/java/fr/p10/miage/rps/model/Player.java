package fr.p10.miage.rps.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Player {
    private String nom;
    private int score;
    private List<RPSEnum> CollMouv;
    private int nextMove;

    public Player(String name, List<RPSEnum> collMouv)
    {
        this.nom = name;
        this.CollMouv = collMouv;
    }

    public Player(String name)
    {
        this.nom = name;
        this.nextMove = 0;
        this.CollMouv = new ArrayList<RPSEnum>();

        int nbRand;
        for(int i = 0; i<10; i++)
        {
            Random rand = new Random();
            nbRand = rand.nextInt(3);

            if(nbRand == 0)
            {
                CollMouv.add(RPSEnum.PAPER);
            }
            else if(nbRand == 1)
            {
                CollMouv.add(RPSEnum.ROCK);
            }
            else
            {
                CollMouv.add(RPSEnum.SCISSORS);
            }
        }
    }

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }

    public int getMouvSize()
    {
        return this.CollMouv.size();
    }

    public RPSEnum getNextMove(){
        Iterator i = CollMouv.iterator();
        return (RPSEnum)i.next();
    }

    public void setScore(int score) {
        this.score = score;
    }
}
