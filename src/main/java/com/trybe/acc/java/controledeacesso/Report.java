package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Report {

  int minor = 0;
  int adult = 0;
  int aged = 0;

  ArrayList<Short> ages = new ArrayList<Short>();

  /**
   * constructor
   * ao ser instanciado ira receber um array de idades.
   * @author Murilo
   * @version 1.0
   */
  Report(ArrayList<Short> people) {
    this.ages = people;
    quantityByAges();
  }

  /**
   * numberOfPeople
   * imprime no terminal o numero de pessoas no array recebido.
   * @author Murilo
   * @version 1.0
   */
  public void numberOfPeople() {
    int total = ages.size();
    String retornoEsperado = "\nTOTAL: %s\n";
    System.out.format(retornoEsperado, total);
  }

  /**
   * quantityByAges
   * método ira distribuir de forma assertiva qual a quantidade de
   * menores, adultos e idosos que existem no array.
   * @author Murilo
   * @version 1.0
   */
  private void quantityByAges() {
    ages.forEach((age) -> {
      if (age < 18) {
        minor = minor + 1;
      } else if (age >= 18 && age < 50 ) {
        adult = adult + 1;
      } else {
        aged = aged + 1;
      }
    });
  }

  /**
   * reportPercentageByAges
   * ao ser chamado ira imprimir no terminal a quatidade em porcentagem das idades.
   * @author Murilo
   * @version 1.0
   */
  public void reportPercentageByAges() {

    int arrayLength = ages.size();
    double percentMinor = ((double) minor/arrayLength) * 100;
    double percentAdult = ((double) adult/arrayLength) * 100;
    double percentAged = ((double) aged/arrayLength) * 100;

    String pattern = "##.##";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String percentMinorFormat = decimalFormat.format(percentMinor);
    String percentAdultFormat = decimalFormat.format(percentAdult);
    String percentAgedFormat = decimalFormat.format(percentAged);

    String retornoEsperado =
        "----- Percentual -----\nmenores: %s%%\nadultas: %s%%\nmaiores que 50: %s%%\n";

    System.out.format(retornoEsperado, percentMinorFormat, percentAdultFormat, percentAgedFormat);
  }

  /**
   * reportQuantityByAges
   * ao ser chamado ira imprimir no terminal a quatidade relativa das idades.
   * @author Murilo
   * @version 1.0
   */
  public void reportQuantityByAges() {
    String retornoEsperado =
        "----- Quantidade -----\nmenores: %s\nadultas: %s\nmaiores que 50: %s\n";

    System.out.format(retornoEsperado, minor, adult, aged);
  }
}