package encryptor;

import java.util.Random;

public class SystemConfiguration {

	public static int isEncryptEnabled() {
		Random random = new Random();
		return random.nextInt(3) % 3 + 1;
	}

}
