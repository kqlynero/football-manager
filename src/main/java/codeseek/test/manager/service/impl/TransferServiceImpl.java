package codeseek.test.manager.service.impl;

import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import codeseek.test.manager.model.Transfer;
import codeseek.test.manager.repository.PlayerRepository;
import codeseek.test.manager.repository.TeamRepository;
import codeseek.test.manager.repository.TransferRepository;
import codeseek.test.manager.service.PlayerService;
import codeseek.test.manager.service.TeamService;
import codeseek.test.manager.service.TransferService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final TransferRepository repository;
    private final PlayerService playerService;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TransferServiceImpl(TransferRepository repository, PlayerService playerService, TeamService teamService, TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.repository = repository;
        this.playerService = playerService;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Transfer save(Transfer transfer) {
        return repository.save(transfer);
    }

    @Override
    public List<Transfer> findAll() {
        return repository.findAll();
    }

    @Override
    public Transfer getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Transfer transfer(Transfer transfer) {
        Team teamFrom = transfer.getTeamFrom();
        Team teamTo = transfer.getTeamTo();
        Player player = transfer.getPlayer();
        teamFrom.removePlayer(player);
        teamFrom.setBudget(teamFrom.getBudget() - countTransferPrice(teamFrom, player));
        teamRepository.save(teamFrom);
        teamTo.addPlayer(player);
        teamTo.setBudget(teamTo.getBudget() - countTransferPrice(teamTo, player));
        teamRepository.save(teamTo);
        return repository.save(transfer);
    }

    private long countTransferPrice(Team team, Player player) {
        return playerService.countPrice(player)
                - playerService.countPrice(player)
                * team.getCommission() / 100;
    }
}
