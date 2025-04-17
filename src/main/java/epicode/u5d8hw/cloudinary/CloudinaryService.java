package epicode.u5d8hw.cloudinary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public String upload(MultipartFile file, String folder) {
        try {
            @SuppressWarnings("unchecked")
            Map<String,?> result = cloudinary.uploader()
                    .upload(file.getBytes(),
                            ObjectUtils.asMap("folder", folder,
                                    "public_id", file.getOriginalFilename()));
            return result.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Upload fallito", e);
        }
    }
}
