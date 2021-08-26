package br.com.examplesjava.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteCsvFile {

  public static <T, D> void writeCsvWithoutHeader(
      D dClass, List<T> list, char separator, String path)
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

    Writer writer = getWriter(path);
    StatefulBeanToCsvBuilder<T> beanToCsv =
        new StatefulBeanToCsvBuilder<T>(writer).withSeparator(separator).withQuotechar('\0');

    StatefulBeanToCsv<T> beanWriter =
        beanToCsv.withMappingStrategy(assignMappingStrategy(dClass)).build();

    beanWriter.write(list);
    writer.flush();
    writer.close();
  }

  private static Writer getWriter(String path) throws IOException {
    return Files.newBufferedWriter(Paths.get(path));
  }

  public static <T, D> void writeCsvWithHeader(D dClass, List<T> list, char separator, String path)
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

    Writer writer = getWriter(path);

    CustomMappingStrategy<T> mappingStrategy = new CustomMappingStrategy<T>();
    mappingStrategy.setType((Class<? extends T>) dClass);

    StatefulBeanToCsv<T> beanToCsv =
        new StatefulBeanToCsvBuilder<T>(writer)
            .withSeparator(separator)
            .withQuotechar('\0')
            .withMappingStrategy(mappingStrategy)
            .build();

    beanToCsv.write(list);
    writer.flush();
    writer.close();
  }

  public static <T> ColumnPositionMappingStrategy assignMappingStrategy(T tClass) {
    ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<T>();
    mappingStrategy.setType((Class<? extends T>) tClass);
    mappingStrategy.setColumnMapping(getClassFields(tClass));
    return mappingStrategy;
  }

  public static <T> String[] getClassFields(T t) {
    List<String> fieldList = new ArrayList<>();
    Field fields[] = ((Class) t).getDeclaredFields();
    for (Field field : fields) {
      fieldList.add(field.getName());
    }
    return fieldList.toArray(String[]::new);
  }

}
