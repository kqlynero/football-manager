package codeseek.test.manager.controller;

import codeseek.test.manager.dto.request.PlayerRequestDto;
import codeseek.test.manager.dto.response.PlayerResponseDto;
import codeseek.test.manager.mapper.impl.PlayerMapper;
import codeseek.test.manager.mapper.impl.TeamMapper;
import codeseek.test.manager.model.Player;
import codeseek.test.manager.service.PlayerService;
import codeseek.test.manager.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;
    private final TeamMapper teamMapper;

    @PostMapping
    public PlayerResponseDto save(@RequestBody @Valid PlayerRequestDto requestDto) {
        return playerMapper.toDto(playerService.save(playerMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public PlayerResponseDto getById(@PathVariable Long id) {
        return playerMapper.toDto(playerService.getById(id));
    }

    @GetMapping()
    public List<PlayerResponseDto> findAll() {
        return playerService.findAll().stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/team/{id}")
    public List<PlayerResponseDto> findAllByTeam (@PathVariable Long id) {
        List<Player> players = teamService.getById(id).getPlayers();
        return players.stream().map(playerMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid PlayerRequestDto requestDto) {
        Player player = playerMapper.toModel(requestDto);
        player.setId(id);
        return playerMapper.toDto(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        playerService.deleteById(id);
    }
}
