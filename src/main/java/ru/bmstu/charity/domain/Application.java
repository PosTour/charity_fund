package ru.bmstu.charity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "application")
@NoArgsConstructor
@Getter
@Setter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "fund_id", referencedColumnName = "id")
    private Fund fund;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "details")
    private String details;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    public Application(Service service, Client client, Fund fund, String details, Date createdAt) {
        this.service = service;
        this.client = client;
        this.fund = fund;
        this.details = details;
        this.createdAt = createdAt;
    }

    public String getStatus() {
        if (isApproved == null) {
            return "Рассматривается";
        }
        if (isApproved) {
            return "Одобрена";
        } else {
            return "Отклонена";
        }
    }
}
