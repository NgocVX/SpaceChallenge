public class U1 extends Rocket {
    public U1() {
        //  Rocket cost = $100 Million
        this.cost = 100;
        // Rocket weight = 10 Tonnes
        this.rocketWeight = 10000;
        // Max weight (with cargo) = 18 Tonnes
        this.maxWeight = 18000;
        this.currentWeight = this.rocketWeight;
        this.cargoLimit = this.maxWeight - this.rocketWeight;
        this.cargoCarried = this.currentWeight - this.rocketWeight;

        this.rateExplosion = 0.05;
        this.rateCrash = 0.01;
    }

    @Override
    public boolean launch() {
        double randomLaunch = Math.random();
        this.chanceOfLaunchExplosion = rateExplosion * (this.cargoCarried / this.cargoLimit)*10;
        return (this.chanceOfLaunchExplosion < randomLaunch);
    }

    @Override
    public boolean land() {
        double randomLand = Math.random();
        this.chanceOfLandCrash = this.rateCrash * (this.cargoCarried / this.cargoLimit)*10;
        return (this.chanceOfLandCrash < randomLand);
    }
}
