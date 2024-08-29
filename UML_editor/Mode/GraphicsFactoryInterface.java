package Mode;

import java.awt.Point;

import Shape.Line;
import Shape.Objects;

public interface GraphicsFactoryInterface {
    public Objects drawObject(int mode, Point clickPoint);
	public Line drawLine(int mode ,Point startP, Point endP); //mode 2 3 4

}
