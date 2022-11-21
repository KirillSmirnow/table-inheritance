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
public class TextDocument extends Document {

    @NotNull
    private String name;

    private String description;

    public TextDocument(String owner, String name, String description) {
        super(owner);
        this.name = name;
        this.description = description;
    }
}
