package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by andriy on 12/15/16.
 */
@Entity
@Data
public class SalarySettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float defaultSalary;
    private Integer avanceDay;
    private Integer salaryDay;
    private Integer taxRateESV;
    private Integer taxRatePencia;
    private Integer taxRateVSU;
    private Date issue;
    private Date expiration;

}
