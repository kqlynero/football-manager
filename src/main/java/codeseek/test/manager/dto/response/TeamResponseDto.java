package codeseek.test.manager.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponseDto {
    private Long id;
    private String name;
    private List<Long> players_id;
    private Integer commission;
    private Long budget;
}
