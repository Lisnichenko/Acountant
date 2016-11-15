package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Counterparty;

/**
 * Created by andriy on 11/10/16.
 */
@RepositoryRestResource(collectionResourceRel = "counterparty", path = "counterparty")
public interface CounterpartyRepository extends PagingAndSortingRepository<Counterparty, Long> {
}
