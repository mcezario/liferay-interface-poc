package com.teste.client.service;

public class ClientInfoService {

	private static String MOCK_WELCOME_FILE = "Bem vindo, Catioro!";
	
	public static String getWelcomeTitle() {
		return MOCK_WELCOME_FILE;
	}
	
	public static String setWelcomeTitle(String welcomeTitle) {
		return MOCK_WELCOME_FILE = welcomeTitle;
	}
	
}
