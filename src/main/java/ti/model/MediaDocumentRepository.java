package ti.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaDocumentRepository extends JpaRepository<MediaDocument, UUID> {
}
