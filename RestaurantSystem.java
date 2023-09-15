/**
 *
 * @author (6406835)
 * 
 * Title:                                     Final Challenge - Restaurant Reservation System
 *                                                           
 *                                                          
 * Semester:                                  COP3337 - Summer 2023
 * 
 * Lecturer's name:                           Cristy Charters & Sean Lyon
 * 
 * Description of Program's Functionality:    Display a menu that will offer the user   
 *                                            options that will allow them to create and 
 *                                            manipulate reservations/walk-ins for a restaurant. 
 */
package restaurantsystem;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
/**
 *RestaurantSystem class - contains the main method that will call the validateMenu method,
 * containing the menu and options for the user to manipulate reservations/walk-ins.
 */
public class RestaurantSystem {
//Global variables
LinkedList<Reservation> theLL = new LinkedList();
Queue<Reservation> theQ = new LinkedList();
Scanner keyboard = new Scanner(System.in);
    /**
     * main method - calls validateMenu method
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RestaurantSystem rS = new RestaurantSystem();
        rS.validateMenu();
        
    }
    
    /**
     * void validateMenu - displays the menu of options available to the user. 
     *                     Depending on the user input, the corresponding method 
     *                     will be called. Menu options allow user to create, 
     *                     change, cancel, list, or seat reservations. It also
     *                     offers the options to add, list, or seat a walk-in.
     */
    public void validateMenu()
    {
        int menuOpt = 0;
        boolean errorOccurred = false;
        
        do
        {
            try
            {
            System.out.print("1.  Make a Reservation\n" +
                             "2.  Change a Reservation\n" +
                             "3.  Cancel a Reservation\n" +
                             "4.  List all of the Reservations\n" +
                             "5.  Seat a Reservation\n" +
                             "6.  Add a Walk-In\n" +
                             "7.  List all of the Walk-Ins\n" +
                             "8.  Seat a Walk-In\n" +
                             "9.  Exit\n" +
                             "Enter a value(1-9): ");   
            
            menuOpt = keyboard.nextInt();
            keyboard.nextLine();
            
            switch(menuOpt)
            {
            case 1:
                addReservation();
                break;
            case 2: 
                changeReservation();
                break;
            case 3:
                cancelReservation();
                break;
            case 4:
                listAllReservations();
                break;
            case 5:
                seatAReservation();
                break;
            case 6:
                addAWalkIn();
                break;
            case 7:
                listAllWalkIns();
                break;
            case 8:
                seatAWalkIn();
                break;
            case 9:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Must enter digit between (1-9)\n");
                menuOpt = 1;
                errorOccurred = true;
            }

            }catch(InputMismatchException e)
            {
                System.out.println("Incorrect option, enter digit (1-9)\n");
                keyboard.nextLine();
                menuOpt = 1;
                errorOccurred = true;
            }  
        }while(menuOpt >= 1 && menuOpt <= 8);
        
        
    }
    
    /**
     * void addReservation - method that asks the user for the necessary information 
     *                       to create a Reservation object, and will add the Reservation
     *                       object to global LinkedList theLL.  
     */
    public void addReservation()
    {
        boolean found = false;
        Reservation existRes;
        Reservation newRes = createReservation();
        ListIterator<Reservation> it = theLL.listIterator();
        
        while(it.hasNext() && !found)
        {
            existRes = it.next();
            if(existRes.compareTo(newRes) > 0)
            {
                it.previous();
                it.add(newRes);
                found = true;
                System.out.println("Added successfully!");
                System.out.println("");
            }
        }
        if(!found)
        {
            it.add(newRes);
            System.out.println("Added successfully!");
            System.out.println("");
        }
    }
    
    /**
     * void changeReservation - method that asks the user what they would like to switch
     *                          party size to. If the user would like to change anything 
     *                          else about reservation, they must create a new Reservation object.
     *                          The updated Reservation object will be added to 
     *                          global LinkedList theLL.
     */
    public void changeReservation()
    {
        boolean found = false;
        boolean errorFound = false;
        Reservation existRes;
        Reservation changeRes = createReservation();
        ListIterator<Reservation> it = theLL.listIterator();
        int userInput = 0;
        
        while(it.hasNext() && !found)
        {
            existRes = it.next();
            if(existRes.compareTo(changeRes) == 0)
            {
                do
                {
                try
                {
                System.out.print("What would you like your new party size to be? ");
                userInput = keyboard.nextInt();
                keyboard.nextLine();
                
                errorFound = false;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Error - must enter digit.");
                    errorFound = true;
                    keyboard.nextLine();
                }
                }while(errorFound);
                existRes.setPartySize(userInput);
                found = true;
                System.out.println("Party size changed!");
                System.out.println("");
                
            }
        }
        if(!found)
        {
            System.out.println("Sorry, the reservation you wanted to change does not exist.");
            System.out.println("Please go back to menu and choose option (1. Make a Reservation) if you would like to create a new reservation.");
            System.out.println("");
        }
    }
    
    /**
     * void cancelReservation - method that asks the user for the information regarding 
     *                          the reservation they would like to cancel. Then,
     *                          the Reservation object will be removed from 
     *                          global LinkedList theLL.
     */
    public void cancelReservation()
    {
        boolean found = false;
        Reservation existRes;
        Reservation deleteRes = createReservation();
        ListIterator<Reservation> it = theLL.listIterator();
        
        while(it.hasNext() && !found)
        {
            existRes = it.next();
            if(existRes.compareTo(deleteRes) == 0)
            {
                it.remove();
                System.out.println("Successfully cancelled!");
                found = true;
                System.out.println("");
            }
        }
        if(!found)
        {
            System.out.println("Sorry, the reservation you wanted to cancel does not exist.");
            System.out.println("");
        }
    }
    
    /**
     * void listAllReservations - method that will print all Reservation objects
     *                            within global LinkedList theLL.
     */
    public void listAllReservations()
    {
        boolean found = false;
        Reservation existRes;
        ListIterator<Reservation> it = theLL.listIterator();
        System.out.println("");
        while(it.hasNext())
        {
            existRes = it.next();
            System.out.println(existRes);
            found = true;
        }
        if(!found)
        {
            System.out.println("Reservation list is empty!");
        }
        //else
        //{
        //    System.out.println("List has no reservations!");   
        //}
        System.out.println("");
        
    }
    
    /**
     * void seatAReservation - method that asks the user for the information regarding 
     *                          the reservation that will be seated. Then,
     *                          the Reservation object will be removed from 
     *                          global LinkedList theLL.
     *                          *NOTE*: same as cancelReservation method, just a 
     *                          different print statement.
     */
    public void seatAReservation()
    {
        boolean found = false;
        Reservation existRes;
        Reservation deleteRes = createReservation();
        ListIterator<Reservation> it = theLL.listIterator();
        
        while(it.hasNext() && !found)
        {
            existRes = it.next();
            if(existRes.compareTo(deleteRes) == 0)
            {
                it.remove();
                System.out.println("Please come this way to be seated.");
                found = true;
                System.out.println("");
            }
        }
        if(!found)
        {
            System.out.println("Sorry, the reservation you wanted to seat does not exist.");
        }
    }
    
    /**
     * void addAWalkIn - method that will use the localDateTime class to fill in
     *                   the variables regarding the date and time. Then, will use
     *                   the information given by the user (first/last name and party size) 
     *                   to create the Reservation object and add it to the global Queue theQ.
     */
    public void addAWalkIn()
    {
        LocalDateTime now = LocalDateTime.now();
        // Get the current year, month, and day
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        // Get the current military hour and minute
        int hour = now.getHour();
        int minute = now.getMinute();
        
        int partySize = 0;
        
        boolean errorFound = false;
        do
        {
            try
            {
                System.out.print("Enter the size of your party: ");
                partySize = keyboard.nextInt();
                keyboard.nextLine();
                errorFound = false;
            }
            catch(InputMismatchException e)
            {
                errorFound = true;
                keyboard.nextLine();
                System.out.println("Invalid party size. Try again.");
            }
        }while(errorFound);
        
        //First and last name
        System.out.print("What is your last name: ");
        String lastName = keyboard.nextLine();
        System.out.print("What is your first name: ");
        String firstName = keyboard.nextLine();
        
        Reservation walkIn = new Reservation(year, month, day, hour, minute, lastName, firstName, partySize);
        theQ.add(walkIn);
        System.out.println("");
        System.out.println("Walk-in added to queue!");
        System.out.println("");
    }
    
    /**
     * void listAllWalkIns - method that will print the information of all the 
     *                       walk-ins within the global Queue theQ. 
     */
    public void listAllWalkIns()
    {
        Queue copyQ = new LinkedList<Reservation>();
        System.out.println("");
        boolean found = false;
        while(theQ.peek() != null)
        {
            Reservation res = theQ.poll();
            System.out.println(res);
            copyQ.add(res);
            found = true;
        }
        if(!found)
        {
            System.out.println("Queue is empty!");
        }
        System.out.println("");
        theQ = copyQ;
       
        
    }
    
    /**
    * void seatAWalkIn - method that will print a statement to seat a walk-in. 
    *                    Will remove the walk-in from the global Queue theQ. 
    */
    public void seatAWalkIn()
    {
        System.out.println("");
        if(theQ.peek() != null)
        {
        Reservation walkIn = theQ.remove();
        System.out.println("Follow me to your table " + walkIn);
        }
        else
        {
            System.out.println("Walk-in Queue is empty!");
        }
        System.out.println("");
    }
    
    /**
     * Reservation createReservation - method that will prompt the user for the 
     *                                 required information to create a Reservation 
     *                                 object. 
     * @return reservation - Reservation object containing information from the user
     */
    public Reservation createReservation()
    {
        int year = 0, month = 0, day = 0, hour = 0, minute = 0, partySize = 0;
        String lastName = "", firstName = "";
        
        boolean errorFound = false;
        //year, month, and day 
        do
        {
            try
            {
                System.out.print("Please enter the year of your reservation: ");
                year = keyboard.nextInt();
                System.out.print("Enter the month: ");
                month = keyboard.nextInt();
                System.out.print("Enter the day of the month: ");
                day = keyboard.nextInt();
                errorFound = false;
            }
            catch(InputMismatchException e)
            {
                errorFound = true;
                System.out.println("Invalid date. Try again.");
                keyboard.nextLine();
            }
        }while(errorFound);
        
        //hour and minutes
        errorFound = false;
        do
        {
            try
            {
                System.out.print("Please enter the hour of your reservation(Military time): ");
                hour = keyboard.nextInt();
                System.out.print("Enter the minute(Military time): ");
                minute = keyboard.nextInt();
                errorFound = false;
            }
            catch(InputMismatchException e)
            {
                errorFound = true;
                System.out.println("Invalid time. Try again.");
                keyboard.nextLine();
            }
        }while(errorFound);
        
        //party size
        errorFound = false;
        do
        {
            try
            {
                System.out.print("Enter the size of your party: ");
                partySize = keyboard.nextInt();
                keyboard.nextLine();
                errorFound = false;
            }
            catch(InputMismatchException e)
            {
                errorFound = true;
                keyboard.nextLine();
                System.out.println("Invalid party size. Try again.");
            }
        }while(errorFound);
        
        //First and last name
        System.out.print("What is your last name: ");
        lastName = keyboard.nextLine();
        System.out.print("What is your first name: ");
        firstName = keyboard.nextLine();
        
        System.out.println("");
        
        Reservation reservation = new Reservation(year, month, day, hour, minute, lastName, firstName, partySize);
        return reservation;
    }
    
}
