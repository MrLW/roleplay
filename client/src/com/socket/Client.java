package com.socket;

public class Client {

//	public static void main(String[] args) throws Exception {   
//		Protocol protocol = new Protocol() ;
//        protocol.setLen(13);
////        protocol.setProtocolId((short)1001);
////        protocol.setMessage("abcd".getBytes());
//        System.out.println("客户端启动");  
//        Socket socket = new Socket("localhost", 8899);  //启动socket，并连接本地主机的相应端口号  
//        PrintWriter out = new PrintWriter(socket.getOutputStream());    
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//从控制台获取输入的内容   
//        byte[] bs = ByteObjConverter.objectToByte(protocol);
//        //不断的获取输入的内容，并不断的发送给服务器，当输入shutdown时，跳出循环，停止运行  
//        while (true) {    
//            String msg = reader.readLine();    
//            out.println(bs);    
//            out.flush();    
//            if (msg.equals("shutdown")) {    
//                break;    
//            }    
//        }    
//        //执行相应的关闭操作  
//        socket.close();  
//        out.close();  
//        reader.close();  
//    }    
}
