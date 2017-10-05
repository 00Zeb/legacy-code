package encryptor;

import org.junit.Assert;
import org.junit.Test;

public class EncryptorTest {

	@Test
	public void nothing() {
		Encryptor enc = new Encryptor();
		String result = enc.cryptWord("word");
		Assert.assertEquals("yqtf", result);

	}

	@Test
	public void testCryptWordToNumbers() {
		Encryptor enc = new Encryptor();
		String result = enc.cryptWordToNumbers("word");
		Assert.assertEquals("121113116102", result);

	}

	@Test
	public void testCryptWord() {
		Encryptor enc = new Encryptor();
		String result = enc.cryptWord("word", "word2");
		Assert.assertEquals("yqtf", result);

	}

	@Test
	public void testCryptSentence() {
		Encryptor enc = new Encryptor();
		String result = enc.cryptSentence("This is a correct test");
		Assert.assertEquals("Vjku\"ku\"c\"eqttgev\"vguv", result);

	}

	@Test
	public void testGetWords() {
		Encryptor enc = new Encryptor();
		String[] result = enc.getWords("This is a correct test");
		Assert.assertArrayEquals(new String[] { "This", "is", "a", "correct", "test" }, result);

	}

}
