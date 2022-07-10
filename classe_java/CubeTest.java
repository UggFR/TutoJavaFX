package tutoriel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class CubeTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Create a Pane et graph scene root for the 3D content
        Group root3D = new Group();
        Pane pane3D = new Pane(root3D);

        //Create cube shape
        Box cube = new Box(1, 1, 1);

        //Create Material
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.BLUE);
        //Set it to the cube
        // ...

        //Add the cube to this node
        // ...

        //Add a camera group
        PerspectiveCamera camera = new PerspectiveCamera(true);
        Group cameraGroup = new Group(camera);
        // ...

        //Rotate then move the camera
        Rotate ry = new Rotate();
        // ...

        Translate tz = new Translate();
        // ...

        // Add point light
        PointLight light = new PointLight(Color.WHITE);
        // ...

        // Create scene
        // ...

        //Add the scene to the stage and show it
        primaryStage.setTitle("Cubes Test");
        // ...
    }

    public static void main(String[] args) {
        launch(args);
    }
}
