import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> teamsEven = new ArrayList<>();
        Collections.addAll(teamsEven, "Galatasaray", "Bursaspor", "Fenerbahçe", "Beşiktaş", "Başakşehir", "Trabzonspor");

        List<String> teamsOdd = new ArrayList<>();
        Collections.addAll(teamsOdd, "Galatasaray", "Bursaspor", "Fenerbahçe", "Beşiktaş", "Başakşehir", "Bursaspor", "Boluspor");


        if (teamsOdd.size() % 2 != 0) {
            teamsOdd.add("Bay");
        }


        Collections.shuffle(teamsEven);
        Collections.shuffle(teamsOdd);


        generateFixture(teamsEven);

        System.out.println("\n-----------------------------\n");


        generateFixture(teamsOdd);
    }

    private static void generateFixture(List<String> teams) {
        int rounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round + "\n");

            for (int i = 0; i < matchesPerRound; i++) {
                String team1 = teams.get(i);
                String team2 = teams.get(teams.size() - 1 - i);

                System.out.println(team1 + " vs " + team2);
            }
            
            rotateTeams(teams);

            System.out.println();
        }
    }

    private static void rotateTeams(List<String> teams) {
        String lastTeam = teams.remove(teams.size() - 1);
        teams.add(1, lastTeam);
    }
}