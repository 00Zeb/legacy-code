package encryptor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EncryptorTest {

	private Encryptor encryptor;

	@Before
	public void create() {
		encryptor = new Encryptor(){

			@Override
			protected Date getDate() {
				Calendar instance = Calendar.getInstance();
				instance.set(Calendar.YEAR, 2017);
				instance.set(Calendar.DAY_OF_YEAR, 0);
				instance.set(Calendar.HOUR_OF_DAY, 0);
				instance.set(Calendar.MINUTE, 0);
				instance.set(Calendar.SECOND, 0);
				instance.set(Calendar.MILLISECOND, 0);
				return instance.getTime();
			}
			
		};
		AlgorithmLocatorServiceFactoryFacade facadeStub = new AlgorithmLocatorServiceFactoryFacade(){
			@Override
			public Algorithm getAlgorithm(String algorithm) {
				return new Algorithm() {
					@Override
					public String encrypt(String text) {
						return "!5315word!5315";
					}
				};
			}
		};
		encryptor.setFacade(facadeStub);
	}

	@Test
	public void nothing() {
		String result = encryptor.cryptWord("word");
		assertEquals("yqtf", result);
	}

	@Test
	public void testCryptWordToNumbers() {
		String result = encryptor.cryptWordToNumbers("word");
		assertEquals("121113116102", result);
	}

	@Test
	public void testCryptWord() {
		String result = encryptor.cryptWord("word", "word2");
		assertEquals("yqtf", result);
	}

	@Test
	public void testCryptSentence() {
		String result = encryptor.cryptSentence("This is a correct test");
		assertEquals("Vjku\"ku\"c\"eqttgev\"vguv", result);
	}

	@Test
	public void testGetWords() {
		String[] result = encryptor.getWords("This is a correct test");
		assertArrayEquals(new String[] { "This", "is", "a", "correct", "test" }, result);
	}

	@Test
	public void testEncryptTime() {
		String result = encryptor.encryptTime();
		
		assertEquals("vjg\"vkog\"ku\"5303404238\"22<22<22<2222222\"tkijv\"pqy", result);
	}
	@Test
	public void testCrptExternal() {
		String result = encryptor.encryptExternal("word","");
		assertEquals("!5315word!5315", result);
	}

	
	
	
	
	
	
	
	
	
}
