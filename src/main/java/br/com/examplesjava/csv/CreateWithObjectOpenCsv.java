package br.com.examplesjava.csv;


import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateWithObjectOpenCsv {

  public static void main(String[] args)
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

    List<People> people = new ArrayList<>();
    people.add(new People("Joao",35,"joao@examplejava.com.br"));
    people.add(new People("Maria",23,"maria@examplejava.com.br"));
    people.add(new People("Ana",25,"ana@examplejava.com.br"));

    Writer writer = Files.newBufferedWriter(Paths.get("people.csv"));

    StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer).build();

    beanToCsv.write(people);

    writer.flush();
    writer.close();

  }
}
