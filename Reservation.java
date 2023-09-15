package restaurantsystem;

/**
 * Reservation class - implements Comparable<Reservation>, contains the constructor
 *                     for the Reservation object, compareTo method, toString, and its 
 *                     respective getters and setters.
 */
public class Reservation implements Comparable<Reservation> {
    private int year;
    private int month;
    private int day;
    private int militaryHour;
    private int militaryMinute;
    private String lastName;
    private String firstName;
    private int partySize;

    /**
     * Reservation constructor - contains the necessary instance variables to create a Reservation object
     * @param year
     * @param month
     * @param day
     * @param militaryHour
     * @param militaryMinute
     * @param lastName
     * @param firstName
     * @param partySize 
     */
    public Reservation(int year, int month, int day, int militaryHour, int militaryMinute, String lastName, String firstName, int partySize) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.militaryHour = militaryHour;
        this.militaryMinute = militaryMinute;
        this.lastName = lastName;
        this.firstName = firstName;
        this.partySize = partySize;
    }
    
    /**
     * int compareTo - method that will compare the Reservation objects
     * @param other
     * @return retCode - int that is intended to keep Reservation objects in 
     *                   ascending order for LinkedList theLL
     */
    public int compareTo(Reservation other)
    {
         int retCode;
     
     if(this.year > other.year)
     {
         retCode = 1;
     }
     else if(this.year < other.year)
     {
         retCode = -1;
     }
    else if(this.month < other.month)
    {
        retCode = -1;
    }
    else if(this.month > other.month)
    {
        retCode = 1;
    }
    else if(this.day < other.day)
    {
        retCode = -1;
    }
    else if(this.day > other.day)
    {
        retCode = 1;
    }
    else if(this.militaryHour < other.militaryHour)
    {
        retCode = -1;
    }
    else if(this.militaryHour > other.militaryHour)
    {
        retCode = 1;
    }
    else if(this.militaryMinute < other.militaryMinute)
    {
        retCode = -1;
    }
    else if(this.militaryMinute > other.militaryMinute)
    {
        retCode = 1;
    }
    else
    {
        retCode = this.lastName.compareTo(other.lastName);
        if(retCode == 0)
        {
            retCode = this.firstName.compareTo(other.firstName);
        }
    }
    
    return retCode;
    }
    
    /**
     * int getYear - returns year
     * @return year 
     */
    public int getYear() {
        return year;
    }
    /**
     * void setYear - sets year variable
     * @param year 
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * int getMonth - returns month 
     * @return month
     */
    public int getMonth() {
        return month;
    }
    /**
     * void setMonth - sets month variable
     * @param month 
     */
    public void setMonth(int month) {
        this.month = month;
    }
    
    /**
     * int getDay - returns day
     * @return day
     */
    public int getDay() {
        return day;
    }
    /**
     * void setDay - sets day variable
     * @param day 
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * int getMilitaryHour - returns militaryHour
     * @return militaryHour 
     */
    public int getMilitaryHour() {
        return militaryHour;
    }
    /**
     * void setMilitaryHour - sets militaryHour variable
     * @param militaryHour 
     */
    public void setMilitaryHour(int militaryHour) {
        this.militaryHour = militaryHour;
    }
    
    /**
     * int getMilitaryMinute - returns militaryMinute
     * @return militaryMinute 
     */
    public int getMilitaryMinute() {
        return militaryMinute;
    }
    /**
     * void setMilitaryMinute - sets militaryMinute variable
     * @param militaryMinute 
     */
    public void setMilitaryMinute(int militaryMinute) {
        this.militaryMinute = militaryMinute;
    }

    /**
     * String getLastName - returns lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * void setLastName - sets lastName variable
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * String getFirstName - returns firstName
     * @return firstName 
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * void setFirstName - sets firstName variable
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * int getPartySize - returns partySize
     * @return partySize 
     */
    public int getPartySize() {
        return partySize;
    }
    /**
     * void setPartySize - sets partySize variable
     * @param partySize 
     */
    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    /**
     * String toString - returns a message with all the information for a Reservation object
     * @return message containing all information for Reservation object
     */
    @Override
    public String toString() {
        return "Reservation{" + "year=" + year + ", month=" + month + ", day=" + day + ", militaryHour=" + militaryHour + ", militaryMinute=" + militaryMinute + ", lastName=" + lastName + ", firstName=" + firstName + ", partySize=" + partySize + '}';
    }

    
    
    
}
