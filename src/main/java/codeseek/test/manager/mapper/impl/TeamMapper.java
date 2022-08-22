package codeseek.test.manager.mapper.impl;

import codeseek.test.manager.dto.request.TeamRequestDto;
import codeseek.test.manager.dto.response.TeamResponseDto;
import codeseek.test.manager.mapper.Mapper;
import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import codeseek.test.manager.service.PlayerService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper implements Mapper<TeamRequestDto, TeamResponseDto, Team> {
    private final PlayerService playerService;

    public TeamMapper(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public TeamResponseDto toDto(Team team) {
        TeamResponseDto responseDto = new TeamResponseDto();
        responseDto.setId(team.getId());
        responseDto.setName(team.getName());
        responseDto.setPlayers_id(team.getPlayers().stream()
                .map(Player::getId)
                .collect(Collectors.toList()));
        responseDto.setBudget(team.getBudget());
        responseDto.setCommission(team.getCommission());
        return responseDto;
    }

    @Override
    public Team toModel(TeamRequestDto requestDto) {
        Team team = new Team();
        team.setName(requestDto.getName());
        team.setPlayers(playerService.findAllByTeam(team));
        team.setBudget(requestDto.getBudget());
        team.setCommission(requestDto.getCommission());
        return team;
    }
}
