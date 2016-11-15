package ua.andriy.acc.entities;


import lombok.*;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by andriy on 11/10/16.
 */
@Entity
@ToString
public class Counterparty {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "counterparty_id",nullable = false)
    private Long counterparty_id;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private CounterpartyTypeEnum type;
    @Getter @Setter
    private String name;

    //for type.PERSON and type.FOP - it is filled like surname
    @Getter @Setter
    private String ownership;

    //for type.PERSON and type.FOP - it is filled like middleName
    @Getter @Setter
    private String shortName;

    // INN or ERDPOU 10 or 8 symbols
    @Getter @Setter
    private String regNumber;
    //INN for those who have ERDPOU
    @Getter @Setter
    private String taxNumber;
    @Getter @Setter
    private Boolean isTaxpayer;
    @Getter @Setter
    private String taxpayerLicenseNumber;
    @Getter @Setter
    private Long mainCounterparty;
    //Todo: Enum on status for Counterparty
    //@Enumerated(EnumType.STRING)
    @Getter @Setter
    private String status;
    @Getter @Setter
    private Date lastStatus;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    private Set<Document> documents = new HashSet<Document>();

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    private Set<Address> address = new HashSet<Address>();

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    private Set<Contacts> contacts = new HashSet<Contacts>();

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    private Set<Finance> finances = new HashSet<Finance>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counterparty)) return false;

        Counterparty that = (Counterparty) o;

        if (!counterparty_id.equals(that.counterparty_id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return counterparty_id.hashCode();
    }
}