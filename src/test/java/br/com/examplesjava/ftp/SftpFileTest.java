package br.com.examplesjava.ftp;

import br.com.examplesjava.util.files.FileFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SftpFileTest")
public class SftpFileTest {

  private SftpFile sftpFile;
  private FileFactory fileFactory;
  private static String path = "files/";

  @Test
 public void sendFtpTest() {
    boolean isUpload = sftpFile.uploadFileSsh("host",
        22,
        "userName",
        "password",
        "localDir",
        "remotoDir");

    if (isUpload) {
      fileFactory.deleteFilesDirectory(path);
    }
  }
}
