package generalServices;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAndPassCheckImpl implements UserAndPassCheck {

	@Override
	public String createPass(String user, String pass) {

		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes("UTF8"));
			byte s[] = m.digest();

			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
			}

			System.out.println("Digest:" + s);
			System.out.println("Rez: " + result);
			
			return result;
			
			

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	

}
