package com.db.assignment.Trade.Store.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "trades")
@NamedQueries({
        @NamedQuery(name = "Trades.findAll", query = "select t from Trades t")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trades {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Trade_Id")
    private String tradeId;

    @Column(name = "Version")
    @NotNull
    private int version;

    @Column(name = "Counter_Party_Id")
    @NotNull
    private String counterPartyId;

    @Column(name = "Book_id")
    @NotNull
    private String bookId;

    @Column(name = "Maturity_Date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private Date maturityDate;


    @Column(name = "created_Date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private Date createdDate;

    @Column(name = "Expired")
    @NotNull
    private char expired;
}
