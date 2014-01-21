package br.com.vgsolutions.vgexchange.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VGXORMTestUtil {
	public static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("vgx-test");
	}
	
}
