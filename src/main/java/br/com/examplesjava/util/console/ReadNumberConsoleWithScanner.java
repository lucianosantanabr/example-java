package br.com.examplesjava.util.console;import java.util.InputMismatchException;import java.util.Scanner;public class ReadNumberConsoleWithScanner {  public static void main(String[] args) {    Scanner scanner = new Scanner(System.in);    System.out.print("enter an integer: ");    try {      int number = scanner.nextInt();      System.out.print("The value informed was " + number);    } catch (InputMismatchException e) {      System.out.print("The value entered is not a number.!");    }  }}