package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Contacts;

/**
 * Created by andriy on 11/13/16.
 */
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long> {
}
