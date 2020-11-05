package fr.p10.miage.rps.tests;

import fr.p10.miage.rps.model.Player;
import fr.p10.miage.rps.model.RPSEnum;
import fr.p10.miage.rps.model.Result;
import fr.p10.miage.rps.model.RockPaperScissors;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {
    private RockPaperScissors rps;
    private List<RPSEnum> collMouv;
    private List<RPSEnum> collMouv2;

    @BeforeClass
    public void setUp() {

        rps = new RockPaperScissors();

        this.collMouv = new ArrayList<>();
        collMouv.add(RPSEnum.SCISSORS);
        collMouv.add(RPSEnum.PAPER);
        collMouv.add(RPSEnum.ROCK);
        collMouv.add(RPSEnum.ROCK);
        collMouv.add(RPSEnum.SCISSORS);
        collMouv.add(RPSEnum.PAPER);
        collMouv.add(RPSEnum.ROCK);
        collMouv.add(RPSEnum.SCISSORS);
        collMouv.add(RPSEnum.PAPER);
        collMouv.add(RPSEnum.SCISSORS);
        collMouv.add(RPSEnum.ROCK);
        collMouv.add(RPSEnum.PAPER);
        collMouv.add(RPSEnum.SCISSORS);
        collMouv.add(RPSEnum.PAPER);



        this.collMouv2 = new ArrayList<>();
        collMouv2.add(RPSEnum.PAPER);
        collMouv2.add(RPSEnum.ROCK);
        collMouv2.add(RPSEnum.SCISSORS);
        collMouv2.add(RPSEnum.SCISSORS);
        collMouv2.add(RPSEnum.PAPER);
        collMouv2.add(RPSEnum.ROCK);
        collMouv2.add(RPSEnum.SCISSORS);
        collMouv2.add(RPSEnum.ROCK);
        collMouv2.add(RPSEnum.PAPER);
        collMouv2.add(RPSEnum.ROCK);
        collMouv2.add(RPSEnum.PAPER);
        collMouv2.add(RPSEnum.SCISSORS);
        collMouv2.add(RPSEnum.PAPER);
        collMouv2.add(RPSEnum.ROCK);

    }

    @AfterClass
    public void tearDown() {

        rps = null;
        collMouv = null;
        collMouv2 = null;
    }

    // WITH DATA PROVIDER

    @DataProvider (name = "winData")
    public Object[][] createWinData(){
        return new Object[][] {{RPSEnum.PAPER, RPSEnum.ROCK}, {RPSEnum.ROCK, RPSEnum.SCISSORS}, {RPSEnum.SCISSORS, RPSEnum.PAPER}};
    }

    @DataProvider (name = "tieData")
    public Object[][] createTieData(){
        return new Object[][] {{RPSEnum.PAPER, RPSEnum.PAPER}, {RPSEnum.ROCK, RPSEnum.ROCK}, {RPSEnum.SCISSORS, RPSEnum.SCISSORS}};
    }

    @DataProvider (name = "lostData")
    public Object[][] createLostData(){
        return new Object[][] {{RPSEnum.PAPER, RPSEnum.SCISSORS}, {RPSEnum.ROCK, RPSEnum.PAPER}, {RPSEnum.SCISSORS, RPSEnum.ROCK}};
    }



    @Test (dataProvider = "winData")
    public void testWinPlay(RPSEnum p1, RPSEnum p2){
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test (dataProvider = "tieData")
    public void testTiePlay(RPSEnum p1, RPSEnum p2){
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @Test (dataProvider = "lostData")
    public void testLostPlay(RPSEnum p1, RPSEnum p2){
        assertEquals(rps.play(p1, p2), Result.LOST);
    }







    //With player

    @DataProvider (name = "PlayerWinData")
    public Object[][] createWinDataPlayer(){
        return new Object[][] {{new Player("Rahul", this.collMouv), new Player("Wassim", this.collMouv2)}};
    }

    @Test (dataProvider = "PlayerWinData")
    public void testWinPlayPlayer(Player p1, Player p2){
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @DataProvider (name = "PlayerLostData")
    public Object[][] createLostDataPlayer(){
        return new Object[][] {{new Player("Rahul", this.collMouv2), new Player("Wassim", this.collMouv)}};
    }

    @Test (dataProvider = "PlayerLostData")
    public void testTiePlayPlayer(Player p1, Player p2){
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @DataProvider (name = "PlayerTieData")
    public Object[][] createTieDataPlayer(){
        return new Object[][] {{new Player("Rahul", this.collMouv2), new Player("Wassim", this.collMouv2)}};
    }

    @Test (dataProvider = "PlayerTieData")
    public void testLostPlayPlayer(Player p1, Player p2){
        assertEquals(rps.play(p1, p2), Result.TIE);
    }
}