package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;

public class Report {

  ArrayList<Short> ages = new ArrayList<>();

  Report(ArrayList<Short> people) {
    this.ages = people;
  }

  public void numberOfPeople() {
    int total = ages.size();
    String retornoEsperado = "Número total de pessoas que visitaram o estabelecimento: %s \n";
    System.out.format(retornoEsperado, total);
  }

  public void byAges() {
    System.out.println("Not implemented yet");
    // ages.forEach(null);
  }
}