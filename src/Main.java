import java.util.ArrayList;

public class Main {
    public static final String ITEM_PHASE1_FILE = "phase-1.txt";
    public static final String ITEM_PHASE2_FILE = "phase-2.txt";

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> itemsPhase1 = simulation.loadItems(ITEM_PHASE1_FILE);
        ArrayList<Item> itemsPhase2 = simulation.loadItems(ITEM_PHASE2_FILE);

        System.out.println("\n= = = = = Load a fleet of U1 rockets for Phase-1 = = = = =");
        ArrayList u1Phase1RocketList = simulation.loadU1(itemsPhase1);
        int u1BudgetPhase1 = simulation.runSimulation(u1Phase1RocketList);

        System.out.println("\n= = = = = Load a fleet of U1 rockets for Phase-2 = = = = =");
        ArrayList u1Phase2RocketList = simulation.loadU1(itemsPhase2);
        int u1BudgetPhase2 = simulation.runSimulation(u1Phase2RocketList);

        System.out.println("Total budget for U1 rocket (phase-1, phase-2): " + (u1BudgetPhase1+u1BudgetPhase2) + " Million.");



        // ----------------------

        System.out.println("\n\n= = = = = Load a fleet of U2 rockets for Phase-1 = = = = =");
        ArrayList u2Phase1RocketList = simulation.loadU2(itemsPhase1);
        int u2BudgetPhase1 = simulation.runSimulation(u2Phase1RocketList);

        System.out.println("\n= = = = = Load a fleet of U2 rockets for Phase-2 = = = = =");
        ArrayList u2Phase2RocketList = simulation.loadU2(itemsPhase2);
        int u2BudgetPhase2 = simulation.runSimulation(u2Phase2RocketList);

        System.out.println("Total budget for U2 rocket (phase-1, phase-2): " + (u2BudgetPhase1+u2BudgetPhase2) + " Million.");
    }
}
