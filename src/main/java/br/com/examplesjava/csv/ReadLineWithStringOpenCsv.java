package br.com.examplesjava.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadLineWithStringOpenCsv {

  public static void main(String[] args) throws IOException, CsvException {

    Reader reader = Files.newBufferedReader(Paths.get("people.csv"));

    // skip header line => withSkipLines(1)
    CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).build();

    List<String[]> peoples = csvReader.readAll();
    peoples.stream()
        .forEach(
            p -> System.out.println("Name : " + p[0] + " - Age : " + p[1] + " - Email : " + p[2]));
  }
}
