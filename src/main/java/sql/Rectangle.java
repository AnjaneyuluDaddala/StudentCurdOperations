package sql;

import org.springframework.stereotype.Component;

@Component
public class Rectangle {
	public void area(int dim1,int dim2) {
		System.out.println("Area of Rectangle -->"+dim1*dim2);
	}

}
