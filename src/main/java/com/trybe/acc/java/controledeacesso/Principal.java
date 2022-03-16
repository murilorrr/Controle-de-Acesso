package com.trybe.acc.java.controledeacesso;

import java.util.*;

public class Principal {

  static ArrayList<Short> people = new ArrayList<Short>();
  short acess;
  static short logoutOption = 2;
  static int loginOption = 1;

  /**
   * warn
   * método main vai chamar a execução da aplicação do sistema.
   * @author Murilo
   * @version 1.0
   */
  public static void main(String[] args) throws Exception {
    // ESCREVA SEU CÓDIGO AQUI
    // inicio da contagem
    init();

    fluxo();

    end();
  }

  public static void init() {
    System.out.println("Inicia o sistema");
  }

  /**
   * warn
   * método fluxo vai vai acessar o sistem para cadastro de pessoas pela idade e
   * caso desejado realizar o relatório.
   * @author Murilo
   * @version 1.0
   */
  public static void fluxo() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1-Acessar o estabelecimento\n2-Finalizar sistema e mostrar relatório\n");
    Scanner inputScanner = new Scanner(System.in);
    int inputNumber = inputScanner.nextInt();

    // inputScanner.close();
    if (inputNumber == loginOption) {
      // adiciono a primeira pessoa ao relatorio
      storeUserAge();

      // eu quero contar mais um? então chamo o metodo nomente
      fluxo();
    } else if (inputNumber != logoutOption) {
      System.out.println("Entre com uma opção válida");
      fluxo();
      // quando acabar eu quero que a entidade de relatorio me ofereça o relatorio das
      // pessoas
    } else {
      int quantityOfPeople = people.size();
      if(quantityOfPeople == 0) fluxo();
      relatorio();
    }
    // inputScanner.close();
  }

  /**
   * método storeUserAge vai esperar a idade e guardar no arrayList de people.
   * @author Murilo
   * @version 1.0
   */
  public static void storeUserAge() {
    System.out.println("Entre com a idade:\n");
    Scanner inputScanner = new Scanner(System.in);
    Short age = inputScanner.nextShort();
    people.add(age);
    // inputScanner.close();
  }

  /**
   * método relatorio instancia uma classe de Report que contem
   * metodos para analizar um array de idades.
   * @author Murilo
   * @version 1.0
   */
  public static void relatorio() {
    Report report = new Report(people);
    report.numberOfPeople();
    report.reportQuantityByAges();
    report.reportPercentageByAges();
  }

  public static void end() {
    System.out.println("Fim do sistema");
  }

}
