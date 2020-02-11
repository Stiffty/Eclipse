package little3D;

import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Controll {
    public Box box1;

    private double oldMousePosX;
    private double oldMousePosY;
    private double oldMousePosZ;
    private PhongMaterial material1 = new PhongMaterial();

    {
        material1.setDiffuseMap(new Image
                ("https://greenmountainveneer.com/wp-content/uploads/2018/11/Architectural-Red-Smooth600.jpg"));

    }

    public void drag1(MouseEvent mouseDragEvent) {
        System.out.println(oldMousePosX+mouseDragEvent.getX());
        box1.setMaterial(material1);
        box1.setRotate(((oldMousePosX+mouseDragEvent.getX())-(oldMousePosY+mouseDragEvent.getY())-(oldMousePosZ+mouseDragEvent.getZ()))/4);
//        box1.setRotate(oldMousePosX-mouseDragEvent.getY());
        box1.setRotationAxis(new Point3D(mouseDragEvent.getX(),mouseDragEvent.getY(),mouseDragEvent.getZ()));
    }

    public void click1(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX());
        oldMousePosY = mouseEvent.getY();
        oldMousePosX = mouseEvent.getX();
        oldMousePosZ = mouseEvent.getZ();
    }

}
