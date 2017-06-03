package org.example.sticker;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint(value="/story/notifications",encoders={StickerEncoder.class}, decoders={StickerDecoder.class})
public class StoryWebSocket {
	// 保存所有的 sticker
	private static final List<Sticker> stickers = Collections.synchronizedList(new LinkedList<Sticker>()); 
	// 保存所有客户端的 session
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>()); 
	
	@OnMessage
	public void onMessage(Session session, Sticker sticker){
		// 有消息从客户端发送过来，保存到列表中，然后通知所有的客户端
		stickers.add(sticker);
		for(Session openSession : sessions){
			try {
				openSession.getBasicRemote().sendObject(sticker);
			} catch (IOException | EncodeException e) {
				sessions.remove(openSession); 
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException{
		// 有新的客户端连接时，保存此客户端的session，并且把当前所有的sticker发送给它
		sessions.add(session);
		for(Sticker sticker : stickers){
			session.getBasicRemote().sendObject(sticker);
		}
	}
	
	@OnClose
	public void onClose(Session session){
		// 有客户端断开连接时 ，从session列表中移除此客户端的session
		sessions.remove(session);
		
	}
	
	@OnError
	public void onError(Throwable error){
		System.out.println(error.getMessage());
	}
}
