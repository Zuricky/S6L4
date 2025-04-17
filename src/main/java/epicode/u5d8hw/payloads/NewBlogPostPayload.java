package epicode.u5d8hw.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class NewBlogPostPayload {
    @NonNull @Positive
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
