package encryptor;

public class AlgorithmLocatorServiceFactoryFacade {

	public static Algorithm getAlgorithm(String algorithm) {
		invokeSlowly();
		return new Algorithm() {
			@Override
			public String encrypt(String text) {
				return "!5315" + text +"!5315";
			}
		};
	}

	private static void invokeSlowly() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
