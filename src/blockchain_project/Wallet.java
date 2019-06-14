package blockchain_project;
import java.security.*;
import java.security.spec.*;

public class Wallet {
	public PrivateKey privatekey;
	public PublicKey publickey;
	
	public Wallet() {
		generateKeyPair();
	}
	public void generateKeyPair() {
		try{
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			keyGen.initialize(ecSpec, random);
			KeyPair keyPair = keyGen.generateKeyPair();
			privatekey = keyPair.getPrivate();
			publickey = keyPair.getPublic();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
