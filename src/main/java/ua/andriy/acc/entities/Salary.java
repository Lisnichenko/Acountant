package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by andriy on 11/14/16.
 */
@Entity
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salaryId;

    //filled in service class any hard relations on db level.
    private Long counterpartyId;
    private Date dateCulcSalary;
    private boolean isCash;
    private Integer avansProcent;
    private Float salary;

}
