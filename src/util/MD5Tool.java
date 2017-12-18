package util;

import java.security.MessageDigest;

public final class MD5Tool {

	private MD5Tool() {
	}

	public final static String MD5(String src) {

		char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = src.getBytes();
			// 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			// MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
			mdInst.update(btInput);

			// 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
			byte[] md = mdInst.digest();

			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) { // i = 0
				byte byte0 = md[i]; // 95
				str[k++] = md5String[byte0 >>> 4 & 0xf]; // 5
				str[k++] = md5String[byte0 & 0xf]; // F
			}
			return new String(str).toUpperCase();
		} catch (Exception e) {
			return null;
		}
	}

}
