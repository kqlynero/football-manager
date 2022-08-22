package codeseek.test.manager.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Max(50)
    private Integer age;
    private Integer experience;
}
