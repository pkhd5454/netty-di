package study.netty;

import com.xxlabaza.utils.netty.config.server.NettyServerConfig;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import study.netty.handler.ServerHandler;
import study.netty.repository.ServerRepository;
import study.netty.service.ServerService;

import static com.xxlabaza.utils.netty.handler.ChannelHandlerInitializerPipeline.pipelineOf;
import static io.netty.handler.logging.LogLevel.INFO;

@SpringBootApplication
public class NettyApplication {

  public static void main(String[] args) {
    SpringApplication.run(NettyApplication.class, args);
  }

  @Bean
  NettyServerConfig serverConfig() {
    return NettyServerConfig.builder()
        .propertiesPrefix("my.netty.server")
        .channelInitializer(pipelineOf(loggingHandler(), serverHandler()))
        .build();
  }

  @Bean
  LoggingHandler loggingHandler() {
    return new LoggingHandler(INFO);
  }

  @Bean
  ServerHandler serverHandler() {
    return new ServerHandler(serverService(null, null));
  }

  @Bean
  ServerService serverService(@Value("${my.prop}") String prop, ServerRepository repository) {
    return new ServerService(prop, repository);
  }
}
