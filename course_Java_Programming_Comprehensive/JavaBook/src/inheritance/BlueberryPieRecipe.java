package inheritance;

public class BlueberryPieRecipe extends PieRecipe {
    // overriding method
    public void getDirections() {
        super.getDirections(); // access overridden superclass method with 'super'
        System.out.println(
                "To prepare filling, combine blueberries, flour, lemon juice and sugar and put in pie pan, then cover with extra dough and bake.");

    }
}
