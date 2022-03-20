package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Report {

  short minor = 0;
  short adult = 0;
  short aged = 0;
  short total = 0;

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
        minor = (short) (minor + 1);
      } else if (age >= 18 && age < 50) {
        adult = (short) (adult + 1);
      } else {
        aged = (short) (aged + 1);
      }
      this.total += 1;
    });
    // para que nunca se divide nada por 0
    if (total == 0) {
      this.total += 1;
    }
  }

  /**
   * reportPercentageByAges
   * ao ser chamado ira imprimir no terminal a quatidade em porcentagem das idades.
   * @author Murilo
   * @version 1.0
   */
  public void reportPercentageByAges() {

    float percentMinor = ((float) minor / total) * 100;
    float percentAdult = ((float) adult / total) * 100;
    float percentAged = ((float) aged / total) * 100;

    // DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
    DecimalFormat decimalFormatUS = new DecimalFormat(
        "#,###.##", new DecimalFormatSymbols(Locale.US));

    // String retornoEsperado =
    //     "----- Percentual -----\nmenores: %s%%\nadultas: %s%%\nmaiores que 50: %s%%\n";

    System.out.println("----- Percentual -----");

    System.out.print("menores: ");
    System.out.print(decimalFormatUS.format(percentMinor));
    System.out.println("%");

    System.out.print("adultas: ");
    System.out.print(decimalFormatUS.format(percentAdult));
    System.out.println("%");

    System.out.print("maiores que 50: ");
    System.out.print(decimalFormatUS.format(percentAged));
    System.out.println("%");

  }

  /**
   * reportQuantityByAges
   * ao ser chamado ira imprimir no terminal a quatidade relativa das idades.
   * @author Murilo
   * @version 1.0
   */
  public void reportQuantityByAges() {
    String retornoEsperado =
        "----- Quantidade -----\nmenores: %s\nadultas: %s\nmaiores que 50: %s\n\n";

    System.out.format(retornoEsperado, minor, adult, aged);
  }
}