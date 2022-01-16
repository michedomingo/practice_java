package ch5hw.ex7;

/**
 * The Country class defines a country object.
 * The country name, capital, and population can be specified and updated.
 */
public class Country {
    /** name of country */
    private String name;
    /** capital of country */
    private String capital;
    /** population of country */
    private double population;

    /**
     * Constructs a new Country initialized with
     * country 'Philippines', capital 'Manila', population 109.6.
     */
    public Country() {
        this("Philippines", "Manila", 109.6);
    }

    /**
     * Constructs a new Country with the specified arguments.
     * 
     * @param str the name of a country.
     * @param cap the capital of the country.
     * @param pop the population of the country.
     */
    public Country(String str, String cap, double pop) {
        name = str;
        capital = cap;
        population = pop;
    }

    /**
     * Method to get country name.
     * 
     * @return the name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the country name to specified string.
     * 
     * @param newName the name of a country.
     */
    public void changeName(String newName) {
        name = name.replace(name, newName);
    }

    /**
     * Method to get country capital.
     * 
     * @return the capital of the country.
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Method to change the country capital to specified string.
     * 
     * @param newCapital the capital of the country.
     */
    public void changeCapital(String newCapital) {
        capital = capital.replace(capital, newCapital);
    }

    /**
     * Method to get country population.
     * 
     * @return the population of the country.
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Method to change the country population to specified string.
     * 
     * @param newPopulation the population of the country.
     */
    public void changePopulation(double newPopulation) {
        population = newPopulation;
    }

    public static void main(String[] args) {
        Country country1 = new Country();
        System.out.println(String.format("country1 original name: %s", country1.getName()));
        System.out.println(String.format("country1 original capital: %s", country1.getCapital()));
        System.out.println(String.format("country1 original population: %.2f", country1.getPopulation()));
        System.out.println();
        country1.changeName("Greece");
        country1.changeCapital("Athens");
        country1.changePopulation(10.72);
        System.out.println(String.format("country1 name updated: %s", country1.getName()));
        System.out.println(String.format("country1 capital updated: %s", country1.getCapital()));
        System.out.println(String.format("country1 population updated: %.2f", country1.getPopulation()));
        System.out.println();
        Country country2 = new Country("Australia", "Canberra", 25.69);
        System.out.println(String.format("country2 original name: %s", country2.getName()));
        System.out.println(String.format("country2 original capital: %s", country2.getCapital()));
        System.out.println(String.format("country2 original population: %.2f", country2.getPopulation()));
        System.out.println();
        country2.changeName("Egypt");
        country2.changeCapital("Cairo");
        country2.changePopulation(102.3);
        System.out.println(String.format("country2 name updated: %s", country2.getName()));
        System.out.println(String.format("country2 capital updated: %s", country2.getCapital()));
        System.out.println(String.format("country2 population updated: %.2f", country2.getPopulation()));
    }
}

// ch5_p162_pdf167, hw1_p187_pdf192_ex7
// ch5_p180_pdf186, hw1_p187_pdf192_ex8
