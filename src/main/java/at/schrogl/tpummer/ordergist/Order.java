package at.schrogl.tpummer.ordergist;

/*-
 * #%L
 * OrderPuzzle
 * %%
 * Copyright (C) 2019 - 2020 Fritz Schrogl
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Description https://gist.github.com/tpummer/dbdc0e7ea09368dc36a47650cad963ab
 */
public class Order {

	public static String order(String words) {
		if (words == null || words.isEmpty())
			return "";

		return Arrays.stream(words.split(" "))
			.sorted(new OrderComparator())
			.collect(Collectors.joining(" "));
	}

	private static class OrderComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return getInt(s1).compareTo(getInt(s2));
		}

		private Integer getInt(String s) {
			for (char c : s.toCharArray()) {
				if (c >= 48 && c <= 57) {
					return (int) c;
				}
			}
			return 0;
		}
	}
}
