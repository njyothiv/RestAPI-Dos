package in.ashokit;

public class AreaV1 {
	
	private String shape;
	private int area;
		
	public AreaV1(String shape, int area) {
		this.shape = shape;
		this.area = area;		
	}

	
	
	
	public String getShape() {
		return shape;
	}




	public void setShape(String shape) {
		this.shape = shape;
	}




	public int getArea() {
		return area;
	}




	public void setArea(int area) {
		this.area = area;
	}




	@Override
	public String toString() {
		return "AreaV1 [shape=" + shape + ", area=" + area + "]";
	}

}
