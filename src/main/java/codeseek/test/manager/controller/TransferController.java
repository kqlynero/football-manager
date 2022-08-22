package codeseek.test.manager.controller;

import codeseek.test.manager.dto.request.TransferRequestDto;
import codeseek.test.manager.dto.response.TransferResponseDto;
import codeseek.test.manager.mapper.impl.TransferMapper;
import codeseek.test.manager.service.TransferService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;
    private final TransferMapper transferMapper;

    @PutMapping
    public TransferResponseDto transfer(@RequestBody @Valid TransferRequestDto requestDto) {
        return transferMapper.toDto(transferService.transfer(transferMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public TransferResponseDto getById(@PathVariable Long id) {
        return transferMapper.toDto(transferService.getById(id));
    }
}



























//        TeamResponseDto teamFromDto = teamMapper.toDto(teamService.getById(teamFromId));
//        TeamResponseDto teamToDto = teamMapper.toDto(teamService.getById(teamToId));
//        PlayerResponseDto playerDto = playerMapper.toDto(playerService.getById(playerId));