package be.finance.bankbeheer.model;

import jakarta.persistence.*;

import java.time.LocalDate;


/**
 * Alles wat te maken heeft met voedsel: winkelbezoeken zoals Carrefour, Colruyt
 * maar ook takeaway zoals Takeaway.com of Pizza Hut
 * HelloFresh
 * Couvert (vlees)
 */

@Entity
public class Voedselgroepen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datum_aankoop")
    private LocalDate datumAankoop;
    @Column(name = "naam_winkel")
    private String naamWinkel;
    private float bedrag;

    //met wat heb je je verrichtingen betaald? cash? bcc? overschrijving? ...
    @Enumerated(EnumType.STRING)
    private SoortBetaling soortBetaling;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatumAankoop() {
        return datumAankoop;
    }

    public void setDatumAankoop(LocalDate datumAankoop) {
        this.datumAankoop = datumAankoop;
    }

    public String getNaamWinkel() {
        return naamWinkel;
    }

    public void setNaamWinkel(String naamWinkel) {
        this.naamWinkel = naamWinkel;
    }

    public float getBedrag() {
        return bedrag;
    }

    public void setBedrag(float bedrag) {
        this.bedrag = bedrag;
    }

    public SoortBetaling getSoortBetaling() {
        return soortBetaling;
    }

    public void setSoortBetaling(SoortBetaling soortBetaling) {
        this.soortBetaling = soortBetaling;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
