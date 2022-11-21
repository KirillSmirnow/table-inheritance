package ti.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@ToString(callSuper = true)
public class MediaDocument extends Document {

    @NotNull
    private String mediaType;

    public MediaDocument(String owner, String mediaType) {
        super(owner);
        this.mediaType = mediaType;
    }
}
