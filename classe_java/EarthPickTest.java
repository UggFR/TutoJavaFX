package tutoriel;

import java.net.URL;


import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.stage.Stage;



public class EarthPickTest extends Application {

    private static final float TEXTURE_LAT_OFFSET = -0.2f;
    private static final float TEXTURE_LON_OFFSET = 2.8f;

    public Group earth;

  
    
    @Override
    public void start(Stage primaryStage) {

        //Create a Pane et graph scene root for the 3D content
        Group root3D = new Group();
        Pane pane3D = new Pane(root3D);

        // Load geometry
        ObjModelImporter objImporter = new ObjModelImporter();
        try {
            URL modelUrl = this.getClass().getResource("Earth/earth.obj");
            objImporter.read(modelUrl);
        } catch (ImportException e) {
            // handle exception
            System.out.println(e.getMessage());
        }
        MeshView[] meshViews = objImporter.getImport();
        earth = new Group(meshViews);
        
        root3D.getChildren().add(earth);
         root3D.setFocusTraversable(true);

        
        root3D.addEventHandler(MouseEvent.ANY, event -> {
        	if (event.getEventType() == MouseEvent.MOUSE_PRESSED && event.isControlDown())
        	{
        		PickResult pickResult = event.getPickResult();
        		System.out.println(pickResult.getIntersectedNode().getId());
        		System.out.println(pickResult.getIntersectedPoint());

        	}
        });
        
        
        
        // Add a camera group
        PerspectiveCamera camera = new PerspectiveCamera(true);
        new CameraManager(camera, pane3D, root3D);        

        // Add ambient light
        AmbientLight ambientLight = new AmbientLight(Color.WHITE);
        ambientLight.getScope().addAll(root3D);
        root3D.getChildren().add(ambientLight);

        // Create scene
        Scene scene = new Scene(pane3D, 600, 600, false,SceneAntialiasing.BALANCED);
        scene.setCamera(camera);
        scene.setFill(Color.gray(0.2));

        //Add the scene to the stage and show it
        primaryStage.setTitle("Earth Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

 
    
}
