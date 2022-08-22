package codeseek.test.manager.controller;

import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import codeseek.test.manager.service.PlayerService;
import codeseek.test.manager.service.TeamService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final TeamService teamService;
    private final PlayerService playerService;

    public InjectController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("/inject")
    public String inject() {
        Player player1 = new Player();
        player1.setFirstName("Antony");
        player1.setLastName("Martial");
        player1.setAge(30);
        player1.setExperience(100);
        playerService.save(player1);
        Player pLayer2 = new Player();
        pLayer2.setFirstName("Lionel");
        pLayer2.setLastName("Messi");
        pLayer2.setAge(29);
        pLayer2.setExperience(160);
        playerService.save(pLayer2);
        Player player3 = new Player();
        player3.setFirstName("Manuel");
        player3.setLastName("Pelle");
        player3.setAge(23);
        player3.setExperience(24);
        playerService.save(player3);
        Player player4 = new Player();
        player4.setFirstName("Luis");
        player4.setLastName("Suarez");
        player4.setAge(34);
        player4.setExperience(124);
        playerService.save(player4);
        Player player5 = new Player();
        player5.setFirstName("Muhammed");
        player5.setLastName("Salah");
        player5.setAge(21);
        player5.setExperience(15);
        playerService.save(player5);
        Player player6 = new Player();
        player6.setFirstName("Oleksandr");
        player6.setLastName("Zinchenko");
        player6.setAge(27);
        player6.setExperience(74);
        playerService.save(player6);
        Player player7 = new Player();
        player7.setFirstName("Andriy");
        player7.setLastName("Yarmolenko");
        player7.setAge(30);
        player7.setExperience(90);
        playerService.save(player7);
        Player player8 = new Player();
        player8.setFirstName("Raul");
        player8.setLastName("Jimenez");
        player8.setAge(18);
        player8.setExperience(6);
        playerService.save(player8);
        Team team1 = new Team();
        team1.setName("Barcelona");
        team1.setCommission(5);
        team1.setBudget(10_000_000L);
        team1.setPlayers(new ArrayList<>(List.of(player1, player4)));
        teamService.save(team1);
        Team team2 = new Team();
        team2.setName("Real Madrid");
        team2.setCommission(7);
        team2.setBudget(10_000_000_000L);
        team2.setPlayers(new ArrayList<>(List.of(player3, pLayer2,player8)));
        teamService.save(team2);
        Team team3 = new Team();
        team3.setName("Liverpool");
        team3.setCommission(0);
        team3.setBudget(1_000_000L);
        team3.setPlayers(new ArrayList<>(List.of(player7,player6,player5)));
        teamService.save(team3);
        return "Injected";
    }
}
