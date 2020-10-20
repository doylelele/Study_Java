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

	//int, ������ ���� x,y,width,height�� ���ڿ��� �ٲٴ� �Լ�. �ٲٴ� �Լ��� Integer.toString()�Լ��� �̿��Ѵ�. ��ȯ������ ���ڿ��� ��ȯ�Ѵ�.
	public String toString() {
		String strX, strY, strWidth, strHeight;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strWidth = Integer.toString(width);
		strHeight = Integer.toString(height);
		return "x=" + strX + ", " + "y=" + strY + ", " + "width=" + strWidth + ", " + "height=" + strHeight;
	}

	//�Է¹��� ��ü r�� ���� ��ü�� ������ �簢���̶�� ���� x,y,width,height ������ ���� ���� ���̹Ƿ� ������ ���� �ۼ��Ѵ�. ���� ��� ��ȯ������ true�� ��ȯ�Ѵ�.
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

	//Rectangle �Լ��� ����.
	public String toString() {
		String strX, strY, strRadius;
		strX = Integer.toString(x);
		strY = Integer.toString(y);
		strRadius = Integer.toString(radius);
		return "x=" + strX + ", " + "y=" + strY + ", " + "radius=" + strRadius;
	}

	//Rectangle �Լ��� ����.
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
	
	//�迭�� ũ�⸦ ���ϴ� �ڵ��ε� �˳���� 100���� �����Ͽ���.
	public FigureEditor() {
		rectangles=new Rectangle[100];
		circles=new Circle[100];
	}

	//flag������ �ϳ� �����Ͽ� �迭 �ȿ� ���� ��ü�� ���� ��� false�� �ǰ� �ϰ�, flag�� true�� ��쿡�� ��ü r�� �迭�� ����ǰ� �Ѵ�.
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
	
	//���� �ڵ�� ���������̴�.
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

	//�迭�� �Էµ� ��ü���� ���� ��µǰ� �ϴ� �ڵ��̴�. ������ �ۼ��� toString �ڵ带 �̿��Ѵ�.
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
		editor.add(r3); // r2�� ������ Rectangle ��ü �߰� �õ�
		editor.display();

		r3.setX(1);
		editor.add(r3); // (x=1, y=3, width=4, height=5) �߰�
		Circle c3 = new Circle(4, 5, 6);
		editor.add(c3); // c2�� ������ Circle ��ü �߰� �õ�
		editor.display();
	}

}
