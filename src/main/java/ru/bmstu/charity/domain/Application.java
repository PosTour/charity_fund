package ru.bmstu.charity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String createdAt;

    public Application(Service service, Client client, String details, String createdAt) {
        this.service = service;
        this.client = client;
        this.details = details;
        this.createdAt = createdAt;
    }
}
