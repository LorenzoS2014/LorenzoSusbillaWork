package com.mycompany.A2.interfaces;

import com.mycompany.A2.GameObject;

public interface ICollection {
	public void add(GameObject obj);
	public IIterator getIterator();
}
