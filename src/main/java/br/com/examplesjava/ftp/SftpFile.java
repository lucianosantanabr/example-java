package br.com.examplesjava.ftp;

import br.com.examplesjava.util.files.FileFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

@Slf4j
public class SftpFile {

  private FileFactory fileFactory;

  public boolean uploadFileSsh(
      String remoteHost,
      int port,
      String userName,
      String password,
      String localDir,
      String remoteDir) {

    boolean isUpload = false;
    try {

      SSHClient sshClient = setupSshj(remoteHost, port, userName, password);

      if (Objects.nonNull(sshClient)) {
        if (sshClient.isConnected() && sshClient.isAuthenticated()) {
          SFTPClient sftpClient = sshClient.newSFTPClient();
          sendFiles(sftpClient, localDir, remoteDir);
          sshClient.disconnect();
          isUpload = true;
        }
      }

    } catch (IllegalStateException | IOException e) {
      log.error(
          String.format(
              "Error in method uploadFileSsh => %s, %s", SftpFile.class.getName(), e.getMessage()));
    }
    return isUpload;
  }

  private void sendFiles(SFTPClient sftpClient, String localDir, String remoteDir)
      throws IOException {

    Collection<String> files = fileFactory.listFiles(localDir);
    if (!files.isEmpty()) {
      files.stream()
          .forEach(
              f -> {
                try {
                  sftpClient.put(localDir + f, remoteDir);
                } catch (IOException e) {
                  e.printStackTrace();
                }
              });
    }
    sftpClient.close();
  }

  private SSHClient setupSshj(String remoteHost, int port, String userName, String password)
      throws IOException {
    SSHClient client = null;
    try {
      client = new SSHClient();
      client.addHostKeyVerifier(new PromiscuousVerifier());
      client.setTimeout(60000);
      client.connect(remoteHost, port);
      client.authPassword(userName, password);
      return client;
    } catch (IOException e) {
      log.error(
          String.format(
              "Error in method setupSshj => %s, %s ", SftpFile.class.getName(), e.getMessage()));
    }
    return client;
  }
}
