package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by andriy on 11/13/16.
 */
@Entity
@Data
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contacts_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", nullable = false)
    private Counterparty counterparty;
    @Enumerated(EnumType.STRING)
    private ContactsTypeEnum type;

    private String values;
    private String Comments;

}
