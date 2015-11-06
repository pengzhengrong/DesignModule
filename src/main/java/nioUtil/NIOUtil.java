package nioUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 很重要的一点，那就是NIO最主要的就是缓冲，了解缓冲的一些操作将会更加了解如何运用NIO。
 * 
 * @author pzr
 *
 */
public class NIOUtil {

	public static void main(String[] args) {
//		FileReadUtil.read("/home/save/cms", "/home/save/cmstemp");
//		BufferOpt.test();

		FileReadUtil.mappedByteBufferWrite();
		FileReadUtil.mappedByteBufferRead();
	}

}



/**
 * 简单的对文件的读取和写入。 read - buffer - writer 。
 * 
 * @author pzr
 *
 */
class FileReadUtil {
	
	
	public static void mappedByteBufferWrite(){
		try {
			RandomAccessFile ras = new RandomAccessFile("/home/save/cmstemp", "rw");
			FileChannel writeChannel = ras.getChannel() ;
			MappedByteBuffer mbb = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
			mbb.put("this is a mappedByteBuffer test !".getBytes("utf-8")) ;
			writeChannel.close();
			ras.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void mappedByteBufferRead(){
		try {
			RandomAccessFile raf = new RandomAccessFile("/home/save/cmstemp", "rw");
			FileChannel fc = raf.getChannel();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, raf.length() ) ;
			while( mbb.hasRemaining() ){
				System.out.print( (char)mbb.get() );
			}
			fc.close();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void read(String fileName, String dsc) {
		File file = new File(fileName);
		File out = new File(dsc);
		if (!out.exists()) {
			try {
				out.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		/*
		 * Nio 最主要的就是缓冲，缓冲最主要的就是理解对缓冲的一些操作
		 * 从读到写，都必须经过缓冲才行。 读 -  缓冲 - 写 ; 读 (缓冲：pos 0 lim 3 cap 3 )- 缓冲(pos 3 lim 3 cap 3) - flip( 此时缓冲当中已经满了，pos=3，所以经过flip操作至0,才能从0写到3)
		 * 写( pos 3 lim 3 cap 3 说明已经写入完成）  - clear（将pos置0,重新等待接收新的值）
		 *  
		 */
		try {
			fos = new FileOutputStream(out);
			fis = new FileInputStream(file);
			FileChannel fileChannel = fis.getChannel();
			FileChannel writeChannel = fos.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(3);
			while (true) {
				// 清空缓冲
				byteBuffer.clear();
				System.out.println( byteBuffer +"--1");
				int len = fileChannel.read(byteBuffer);
				if (len == -1) {
					break;
				}
				// 输出： limit：1024 ， position： 0 ， capacity = 1024
				// System.out.println( byteBuffer );
				// 重置缓冲 limit：16（实际读取的字节大小） ， capactiy：1024 ， position：0
				 System.out.println( byteBuffer +"--2");
				byteBuffer.flip();
				System.out.println( byteBuffer +"--3"); 
				writeChannel.write(byteBuffer);
				System.out.println( byteBuffer +"--4"); 
			}
			fileChannel.close();
			writeChannel.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/**
 * limit：缓冲区的实际上限
 * position：当前缓冲区位置，将从下一个位置开始写数据
 * capactiy：缓冲区的总容量上限
 * 					pos mark lim              作用 
 * flip()：          0      0    置零前pos   读写切换 
 * clear()：		 0      0    置为cap		写入数据 
 * rewind()：	 0      0	   未改动			读取buffer有效数据准备 
 * mark() : 标志位 ， 为下一次操作标志 
 * reset() : 返回标志位mark
 * 复制缓冲区，使共用一个内存，那么使多个修改成为可能。
 * 聚集和散射，可以把一个缓冲散射成多个，也可以把多个缓冲聚集成一个
 * 直接映射内存操作 -- 对于利用以上的知识，可以比以前的I/O速度提升了很多。但是这个方法将会更加提升一个度，单独写model
 * @author pzr
 *
 */
class BufferOpt {

	public static void test() {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		for( int i = 0 ; i < 15 ; i++ ){
			buffer.put( (byte)i );
		}
		System.out.println("--------------------------放入数据1-15-----------------------");
		System.out.println( buffer );
		System.out.println("--------------------------flip后-----------------------");
		// pos lim cap 15 15 15
		buffer.flip();
		System.out.println( buffer );
		System.out.println("--------------------------读取数据1-5-----------------------");
		// pos lim cap 0  15 15
		for ( int i = 0 ;i < 5 ; i++ ){
			//输出：01234
			System.out.print( buffer.get() );
		}
		System.out.println( buffer );
		// pos lim cap 5 15 15
//		buffer.flip();  // 重置pos 并且将lim = pos 多用于读取数据转换写数据的时候
		// pos lim cap 0 5 15
		buffer.rewind();  //清除标志位
		System.out.println("--------------------------rewind后-----------------------");
		System.out.println( buffer );
		// pos lim cap 0 15 15
//		System.out.println( buffer );
		//将 i 改成10 ，报错。
		for ( int i = 0 ;i < 5 ; i++ ){
			//输出：01234
			System.out.print( buffer.get() );
		}
		//pos lim cap 5 5 15
		buffer.clear(); //将 buffer重置，并且清除limit，无法获知buffer真实有效数据，用于重新学buffer
		//pos lim cap 0 15 15
		for ( int i = 0 ;i < 10 ; i++ ){
			//输出：0-9
			System.out.print( buffer.get() );
		}
		//pos lim cap 10 15 15
		
		//mark reset
		for ( int i = 0 ;i < 5 ; i++ ){
			//输出：10-15
			System.out.print( buffer.get() );
		if( i ==2 ){
				buffer.mark();
			}
		}
		buffer.reset();
		while( buffer.hasRemaining() ){
			System.out.print( "mark:"+ buffer.get() );
		}
		
		//复制缓冲区
		System.out.println("\n------------------------------复制缓冲区-----------------------");
		buffer.clear();
		ByteBuffer buffer2 = buffer.duplicate();
		System.out.println( buffer2 +" "+ buffer );
//		buffer.get();buffer.get(); //后移 pos2位
		System.out.println( buffer2 +" "+ buffer );
		buffer2.put( (byte)9 );
		buffer.put(3,(byte)8); // buffer 添加后的数据会覆盖buffer2的数据
		System.out.println( buffer2 +" "+ buffer );
		buffer.clear();
		buffer2.clear();
		while(buffer2.hasRemaining() ){
//			System.out.print( buffer.get() );
			System.out.print( buffer2.get() );
		}
		
		System.out.println("\n---------------------------分片缓冲区---------------------------------");
		buffer.clear();
		buffer.position(2);
		buffer.limit(6);
		ByteBuffer subBuffer = buffer.slice(); // 切片段，片段和主片段共享切片
		System.out.println( subBuffer );
		int i = 0 ;
		while(subBuffer.hasRemaining()  ){
			int temp = 10 * subBuffer.get();
			subBuffer.put( i , (byte)temp);
			i++;
		}
		buffer.clear();
		while( buffer.hasRemaining() ){
			System.out.print( buffer.get() + " " );
		}
		
		System.out.println("\n---------------------------聚集和散射---------------------------------");
		ByteBuffer temp , temp2;
		try {
			System.out.println("----------散射5byte this is a test .-----------");
			temp = ByteBuffer.allocate(5);
			temp2 = ByteBuffer.allocate(5);
			ByteBuffer[] buffers = new ByteBuffer[]{temp,temp2};
			File file = new File("/home/save/cms");
			FileInputStream fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			fc.read(buffers);
			
			String s1 = new String( buffers[0].array(), "utf-8" ) ;
			String s2 = new String( buffers[1].array(), "utf-8" ) ;
//			String s3 = new String( buffers[0].array(), "utf-8" ) ;
			System.out.println("s1:"+s1 +" s2:"+ s2);
			fc.close();
			fis.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------聚集 this is a test . hello world -----------");
		
		ByteBuffer temp3 , temp4;
		try {
			temp3 = ByteBuffer.wrap(" this is a test ".getBytes("utf-8"));
			temp4 = ByteBuffer.wrap(" hello world ".getBytes("utf-8"));
			File file = new File("/home/save/cmstemp");
			FileOutputStream fos = new FileOutputStream( file );
			FileChannel writeChannel = fos.getChannel();
			ByteBuffer[] buffs = new ByteBuffer[]{temp3,temp4};
			writeChannel.write( buffs );
			// cmstemp : this is a test hello world
			writeChannel.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n" + buffer );
		
		
		
		
		
		
	}

	
	
	
}
