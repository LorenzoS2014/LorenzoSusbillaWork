package com.mycompany.A3.interfacer;

import com.mycompany.A3.GameObject;

public interface IIterator {
	public boolean hasNext();
	public GameObject getNext();
	public int getCurrElementIndex();
}
