package study.netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.netty.service.ServerService;

import java.nio.charset.Charset;

import static io.netty.channel.ChannelHandler.Sharable;

@Slf4j
@Sharable
@RequiredArgsConstructor
public class ServerHandler extends ChannelInboundHandlerAdapter {

  private final ServerService service;

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object object) throws Exception {
    log.info("ServerHandler.channelRead()");

    String data = service.register(object);
    log.info("data={}", data);

    ctx.writeAndFlush(Unpooled.copiedBuffer(data, Charset.defaultCharset()));
  }
}
