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
    private Long financeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterpartyId", nullable = false)
    private Counterparty counterparty;

    private String account, bankNameShortly, mfi;

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }
}