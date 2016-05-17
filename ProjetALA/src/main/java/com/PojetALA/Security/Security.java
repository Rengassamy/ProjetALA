package com.PojetALA.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BCryptPasswordEncoder bc= new BCryptPasswordEncoder(12);
System.out.println(bc.encode("1234"));

}
}