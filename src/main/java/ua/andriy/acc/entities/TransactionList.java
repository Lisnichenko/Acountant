package ua.andriy.acc.entities;

import lombok.Data;
import ua.andriy.acc.entities.Enums.TransactionTypeEnum;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by andriy on 11/14/16.
 */
@Entity
@Data
public class TransactionList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;
    private String status;

    private Long counterpatyIdFrom;
    private Long counterpatyIdTo;

    private String accountFrom;
    private String accountTo;

    private Date trDate;
    private Double price;
    private String description;
    private String eBankReference;

}
