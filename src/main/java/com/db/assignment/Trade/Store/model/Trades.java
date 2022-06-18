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
    private int version;

    @Column(name = "Counter_Party_Id", updatable = false)
    @NotNull
    private String counterPartyId;

    @Column(name = "Book_id", updatable = false)
    @NotNull
    private String bookId;

    @Column(name = "Maturity_Date", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private Date maturityDate;


    @Column(name = "created_Date", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private Date createdDate;

    @Column(name = "Expired")
    @NotNull
    private char expired;
}
