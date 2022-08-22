package codeseek.test.manager.service;

import codeseek.test.manager.model.Team;
import java.util.List;

public interface TeamService {
    Team save(Team team);

    List<Team> findAll();

    Team getById(Long id);

    void deleteById(Long id);
}
