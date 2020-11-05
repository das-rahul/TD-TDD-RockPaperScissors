package fr.p10.miage.rps.model;

import java.io.NotActiveException;

public class RockPaperScissors {

    public RockPaperScissors(){}

    public Result play(RPSEnum p1, RPSEnum p2)
    {
        if(p1 == RPSEnum.PAPER && p2 == RPSEnum.ROCK)
        {
            return Result.WIN;
        }
        else if(p1 == RPSEnum.PAPER && p2 == RPSEnum.SCISSORS)
        {
            return Result.LOST;
        }
        else if(p1 == RPSEnum.PAPER && p2 == RPSEnum.PAPER)
        {
            return Result.TIE;
        }
        else if(p1 == RPSEnum.ROCK && p2 == RPSEnum.PAPER)
        {
            return Result.LOST;
        }
        else if(p1 == RPSEnum.ROCK && p2 == RPSEnum.ROCK)
        {
            return Result.TIE;
        }
        else if(p1 == RPSEnum.ROCK && p2 == RPSEnum.SCISSORS)
        {
            return Result.WIN;
        }
        else if(p1 == RPSEnum.SCISSORS && p2 == RPSEnum.PAPER)
        {
            return Result.WIN;
        }
        else if(p1 == RPSEnum.SCISSORS && p2 == RPSEnum.ROCK)
        {
            return Result.LOST;
        }
        else if(p1 == RPSEnum.SCISSORS && p2 == RPSEnum.SCISSORS)
        {
            return Result.TIE;
        }
        else
        {
            return null;
        }
    }

    public Result play(Player p1, Player p2)
    {
        Result res;
        System.out.println( "" + p1.getNextMove());
        System.out.println( "" + p2.getNextMove());
        System.out.println( "" + p1.getMouvSize());
        System.out.println( "" + p2.getMouvSize());
        for(int i = 0; i < p1.getMouvSize(); i++)
        {

            res = play(p1.getNextMove(), p2.getNextMove());

            if(res.equals(Result.WIN))
            {
                p1.setScore(p1.getScore() + 1);
            }
            else if(res.equals(Result.LOST))
            {
                p2.setScore(p2.getScore() + 1);
            }
            else
            {
                p1.setScore(p1.getScore() + 1);
                p2.setScore(p2.getScore() + 1);
            }

            if(p1.getScore() > 5 && p2.getScore() < 5)
            {
                return Result.WIN;
            }
            if(p2.getScore() > 5 && p1.getScore() < 5)
            {
                return Result.LOST;
            }
        }
        return Result.TIE;
    }
}
