package Shape;

public abstract class Line extends Graph {
    protected int[] Ports = new int[2];
    public Object fromObject, toObject;

    public void setPort(Object _from, int _fromPort, Object _to, int _toPort) {
        this.fromObject = _from;
        this.toObject = _to;
        this.Ports[0] = _fromPort;
        this.Ports[1] = _toPort;

    }

    public void resetLocation(int moveX, int moveY) {
        this.x1 += moveX;
        this.y1 += moveY;
        this.x2 += moveX;
        this.y2 += moveY;
    }

    public void resetLocation(int moveX, int moveY, int mode) {
        if (mode == 2) {
            this.x1 += moveX;
            this.y1 += moveY;
            this.x2 += moveX;
            this.y2 += moveY;
        } else {
            if (mode == 0) { // 動起點
                this.x1 += moveX;
                this.y1 += moveY;
            }
            if (mode == 1) { // 動終點
                this.x2 += moveX;
                this.y2 += moveY;
            }
        }

    } // x y 是偏移量

    public double[] rotateVec(double e, double f, double ang,
            boolean isChLen, double newLen) {
        double mathstr[] = new double[2];
        double vx = e * Math.cos(ang) - f * Math.sin(ang);
        double vy = e * Math.sin(ang) + f * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }
}
