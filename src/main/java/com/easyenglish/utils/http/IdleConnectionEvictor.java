package com.easyenglish.utils.http;//package com.way.utils.http;
//
//import org.apache.http.conn.HttpClientConnectionManager;
///**
// *  用于清除无效请求IdleConnectionEvictor.java的实现
// * @author ASNPHXW
// *
// */
//public class IdleConnectionEvictor extends Thread {
//
//    private final HttpClientConnectionManager connMgr;
//
//    private volatile boolean shutdown;
//
//    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
//        this.connMgr = connMgr;
//        this.start();// 启动线程
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!shutdown) {
//                synchronized (this) {
//                    // 每隔5秒执行一个，关闭失效的http连接
//                    wait(5000);
//                    // 关闭失效的连接
//                    connMgr.closeExpiredConnections();
//                }
//            }
//        } catch (InterruptedException ex) {
//            // 结束
//        }
//    }
//
//    public void shutdown() {
//        shutdown = true;
//        synchronized (this) {
//            notifyAll();
//        }
//    }
//
//}