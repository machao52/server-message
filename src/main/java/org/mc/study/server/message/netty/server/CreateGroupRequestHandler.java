package org.mc.study.server.message.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import org.mc.study.server.message.netty.protocol.CreateGroupRequestPacket;
import org.mc.study.server.message.netty.protocol.CreateGroupResponsePacket;
import org.mc.study.server.message.netty.utils.IDUtil;
import org.mc.study.server.message.netty.utils.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machao
 * @date 2021/04/06
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();

        List<String> usernameList = new ArrayList<>();

        //1、创建一个channel分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        //2、筛选出待加入群聊的用户的channel和username
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                usernameList.add(SessionUtil.getSession(channel).getUsername());
            }
        }

        //3、创建群聊创建结果的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IDUtil.randomId());
        createGroupResponsePacket.setUsernameList(usernameList);

        //4、给每个用户发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.print("群创建成功，id为[" + createGroupResponsePacket.getGroupId() + "]");
        System.out.println("群里面有：" + createGroupResponsePacket.getUsernameList());

    }
}
