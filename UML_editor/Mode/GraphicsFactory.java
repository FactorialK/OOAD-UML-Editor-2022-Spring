package Mode;

import java.awt.Point;

import Shape.Associate;
import Shape.ClassObject;
import Shape.Composition;
import Shape.Generalization;
import Shape.Line;
import Shape.Objects;
import Shape.UserCaseObject;

public class GraphicsFactory implements GraphicsFactoryInterface {
    public Objects drawObject(int mode, Point clickPoint) {
        if (mode == 5) {
            return new ClassObject(clickPoint.x, clickPoint.y);
        } else if (mode == 6) {
            return new UserCaseObject(clickPoint.x, clickPoint.y);
        }
        return null;

    };

    public Line drawLine(int mode, Point startP, Point endP) {
        if (mode == 2) {
            return new Associate(startP.x,startP.y,endP.x,endP.y);
        } else if (mode == 3) {
            return new Generalization(startP.x,startP.y,endP.x,endP.y);
        } else if (mode == 4) {
            return new Composition(startP.x,startP.y,endP.x,endP.y);
        }
        return null;

    };

}
