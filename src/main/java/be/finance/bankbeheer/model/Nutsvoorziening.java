package be.finance.bankbeheer.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Alle leveranciers van nutsvoorzieningen: water, gas, electriciteit, telecom, ...
 */
@Entity
public class Nutsvoorziening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datum;

    @Enumerated(EnumType.ORDINAL)
    private Periode periode;

    @Column(name = "naam_bedrijf")
    private String naamBedrijf;
    @Enumerated(EnumType.STRING)
    private SoortNutsvoorziening soortNutsvoorziening;
    private String klantnummer;
    private String apparaatNr;
    private float bedrag;
    @Enumerated(EnumType.STRING)
    private Betaalperiode betaalperiode;

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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public String getNaamBedrijf() {
        return naamBedrijf;
    }

    public void setNaamBedrijf(String naamBedrijf) {
        this.naamBedrijf = naamBedrijf;
    }

    public SoortNutsvoorziening getSoortNutsvoorziening() {
        return soortNutsvoorziening;
    }

    public void setSoortNutsvoorziening(SoortNutsvoorziening soortNutsvoorziening) {
        this.soortNutsvoorziening = soortNutsvoorziening;
    }

    public String getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(String klantnummer) {
        this.klantnummer = klantnummer;
    }

    public String getApparaatNr() {
        return apparaatNr;
    }

    public void setApparaatNr(String apparaatNr) {
        this.apparaatNr = apparaatNr;
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
