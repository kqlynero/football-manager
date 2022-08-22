package codeseek.test.manager.mapper.impl;

import codeseek.test.manager.dto.request.TransferRequestDto;
import codeseek.test.manager.dto.response.TransferResponseDto;
import codeseek.test.manager.mapper.Mapper;
import codeseek.test.manager.model.Transfer;
import codeseek.test.manager.service.PlayerService;
import codeseek.test.manager.service.TeamService;
import codeseek.test.manager.service.TransferService;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper implements Mapper<TransferRequestDto, TransferResponseDto, Transfer> {
    private final TransferService transferService;
    private final TeamService teamService;
    private final PlayerService playerService;

    public TransferMapper(TransferService transferService, TeamService teamService, PlayerService playerService) {
        this.transferService = transferService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Override
    public TransferResponseDto toDto(Transfer transfer) {
        TransferResponseDto responseDto = new TransferResponseDto();
        responseDto.setId(transfer.getId());
        responseDto.setTeamFromId(transfer.getTeamFrom().getId());
        responseDto.setTeamToId(transfer.getTeamTo().getId());
        responseDto.setPlayerId(transfer.getPlayer().getId());
        return responseDto;
    }

    @Override
    public Transfer toModel(TransferRequestDto requestDto) {
        Transfer transfer = new Transfer();
        transfer.setTeamFrom(teamService.getById(requestDto.getTeamFromId()));
        transfer.setTeamTo(teamService.getById(requestDto.getTeamToId()));
        transfer.setPlayer(playerService.getById(requestDto.getPlayerId()));
        return transfer;
    }
}
