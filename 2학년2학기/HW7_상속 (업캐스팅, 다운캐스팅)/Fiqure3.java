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
	Shape[] shapes;
	int numOfShape;
	
	public FigureEditor() {
		shapes=new Shape[100];
	}

	public void add(Shape s) {
		boolean isR=false;
		System.out.println("-------------------");
		if(s instanceof Rectangle) {
			isR=true;
			System.out.println("ADD 네모");
		}
		else {
			System.out.println("ADD 원");
		}
		
		boolean flag=true;
		for (int i = 0; i < numOfShape; i++) {
			if (isR) {
				if (shapes[i] instanceof Rectangle) {
					System.out.println(i + ": 이 둘은 서로 같은 네모입니다.");
					System.out.println(((Rectangle)shapes[i]).equals((Rectangle)s));
					if (((Rectangle)shapes[i]).equals((Rectangle)s)) {
						flag = false;
					}
				}
			}
			else {
				if (shapes[i] instanceof Circle) {
					System.out.println(i + ": 이 둘은 서로 같은 원입니다.");
					System.out.println(((Circle)shapes[i]).equals((Circle)s));
					if (((Circle)shapes[i]).equals((Circle)s)) {
						flag = false;
					}
				}
			}
		}
		if (flag) {
			shapes[numOfShape] = s;
			numOfShape += 1;
		}
		
	}

	public void display() {
		System.out.println("------Shapes ------");
		for(int i=0;i<numOfShape;i++) {
			System.out.println(shapes[i].toString());
		}
		
		

	}
}



public class Fiqure3 {

	public static void main(String[] args) {
		FigureEditor editor = new FigureEditor();
		
		Shape r1 = new Rectangle(1,2,3,4);
		Shape r2 = new Rectangle(2,3,4,5);
		Shape c1 = new Circle(3,4,5);
		Shape c2 = new Circle(4,5,6);
		
		editor.add(r1);
		editor.add(r2);
		editor.add(c1);
		editor.add(c2);
		editor.display();
		
		Rectangle r3 = new Rectangle(2,3,4,5);
		editor.add(r3);
		editor.display();
		
		r3.setX(1);
		editor.add(r3);
		Circle c3 = new Circle(4,5,6);
		editor.add(c3);
		editor.display();

	}

}
