package fu.infb.ueb11;

import java.util.Iterator;

import fu.infb.ueb11.vl.BinaryTree;
import fu.infb.ueb11.vl.BoundaryViolationException;
import fu.infb.ueb11.vl.EmptyTreeException;
import fu.infb.ueb11.vl.InvalidPositionException;
import fu.infb.ueb11.vl.Position;

public class BinaryTreeImpl<E> implements BinaryTree<E> {

	private Position[] tree;

	public BinaryTreeImpl(int size) {
		tree = new Position[size];
	}

	@Override
	public int size() {
		return tree.length;
	}

	@Override
	public boolean isEmpty() {
		return tree == null || tree.length == 0 ? true : false;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			int current = 0;

			@Override
			public boolean hasNext() {
				return current + 1 < tree.length ? true : false;
			}

			@Override
			public E next() {
				current = current + 1;
				return (E) tree[current].element();
			}
		};
	}

	@Override
	public Iterable<Position<E>> positions() {
		return new Iterable<Position<E>>() {

			@Override
			public Iterator<Position<E>> iterator() {
				return new Iterator<Position<E>>() {

					int current = 0;

					@Override
					public boolean hasNext() {
						return current + 1 < tree.length ? true : false;
					}

					@Override
					public Position<E> next() {
						current = current + 1;
						return tree[current];
					}
				};
			}
		};
	}

	@Override
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		return null;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		return null;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		return null;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException {
		return null;
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		return false;
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return false;
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		return false;
	}

	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		return null;
	}

	@Override
	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		return null;
	}

	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		return false;
	}

	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		return false;
	}

}
