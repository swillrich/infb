package org.jgrapht.ext.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.DirectedGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.DirectedMultigraph;

public class GraphView extends JApplet {

	private static final long serialVersionUID = 3256444702936019250L;
	private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

	private JGraphModelAdapter<String, DefaultEdge> jgAdapter;

	public static void main(String[] args) {
		go(null);
	}

	public static void go(ListenableGraph<String, DefaultEdge> g) {
		GraphView applet = new GraphView();

		// create a JGraphT graph
		g = new ListenableDirectedMultigraph<String, DefaultEdge>(
				DefaultEdge.class);

		String v1 = "v1";
		String v2 = "v2";
		String v3 = "v3";
		String v4 = "v4";
		String v5 = "v6";
		String v6 = "v7";

		// add some sample data (graph manipulated via JGraphT)
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);

		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v1);
		g.addEdge(v4, v3);

		applet.init(g);

		JFrame frame = new JFrame();
		frame.getContentPane().add(applet);
		frame.setTitle("JGraphT Adapter to JGraph Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void init(ListenableGraph<String, DefaultEdge> g) {
		jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(g);

		JGraph jgraph = new JGraph(jgAdapter);

		adjustDisplaySettings(jgraph);
		getContentPane().add(jgraph);
		resize(DEFAULT_SIZE);

		Iterator<String> iterator = g.vertexSet().iterator();
		double sqrt = Math.sqrt(g.vertexSet().size());

		for (int row = 0, column = 0; iterator.hasNext(); column++) {
			if (column > sqrt) {
				row = row + 1;
				column = 0;
			}
			positionVertexAt(iterator.next(), row * 150, column * 100);
		}

	}

	private void adjustDisplaySettings(JGraph jg) {
		jg.setPreferredSize(DEFAULT_SIZE);

		Color c = DEFAULT_BG_COLOR;
		String colorStr = null;

		try {
			colorStr = getParameter("bgcolor");
		} catch (Exception e) {
		}

		if (colorStr != null) {
			c = Color.decode(colorStr);
		}

		jg.setBackground(c);
	}

	@SuppressWarnings("unchecked")
	// FIXME hb 28-nov-05: See FIXME below
	private void positionVertexAt(Object vertex, int x, int y) {
		DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
		AttributeMap attr = cell.getAttributes();
		Rectangle2D bounds = GraphConstants.getBounds(attr);

		Rectangle2D newBounds = new Rectangle2D.Double(x, y, bounds.getWidth(),
				bounds.getHeight());

		GraphConstants.setBounds(attr, newBounds);

		// TODO: Clean up generics once JGraph goes generic
		AttributeMap cellAttr = new AttributeMap();
		cellAttr.put(cell, attr);
		jgAdapter.edit(cellAttr, null, null, null);
	}

	/**
	 * a listenable directed multigraph that allows loops and parallel edges.
	 */
	private static class ListenableDirectedMultigraph<V, E> extends
			DefaultListenableGraph<V, E> implements DirectedGraph<V, E> {
		private static final long serialVersionUID = 1L;

		ListenableDirectedMultigraph(Class<E> edgeClass) {
			super(new DirectedMultigraph<V, E>(edgeClass));
		}
	}
}