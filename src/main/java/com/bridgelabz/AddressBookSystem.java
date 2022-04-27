package com.bridgelabz;
import java.io.IOException;
import java.util.*;


public class AddressBookSystem {
    public static void main(String[] args) {
        /**
         * 1st display welcome msg
         */
        System.out.println("Welcome to Address Book Program");

        /**
         * crete a object for AddressBook class object name as addressBookMain
         */
        AddressBook addressBookMain = new AddressBook();
        /**
         * crete object for AddressBookFileNIO class, object name as openCSVService
         */
        AddressBookFileNIO addBookFileNIO = new AddressBookFileNIO();
        /**
         * crete object for OpenCSVService class, object name as openCSVService
         */
        OpenCSVService openCSVService = new OpenCSVService();
        /**
         * crete object for JSONService class, object name as JSONService
         */
        JSONService jsonService = new JSONService();
        /**
         * crete object for scanner class, object name as input
         */
        Scanner input = new Scanner(System.in);

        while (true) {
            /**
             * choose the option what u want
             */
            System.out.println("Choose the option between 1 - 18");
            System.out.println("1. Add address book to the system");
            System.out.println("2. Edit contact details of the address book");
            System.out.println("3. Delete contact details of the address book");
            System.out.println("4. Show particular address book by its name");
            System.out.println("5. Show address book system");
            System.out.println("6. Search person by the city or sate");
            System.out.println("7. View person by the city or state");
            System.out.println("8. Count by city or sate");
            System.out.println("9. Sort the address book by City");
            System.out.println("10. Sort the address book by State");
            System.out.println("11. Sort the address book by Zip");
            System.out.println("12. Writing data to file");
            System.out.println("13. Reading data from file");
            System.out.println("14. Writing data to CSV");
            System.out.println("15. Reading data from CSV");
            System.out.println("16. Writing data to JSON");
            System.out.println("17. Reading data from JSON");
            System.out.println("18. Exit");

            String option = input.next();

            /**
             * If u choose option 1
             * Adding address book to the system
             */
            if (option.equals("1")) {
                System.out.println("Number of Address Book to be added:");
                int noOfAddressBook = input.nextInt();

                /**
                 * using for loop for count andress book and enter the name of address book
                 */
                for (int i = 0; i < noOfAddressBook; i++) {
                    System.out.println("Enter the name of the Address Book");
                    input.nextLine();
                    String addressBookName = input.nextLine();

                    /**
                     * enter the persons no what u want
                     */
                    System.out.println(
                            "Enter the number of person's details to be added in address book: " + addressBookName);
                    int noOfPerson = input.nextInt();

                    /**
                     * crete a set, crete object name as phonebook
                     */
                    Set<ContactPerson> phoneBook = new HashSet<>();
                    /**
                     * calling the method
                     */
                    addressBookMain.setAddressBook(phoneBook);
                    /**
                     * using for loop they will count of how many persons is add in address book
                     */
                    for (int j = 0; j < noOfPerson; j++) {
                        /**
                         * fill the details of those persons
                         */
                        System.out.println("Enter the details of the Contact Person");
                        ContactPerson contactPerson = addressBookMain.addContactPersonDetails(input);
                        /**
                         * calling the addContactPerson from addressBookMain object
                         */
                        addressBookMain.addContactPerson(contactPerson);
                        /**
                         * persons firstname and last name
                         * for ex -Nilofar Mujawar
                         */
                        String name = contactPerson.getFirstName() + " " + contactPerson.getLastName();
                        /**
                         * all the details add then display this msg
                         */
                        System.out.println("The details of the " + name + " is added to the Address Book: "
                                + addressBookName + " successfully.");
                    }

                    /**
                     * set the addressbook
                     */
                    Set<ContactPerson> addressBook = addressBookMain.getAddressBook();
                    /**
                     * calling addAddressBookToSystem Frome addressBookMain object
                     */
                    addressBookMain.addAddressBookToSystem(addressBookName, addressBook);

                    System.out.println("Address Book: " + addressBookName + " is successfully added to the system.");
                }
                continue;
            }

            /**
             * if u choose option 2
             * Editing contact details of the address book
             */
            if (option.equals("2")) {
                /**
                 * enter the name of address book what u want and select the person details to be edited
                 */
                System.out.println("Enter the name of the address book of which person's details to be edited:");
                input.nextLine();
                /**
                 * addres book name in string type
                 */
                String addressBookName = input.nextLine();
                /**
                 * if in addressBookMain in present what u want address book name is edited then,
                 */
                if (addressBookMain.isPresentAddressBook(addressBookName)) {
                    /**
                     * enter the persons whose details to b edited
                     */
                    System.out.println("Enter the name of the person whose details to be edited:");
                    /**
                     * person name in string type
                     */
                    String personName = input.nextLine();
                    /**
                     *
                     */
                    if (addressBookMain.editContactPersonDetails(addressBookName, personName, input))
                        System.out.println("The contact details of the " + personName + " from " + addressBookName
                                + " is edited.");
                    else
                        System.out.println("Sorry, the contact details of the " + personName + " is not found in "
                                + addressBookName + ". We can't proceed to edit.");
                } else
                    System.out.println("Sorry, the address book: " + addressBookName
                            + " is not found in the system. We can't proceed to edit.");
                continue;
            }

            /**
             * if u choose option 3
             * Deleting contact details of the address book
             */
            if (option.equals("3")) {
                /**
                 * write the name of the address book from which u want to deleted that persons information
                 */
                System.out.println("Enter the name of the address book from which person's details to be deleted:");
                input.nextLine();
                /**
                 * addressbook name is string type
                 */
                String addressBookName = input.nextLine();
                /**
                 * if the address book name is present in the addressbookmain,whose name you have written then
                 */
                if (addressBookMain.isPresentAddressBook(addressBookName)) {
                    /**
                     * display the choice ,enter the name of person whose details to b deleted
                     */
                    System.out.println("Enter the name of the person whose details to be deleted:");
                    /**
                     * person name is string type
                     */
                    String personName = input.nextLine();
                    /**
                     * if the name of the person have u written in choice time and this name is present in addressbook  what u selected
                     * and this address book present in addressbookMain then
                     */
                    if (addressBookMain.deleteContactPersonDetails(addressBookName, personName))
                    /**
                     * display this msg is the contact details of the persons name frome addressbookname what u selected is delect
                     */
                        System.out.println("The contact details of the " + personName + " from " + addressBookName
                                + " is deleted.");
                    /**
                     * if  1st condition is false then execute this condition
                     */
                    else
                    /**
                     * if person name what u enter this is not present in address book then dispay this statment
                     */
                        System.out.println("Sorry, the contact details of the " + personName + " is not found in "
                                + addressBookName + ". We can't proceed to delete.");
                } else
                /**
                 * if u put it wrong address book name then display this msg
                 */
                    System.out.println("Sorry, the address book: " + addressBookName
                            + " is not found in the system. We can't proceed to delete.");
                continue;
            }

            /**
             * if u choose option no 4
             * Showing particular address book by its name
             */
            if (option.equals("4")) {
                /**
                 * display this msg and u put the address book name what u want
                 */
                System.out.println("Enter the name of the address book:");
                input.nextLine();
                /**
                 * addressbook name is string type
                 */
                String addressBookName = input.nextLine();
                /**
                 * if u put the address book name what u want, and this address book is presnt in addressbookmain then
                 */
                if (addressBookMain.isPresentAddressBook(addressBookName))
                /**
                 * show address book name in present addressbookmain
                 */
                    addressBookMain.showAddressBook(addressBookName);
                /**
                 * ist constion is false then else satement is execute
                 */
                else
                /**
                 * if by chance u written wrong address book name then display this msg
                 */
                    System.out.println("Sorry, Address Book: " + addressBookName + " is not present in the system.");
                continue;
            }

            /**
             * if u choose option 5
             * Show address book system
             */
            if (option.equals("5")) {
                /**
                 * calling showAddressbookSystem method from the addressBookMain object
                 */
                addressBookMain.showAddressBookSystem();
                continue;
            }

            /**
             * if u choose option 6
             * Searching person by the city or sate
             */
            if (option.equals("6")) {
                /**
                 * enter city name of person
                 */
                System.out.println("Enter the state/city name to search the persons:");
                input.nextLine();
                /**
                 * cityname is string type
                 */
                String cityOrStateName = input.nextLine();
                /**
                 * create list ,search a person in addressbookMain by city or state
                 */
                List<String> personsInCityOrState = addressBookMain.searchPersonByCityorState(cityOrStateName);
                /**
                 * if u enter the city or state name and the person is not present in address book then
                 */
                if (personsInCityOrState.size() == 0)
                /**
                 * display this msg and city name what u searched for
                 */
                    System.out.println("Sorry, there is no person in the " + cityOrStateName + ".");
                /**
                 * if 1st condition is false then else condition is execute
                 */
                else {
                    /**
                     * display list of persons and city or state name
                     */
                    System.out.println("The list of persons in the " + cityOrStateName + ":");
                    /**
                     * using  for each loop if got the person name by in city or state then print person name
                     */
                    personsInCityOrState.stream().forEach(personName -> System.out.println(personName));
                }
                continue;
            }

            /**
             * if u choose option 7
             * View person by the city or state
             */
            if (option.equals("7")) {
                /**
                 * enter the persons city name for view the person
                 */
                System.out.println("Enter the state/city name to view the persons:");
                input.nextLine();
                /**
                 * city or statename in string type
                 */
                String cityOrStateName = input.nextLine();
                /**
                 * using map and list ,view person by city or state in addressbookmain
                 */
                Map<String, List<String>> personCityStateMap = addressBookMain.viewPersonByCityOrState(cityOrStateName);
                if (personCityStateMap.size() == 0)
                /**
                 * if u enter wrong city name then display this msg
                 */
                    System.out.println("Sorry, there is no any details.");
                /**
                 * if 1st statement is false then else condition is excecute
                 */
                else {
                    /**
                     * if u put the correct city or state name
                     */
                    System.out.println("The mapping of city/state and persons:");
                    /**
                     * display the person name
                     */
                    System.out.println(personCityStateMap);
                }
                continue;
            }

            /**
             * if u choose option 8
             * Count by city or sate
             */
            if (option.equals("8")) {
                /**
                 * 1st enter the city or state name to the count person
                 */
                System.out.println("Enter the state/city name to count the persons:");
                input.nextLine();
                /**
                 * city or state name string type
                 */
                String cityOrStateName = input.nextLine();
                /**
                 * create list, search the person by city or state in addressbookmain and store in personInCityOrState
                 */
                List<String> personsInCityOrState = addressBookMain.searchPersonByCityorState(cityOrStateName);
                /**
                 * if u enter wrong city or state name then
                 */
                if (personsInCityOrState.size() == 0)
                /**
                 * display sorry there is no person in the cityname.
                 */
                    System.out.println("Sorry, there is no person in the " + cityOrStateName + ".");
                /**
                 * suppose 1st condition is false then else is executed
                 */
                else {
                    /**
                     * calling countPersonByCityorState method from the addressBookMain object
                     */
                    addressBookMain.countPersonByCityorState(cityOrStateName);
                }
                continue;
            }

            /**
             * if u choose option 9
             * Sort person details by the city or state
             */
            if (option.equals("9")) {
                /**
                 * crete map and list,in this case 1st we sorted the city and then persons view by city in addressbookmain
                 * and if got this person then store the data in personCitySortedMap
                 */
                Map<String, List<ContactPerson>> personCitySortedMap = addressBookMain.viewSortedByCity();
                /**
                 * if u put the wrong city name then
                 */
                if (personCitySortedMap.size() == 0)
                /**
                 * display this msg
                 */
                    System.out.println("Sorry, there is no any details.");
                /**
                 * if 1t condition is false u put the correct city name then
                 */
                else {
                    /**
                     * display this msg with city name
                     */
                    System.out.println("The address books are sorted by city:");
                    /**
                     * calling printSortedMap method from addressBookMain object
                     */
                    addressBookMain.printSortedMap(personCitySortedMap);
                }
                continue;
            }

            /**
             * if u choose option 10
             * Sort person details by the city or state
             */
            if (option.equals("10")) {
                /**
                 * crete map ,list 1st sorted by state and then view the person by state in addressbookmain
                 * if got this then store the data in personStateSortedMap
                 */
                Map<String, List<ContactPerson>> personStateSortedMap = addressBookMain.viewSortedByState();
                /**
                 * if u put the wrong state name then
                 */
                if (personStateSortedMap.size() == 0)
                /**
                 * display this msg
                 */
                    System.out.println("Sorry, there is no any details.");
                /**
                 * u put the correct state name and suppose 1st condition is false then else statement execute
                 */
                else {
                    /**
                     * if u put the correct state name then display this msg with statename
                     */
                    System.out.println("The address books are sorted by state:");
                    /**
                     * calling printSortedMap method from addressBookMain object
                     */
                    addressBookMain.printSortedMap(personStateSortedMap);
                }
                continue;
            }

            /**
             * if choose option no 11
             * Sort person details by the city or state
             */
            if (option.equals("11")) {
                /**
                 * crete map,list ,1st sorted the data by zip then view the person by zip,if got this details then this details
                 * store in personZipSortedMap
                 */
                Map<String, List<ContactPerson>> personZipSortedMap = addressBookMain.viewSortedByZip();
                /**
                 * if u put the zip code incorrect then
                 */
                if (personZipSortedMap.size() == 0)
                /**
                 * display this msg
                 */
                    System.out.println("Sorry, there is no any details.");
                /**
                 * if 1st condition was false then execute else statment
                 */
                else {
                    /**
                     * u put the correct zip then showing the result with zip code
                     */
                    System.out.println("The address books are sorted by zip:");
                    /**
                     * calling printSortedMap method from addressBookMain object
                     */
                    addressBookMain.printSortedMap(personZipSortedMap);
                }
                continue;
            }

            /**
             * if u choose option no 12
             * Writing data into file
             */
            if (option.equals("12")) {
                /**
                 * here we using try catch block for exception handling
                 */
                try {
                    /**
                     * calling the method from object
                     */
                    addBookFileNIO.writeToFile(addressBookMain.getAddressBookSystem());
                } catch (IOException e) {
                    e.getMessage();
                }
                continue;
            }

            /**
             * if u choose the option no 13
             * Reading data from file
             */
            if (option.equals("13")) {
                /**
                 * using try catch block for exception handling
                 */
                try {
                    /**
                     * calling readFromFile method from  addBookFileNIO object
                     */
                    addBookFileNIO.readFromFile();
                } catch (IOException e) {
                    e.getMessage();
                }
                continue;
            }

            /**
             * if u choose option no 14
             * Writing data into CSV
             */
            if (option.equals("14")) {
                /**
                 * using try catch block for execption handling
                 */
                try {
                    /**
                     * calling method from object
                     */
                    openCSVService.writetoCsv(addressBookMain.getAddressBookSystem());
                } catch (IOException e) {
                    e.getMessage();
                }
                continue;
            }

            /**
             * if choose the option no 15
             * Reading data from CSV
             */
            if (option.equals("15")) {
                /**
                 * using try catch block for exception handling
                 */
                try {
                    /**
                     * calling readCsv method from openCSVService object
                     */
                    openCSVService.readCsv();
                    /**
                     * catch block
                     */
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }

            /**
             * if u choose the option 16
             * Writing data into JSON
             */
            if (option.equals("16")) {
                /**
                 * here we using try catch block fro exception handling
                 */
                try {
                    /**
                     * calling the method frome object
                     */
                    jsonService.writeJson(addressBookMain.getAddressBookSystem());
                } catch (Exception e) {
                    e.getMessage();
                }
                continue;
            }

            /**
             * if u choose option no 17
             * Reading data from JSON
             */
            if (option.equals("17")) {
                /**
                 * variable
                 */
                int x=0;
                /**
                 * here we using try catch block for exeption handling
                 */
                try {
                    /**
                     * calling readJson method from jsonService object and result store in x variable
                     */
                    x=jsonService.readJson();
                    /**
                     * print the result
                     */
                    System.out.println(x);
                    /**
                     * catch block
                     */
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }

            /**
             * if u choose option 18
             * Exiting from the address book system
             */
            if (option.equals("18")) {
                /**
                 * display thank you msg
                 */
                System.out.println("Thank you.");
                /**
                 * if 1st condtion is true then break the condtion means remaining condition is not execute
                 */
                break;
                /**
                 * if u choose wrong no like 19 etc then else condtion execute
                 */
            } else
            /**
             * if u choose wrong option then display this msg
             */
                System.out.print("You entered the invalid option. Please, ");
        }
    }
}
