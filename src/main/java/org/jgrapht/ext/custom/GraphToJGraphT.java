package org.jgrapht.ext.custom;

import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphToJGraphT {
	public static ListenableGraph<String, DefaultEdge> to(fu.infb.Graph src) {

		boolean[][] matrix = src.getMatrix();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				boolean b = matrix[i][j];

			}
		}
		return null;
	}
}
