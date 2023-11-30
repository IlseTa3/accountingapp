package be.finance.bankbeheer.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Hier komen alle gegevens die op de bankrekening verschijnen
 * Zowel betalingen als inkomsten
 * Linken met Huur, Nutsvoorziening, OverigeBetaling, Voedselgroepen, VerzekeringBelegging
 * Bank kan verschillende bovenstaande soorten betalingen hebben
 * er kan maar 1 betaling per soort plaatsvinden
 * OneToMany - ManyToOne
 */

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy ="bank",cascade = CascadeType.ALL)
    private List<Huur> huur;

    @OneToMany(mappedBy ="bank",cascade =CascadeType.ALL)
    private List<Nutsvoorziening> nutsvoorzieningen;

    @OneToMany(mappedBy ="bank",cascade = CascadeType.ALL)
    private List<Voedselgroepen> voedselgroepens;

    @OneToMany(mappedBy ="bank",cascade = CascadeType.ALL)
    private List<VerzekeringBelegging> verzekeringBeleggingen;

    @OneToMany(mappedBy ="bank",cascade = CascadeType.ALL)
    private List<OverigeBetaling> overigeBetalingen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Huur> getHuur() {
        return huur;
    }

    public void setHuur(List<Huur> huur) {
        this.huur = huur;
    }

    public List<Nutsvoorziening> getNutsvoorzieningen() {
        return nutsvoorzieningen;
    }

    public void setNutsvoorzieningen(List<Nutsvoorziening> nutsvoorzieningen) {
        this.nutsvoorzieningen = nutsvoorzieningen;
    }

    public List<Voedselgroepen> getVoedselgroepens() {
        return voedselgroepens;
    }

    public void setVoedselgroepens(List<Voedselgroepen> voedselgroepens) {
        this.voedselgroepens = voedselgroepens;
    }

    public List<VerzekeringBelegging> getVerzekeringBeleggingen() {
        return verzekeringBeleggingen;
    }

    public void setVerzekeringBeleggingen(List<VerzekeringBelegging> verzekeringBeleggingen) {
        this.verzekeringBeleggingen = verzekeringBeleggingen;
    }

    public List<OverigeBetaling> getOverigeBetalingen() {
        return overigeBetalingen;
    }

    public void setOverigeBetalingen(List<OverigeBetaling> overigeBetalingen) {
        this.overigeBetalingen = overigeBetalingen;
    }
}
