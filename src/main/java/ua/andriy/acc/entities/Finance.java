package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by andriy on 11/13/16.
 */
@Entity
@Data
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long finance_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", nullable = false)
    private Counterparty counterparty;

    private String account;
    private String bankNameShortly;
    //ru - MFO
    private String mfi;
}
