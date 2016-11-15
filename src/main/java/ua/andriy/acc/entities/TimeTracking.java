package ua.andriy.acc.entities;

import lombok.Data;

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
    private Long tt_id;
    //filled in service class any hard relations on db level.
    private Long counterparty_id;

    private Date date_from;
    private Date date_to;
    @Enumerated(EnumType.STRING)
    private TimeTrackingTypeEnum reason;
    private String comments;

}
