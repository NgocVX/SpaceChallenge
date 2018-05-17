import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String textFile) {
        ArrayList<Item> itemList = new ArrayList<>();

        try {
            File file = new File(textFile);
            Scanner scanner = new Scanner(file);



            int indexOfEqual = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                indexOfEqual = line.indexOf('=');
                String name = line.substring(0, indexOfEqual);
                int weight = Integer.parseInt(line.substring(indexOfEqual+1));

                Item item = new Item();
                item.setName(name);
                item.setWeight(weight);
                itemList.add(item);
            }

        }catch (FileNotFoundException ex){
            System.out.println("O day co loi");
            ex.printStackTrace();
        }
        catch (NumberFormatException ex) {
            System.out.println("Have a error");
            ex.printStackTrace();
        }
        return  itemList;
    }

    /**
     * Creating rocket U1 and filling them with those item
     * @param   itemList     ArrayList of Items
     * @return  the ArrayList of those U1 rockets that are fully loaded.
     */
    public ArrayList<U1> loadU1(ArrayList<Item> itemList) {
        ArrayList<U1> rocketU1List = new ArrayList<U1>();

        U1 rocketU1 = new U1();
        for (Item item : itemList) {
            //U1 rocketU1 = new U1();
            if (rocketU1.canCarry(item)) {
                rocketU1.carry(item);
            }
            else {
                rocketU1List.add(rocketU1);
                rocketU1 = new U1();
                rocketU1.carry(item);

            }
        }
        // add last rocket
        rocketU1List.add(rocketU1);
        return rocketU1List;
    }

    /**
     * Create rocket U2 and filling them with those item
     * @param itemList Array of Item
     * @return array list of those U2 rockets that are fully loaded.
     */
    public ArrayList<U2> loadU2(ArrayList<Item> itemList) {
        ArrayList<U2> rocketU2List = new ArrayList<>();

        U2 rocketU2 = new U2();
        for (Item item : itemList) {
            if (rocketU2.canCarry(item)) {
                rocketU2.carry(item);
            }
            else {
                rocketU2List.add(rocketU2);
                rocketU2 = new U2();
                rocketU2.carry(item);
            }
        }
        // add last rocket
        rocketU2List.add(rocketU2);

        return rocketU2List;
    }


    public int runSimulation(ArrayList<Rocket> rocketArrayList) {
        int totalRocket = 0;
        int i = 0;
        for (Rocket rocket : rocketArrayList) {
            i++;
            System.out.println("------ " +i+ " Shipment --------");
            //  launch explosion
            boolean launchFail = true;
            // anding crash
            boolean landFail = true;
            while (launchFail || landFail) {
                totalRocket++;
                if (!rocket.launch()){
                    launchFail = true;
                    System.out.println("Rocket " +rocket.getClass().getName()+ " launch EXPLOSION.");
                    continue;
                }
                else {
                    launchFail = false;
                    System.out.println("Rocket " +rocket.getClass().getName()+ " successfully launched.");
                    if (!rocket.land()) {
                        landFail = true;
                        System.out.println("Rocket " +rocket.getClass().getName()+ " land CRASH.");
                        continue;
                    }
                    else{
                        landFail = false;
                        System.out.println("Rocket " +rocket.getClass().getName()+ " successfully landed.");
                    }
                }
            }
        }

        System.out.println("Ket qua phong tau vu tru, du dinh phong " +rocketArrayList.size()+ " lan, thuc te phong " +totalRocket+ " lan.");
        int totalBudget = totalRocket *rocketArrayList.get(0).cost;
        System.out.println("Budget: " + totalBudget + " Million.");
        return totalBudget;
    }

    /*public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems("phase-1.txt");
        int weighPhase = 0;
        for (Item item : items
             ) {
            weighPhase += item.getWeight();
            System.out.printf(item.getName() + "\t" +item.getWeight()+"\n");
        }

        ArrayList u1List = simulation.loadU1(items);
        ArrayList u2List = simulation.loadU2(items);

        System.out.println("So luong rocket U1:" + u1List.size());
        int weightTotal = 0;
        for (Object rocket : u1List) {
            U1 u1 = (U1) rocket;
            weightTotal += u1.cargoCarried;
            System.out.println("U1: " + u1.currentWeight/1000);
        }
        System.out.println("Check cargo:" + weighPhase + "\t" + weightTotal);

        simulation.runSimulation(u1List);
        simulation.runSimulation(u2List);
    }*/
}
