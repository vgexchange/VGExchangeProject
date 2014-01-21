package br.com.vgsolutions.vgexchange.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VGXORMUtil {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("vgx-desenv");
		factory.close();
	}
}
