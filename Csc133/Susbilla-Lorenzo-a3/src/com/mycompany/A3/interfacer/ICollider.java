package com.mycompany.A3.interfacer;

public interface ICollider {
	public boolean collidesWith (ICollider otherObject);
	public void handleCollision(ICollider otherObject);
}
