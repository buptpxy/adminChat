package com.pxy.chat;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.pxy.entity.User;

/**
 * @ServerEndpoint ע����һ�����ε�ע�⣬���Ĺ�����Ҫ�ǽ�Ŀǰ���ඨ���һ��websocket��������,
 *                 ע���ֵ�������ڼ����û����ӵ��ն˷���URL��ַ,�ͻ��˿���ͨ�����URL�����ӵ�WebSocket��������
 */
@ServerEndpoint("/check_user")
public class H5ServletServerSocket {
	// ��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
	private static int onlineCount = 1;
	
	

	// concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
	private static CopyOnWriteArraySet<H5ServletServerSocket> webSocketSet = new CopyOnWriteArraySet<H5ServletServerSocket>();

	// ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
	private Session session;

	/**
	 * ���ӽ����ɹ����õķ���
	 * 
	 * @param session
	 *            ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this); // ����set��
		addOnlineCount(); // ��������1
		
		System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * ���ӹرյ��õķ���
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this); // ��set��ɾ��
		subOnlineCount(); // ��������1
		
		System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * �յ��ͻ�����Ϣ����õķ���
	 * 
	 * @param message
	 *            �ͻ��˷��͹�������Ϣ
	 * @param session
	 *            ��ѡ�Ĳ���
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("���Կͻ��˵���Ϣ:" + message);
		// Ⱥ����Ϣ
		for (H5ServletServerSocket item : webSocketSet) {
			try {
			
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	/**
	 * ��������ʱ����
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("��������");
	
		error.printStackTrace();
	}

	/**
	 * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}
	
	//��õ�ǰ��������
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	
	
	
	public static synchronized void addOnlineCount() {
		H5ServletServerSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		H5ServletServerSocket.onlineCount--;
	}
}
