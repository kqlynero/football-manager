package codeseek.test.manager.service;

import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import java.util.List;

public interface PlayerService {
    Player save(Player player);

    Player getById(Long id);

    List<Player> findAll();

    List<Player> findAllByTeam(Team team);

    void deleteById(Long id);

    long countPrice(Player player);
}
