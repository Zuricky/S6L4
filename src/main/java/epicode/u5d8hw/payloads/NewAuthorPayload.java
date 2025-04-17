package epicode.u5d8hw.payloads;

import jakarta.validation.constraints.*;

public class NewAuthorPayload {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email @NotBlank
    private String email;
    @Past @NotNull
    private String dateOfBirth;
}