package com.petal.petalpokemons.model;

import jakarta.persistence.*;

@Entity(name="pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String names;
    @Column()
    private String typeOne;
    @Column()
    private String typeTwo;
    @Column()
    private int totals;
    @Column()
    private int hp;
    @Column()
    private int attacks;
    @Column()
    private int defences;
    @Column()
    private int spAtks;
    @Column()
    private int speeds;
    @Column()
    private int defSpeeds;
    @Column()
    private int generations;
    @Column()
    private boolean legend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getDefences() {
        return defences;
    }

    public void setDefences(int defences) {
        this.defences = defences;
    }

    public int getSpAtks() {
        return spAtks;
    }

    public void setSpAtks(int spAtks) {
        this.spAtks = spAtks;
    }

    public int getDefSpeeds() {
        return defSpeeds;
    }

    public void setDefSpeeds(int defSpeeds) {
        this.defSpeeds = defSpeeds;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public boolean isLegend() {
        return legend;
    }

    public void setLegend(boolean legend) {
        this.legend = legend;
    }

    public int getSpeeds() {
        return speeds;
    }

    public void setSpeeds(int speeds) {
        this.speeds = speeds;
    }
}
