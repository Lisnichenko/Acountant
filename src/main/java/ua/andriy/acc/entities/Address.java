package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by andriy on 11/13/16.
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", nullable = false)
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

}
