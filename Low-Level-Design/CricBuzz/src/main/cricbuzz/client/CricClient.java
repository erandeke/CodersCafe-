package src.main.cricbuzz.client;

import src.main.cricbuzz.models.*;
import src.main.cricbuzz.service.ResultCalculationService;
import src.main.cricbuzz.service.ScoreCardGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CricClient {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the teamName");

        String teamName = "INDIA";

        System.out.println("Enter the Opposite TeamName");

        String oppTeamName = "SA";
        System.out.println("Enter the no of overs");
        int noOfOvers = 2;
        List<String> playingTeam1List = new ArrayList<>(); //list of players for team-1
        playingTeam1List.add("P1");
        playingTeam1List.add("P2");
        playingTeam1List.add("P3");
        playingTeam1List.add("P4");
        playingTeam1List.add("P5");

        List<String> playingTeam2List = new ArrayList<>(); //list of players for team-1
        playingTeam2List.add("P6");
        playingTeam2List.add("P7");
        playingTeam2List.add("P8");
        playingTeam2List.add("P9");
        playingTeam2List.add("P10");


        //createRuns for team1 for two overs
        List<List<Integer>> runsOnBallsForTeam1 = new ArrayList<>();
        runsOnBallsForTeam1.add(Arrays.asList(1, 1, 1, 1, 1, 2));
        runsOnBallsForTeam1.add(Arrays.asList(1000, 4, 4, 1002, 1000, 1, 6));


        List<List<Integer>> runsOnBallsForTeam2 = new ArrayList<>();
        runsOnBallsForTeam2.add(Arrays.asList(4, 6, 1000, 1000, 1, 1));
        runsOnBallsForTeam2.add(Arrays.asList(6, 1, 1000, 1000));


        //create team Instance to play
        Overs overs = new Overs(noOfOvers);
        List<Players> playersListTeam1 = playingTeam1List.stream().map(x -> new Batter(x)).collect(Collectors.toList());

        List<Players> playersListTeam2 = playingTeam2List.stream().map(x -> new Batter(x)).collect(Collectors.toList());


        //create dummy bowler list
        List<Bowler> bowlers = Arrays.asList(new Bowler("bowler-1"), new Bowler("bowler-2"));
        Team team = new Team(teamName, playersListTeam1);
        Team oppositeTeam = new Team(oppTeamName, playersListTeam2);


        ScoreCardGenerator scoreCardGenerator = new ScoreCardGenerator();

        //Client starts play for Team1
        scoreCardGenerator.generateScoreCard(team, overs, playersListTeam1, runsOnBallsForTeam1, bowlers);

        //Client starts play for Team2

        scoreCardGenerator.generateScoreCard(oppositeTeam, overs, playersListTeam2, runsOnBallsForTeam2, bowlers);

        //Time to calculate Results
        ResultCalculationService resultCalculationService = new ResultCalculationService();
        resultCalculationService.calculateResults(team, oppositeTeam);


    }
}
