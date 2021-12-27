package zoo;

import org.apache.commons.lang3.StringUtils;
import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.employee.Cleaner;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;
import zoo.exception.GondozooNotAvailable;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Save and load Zoo class, uses a .tmp file
 */
public class ZooSaver implements Serializable {

    /**
     * Newest function for saving our zoo to a txt file
     * file will be called "zoo.txt" in our root folder
     */
    public static void saveZooPrettier(Zoo zoo) {

    StringBuilder stringBuilder = new StringBuilder("Director" + " \n");
        if (zoo.getEmployeeManager().getDirector() != null) {
            stringBuilder.append(employeeStringBuilder(zoo.getEmployeeManager().getDirector()));
        } else {
            stringBuilder.append("null");
        }

        stringBuilder.append("Employee" + "\n");
        zoo.getEmployeeManager().getWorkers().forEach(employee -> {
            stringBuilder.append(employeeStringBuilder(employee)).append("\n");
        });


        stringBuilder.append("Animals" + "\n");
        zoo.getAnimals().forEach(
                animal -> {
                    stringBuilder.append(animalStringBuilder(animal));
                });

        try (BufferedWriter bufferedReader = new BufferedWriter(new FileWriter("zoo.txt"))) {

           bufferedReader.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Newest function for loading our zoo from a txt file
     * the "zoo.txt" file is in our root folder
     */
    public static Zoo loadZooPrettier() {

        Zoo tempZoo = new Zoo();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("zoo.txt"))) {

            String line = bufferedReader.readLine();
            Employee employee;

            String[] directorAttributes = bufferedReader.readLine().split(";");
                employee = new Director(
                        directorAttributes[0].trim(),
                        LocalDate.parse(directorAttributes[1]),
                        Enum.valueOf(Sex.class, directorAttributes[2]),
                        LocalDate.parse(directorAttributes[3]));
                tempZoo.addEmployee(employee);
            while (!(line = bufferedReader.readLine()).equals("Animals")) {

                String[] employeeAttributes = line.split(";");


                if (employeeAttributes[0].trim().equals("G")) {

                    List<AnimalType> animalTypes = Arrays.stream(employeeAttributes[4].split(",")).map(
                            animalTypeString -> Enum.valueOf(AnimalType.class,animalTypeString)
                    ).collect(Collectors.toList());

                    employee = new GondoZoo(
                            employeeAttributes[1],
                            LocalDate.parse(employeeAttributes[2]),
                            Enum.valueOf(Sex.class,employeeAttributes[3]),
                            animalTypes,
                            LocalDate.parse(employeeAttributes[5])
                    );
                } else if (employeeAttributes[0].trim().equals("C")) {

                    employee = new Cleaner(
                            employeeAttributes[1],
                            LocalDate.parse(employeeAttributes[2]),
                            Enum.valueOf(Sex.class,employeeAttributes[3]),
                            Arrays.stream(employeeAttributes[4].split(",")).map(
                                    cleaningAreaString -> Enum.valueOf(CleaningArea.class,cleaningAreaString)
                            ).collect(Collectors.toList()),
                            LocalDate.parse(employeeAttributes[5])
                    );
                }

                tempZoo.addEmployee(employee);

            }
            while ((line = bufferedReader.readLine()) != null) {
                String[] animalAttributes = line.split(";");
                Animal animal = new Animal(
                        Enum.valueOf(AnimalType.class, animalAttributes[0].trim()),
                        animalAttributes[1],
                        LocalDate.parse(animalAttributes[2]),
                        Enum.valueOf(Sex.class, animalAttributes[3]));

                tempZoo.addAnimal(animal);
            }


        } catch (IOException | GondozooNotAvailable e) {
            e.printStackTrace();
        }
        return tempZoo;
    }

    /**
     * Build a readable string format for a given animal. Fields are separated by ";".
     */
    public static String animalStringBuilder(Animal animal) {
        StringBuilder stringBuilder = new StringBuilder("\t");

            stringBuilder
                    .append(animal.getAnimalTypeString() + ";")
                    .append(animal.getNickname() + ";")
                    .append(animal.getBirthday() + ";")
                    .append(animal.getSex() + ";")
                    .append("\n");
            return stringBuilder.toString();
    }

    public static String employeeStringBuilder(Employee employee) {
        StringBuilder stringBuilder = new StringBuilder("\t");

        if (employee instanceof GondoZoo) {
            stringBuilder.append("G;");
        } else if (employee instanceof Cleaner) {
            stringBuilder.append("C;");
        }

        stringBuilder
                .append(employee.getName() + ";")
                .append(employee.getBirthDate() + ";")
                .append(employee.getSex() + ";");

        if (employee instanceof Cleaner) {
            stringBuilder
                    .append(
                            StringUtils.join(((Cleaner) employee).getCleaningArea(), ",") + ";"
                    );
        } else if (employee instanceof GondoZoo) {
            stringBuilder
                    .append(
                            StringUtils.join(((GondoZoo) employee).getCaredAnimalTypes(), ",") + ";"
                    );
        }

        stringBuilder.append(employee.getHireDate() + ";");

        return stringBuilder.toString();
    }

    /**
     * Old version for saving zoo to a .tmp file
     */
    public static void saveZoo(Zoo zoo) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("zoo.tmp", false));
            oos.writeObject(zoo);
            System.out.println("Az állatkert kimentve a zoo.tmp fileba");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * Old version for loading zoo from a .tmp file
     */
    public static Zoo loadZoo() {

        Zoo loadedZoo = new Zoo();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("zoo.tmp"));
            loadedZoo = (Zoo) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return loadedZoo;
    }
}
