package hw7;

class Rectangle {
	private int x, y, width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
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

	//int, 정수로 받은 x,y,width,height를 문자열로 바꾸는 함수. 바꾸는 함수로 Integer.toString()함수를 이용한다. 반환값으로 문자열을 반환한다.
	public String toString() {
		String strX, strY, strWidth, strHeight;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strWidth = Integer.toString(width);
		strHeight = Integer.toString(height);
		return "x=" + strX + ", " + "y=" + strY + ", " + "width=" + strWidth + ", " + "height=" + strHeight;
	}

	//입력받은 객체 r이 현재 객체와 동일한 사각형이라는 뜻은 x,y,width,height 변수의 값이 같은 것이므로 다음과 같이 작성한다. 같을 경우 반환값으로 true를 반환한다.
	public boolean equals(Rectangle r) {
		if (r.getX() == this.x && r.getY() == this.y && r.getWidth() == this.width && r.getHeight() == this.height)
			return true;
		else
			return false;

	}
}

class Circle {
	private int x, y, radius;
	
	public Circle(int x, int y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	//Rectangle 함수와 같다.
	public String toString() {
		String strX, strY, strRadius;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strRadius = Integer.toString(radius);
		return "x=" + strX + ", " + "y=" + strY + ", " + "radius=" + strRadius;
	}

	//Rectangle 함수와 같다.
	public boolean equals(Circle c) {
		if (c.getX() == this.x && c.getY() == this.y && c.getRadius() == this.radius )
			return true;
		else
			return false;

	}

}

class FigureEditor {
	Rectangle[] rectangles; 
	int numOfRect;
	Circle[] circles;
	int numOfCircle;
	
	//배열의 크기를 정하는 코드인데 넉넉잡아 100으로 생성하였다.
	public FigureEditor() {
		rectangles=new Rectangle[100];
		circles=new Circle[100];
	}

	//flag변수를 하나 생성하여 배열 안에 같은 객체가 있을 경우 false가 되게 하고, flag가 true일 경우에만 객체 r이 배열에 저장되게 한다.
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
	
	//위에 코드와 마찬가지이다.
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

	//배열에 입력된 객체들을 전부 출력되게 하는 코드이다. 위에서 작성한 toString 코드를 이용한다.
	public void display() {
		for(int i=0;i<numOfRect;i++) {
			System.out.println(rectangles[i].toString());
		}
		
		for(int i=0;i<numOfCircle;i++) {
			System.out.println(circles[i].toString());
		}

		

	}
}

public class FirqureEditorTest {

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
