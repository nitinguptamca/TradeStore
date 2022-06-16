package com.db.assignment.Trade.Store.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "trades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trades {

    @Id()
    @Column(name = "Trade_Id")
    private String id;

    @Column(name = "Version", updatable = false)
    @NotNull
    private int Version;

    @Column(name = "Counter_Party_Id", updatable = false)
    @NotNull
    private String CounterPartyId;

    @Column(name = "Book_id", updatable = false)
    @NotNull
    private String bookId;

    @Column(name = "Maturity_Date", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    @NotNull
    private Date MaturityDate;


    @Column(name = "created_Date", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    @NotNull
    private Date createdDate;

    @Column(name = "Expired")
    @NotNull
    private char expired;
}
