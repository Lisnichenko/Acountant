package ua.andriy.acc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.andriy.acc.entities.SalarySettings;

/**
 * Created by andriy on 12/22/16.
 */
public interface SalarySettingsRepository extends PagingAndSortingRepository<SalarySettings, Long> {
}
