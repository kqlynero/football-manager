package codeseek.test.manager.dto.request;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequestDto {
    @NotNull
    private String name;
    @Positive
    private List<Long> playersId;
    @Min(0)
    @Max(10)
    private Integer commission;
    @Positive
    private Long budget;
}
