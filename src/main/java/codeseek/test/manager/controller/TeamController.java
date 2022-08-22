package codeseek.test.manager.controller;

import codeseek.test.manager.dto.request.TeamRequestDto;
import codeseek.test.manager.dto.response.TeamResponseDto;
import codeseek.test.manager.mapper.impl.TeamMapper;
import codeseek.test.manager.model.Team;
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
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @PostMapping
    public TeamResponseDto save(@RequestBody @Valid TeamRequestDto requestDto) {
        return teamMapper.toDto(teamService.save(teamMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public TeamResponseDto getById(@PathVariable Long id) {
        return teamMapper.toDto(teamService.getById(id));
    }

    @GetMapping
    public List<TeamResponseDto> findAll() {
        return teamService.findAll().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid TeamRequestDto requestDto) {
        Team team = teamMapper.toModel(requestDto);
        team.setId(id);
        return teamMapper.toDto(teamService.save(team));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}
