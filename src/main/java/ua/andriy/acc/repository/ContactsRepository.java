package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Address;
import ua.andriy.acc.entities.Contacts;
import ua.andriy.acc.entities.Counterparty;

import java.util.Set;

/**
 * Created by andriy on 11/13/16.
 */
//@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long> {

    public Set<Contacts> findByCounterparty(Counterparty Counterparty);
}
