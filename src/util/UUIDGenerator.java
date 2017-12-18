package util;

import java.util.UUID;

public final class UUIDGenerator {
	private UUIDGenerator() {
	}

	public final static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replaceAll("-", "");
		str = MD5Tool.MD5(str);
		return str;
	}

}
