package br.com.examplesjava.util.list;import java.util.Arrays;import org.apache.commons.lang3.ArrayUtils;public class JoinArrays {  public static void main(String[] args) {    String[] array1 = new String[] {"a", "b", "c", "d"};    String[] array2 = new String[] {"e", "f", "g", "h"};    String[] arraysJoin = ArrayUtils.addAll(array1, array2);    System.out.println(Arrays.toString(arraysJoin));  }}