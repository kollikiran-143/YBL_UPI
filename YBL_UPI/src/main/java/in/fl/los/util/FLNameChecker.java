package in.fl.los.util;

public class FLNameChecker {

	public static final float qualifyingMatch = 85;

	public static boolean nameMatchBool(String name1, String name2) {
		return nameMatchPct(name1, name2) >= qualifyingMatch;
	}

	public static boolean nameMatch3NamesBool(String name1, String name2, String name3) {
		return nameMatch3NamesPct(name1, name2, name3) >= qualifyingMatch;
	}

	public static float nameMatchPct(String name1, String name2) {
		float len1 = nameMatchOrderPct(name1, name2);
		float len2 = nameMatchOrderPct(name2, name1);
		return Math.max(len1, len2);
	}

	public static float nameMatch3NamesPct(String name1, String name2, String name3) {
		float lenPct12 = nameMatchPct(name1, name2);
		float lenPct23 = nameMatchPct(name2, name3);
		float lenPct31 = nameMatchPct(name3, name1);
		return Math.min(Math.min(lenPct12, lenPct23), lenPct31);
	}

	private static String lcs(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		int[][] arr = new int[l1 + 1][l2 + 1];

		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j))
					arr[i][j] = arr[i + 1][j + 1] + 1;
				else
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
			}
		}

		int i = 0, j = 0;
		StringBuffer sb = new StringBuffer();
		while (i < l1 && j < l2) {
			if (str1.charAt(i) == str2.charAt(j)) {
				sb.append(str1.charAt(i));
				i++;
				j++;
			} else if (arr[i + 1][j] >= arr[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}

		return sb.toString();
	}

	public static int lcsleni(String str1, String str2) {
		return lcslen(str1.toLowerCase(), str2.toLowerCase());
	}

	public static int lcslen(String str1, String str2) {
		String lcs = lcs(str1, str2);
		return lcs.length();
	}

	private static float nameMatchOrderPct(String name1, String name2) {
		if(name1 == null || name2 == null) {
			return 0;
		}
		
		name1 = name1.toLowerCase();
		name1 = name1.replaceAll("[^a-z ]", "");
		name2 = name2.toLowerCase();
		name2 = name2.replaceAll("[^a-z ]", "");

		String name1NoSpace = name1.replace(" ", "");
		String name2NoSpace = name2.replace(" ", "");

		if (name1.equals(name2)) {
			return 100;
		}
		if (name1NoSpace.equals(name2NoSpace)) {
			return 100;
		}

		int maxlen = 0;
		String[] name1Parts = name1.split(" ");
		String[] name2Parts = name2.split(" ");
		for (int i = 0; i < name1Parts.length; i++) {
			String name1Part = name1Parts[i].trim();
			if (name1Part.length() == 0) {
				continue;
			}
			if (name1Part.length() == 1) {
				// if initials, should be beginning of a name2Part
				for (int j = 0; j < name2Parts.length; j++) {
					if (name2Parts[j].startsWith(name1Part)) {
						// System.out.println("==> " + name2Parts[j] + "
						// startsWith " + name1Part + " : " + maxlen + " += " +
						// name1Part.length());
						maxlen += name1Part.length();
						break;
					}
				}
			} else {
				if (name2NoSpace.contains(name1Part)) {
					// exact contains match
					maxlen += name1Part.length();
					// System.out.println("==> " + name2NoSpace + " contains " +
					// name1Part + " : " + maxlen + " += " +
					// name1Part.length());
				} else {
					// LCS match
					float lcsLen = lcslen(name1Part, name2NoSpace);
					float matchFraction = lcsLen / name1Part.length();
					lcsLen *= matchFraction * 0.9;
					maxlen += lcsLen;
					// System.out.println("==> LCS ( " + name1Part + ", " +
					// name2NoSpace + ") : " + maxlen + " += " +
					// name1Part.length());
				}
			}
		}

		int name1NoSpaceLen = name1NoSpace.length();
		float matchPct = (float) (100 * maxlen) / (float) name1NoSpaceLen;

		return matchPct;
	}

}
