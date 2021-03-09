/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1utt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author vsa
 */
@Entity
public class Kniha {
    
    enum Dostupnost{
        NASKLADE,
        DO3DNI,
        VYPREDANE
    }
    
    @Id
    private String nazov;
    @Column (nullable = false)
    private Double cena;
    @Transient      /// atribut, ktory sa v tabulke nenachadza
    private int pocet;
    @Enumerated(javax.persistence.EnumType.STRING)
    private Dostupnost dostupnost;

    @Override
    public String toString() {
        return "Kniha{" + "nazov=" + nazov + ", cena=" + cena + '}';
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public Dostupnost getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Dostupnost dostupnost) {
        this.dostupnost = dostupnost;
    }



}
