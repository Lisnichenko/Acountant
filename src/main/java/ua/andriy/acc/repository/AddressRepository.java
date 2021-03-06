package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.andriy.acc.entities.Address;
import ua.andriy.acc.entities.Counterparty;


import java.util.Set;

/**
 * Created by andriy on 11/13/16.
 */
//@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    public Set<Address> findByCounterparty(Counterparty Counterparty);
}
