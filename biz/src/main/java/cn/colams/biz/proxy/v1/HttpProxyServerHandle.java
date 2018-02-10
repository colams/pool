package cn.colams.biz.proxy.v1;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpVersion;

public class HttpProxyServerHandle extends ChannelInboundHandlerAdapter {

    private ChannelFuture cf;
    private String host;
    private int port;

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String host = request.headers().get("host");
            String[] temp = host.split(":");
            int port = 80;
            if (temp.length > 1) {
                port = Integer.parseInt(temp[1]);
            } else {
                if (request.getUri().indexOf("https") == 0) {
                    port = 443;
                }
            }

            this.host = temp[0];
            this.port = port;

            if ("CONNECT".equalsIgnoreCase(request.getMethod().name())){
                HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, NettyHttpProxyServer.SUCCESS);

            }
        }
    }

}
