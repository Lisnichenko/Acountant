package ua.andriy.acc.entities.DTO;

import lombok.Data;

import java.sql.Date;

/**
 * Created by andriy on 11/30/16.
 */
@Data
public class SalaryDTO {
    private Long counterpartyId;
    private Date dateCulcSalary;
    private boolean isCash;
    private Integer avansProcent;
    private Float salary;
}
