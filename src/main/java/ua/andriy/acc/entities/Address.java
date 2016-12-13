package ua.andriy.acc.entities;

import lombok.Data;
import ua.andriy.acc.entities.Enums.AddressTypeEnum;

import javax.persistence.*;

/**
 * Created by andriy on 11/13/16.
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterpartyId", nullable = false)
    private Counterparty counterparty;
    @Enumerated(EnumType.STRING)
    private AddressTypeEnum type;

    private String zipCode;
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String apartment;

    private String fullAddress;

    private String Comments;

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }
}
