package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  static ArrayList<Short> people = new ArrayList<Short>();
  short acess;
  static short logoutOption = 2;
  static int loginOption = 1;

  /**
   * warn
   * método main vai chamar a execução da aplicação do sistema
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
   * caso desejado realizar o relatório
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
      // quando acabar eu quero que a entidade de relatorio me ofereça o relatorio das
      // pessoas
    } else {
      relatorio();
    }
    // inputScanner.close();
  }

  /**
   * warn
   * método storeUserAge vai esperar a idade e guardar no arrayList de people
   */
  public static void storeUserAge() {
    System.out.println("Entre com a idade:\n");
    Scanner inputScanner = new Scanner(System.in);
    Short age = inputScanner.nextShort();
    people.add(age);
    // inputScanner.close();
  }

  public static void relatorio() {
    Report report = new Report(people);
    report.numberOfPeople();
    report.reportPercentageByAges();
  }

  public static void end() {
    System.out.println("Fim do sistema");
  }

}
