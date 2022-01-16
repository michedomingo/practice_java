package ch5hw.ex11;

/**
 * The IDCard class defines an identification card object.
 * The person's name, photo file name, and ID number can be specified and
 * updated.
 */
public class IDCard {
    /** name of person */
    private String personName;
    /** name of file containing person's photo */
    private String fileName;
    /** person's identification number */
    private int idNumber;

    /**
     * Constructs a new IDCard initialized with person's
     * name 'Mickey Mouse', fileName 'image/mickeymouse.jpg', idNumber 123456789.
     */
    public IDCard() {
        this("Mickey Mouse", "image/mickeymouse.jpg", 123456789);
    }

    /**
     * Constructs a new IDCard with the specified arguments.
     * 
     * @param name the name of person on IDCard.
     * @param file the name of file for person's photo.
     * @param id   the identification number.
     */
    public IDCard(String name, String file, int id) {
        personName = name;
        fileName = file;
        idNumber = id;
    }

    /**
     * Method to get person's name.
     * 
     * @return the name of the person.
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Method to change the person's name to specified string.
     * 
     * @param newPersonName the name of person on IDCard.
     */
    public void changePersonName(String newPersonName) {
        personName = personName.replace(personName, newPersonName);
    }

    /**
     * Method to get name file containing person's photo.
     * 
     * @return the name of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Method to change the file name to specified string.
     * 
     * @param newFileName the name of the file.
     */
    public void changeFileName(String newFileName) {
        fileName = fileName.replace(fileName, newFileName);
    }

    /**
     * Method to get the ID number on the identification card.
     * 
     * @return the identification number.
     */
    public int getNumber() {
        return idNumber;
    }

    /**
     * Method to change the ID number on the identification card.
     * 
     * @param newNumber the identification number.
     */
    public void changeNumber(int newNumber) {
        idNumber = newNumber;
    }

    public static void main(String[] args) {
        IDCard person1 = new IDCard();
        System.out.println(String.format("person1 name: %s", person1.getPersonName()));
        System.out.println(String.format("person1 photo file name: %s", person1.getFileName()));
        System.out.println(String.format("person1 ID number: %d", person1.getNumber()));
        System.out.println();
        person1.changePersonName("Mouse, Mickey");
        person1.changeFileName("image/mouseMickey.jpg");
        person1.changeNumber(7654321);
        System.out.println(String.format("person1 name updated: %s", person1.getPersonName()));
        System.out.println(String.format("person1 photo file name updated: %s", person1.getFileName()));
        System.out.println(String.format("person1 ID number updated: %d", person1.getNumber()));
        System.out.println();
        IDCard person2 = new IDCard("Little Mermaid", "image/littlemermaid.jpg", 333777);
        System.out.println(String.format("person2 name: %s", person2.getPersonName()));
        System.out.println(String.format("person2 photo file name: %s", person2.getFileName()));
        System.out.println(String.format("person2 ID number: %d", person2.getNumber()));
        System.out.println();
        person2.changePersonName("Mermaid, Little");
        person2.changeFileName("image/mermaidLittle.jpg");
        person2.changeNumber(777333);
        System.out.println(String.format("person2 name updated: %s", person2.getPersonName()));
        System.out.println(String.format("person2 photo file name updated: %s", person2.getFileName()));
        System.out.println(String.format("person2 ID number updated: %d", person2.getNumber()));
        System.out.println();
    }
}

// ch5_p162_pdf168, hw1_p188_pdf193_ex11
