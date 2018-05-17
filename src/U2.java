public class U2 extends Rocket {
    public U2() {
        // Rocket cost = $120 Million
        this.cost = 120;
        // Rocket weight = 18 Tonnes
        this.rocketWeight = 18000;
        // Max weight (with cargo) = 29 Tonnes
        this.maxWeight = 29000;
        this.currentWeight = this.rocketWeight;
        this.cargoLimit = this.maxWeight - this.rocketWeight;
        this.cargoCarried = this.currentWeight - this.rocketWeight;

        this.rateExplosion = 0.04;
        this.rateCrash = 0.08;
    }

    @Override
    public boolean launch() {
        double randomLaunch = Math.random();
        this.chanceOfLaunchExplosion = rateExplosion * (this.cargoCarried / this.cargoLimit);
        return (this.chanceOfLaunchExplosion < randomLaunch);
    }

    @Override
    public boolean land() {
        double randomLand = Math.random();
        this.chanceOfLandCrash = this.rateCrash * (this.cargoCarried / this.cargoLimit);
        return (this.chanceOfLandCrash < randomLand);
    }
}
