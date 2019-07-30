/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.util.Optional;

/**
 *
 * @author tnagel
 */
public class OptionalTest implements Runnable {

    public static void main(String... args) {
        new OptionalTest().run();
    }

    public OptionalTest() {
    }
            
    void showIt(Optional<String> arg) {
        System.out.println("Value " + arg.orElse("(null)") );
    }
    
    @Override
    public void run() {
        test1();
        test2();
        test3();
    }

    private void test1() {
        String st = null;
        Optional<String> opt1 = Optional.ofNullable(st);
        showIt(opt1);
        
        String st2 = "Meier";
        opt1 = Optional.ofNullable(st2);
        showIt(opt1);
    }

    private void test2() {
        // if the value is not present
	Optional<Integer> carOptionalEmpty = Optional.empty();
	carOptionalEmpty
                .filter( x  -> "250".equals( x.toString() ) )
                .ifPresent( x -> System.out.println( "Case 1 " + x.toString() + " is ok!" ) );
	// if the value does not pass the filter
	Optional<Integer> carOptionalExpensive = Optional.of( new Integer( 3333 ) );
	carOptionalExpensive
                .filter( x  -> "250".equals( x.toString() ) )
                .ifPresent( x -> System.out.println( "Case 2 " + x.toString() + " is ok!" ) );
	// if the value is present and does pass the filter
	Optional<Integer> carOptionalOk = Optional.of( new Integer( 250 ) );
	carOptionalOk
                .filter( x  -> "250".equals( x.toString() ) )
                .ifPresent( x -> System.out.println( "Case 3 " + x.toString() + " is ok!" ) );
    }
    
    private void test3 () {
        // non empty string map to its length -> we get the lenght as output (18)
	Optional<String> stringOptional = Optional.of( "loooooooong string" );
	Optional sizeOptional = stringOptional.map( String::length ); //map from Optional to Optional
	System.out.println( "case A: size of string " + sizeOptional.orElse( 0 ) );
	// empty string map to its length -> we get 0 as lenght
	Optional<String> stringOptionalNull = Optional.ofNullable( null );
	Optional sizeOptionalNull = stringOptionalNull.map( x -> x.length()  ); // we can use Lambdas as we want
	System.out.println( "case B: size of string " + sizeOptionalNull.orElse( 0 ) );
    }

    /*
    EntityManager em;
    
    public class Bean {
        private String name;
        public String getName() { return name; }
        public Bean setName(final String name) { this.name = name; return this; }
    }
    public Optional<Bean> findBeanByName(final String name) {
        try {
            return Optional.of(
                em  .createQuery("select b from Bean b where b.name = :name" , Bean.class)
                    .setParameter("name" , name)
                    .setMaxResults(1)
                    .getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    */
    
    
}
