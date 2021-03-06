package br.com.examplesjava.csv;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class People {

  private String name;
  private Integer age;
  private String email;

}
