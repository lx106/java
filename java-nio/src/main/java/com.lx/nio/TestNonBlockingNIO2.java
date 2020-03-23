package  com.lx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

public class TestNonBlockingNIO2 {

	@Test
	public void send() throws IOException{

		DatagramChannel datagramChannel = DatagramChannel.open();

		datagramChannel.configureBlocking(false);

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNext()){
			String str = scanner.nextLine();
			byteBuffer.put(str.getBytes());
			byteBuffer.flip();
			datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9999));
			byteBuffer.clear();
		}
		datagramChannel.close();
	}

	@Test
	public void receive() throws IOException{

		DatagramChannel datagramChannel = DatagramChannel.open().bind(new InetSocketAddress(9999));

		datagramChannel.configureBlocking(false);

		Selector selector = Selector.open();

		datagramChannel.register(selector, SelectionKey.OP_READ);

		while(selector.select()>0){

			Iterator<SelectionKey> it = selector.selectedKeys().iterator();

			while(it.hasNext()){
				SelectionKey selectionKey = it.next();

				if(selectionKey.isReadable()){

					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

					datagramChannel.receive(byteBuffer);
					byteBuffer.flip();
					System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
					byteBuffer.clear();

				}
				it.remove();
			}
		}

	}
}
