package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Counterparty;
import ua.andriy.acc.entities.Finance;

import java.util.Set;

/**
 * Created by andriy on 11/13/16.
 */
//@RepositoryRestResource(collectionResourceRel = "finance", path = "finance")
public interface FinanceRepository extends PagingAndSortingRepository<Finance, Long> {

    public Set<Finance> findByCounterparty(Counterparty Counterparty);
}
