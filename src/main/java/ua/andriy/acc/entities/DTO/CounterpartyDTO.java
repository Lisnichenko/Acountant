package ua.andriy.acc.entities.DTO;

import lombok.*;
import ua.andriy.acc.entities.Enums.CounterpartyStatusEnum;
import ua.andriy.acc.entities.Enums.CounterpartyTypeEnum;

/**
 * Created by andriy on 11/30/16.
 */
@Data
public class CounterpartyDTO {

    private Long counterpartyId;
    private CounterpartyTypeEnum type;
    private CounterpartyStatusEnum status;
    private String shortName;
    private String name;
    private String regNumber;
    //private String subType;
    //private String mainCounterpartyName;


    public CounterpartyDTO(Long counterpartyId,
                           CounterpartyTypeEnum type,
                           CounterpartyStatusEnum status,
                           String shortName,
                           String regNumber) {
        this.counterpartyId = counterpartyId;
        this.type = type;
        this.status = status;
        this.shortName = shortName;
        this.regNumber = regNumber;
    }

    public CounterpartyDTO(Long counterpartyId, String name) {
        this.counterpartyId = counterpartyId;
        this.name = name;
    }
}
