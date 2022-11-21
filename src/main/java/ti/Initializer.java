package ti;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ti.model.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.IntStream.range;

@Component
@RequiredArgsConstructor
public class Initializer {

    private static final List<String> USERS = List.of("Nicola", "Boris", "Anna");

    private final DocumentRepository documentRepository;
    private final TextDocumentRepository textDocumentRepository;
    private final MediaDocumentRepository mediaDocumentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void setUp() {
        documentRepository.saveAll(range(0, 100_000).mapToObj($ -> {
            var owner = USERS.get(ThreadLocalRandom.current().nextInt(USERS.size()));
            if (ThreadLocalRandom.current().nextBoolean()) {
                return new TextDocument(owner, "Name", "Description");
            }
            return new MediaDocument(owner, "image/jpg");
        }).toList());
        System.out.format(
                "%d text docs & %d media docs inserted\n",
                textDocumentRepository.count(),
                mediaDocumentRepository.count()
        );
    }
}
