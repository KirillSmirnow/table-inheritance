package ti.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TextDocumentRepository extends JpaRepository<TextDocument, UUID> {
}
