package kingict.airplanesearch.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class UserForm {

    @NotBlank
    @Size(min=3)
    String firstname;
    @NotBlank
    @Size(min=3)
    String lastname;
    @NotBlank
    @Size(min=3)
    String password;
}
