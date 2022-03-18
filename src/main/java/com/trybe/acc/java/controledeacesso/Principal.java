package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  static ArrayList<Short> people = new ArrayList<Short>();
  static short logoutOption = 2;
  static short loginOption = 1;
  static Scanner inputScanner = new Scanner(System.in);

  /**
   * warn
   * método main vai chamar a execução da aplicação do sistema.
   * @author Murilo
   * @version 1.0
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    // inicio da contagem

    flow();

  }

  /**
   * warn
   * método fluxo vai vai acessar o sistem para cadastro de pessoas pela idade e
   * caso desejado realizar o relatório.
   * @author Murilo
   * @version 1.0
   */
  public static void flow() {

    short inputNumber = openMenu();

    while (inputNumber != logoutOption) {
      if (inputNumber == loginOption) {
        storeUserAge();
        inputNumber = openMenu();
      } else {
        System.out.println("Entre com uma opção válida!");
        inputNumber = openMenu();
      }
    }

    relatorio();
  }

  private static short openMenu() {
    short inputNumber = 0;
    System.out.println("Entre com o número correspondente à opção desejada:");
    String entrySystemString =
        "1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório";
    System.out.println(entrySystemString);

    if (inputScanner.hasNextShort()) {
      inputNumber = inputScanner.nextShort();
    }
    return inputNumber;
  }

  /**
   * método storeUserAge vai esperar a idade e guardar no arrayList de people.
   * @author Murilo
   * @version 1.0
   */
  public static void storeUserAge() {
    short age = ageEntry();

    agePrintOut(age);

    people.add(age);
  }

  private static void agePrintOut(short age) {
    if (age < 18) {
      System.out.println("Pessoa menor, catraca liberada!");
    } else if (age >= 18 && age < 50) {
      System.out.println("Pessoa adulta, catraca liberada!");
    } else {
      System.out.println("Pessoa idosa, catraca liberada!");
    }
  }

  /**
   * método ageEntry vai esperar a idade e retornar o valor inputado.
   * @author Murilo
   * @version 1.0
   */
  public static short ageEntry() {
    System.out.println("Entre com a sua idade:");
    short age = 0;

    if (inputScanner.hasNextShort()) {
      age = inputScanner.nextShort();
    }
    return age;
  }

  /**
   * método relatorio instancia uma classe de Report que contem
   * metodos para analizar um array de idades.
   * @author Murilo
   * @version 1.0
   */
  public static void relatorio() {
    Report report = new Report(people);
    report.reportQuantityByAges();
    report.reportPercentageByAges();
    report.numberOfPeople();
  }
}
