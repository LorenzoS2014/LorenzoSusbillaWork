package com.mycompany.A2;

import java.util.ArrayList;

import com.mycompany.A2.interfaces.ICollection;
import com.mycompany.A2.interfaces.IIterator;

public class GameCollection implements ICollection {
	
	private ArrayList<GameObject> gameObjects;
	public GameCollection() {
		gameObjects = new ArrayList<GameObject>();
	}
	@Override
	public void add(GameObject obj) {
		gameObjects.add(obj);
		
	}
	public void remove(GameObject obj) {
		gameObjects.remove(obj);
	}
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
		
	}
	public GameObject getObject(int index) {
		return gameObjects.get(index);
	}

	@Override
	public IIterator getIterator() {
		return new GameArrayListIterator();
	}
	private class GameArrayListIterator implements IIterator {
		
		private int currElementIndex;
		public GameArrayListIterator() {
			currElementIndex = -1;
		}
		@Override
		public boolean hasNext() {
			if (gameObjects.size() <= 0) return false;
			if (currElementIndex == gameObjects.size() - 1)
				return false;
			return true;
		}

		@Override
		public GameObject getNext() {
			currElementIndex++;
			return gameObjects.get(currElementIndex);
		}
		public int getCurrElementIndex() {
			return currElementIndex;
		}
		
	}
}
