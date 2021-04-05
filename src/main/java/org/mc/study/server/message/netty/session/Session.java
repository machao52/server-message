package org.mc.study.server.message.netty.session;

import lombok.Data;

/**
 * @author machao
 * @date 2021/4/5
 */

@Data
public class Session {

    private String userId;

    private String username;

    public Session(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    @Override
    public String toString() {
        return userId + ":" + username;
    }

}
