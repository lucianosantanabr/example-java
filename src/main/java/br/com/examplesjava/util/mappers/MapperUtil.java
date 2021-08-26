package br.com.examplesjava.util.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class MapperUtil {

  private static ModelMapper modelMapper = new ModelMapper();

  public static <S, T> List<T> toList(List<S> source, Class<T> targetClass) {
    return source.stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
  }

  public static <S, D> D mapTo(S source, Class<D> destClasse) {
    return modelMapper.map(source, destClasse);
  }
}
