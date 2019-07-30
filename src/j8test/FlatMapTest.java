/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * aus http://www.adam-bien.com/roller/abien/entry/java_8_flatmap_example
 * 
 */
public class FlatMapTest implements Runnable {

    public class Developer {
        private String name;
        private Set<String> languages;
        public Developer(String name) {
            this.languages = new HashSet<>();
            this.name = name;
        }
        public void add(String language) {
            this.languages.add(language);
        }
        public Set<String> getLanguages() {
            return languages;
        }
    }
    
    void showList(List<?> liste) {
        liste.stream().forEach(System.out::println);
    }
        
    public static void main(String[] args) {
        new FlatMapTest().run();
    }
    
    public void run() {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

        List<String> teamLanguages = team.stream().
                map(d -> d.getLanguages()).
                flatMap(l -> l.stream()).
                collect(Collectors.toList());
    
        showList(teamLanguages);
//        assertTrue(teamLanguages.containsAll(polyglot.getLanguages()));
//        assertTrue(teamLanguages.containsAll(busy.getLanguages()));
        
    }
}
