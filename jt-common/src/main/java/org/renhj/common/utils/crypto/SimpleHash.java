package org.renhj.common.utils.crypto;

import java.io.ByteArrayInputStream;

/**
 * 简单的hash加密算法
 */
public class SimpleHash {
    private static final int DEFAULT_ITERATIONS=1;
    private String algorithmName;
    private int iterations;
    private byte[] sourceBytes;
    private byte[] saltBytes;
    private String hexEncoded;
    private String base64Encoded;

    public SimpleHash(String algorithmName, Object source){
        this(algorithmName, source, null, 1);
    }

    public SimpleHash(String algorithmName, Object source, String salt){
        this(algorithmName, source, null, 1);
    }

    public SimpleHash(String algorithmName, Object source, String salt, int iterations){
        this.hexEncoded = null;
        this.base64Encoded = null;
        this.algorithmName = algorithmName;
        this.sourceBytes = BytesUtils.objectToBytes(source);
        this.saltBytes = salt.getBytes();
        this.iterations = Math.max(1, iterations);


    }
}
