package codeseek.test.manager.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferResponseDto {
    private Long id;
    private Long teamFromId;
    private Long teamToId;
    private Long playerId;
}
