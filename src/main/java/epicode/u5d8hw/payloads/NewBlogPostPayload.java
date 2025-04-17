package epicode.u5d8hw.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class NewBlogPostPayload {
    @NotNull @Positive
    private int authorId;
    @NotBlank
    private String category;
    @NotBlank @Size(min = 10)
    private String content;
    @Positive
    private double readingTime;
    @NotBlank @Size(min = 5, max = 100)
    private String title;
}
