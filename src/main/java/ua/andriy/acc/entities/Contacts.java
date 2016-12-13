package ua.andriy.acc.entities;

import lombok.Data;
import ua.andriy.acc.entities.Enums.ContactsTypeEnum;

import javax.persistence.*;

/**
 * Created by andriy on 11/13/16.
 */
@Entity
@Data
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterpartyId", nullable = false)
    private Counterparty counterparty;
    @Enumerated(EnumType.STRING)
    private ContactsTypeEnum type;

    private String values, comments;

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }
}
