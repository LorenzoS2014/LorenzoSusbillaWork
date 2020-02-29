package com.mycompany.A2.interfaces;

import com.mycompany.A2.GameObject;

public interface IIterator {
	public boolean hasNext();
	public GameObject getNext();
	public int getCurrElementIndex();
}
