package challenge;

public class Challenge {
	
	private static String encrypt(String str) {
		StringBuilder sb = new StringBuilder();
		char[][] grid = makeGrid(str);
		//printGrid(grid);	// for debugging
		
		// encrypt the string
		for(int i = 0; i < grid[0].length; i++) {
			for(int j = 0; j < grid.length; j++) {
				// only append non-null characters to prevent spaces
				if(grid[j][i] != '\u0000') 	
					sb.append(grid[j][i]);
			}
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	private static char[][] makeGrid(String str) {
		// remove spaces
		String noSpaces = str.replace(" ", "");
		
		// determine dimensions
		double sqrtLength = Math.sqrt(noSpaces.length());
		int numRows = (int)sqrtLength;
		int numCols = (int) Math.ceil(sqrtLength);
		
		// make sure grid can contain all letters
		if(numRows * numCols < noSpaces.length()) {
			numRows++;
		}
		
		// populate grid
		char[][] grid = new char[numRows][numCols];
		int rowCount = 0;
		int colCount = 0;
		
		for(char ch : noSpaces.toCharArray()) {
			// if get to the end of the row, move to next row
			if(colCount == numCols) {
				rowCount++;
				colCount = 0;				
			}	
			grid[rowCount][colCount++] = ch;
		}
		return grid;
	}
	
	private static void printGrid(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String str1 = "if man was meant to stay on the ground god would have given us roots";
		String str2 = "have a nice day";
		String str3 = "feed the dog";
		String str4 = "chillout";		// length: 8, sqrt between 2 and 3 -> 3x3 grid
		String str5 = "aaaaaaaaaaaaa";	// length: 13, sqrt between 3 and 4 -> 4x4 grid
		
		System.out.println(encrypt(str1));
		System.out.println(encrypt(str2));
		System.out.println(encrypt(str3));
		System.out.println(encrypt(str4));
		System.out.println(encrypt(str5));	
	}
}
