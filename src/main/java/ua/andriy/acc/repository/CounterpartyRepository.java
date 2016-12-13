package ua.andriy.acc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ua.andriy.acc.entities.Counterparty;
import ua.andriy.acc.entities.DTO.CounterpartyDTO;
import ua.andriy.acc.entities.Enums.CounterpartyStatusEnum;
import ua.andriy.acc.entities.Enums.CounterpartySubTypeEnum;

import java.util.Set;

/**
 * Created by andriy on 11/10/16.
 */
//@RepositoryRestResource(collectionResourceRel = "counterparty", path = "counterparty")
public interface CounterpartyRepository extends PagingAndSortingRepository<Counterparty, Long> {

    public Set<Counterparty> findByStatus(CounterpartyStatusEnum status);

    //Spring Data JPA Mapping result to DTO
    // mines is next - fixed field must be pointed and after modification DTO Object we need fix it there
//    @Query(value = "select new ua.andriy.acc.entities.DTO.CounterpartyDTO(c.counterpartyId, c.type,c.status,c.shortName, c.regNumber) from ua.andriy.acc.entities.Counterparty c")
//    public Set<CounterpartyDTO> findByCounterpartyShortList();

    @Query("select new ua.andriy.acc.entities.DTO.CounterpartyDTO(c.counterpartyId, c.ownership + c.name + c.shortName as name) from ua.andriy.acc.entities.Counterparty c where c.status = :status and c.subType = :subType")
    public Set<CounterpartyDTO> findByCounterpartyForDropBox(CounterpartyStatusEnum status , CounterpartySubTypeEnum subType);
    
}
