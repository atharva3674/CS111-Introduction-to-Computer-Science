/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Atharva Patil 
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        
        // WRITE YOUR CODE HERE
        this.listOfPatients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {

        // WRITE YOUR CODE HERE

        this.listOfPatients[arrayIndex] = p;
        if(listOfPatients[arrayIndex].equals(p)){
            return 0;
        }
        
        return -1;
        
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {

        // WRITE YOUR CODE HERE
        this.listOfPatients = new Person[numberOfLines];
        int patients = 0;
        for(int i = 0; i < numberOfLines; i++){
            int iD = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();;
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealh = StdIn.readInt();

            Person person = new Person(iD, ethnicity, gender, age, cause, urgency, stateOfHealh);

            addPerson(person, i);
            patients++;
        }
        return patients;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        this.survivabilityByAge = new SurvivabilityByAge[numberOfLines];

        int survivabilities = 0;
        for(int i = 0; i < numberOfLines; i++){
            int age = StdIn.readInt();
            int yearsPostTransplant = StdIn.readInt();
            double rate = StdIn.readDouble();

            SurvivabilityByAge survive = new SurvivabilityByAge(age, yearsPostTransplant, rate);

            this.survivabilityByAge[i] = survive;
            survivabilities++;
        }

        return survivabilities;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        this.survivabilityByCause = new SurvivabilityByCause[numberOfLines];

        int survivabilities = 0;

        for(int i = 0; i < numberOfLines; i++){
            int cause = StdIn.readInt();
            int yearsPostTransplant = StdIn.readInt();
            Double rate = StdIn.readDouble();

            SurvivabilityByCause survive = new SurvivabilityByCause(cause, yearsPostTransplant, rate);
            survivabilityByCause[i] = survive;
            survivabilities++;
        }

        return survivabilities;

    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {

        // WRITE YOUR CODE HERE
        int n = 0;
        int count = 0;
        for(Person individual: this.listOfPatients){
            if(individual.getAge() > age){
                n++;
            }

        }

        if(n == 0){
            return null;
        }

        Person[] ageAbove = new Person[n];

        for(Person individual: this.listOfPatients){
            
            if(individual.getAge() > age){
                ageAbove[count] = individual;
                count++;
            }
            
        }

        return ageAbove;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {

        // WRITE YOUR CODE HERE
        int n = 0;
        int count = 0;
        for(Person individual: this.listOfPatients){
            
            if(individual.getStateOfHealth() == state){
                n++;
            }
        }

        if(n == 0){
            return null;
        }

        Person[] patientState = new Person[n];

        for(Person individual: this.listOfPatients){
            if(individual.getStateOfHealth() == state){
                patientState[count] = individual;
                count++;
            }
            
        }

        return patientState;

    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {

        // WRITE YOUR CODE HERE

        int n = 0;
        int count = 0;

        for(Person individual: this.listOfPatients){
            if(individual.getCause() == cause){
                n++;
            }

        if (n == 0){
            return null;
            }
        }

        Person[] heartCause = new Person[n];

        for(Person individual: this.listOfPatients){
            if(individual.getCause() == cause){
                heartCause[count] = individual;
                count++;
            }
            
        }

        return heartCause;

        
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {

        // WRITE YOUR CODE HERE

        Person[] heartsArray = new Person[numberOfHearts];
        Person[] age = new Person[this.listOfPatients.length];

        if(numberOfHearts > this.listOfPatients.length){
            return getListOfPatients();
        }

        for(int i = 0; i < heartsArray.length; i++){
            heartsArray[i] = this.listOfPatients[i];
        }

        return heartsArray;

        /*for(Person a : this.listOfPatients){
            age[]
        }
        for(int i = 0; i < this.listOfPatients.length; i++){
            int min = i;
            for(int j = i + 1; j < this.listOfPatients.length; j++){
                if(this.listOfPatients[min].getAge() > this.listOfPatients[j].getAge() )
                    min = j;
            }
            Person temp = this.listOfPatients[i];
            this.listOfPatients[i] = this.listOfPatients[min];
            this.listOfPatients[min] = temp;
        }

        for(int i = 0; i < heartsArray)*/

    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
             StdOut.println(rate);
        }

    }
}
