package codeseek.test.manager.dto.request;

import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequestDto {
    @Positive
    private Long teamFromId;
    @Positive
    private Long teamToId;
    @Positive
    private Long playerId;
}
