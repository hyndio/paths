/**
 * @author hyd 2012-11-30 下午1:05:56 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

/** 
 * TODO
 * <p>
 *  
 */
public class PasswordEncoderTest {

	@Ignore
	@Test
	public void encoder() {
		MessageDigestPasswordEncoder encoder = new Md5PasswordEncoder();
		// salt
		System.out.println(encoder.encodePassword("1", "sysadmin"));
		System.out.println(encoder.encodePassword("1", "test"));
		//5536484b09fdfa322c70338849bcff11
		//2f604010b0ac5764e59edbf08b4fc68a
	}
}
