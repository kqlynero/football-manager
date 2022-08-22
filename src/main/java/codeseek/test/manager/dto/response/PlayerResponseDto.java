package codeseek.test.manager.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer experience;
}
