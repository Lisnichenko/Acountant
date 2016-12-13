package ua.andriy.acc.entities;

import lombok.Data;
import ua.andriy.acc.entities.Enums.DocumentTypeEnum;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by andriy on 11/10/16.
 */
@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterpartyId", nullable = false)
    private Counterparty counterparty;
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum type;
    private String number;
    private String series;
    private String registration;
    private Date dateIssue;
    private Date dateExpiration;
    private String comments;

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }
}
