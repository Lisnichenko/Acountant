package ua.andriy.acc.entities;


import lombok.*;
import ua.andriy.acc.entities.Enums.CounterpartyStatusEnum;
import ua.andriy.acc.entities.Enums.CounterpartySubTypeEnum;
import ua.andriy.acc.entities.Enums.CounterpartyTypeEnum;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by andriy on 11/10/16.
 */
@Entity
@ToString
public class Counterparty {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "counterpartyId",nullable = false)
    private Long counterpartyId;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private CounterpartyTypeEnum type;
    @Getter @Setter
    private String name;

    // like  Employee, Customer, Owner, Contractor
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private CounterpartySubTypeEnum subType;

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
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private CounterpartyStatusEnum status;

    @Getter
    private Date lastStatus;

    public void setLastStatus(Date lastStatus) { this.lastStatus = lastStatus; }

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

    public Long getCounterpartyId() {
        return counterpartyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counterparty)) return false;

        Counterparty that = (Counterparty) o;

        if (!counterpartyId.equals(that.counterpartyId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
    return (counterpartyId == null ? 0 : counterpartyId.intValue());
    }
}