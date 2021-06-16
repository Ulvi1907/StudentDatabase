package ga.alili.domain;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class Student {
    private long id;
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank
    @Size(min = 3, max = 20)
    private String surname;
    @Min(0)
    @Max(100)
    private int point;
}
