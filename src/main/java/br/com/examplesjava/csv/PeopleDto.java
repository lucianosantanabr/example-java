package br.com.examplesjava.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto {

  @CsvBindByName(column = "NAME")
  @CsvBindByPosition(position = 0)
  private String name;

  @CsvBindByName(column = "AGE")
  @CsvBindByPosition(position = 1)
  private Integer age;

  @CsvBindByName(column = "EMAIL")
  @CsvBindByPosition(position = 2)
  private String email;
}