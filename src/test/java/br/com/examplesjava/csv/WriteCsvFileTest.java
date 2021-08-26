package br.com.examplesjava.csv;

import br.com.examplesjava.util.mappers.MapperUtil;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WriteCsvFileTest")
public class WriteCsvFileTest {

  private static char separator = ';';
  private static String path = "files/";
  private static String fileName = "fileTest";

  @Test
  @DisplayName("writeCsvWithoutHeaderTest => Generate files without Header")
  void writeCsvWithoutHeaderTest()
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

    WriteCsvFile.writeCsvWithoutHeader(People.class, getPeople(), separator,
        path + fileName + "_WithoutHeader.csv");
  }

  @Test
  @DisplayName("writeCsvWithHeaderTest => Generate files with Header")
  void writeCsvWithHeaderTest()
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

    List<PeopleDto> dtoList = MapperUtil.toList(getPeople(), PeopleDto.class);
    
    WriteCsvFile.writeCsvWithHeader(PeopleDto.class, dtoList, separator,
        path + fileName + "_WithHeader.csv");
  }

  private List<People> getPeople() {
    List<People> people = new ArrayList<>();
    people.add(new People("Joao", 35, "joao@examplejava.com.br"));
    people.add(new People("Maria", 23, "maria@examplejava.com.br"));
    people.add(new People("Ana", 25, "ana@examplejava.com.br"));
    return people;
  }
}
