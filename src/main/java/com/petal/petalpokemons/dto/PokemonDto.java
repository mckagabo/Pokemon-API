package com.petal.petalpokemons.dto;

public class PokemonDto {
    private int id;
    private String noms;
    private String typeUn;
    private String typeDeux;
    private int sommes;
    private int hp;
    private int attacks;
    private int defences;
    private int spAtks;
    private int defVitesse;
    private int generations;
    private boolean Legende;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return noms;
    }

    public void setNames(String names) {
        this.noms = names;
    }


    public String getTypeTwo() {
        return typeDeux;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeDeux = typeTwo;
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
        return defVitesse;
    }

    public void setDefSpeeds(int defSpeeds) {
        this.defVitesse = defSpeeds;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

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

    public int getSommes() {
        return sommes;
    }

    public void setSommes(int sommes) {
        this.sommes = sommes;
    }

    public int getDefVitesse() {
        return defVitesse;
    }

    public void setDefVitesse(int defVitesse) {
        this.defVitesse = defVitesse;
    }

    public boolean isLegende() {
        return Legende;
    }

    public void setLegende(boolean legende) {
        Legende = legende;
    }
}
