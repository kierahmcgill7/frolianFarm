package lab;

import java.util.*;


public class PhoneBook {

    private final Map<String, List<String>> phoneBook; // creating a new phone book hashmap

    public PhoneBook() {
        phoneBook = new HashMap<>(); //instantiating hashmap in PhoneBook class method?



    }
    /*
    *Key is String, Value is an array list of strings
    *Key - name
    *Value is an array list of phone numbers
    *use if/else statement to check if key exists then add the element to value
    *if the key does not exist then value cannot exist
    *create new array list and associate it with the key then add phoneNumber to the list
    *param name
    *param phoneNumber
    */
    public void add(String name, String phoneNumber) {
        if(phoneBook.containsKey(name)) { //if my hashmap contains name entry
            List<String> phoneNumbers = phoneBook.get(name); //getting the phoneNumbers list from the hashmap
            phoneNumbers.add(phoneNumber); //add the phoneNumber to
        } else {
            List<String> phoneNumbers = new ArrayList<>(); //
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public void addAll(String name, String... phoneNumbers) {
        if(phoneBook.containsKey(name)) { // if the name exists
            List<String> existingPhoneNumbers = phoneBook.get(name); //add all phoneNumbers to the corresponding names
            List<String> listOfNumbers = Arrays.asList(phoneNumbers); // turning String... to a ArrayList
            existingPhoneNumbers.addAll(listOfNumbers); // add all existing numbers to the list of numbers array list
            phoneBook.put(name, listOfNumbers);
        } else {
            System.out.println("Name does not exist");
        }
    }
    public void remove(String name) {
        if(phoneBook.containsKey(name)){  // if my phonebook contains name
            phoneBook.remove(name);
        } else {
            System.out.println("This name doesn't exist");
        }
    }
    public Boolean hasEntry(String name) {
        if (phoneBook.containsKey(name)) {
            return true;
        }else {
            return false;
        }
    }
    public List<String> lookup(String name) { //
        if(phoneBook.containsKey(name)) {
            return phoneBook.get(name); // returns the name list string
        }
        return null; // if statement doesn't work, return nothing
    }
    /*
    reverseLookup
    go through all the entries(both key and value)
    for each entry, go through the value
    if phoneNumber is inside the value, return the entries key
     */
    public String reverseLookup(String phoneNumber){
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) { //iterate through each entry of my map
            List<String> phoneNumbers = entry.getValue(); //getting lIST OF strings phoneNumbers
            for (String number : phoneNumbers) { //for each number string, i'm going to iterate through the phoneNumbers list
                if (phoneNumber.equals(number)){ // if the phoneNumber is inside my value(name)
                    return entry.getKey(); // return getKey which is the name
                }
            }
        }

        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phoneBook.keySet()); // keySet returns all the keys in the phoneBook hashmap and turns it into an arrayList
    }

    public Map<String, List<String>> getMap() {

        return phoneBook; //return the phoneBook hashmap
    }

}

