package com.mycompany.A3.interfacer;

import com.mycompany.A3.GameObject;

public interface ICollection {
	public void add(GameObject obj);
	public IIterator getIterator();
}
