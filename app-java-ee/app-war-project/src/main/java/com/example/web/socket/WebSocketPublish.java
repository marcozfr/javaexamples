package com.example.web.socket;

import javax.websocket.server.ServerEndpointConfig;

public class WebSocketPublish {
	
	static {
		ServerEndpointConfig.Builder.create(ConversationEndpoint.class, "converse").build();
	}

}
