package br.com.examplesjava.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Taxation {
  PIS("TAX PIS", 0.087d),
  INSS("TAX INSS", 0.11d),
  IRRF("TAX IRRF", 0.27);
  
  @Getter
  private String descTax;
  @Getter
  private Double percentage;
}
