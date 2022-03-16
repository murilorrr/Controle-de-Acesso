package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;

public class Report {

  int minor = 0;
  int adult = 0;
  int aged = 0;

  ArrayList<Short> ages = new ArrayList<Short>();

  /**
   * constructor
   * ao ser instanciado ira receber um array de idades
   */
  Report(ArrayList<Short> people) {
    this.ages = people;
    quantityByAges();
  }

  public void numberOfPeople() {
    int total = ages.size();
    String retornoEsperado = "Número total de pessoas que visitaram o estabelecimento: %s \n";
    System.out.format(retornoEsperado, total);
  }

  /**
   * quantityByAges
   * método ira distribuir de forma assertiva qual a quantidade de
   * menores, adultos e idosos que existem no array
   */
  public void quantityByAges() {
    // int[] agesArray = new Array[ages.size()];
    // agesArray = ages;


    // int arrayLength = ages.size();
    // for (int i = 0; i < arrayLength; i++) {
    //   if (ages[i] < 18) {
    //     minor = minor + 1;
    //   } else if (arrayDeIdades[i] >= 18 && arrayDeIdades[i] < 50 ) {
    //     adult = adult + 1;
    //   } else {
    //     aged = aged + 1;
    //   }
    // }
  }

  public void reportPercentageByAges() {
    double percentMinor = minor / ages.size();
    double percentAdult = adult / ages.size();
    double percentAged = aged / ages.size();

    String retornoEsperado =
    " ----- Percentual -----\n menores: %s  \n adultas: %s\n maiores que 50: %s\n";

    System.out.format(retornoEsperado, percentMinor ,percentAdult, percentAged);
  }
}