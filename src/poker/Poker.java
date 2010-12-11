package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Poker {

	private static final Integer A = 14;
	private static final Integer K = 13;
	private static final Integer Q = 12;
	private static final Integer J = 11;
	
	List<Integer> ROYAL_FLUSH = Arrays.asList(new Integer[]{A, K, Q, J, 10});
	
	public Object detectaMao(String... cartas) {
		if(isRoyalFlush(cartas))
			return "Royal Flush";
		
		if(isStraightFlush(cartas))
			return "Straight Flush";

		if(isFourOfAKind(cartas))
			return "Four Of A Kind";
		
		return "";
	}


	private boolean isFourOfAKind(String[] cartas) {
		ordenaPeloRank(cartas);
		int numero_iguais = 1;
		for (int i = 1; i < cartas.length; i++) {
			numero_iguais = rank(cartas[i]) == rank(cartas[i-1])
				? numero_iguais+1 
				: 1;
			if (numero_iguais == 4)
				return true;
		}
		return false;
	}


	private boolean isStraightFlush(String... cartas) {
		if (!mesmoNaipe(cartas)) return false;
		
		ordenaPeloRank(cartas);
		
		for (int i = 1; i < cartas.length; i++) 
			if (rank(cartas[i]) - rank(cartas[i-1]) != 1)
				return false;
		return true;
	}


	private void ordenaPeloRank(String... cartas) {
		Arrays.sort(cartas, new Comparator<String>() { @Override public int compare(String carta1, String carta2) {
			return rank(carta1) - rank(carta2);
		}});
	}
	
	
	private boolean isRoyalFlush(String[] cartas) {
		if (!mesmoNaipe(cartas)) return false;	
		
		for (String carta : cartas) 
			if (!ROYAL_FLUSH.contains(rank(carta)))
				return false;
		
		return true;
	}


	public boolean mesmoNaipe(String... cartas) {
		String naipe = naipe(cartas[0]);
		for (String carta : cartas)
			if (!naipe.equals(naipe(carta))) 
				return false;
		return true;
		
	}
	
	private String naipe(String carta) {
		return carta.split(" ")[1];
	}
	
	private int rank(String carta) {
		String rank = carta.split(" ")[0];
		if (rank.equals("A")) return A;
		if (rank.equals("K")) return K;
		if (rank.equals("Q")) return Q;
		if (rank.equals("J")) return J;
		return Integer.valueOf(rank);
	}
	
}
