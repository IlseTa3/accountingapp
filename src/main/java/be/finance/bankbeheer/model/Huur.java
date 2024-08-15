package be.finance.bankbeheer.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Hier komt alles van betalingen van huur: woning, wagen,...
 */
@Entity
public class Huur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datum;
    @Column(name = "soort_huur")
    private String soortHuur;

    @Enumerated(EnumType.ORDINAL)
    private Periode periode;
    private float bedrag;

    @Enumerated(EnumType.STRING)
    private SoortBetaling soortBetaling;

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

    public String getSoortHuur() {
        return soortHuur;
    }

    public void setSoortHuur(String soortHuur) {
        this.soortHuur = soortHuur;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
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
