package zoo;

import java.io.*;

/**
 * Save and load Zoo class, uses a .tmp file
 */
public class ZooSaver implements Serializable {

    public static void saveZoo(Zoo zoo) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream( new FileOutputStream("zoo.tmp",false) );
            oos.writeObject(zoo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Zoo loadZoo() {

        Zoo loadedZoo = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream("zoo.tmp") );
            loadedZoo = (Zoo) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return loadedZoo;
    }
}
