package study.netty.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.netty.repository.ServerRepository;

@Slf4j
@RequiredArgsConstructor
public class ServerService {

  private final String prop;
  private final ServerRepository repository;

  public String register(Object data) {
    log.info("ServerService.register()");

    log.info("prop={}", prop);
    log.info("repository={}", repository);
    return prop + repository.save(data);
  }
}
