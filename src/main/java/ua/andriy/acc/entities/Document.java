package ua.andriy.acc.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by andriy on 11/10/16.
 */
@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long document_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", nullable = false)
    private Counterparty counterparty;
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum type;
    private String number;
    private String series;
    private String registration;
    private Date dateIssue;
    private Date dateExpiration;
    private String Comments;

//    public Long getDocument_id() {
//        return document_id;
//    }
//
//    public void setDocument_id(Long document_id) {
//        this.document_id = document_id;
//    }
//
//    public Counterparty getCounterparty() {
//        return counterparty;
//    }
//
//    public void setCounterparty(Counterparty counterparty) {
//        this.counterparty = counterparty;
//    }
//
//    public DocumentTypeEnum getType() {
//        return type;
//    }
//
//    public void setType(DocumentTypeEnum type) {
//        this.type = type;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getSeries() {
//        return series;
//    }
//
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public String getRegistration() {
//        return registration;
//    }
//
//    public void setRegistration(String registration) {
//        this.registration = registration;
//    }
//
//    public Date getDateIssue() {
//        return dateIssue;
//    }
//
//    public void setDateIssue(Date dateIssue) {
//        this.dateIssue = dateIssue;
//    }
//
//    public Date getDateExpiration() {
//        return dateExpiration;
//    }
//
//    public void setDateExpiration(Date dateExpiration) {
//        this.dateExpiration = dateExpiration;
//    }
//
//    public String getComments() {
//        return Comments;
//    }
//
//    public void setComments(String comments) {
//        Comments = comments;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Document)) return false;
//
//        Document document = (Document) o;
//
//        if (!document_id.equals(document.document_id)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return document_id.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Document{" +
//                "document_id=" + document_id +
//                ", counterparty=" + counterparty +
//                ", type=" + type +
//                ", number='" + number + '\'' +
//                ", series='" + series + '\'' +
//                ", registration='" + registration + '\'' +
//                ", dateIssue=" + dateIssue +
//                ", dateExpiration=" + dateExpiration +
//                ", Comments='" + Comments + '\'' +
//                '}';
//    }
}
