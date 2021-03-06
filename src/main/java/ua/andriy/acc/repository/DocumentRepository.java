package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Counterparty;
import ua.andriy.acc.entities.Document;

import java.util.Set;

/**
 * Created by andriy on 11/10/16.
 */
//@RepositoryRestResource(collectionResourceRel = "document", path = "document")
public interface DocumentRepository extends PagingAndSortingRepository<Document, Long> {

    public Set<Document> findByCounterparty(Counterparty Counterparty);
}
