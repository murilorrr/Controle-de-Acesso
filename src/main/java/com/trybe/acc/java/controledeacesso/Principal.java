package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
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

    Scanner scanner = new Scanner(System.in);
    short logoutOption = 2;
    short loginOption = 1;
    ArrayList<Short> people = new ArrayList<Short>();

    short inputNumber = openMenuWithScanner(scanner);

    while (inputNumber != logoutOption) {
      if (inputNumber == loginOption) {
        storeUserAgeInArrayWithScanner(people, scanner);
        inputNumber = openMenuWithScanner(scanner);
      } else {
        System.out.println("Entre com uma opção válida!");
        inputNumber = openMenuWithScanner(scanner);
      }
    }

    relatorio(people);
  }

  private static short openMenuWithScanner(Scanner scanner) {
    short inputNumber = 0;
    System.out.println("Entre com o número correspondente à opção desejada:");
    String entrySystemString =
        "1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório";
    System.out.println(entrySystemString);

    if (scanner.hasNextShort()) {
      inputNumber = scanner.nextShort();
    }
    return inputNumber;
  }

  /**
   * método storeUserAge vai esperar a idade e guardar no arrayList de people.
   * @param array arrayList de entrada
   * @author Murilo
   * @version 1.0
   */
  public static void storeUserAgeInArrayWithScanner(ArrayList<Short> array, Scanner scanner) {
    short age = ageEntryIntoScanner(scanner);

    agePrintOut(age);

    array.add(age);
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
   * @param scanner é um scanner que deve receber um input de idade no terminal
   */
  public static short ageEntryIntoScanner(Scanner scanner) {
    System.out.println("Entre com a sua idade:");
    short age = 0;

    if (scanner.hasNextShort()) {
      age = scanner.nextShort();
    }
    return age;
  }

  /**
   * método relatorio instancia uma classe de Report que contem
   * metodos para analizar um array de idades.
   * @param array arrayList de entrada
   * @author Murilo
   * @version 1.0
   */
  public static void relatorio(ArrayList<Short> array) {
    Report report = new Report(array);
    report.reportQuantityByAges();
    report.reportPercentageByAges();
    report.numberOfPeople();
  }
}
