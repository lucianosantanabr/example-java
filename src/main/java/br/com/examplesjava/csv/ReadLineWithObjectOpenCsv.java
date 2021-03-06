package br.com.examplesjava.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadLineWithObjectOpenCsv {

  public static void main(String[] args) throws IOException {

    Reader reader = Files.newBufferedReader(Paths.get("people.csv"));

    CsvToBean<People> csvToBean = new CsvToBeanBuilder(reader).withType(People.class).build();

    List<People> peoples = csvToBean.parse();

    peoples.stream().forEach(people -> System.out.println(people));
  }
}
