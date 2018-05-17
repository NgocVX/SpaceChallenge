public class Rocket implements SpaceShip {
    protected int cost;
    protected int rocketWeight;
    protected int maxWeight;
    protected int currentWeight;
    protected int cargoCarried;
    protected int cargoLimit = 0;

    protected double rateExplosion;
    protected double rateCrash;
    protected double chanceOfLaunchExplosion;
    protected double chanceOfLandCrash;

    public Rocket() {
        this.cost = 0;
        this.rocketWeight = 0;
        this.currentWeight = 0;
        this.maxWeight = 0;
        this.cargoCarried = 0;
        this.cargoLimit = 0;

        this.rateExplosion = 0.0;
        this.rateCrash = 0.0;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (this.currentWeight + item.getWeight() > this.maxWeight) {
            return false;
        }
        return true;
    }

    @Override
    public void carry(Item item) {
        this.currentWeight += item.getWeight();
        this.cargoCarried = this.currentWeight - this.rocketWeight;
    }
}
