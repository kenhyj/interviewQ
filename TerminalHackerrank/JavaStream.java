package TerminalHackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.function.*;
import java.util.Scanner;


/*
 * Create the Filter and Mapper classes here.
 */
 
 class Filter{
     
    public static Predicate<String> nameStartingWithPrefix(String prefix){
        return i -> i.startsWith(prefix);
    }
 }
 
 class Mapper{
    
    public static CharactersCount getDistinctCharactersCount(String s){
        return new CharactersCount(s);
    }
    // public static CharactersCount getDistinctCharactersCount(){
    //     return s -> new CharactersCount(s);
    // }     
 }
 
class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;
    
    public CharactersCount(String name){
        this.name = name;
        this.distinctCharacterCount = getDistinctCharCount(name);
    }

    private int getDistinctCharCount(String s){
        char[] charsmap = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i<charsmap.length; i++){
            set.add(charsmap[i]);
        }
        return set.size();
    }

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }
    
    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

// public class Solution {
public class JavaStream {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Please input your prefix below:");
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );
        
        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(s -> Mapper.getDistinctCharactersCount(s))
                // .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
}
