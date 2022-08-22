package codeseek.test.manager.service.impl;

import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import codeseek.test.manager.repository.PlayerRepository;
import codeseek.test.manager.service.PlayerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAllByTeam(Team team) {
        return repository.findAllByTeam(team);
    }

    @Override
    public Player getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public long countPrice(Player player) {
        int experience = player.getExperience();
        int age = player.getAge();
        return experience * 100000L / age;
    }
}
