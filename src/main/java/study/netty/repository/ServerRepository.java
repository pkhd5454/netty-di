package study.netty.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ServerRepository {

  public String save(Object data) {
    log.info("ServerRepository.save()");
    sleep(1000); // data-access time
    return "success";
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
