package ua.andriy.acc.entities.DTO;

import lombok.Data;
import ua.andriy.acc.entities.Enums.AddressTypeEnum;

/**
 * Created by andriy on 11/30/16.
 */
@Data
public class AddressDTO {
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
