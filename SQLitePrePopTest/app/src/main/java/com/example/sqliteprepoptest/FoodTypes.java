package com.example.sqliteprepoptest;

public class FoodTypes
{
	private String type;
	private double x;
	private double y;
	private double g;
	private double h;
	private boolean kg;
	private boolean gm;
	private boolean L;
	private boolean dL;
	private boolean mL;
	private boolean pcs;

	public FoodTypes(String type, double x, double y, double g, double h, boolean kg, boolean gm, boolean L, boolean dL, boolean mL, boolean pcs)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		this.g = g;
		this.h = h;
		this.kg = kg;
		this.gm = gm;
		this.L = L;
		this.dL = dL;
		this.mL = mL;
		this.pcs = pcs;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getG()
	{
		return g;
	}

	public void setG(double g)
	{
		this.g = g;
	}

	public double getH()
	{
		return h;
	}

	public void setH(double h)
	{
		this.h = h;
	}

	public boolean isKg()
	{
		return kg;
	}

	public void setKg(boolean kg)
	{
		this.kg = kg;
	}

	public boolean isGm()
	{
		return gm;
	}

	public void setGm(boolean gm)
	{
		this.gm = gm;
	}

	public boolean isL()
	{
		return L;
	}

	public void setL(boolean l)
	{
		L = l;
	}

	public boolean isdL()
	{
		return dL;
	}

	public void setdL(boolean dL)
	{
		this.dL = dL;
	}

	public boolean ismL()
	{
		return mL;
	}

	public void setmL(boolean mL)
	{
		this.mL = mL;
	}

	public boolean isPcs()
	{
		return pcs;
	}

	public void setPcs(boolean pcs)
	{
		this.pcs = pcs;
	}
}
