package codeseek.test.manager.mapper.impl;

import codeseek.test.manager.dto.request.PlayerRequestDto;
import codeseek.test.manager.dto.response.PlayerResponseDto;
import codeseek.test.manager.mapper.Mapper;
import codeseek.test.manager.model.Player;
import codeseek.test.manager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper implements Mapper<PlayerRequestDto, PlayerResponseDto, Player> {
    private final TeamService teamService;

    public PlayerMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto responseDto = new PlayerResponseDto();
        responseDto.setId(player.getId());
        responseDto.setFirstName(player.getFirstName());
        responseDto.setLastName(player.getLastName());
        responseDto.setAge(player.getAge());
        responseDto.setExperience(player.getExperience());
        return responseDto;
    }

    @Override
    public Player toModel(PlayerRequestDto requestDto) {
        Player player = new Player();
        player.setFirstName(requestDto.getFirstName());
        player.setLastName(requestDto.getLastName());
        player.setAge(requestDto.getAge());
        player.setExperience(requestDto.getExperience());
        return player;
    }
}
