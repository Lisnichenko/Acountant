package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.andriy.acc.entities.Counterparty;
import ua.andriy.acc.entities.Salary;

import java.util.Set;

/**
 * Created by andriy on 12/10/16.
 */
public interface SalaryRepository extends PagingAndSortingRepository<Salary, Long> {

    public Set<Salary> findByCounterpartyId(Long id);
}
