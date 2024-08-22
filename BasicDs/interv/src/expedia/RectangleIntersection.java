package expedia;

public class RectangleIntersection {
    int x1, y1, x2,y2;
    public RectangleIntersection(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public RectangleIntersection intersection(RectangleIntersection other){
        //Check for overlap
        if(x2<other.x1 || other.x2 < x1 || y2 < other.y1 || other.y2 < y1){
            return null;
        }
        //Calculate intersection
        int left = Math.max(x1, other.x1);
        int bottom = Math.max(y1,other.y1);
        int right = Math.min(x2, other.x2);
        int top = Math.min(y2, other.y2);

        return new RectangleIntersection(left,bottom,right,top);
    }

}
