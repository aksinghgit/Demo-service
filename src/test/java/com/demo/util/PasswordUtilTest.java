package com.demo.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author amritesh
 *
 */
@ExtendWith(MockitoExtension.class)
public class PasswordUtilTest {

	
	@Test
	public void generateSecurePasswordTest() {
		String myPassword = "amritPwd123";
         
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
        System.out.println(mySecurePassword);
        System.out.println(salt);
        assertNotNull(mySecurePassword);
        assertNotNull(salt);
	}

	@Test
	public void verifySecurePasswordTest() {
		String providedPassword = "amritPwd123";
		String securePassword = "9IzbTlS06ylRvDo0gG20UAypQa6INJItuXwIQiUNBk4=";
         
        String salt = "DL9wvCTV1M03u1tbBwvtqjVXEhQeYt";
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);        
        assertTrue(passwordMatch);
	}

}
