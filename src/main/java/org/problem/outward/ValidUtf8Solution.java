package org.problem.outward;

/**
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，
 * 后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 */
public class ValidUtf8Solution {

    public static void main(String[] args) {

    }

    public boolean validUtf8(int[] data) {

        return false;

    }
}
