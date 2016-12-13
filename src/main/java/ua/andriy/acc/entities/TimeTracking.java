package ua.andriy.acc.entities;

import lombok.Data;
import ua.andriy.acc.entities.Enums.TimeTrackingTypeEnum;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by andriy on 11/14/16.
 */
@Entity
@Data
public class TimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ttId;
    //filled in service class any hard relations on db level.
    private Long counterpartyId;

    private Date dateFrom;
    private Date dateTo;
    @Enumerated(EnumType.STRING)
    private TimeTrackingTypeEnum reason;
    private String comments;

}
