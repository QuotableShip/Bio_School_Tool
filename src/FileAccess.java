

import java.io.*;
import java.util.Vector;

public class FileAccess {

        void StoreClasses(Vector<TheClass> Classes) throws Exception {

            try {
                FileWriter file = new FileWriter("classes.txt");
                file.write(Classes.toString());
                file.close();
            } catch (Exception e) {
                throw new Exception(e);
            }
        }



}

