package com.petal.petalpokemons.dto;


public class AddPokemonDto {
    private String noms;
    private String typeUn;
    private String typeDeux;
    private int totals;
    private int hp;
    private int attacques;
    private int defences;
    private int spAtks;
    private int defVitesses;
    private int vitesses;
    private int generations;
    private boolean Legende;

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getTypeUn() {
        return typeUn;
    }

    public void setTypeUn(String typeUn) {
        this.typeUn = typeUn;
    }

    public String getTypeDeux() {
        return typeDeux;
    }

    public void setTypeDeux(String typeDeux) {
        this.typeDeux = typeDeux;
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

    public int getAttacques() {
        return attacques;
    }

    public void setAttacques(int attacques) {
        this.attacques = attacques;
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

    public int getDefVitesses() {
        return defVitesses;
    }

    public void setDefVitesses(int defVitesses) {
        this.defVitesses = defVitesses;
    }

    public int getVitesses() {
        return vitesses;
    }

    public void setVitesses(int vitesses) {
        this.vitesses = vitesses;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public boolean isLegende() {
        return Legende;
    }

    public void setLegende(boolean legende) {
        Legende = legende;
    }
}
