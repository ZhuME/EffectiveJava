package com.zme.effectiveJava.构建器;


/**
 * @auth zme on 2019/1/16 13:53
 **/
//没有引入别的类
public class Iec104Message{
    /**
     * 四个byte的控制域
     */
    private byte[] ctrolField = new byte[4];
    /**
     * 接收到的生产数据
     */
    private byte[] asdu;
    /**
     * 第一个控制域位，存储的是发送序号
     */
    private static final int SEND_POSITION = 0;
    /**
     *  第二个控制域位，存储的是接收序号
     */
    private static final int RECV_POSITION = 2;
    /**
     * 为了测试当前传输的链路是否建立起来，主要是对U帧是否发送的测试
     */
    private static final short SERIES_ERROR = (short) -1;

    public static class Build{
        /**
         * 四个byte的控制域
         */
        private byte[] ctrolField = new byte[4];
        /**
         * 接收到的生产数据
         */
        private byte[] asdu;

        public Build setAsdu(byte[] asdu) {
            this.asdu = asdu;
            return this;
        }



        public Iec104Message builder(){
            return new Iec104Message(this);
        }
    }
    private Iec104Message(Build build){
        this.asdu = build.asdu;
        this.ctrolField = build.ctrolField;
    }


}
