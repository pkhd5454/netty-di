package study.netty.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServerServiceTest {

  @Autowired ServerService service;

  @Test
  void provide() {
    String data = service.register("data");
    assertEquals("12345data", data);
  }
}
