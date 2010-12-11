package tests;

import org.junit.Assert;
import org.junit.Test;

import poker.Poker;

public class DojoTests extends Assert {
	
	Poker poker = new Poker();

	@Test
	public void testaRoyalFlush() {
		assertMao("Royal Flush", "A Paus", "K Paus", "Q Paus", "J Paus", "10 Paus");
		assertNaoMao("Royal Flush", "A Ouros", "K Paus", "Q Paus", "J Paus", "10 Paus");
		assertNaoMao("Royal Flush", "A Paus", "K Paus", "Q Ouros", "J Paus", "10 Paus");
		assertNaoMao("Royal Flush", "A Paus", "K Paus", "Q Paus", "J Paus", "7 Paus");
		assertNaoMao("Royal Flush", "A Paus", "K Paus", "Q Paus", "2 Paus", "10 Paus");
		assertMao("Royal Flush", "K Paus", "A Paus", "Q Paus", "J Paus", "10 Paus");
	}

	
	@Test
	public void testaStraightFlush() {
		assertMao("Straight Flush", "2 Paus", "3 Paus", "4 Paus", "5 Paus", "6 Paus");
		assertNaoMao("Straight Flush", "2 Copas", "3 Paus", "4 Paus", "5 Paus", "6 Paus");
		assertNaoMao("Straight Flush", "2 Paus", "3 Paus", "4 Paus", "5 Paus", "7 Paus");
		assertMao("Straight Flush", "3 Paus", "2 Paus", "4 Paus", "5 Paus", "6 Paus");
		assertMao("Straight Flush", "6 Paus", "7 Paus", "8 Paus", "9 Paus", "10 Paus");
		assertMao("Straight Flush", "J Paus", "Q Paus", "8 Paus", "9 Paus", "10 Paus");
	}

	@Test
	public void fourOfAKind() {
		assertMao("Four Of A Kind", "2 Paus", "2 Ouros", "2 Copas", "2 Espadas", "6 Paus");
		assertMao("Four Of A Kind", "2 Ouros", "2 Paus", "2 Copas", "2 Espadas", "6 Paus");
	}

	private void assertMao(String mao, String... cartas) {
		assertEquals(mao, poker.detectaMao(cartas));
	}

	private void assertNaoMao(String mao, String... cartas) {
		assertFalse(mao.equals(poker.detectaMao(cartas)));
	}
	
}
