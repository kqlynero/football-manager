package codeseek.test.manager.service.impl;

import codeseek.test.manager.model.Team;
import codeseek.test.manager.repository.TeamRepository;
import codeseek.test.manager.service.PlayerService;
import codeseek.test.manager.service.TeamService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;
    private final PlayerService playerService;

    public TeamServiceImpl(TeamRepository repository, PlayerService playerService) {
        this.repository = repository;
        this.playerService = playerService;
    }

    @Override
    public Team save(Team team) {
        return repository.save(team);
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Team getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
