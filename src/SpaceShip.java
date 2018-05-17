public interface SpaceShip {
    /**
     * a method that returns either true or false indicating if the launch was successful or if the rocket has crashed
     * @return
     */
    boolean launch();

    /**
     *  The success of the landing
     * @return
     */
    boolean land();

    /**
     * Check the rocket can carry such item or false if it will exceed the weight limit.
     * @param item
     * @return  true    rocket can carry item
     *          false   item will exceed the weight limit
     */
    boolean canCarry(Item item);

    /**
     * Takes an Item object and updates the current weight of the rocket
     * @param item
     */
    void carry(Item item);
}
