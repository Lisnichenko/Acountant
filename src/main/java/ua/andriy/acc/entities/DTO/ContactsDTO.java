package ua.andriy.acc.entities.DTO;

import lombok.Data;
import ua.andriy.acc.entities.Enums.ContactsTypeEnum;

/**
 * Created by andriy on 11/30/16.
 */
@Data
public class ContactsDTO {
    private ContactsTypeEnum type;
    private String values;
    private String Comments;
}
