package ti;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ti.model.Document;
import ti.model.DocumentRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final EntityManager entityManager;

    @GetMapping("/documents/{id}")
    public Document getById(@PathVariable UUID id) {
        return documentRepository.findById(id).orElseThrow();
    }

    @GetMapping("/documents/search")
    public List<Document> search(String owner, int offset, int maxResults) {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(Document.class);
        var document = query.from(Document.class);
        query.where(
                builder.equal(document.get("owner"), owner)
        ).orderBy(
                builder.desc(document.get("createdAt"))
        );
        return entityManager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(maxResults)
                .getResultList();
    }
}
