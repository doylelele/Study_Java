
class Shape {
	int x, y; //private로 변수를 만들면 밑에 상속받는 클래스들이 사용을 하지 못하여 default를 사용하였다.
	
	public Shape() {
		
	}
	
	public Shape(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

class Rectangle extends Shape{
	private int width, height;
	public Rectangle(int x, int y, int width, int height) {
		super(x,y);//슈퍼클래스의 x,y를 사용하기 위해 super 함수가 필요하다.
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		String strX, strY, strWidth, strHeight;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strWidth = Integer.toString(width);
		strHeight = Integer.toString(height);
		return "x=" + strX + ", " + "y=" + strY + ", " + "width=" + strWidth + ", " + "height=" + strHeight;
	}

	public boolean equals(Rectangle r) {
		if (r.getX() == this.x && r.getY() == this.y && r.getWidth() == this.width && r.getHeight() == this.height)
			return true;
		else
			return false;

	}
}

class Circle extends Shape {
	private int radius;
	
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius=radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		String strX, strY, strRadius;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strRadius = Integer.toString(radius);
		return "x=" + strX + ", " + "y=" + strY + ", " + "radius=" + strRadius;
	}

	public boolean equals(Circle c) {
		if (c.getX() == this.x && c.getY() == this.y && c.getRadius() == this.radius )
			return true;
		else
			return false;

	}

}


class FigureEditor {
	Rectangle[] rectangles;
	int numOfRect=0;
	Circle[] circles;
	int numOfCircle;
	
	public FigureEditor() {
		rectangles=new Rectangle[100];
		circles=new Circle[100];
	}

	public void add(Rectangle r) {
		boolean flag=true;
		for(int i=0;i<numOfRect;i++) {
			if(rectangles[i].equals(r))
				flag=false;
		}
		if (flag) {
			rectangles[numOfRect] = r;
			numOfRect += 1;
		}
		
	

	}
	
	public void add(Circle c) {
		boolean flag=true;
		for(int i=0;i<numOfCircle;i++) {
			if(circles[i].equals(c))
				flag=false;
		}
		if (flag) {
			circles[numOfCircle] = c;
			numOfCircle += 1;
		}
		
	

	}

	public void display() {
		for(int i=0;i<numOfRect;i++) {
			System.out.println(rectangles[i].toString());
		}
		
		for(int i=0;i<numOfCircle;i++) {
			System.out.println(circles[i].toString());
		}

		

	}
}

public class Firqure_2 {

	public static void main(String[] args) {
		FigureEditor editor = new FigureEditor();

		Rectangle r1 = new Rectangle(1, 2, 3, 4);
		Rectangle r2 = new Rectangle(2, 3, 4, 5);
		Circle c1 = new Circle(3, 4, 5);
		Circle c2 = new Circle(4, 5, 6);

		editor.add(r1);
		editor.add(r2);
		editor.add(c1);
		editor.add(c2);
		editor.display();

		Rectangle r3 = new Rectangle(2, 3, 4, 5);
		editor.add(r3); // r2와 동일한 Rectangle 객체 추가 시도
		editor.display();

		r3.setX(1);
		editor.add(r3); // (x=1, y=3, width=4, height=5) 추가
		Circle c3 = new Circle(4, 5, 6);
		editor.add(c3); // c2와 동일한 Circle 객체 추가 시도
		editor.display();

	}

}

