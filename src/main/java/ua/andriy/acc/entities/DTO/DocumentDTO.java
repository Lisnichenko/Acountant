package ua.andriy.acc.entities.DTO;

import lombok.Data;
import ua.andriy.acc.entities.Enums.DocumentTypeEnum;

import java.sql.Date;

/**
 * Created by andriy on 11/30/16.
 */
@Data
public class DocumentDTO {
    private DocumentTypeEnum type;
    private String number;
    private String series;
    private String registration;
    private Date dateIssue;
    private Date dateExpiration;
    private String Comments;
}
