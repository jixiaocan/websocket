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
	// �������е� sticker
	private static final List<Sticker> stickers = Collections.synchronizedList(new LinkedList<Sticker>()); 
	// �������пͻ��˵� session
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>()); 
	
	@OnMessage
	public void onMessage(Session session, Sticker sticker){
		// ����Ϣ�ӿͻ��˷��͹��������浽�б��У�Ȼ��֪ͨ���еĿͻ���
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
		// ���µĿͻ�������ʱ������˿ͻ��˵�session�����Ұѵ�ǰ���е�sticker���͸���
		sessions.add(session);
		for(Sticker sticker : stickers){
			session.getBasicRemote().sendObject(sticker);
		}
	}
	
	@OnClose
	public void onClose(Session session){
		// �пͻ��˶Ͽ�����ʱ ����session�б����Ƴ��˿ͻ��˵�session
		sessions.remove(session);
		
	}
	
	@OnError
	public void onError(Throwable error){
		System.out.println(error.getMessage());
	}
}
