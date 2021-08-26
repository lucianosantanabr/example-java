package br.com.examplesjava.util.files;

import br.com.examplesjava.util.dates.LocalDateUtil;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FileFactory {

  private LocalDateUtil dataUtil;

  public void createFile(String path, String fileName, List<String> dataFileList) {

    createDirectory(path);

    try (var file = new FileWriter(path + fileName)) {
      file.write(joinDelimiter(dataFileList));
      file.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createDirectory(String path) {
    var dir = new File(path);
    if (!dir.exists()) {
      dir.mkdirs();
    }
  }

  private String joinDelimiter(List<String> listLayout) {
    return listLayout.stream().collect(Collectors.joining("|"));
  }

  public String assignFileName(String nameFile, String fileExtension, String formatDate) {
    var sbPath = new StringBuilder();
    sbPath.append(nameFile);
    sbPath.append(dataUtil.convertDateFormat(LocalDateTime.now(), formatDate));
    sbPath.append("." + fileExtension);
    return sbPath.toString();
  }

  public String getPath(LocalDateTime date, String directory) {
    var sbPath = new StringBuilder();
    sbPath.append(directory).append(File.separator);
    sbPath.append(dataUtil.convertForYearMonthDayString(date)).append(File.separator);
    return sbPath.toString();
  }

  public Collection<String> listFiles(String path) {
    File dir = new File(path);
    Collection<String> lstFiles = null;
    if (dir.exists()) {
      File[] files = dir.listFiles();
      lstFiles = Arrays.stream(files).map(File::getName).collect(Collectors.toList());
    }
    return lstFiles;
  }

  public void deleteFilesDirectory(String path) {
    File dir = new File(path);
    if (dir.exists()) {
      Arrays.stream(dir.listFiles()).forEach(file -> file.delete());
    }
  }


}
