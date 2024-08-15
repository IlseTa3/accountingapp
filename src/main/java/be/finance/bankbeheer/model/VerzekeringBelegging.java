package be.finance.bankbeheer.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Hier alles van verzekeringen zoals brand/woonst, wagen, afwasmachine
 * Ook spaarverzekering
 * Beleggen met je wisselgeld
 * Bolerogedeelte hoort hier NIET bij
 */

@Entity
@Table(name = "Verzekering_en_Belegging")
public class VerzekeringBelegging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datum;

    @Column(name = "naam_verzekering")
    private String naamVerzekering;

    private String verzekeringsnr;

    private float bedrag;

    @Enumerated(EnumType.STRING)
    private Betaalperiode betaalperiode;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getNaamVerzekering() {
        return naamVerzekering;
    }

    public void setNaamVerzekering(String naamVerzekering) {
        this.naamVerzekering = naamVerzekering;
    }

    public String getVerzekeringsnr() {
        return verzekeringsnr;
    }

    public void setVerzekeringsnr(String verzekeringsnr) {
        this.verzekeringsnr = verzekeringsnr;
    }

    public float getBedrag() {
        return bedrag;
    }

    public void setBedrag(float bedrag) {
        this.bedrag = bedrag;
    }

    public Betaalperiode getBetaalperiode() {
        return betaalperiode;
    }

    public void setBetaalperiode(Betaalperiode betaalperiode) {
        this.betaalperiode = betaalperiode;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
