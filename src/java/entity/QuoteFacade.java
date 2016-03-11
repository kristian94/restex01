/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Kristian Nielsen
 */
public class QuoteFacade {
    
    static Map<Integer, Quote> quotes = new HashMap(){{
        put(1, new Quote(1, "We are what we repeatedly do. Excellence then, is not an act, but a habit."));
        put(2, new Quote(2, "Knowing is not enough; we must apply. Willing is not enough: we must do."));
        
    }};
    static Random r = new Random();
    
    public static Quote getQuote(int id){
        
        return quotes.get(id);
    }
    
    public static Quote createQuote(String quote){
        Quote q = new Quote(0, quote);
        int id = 1;
        while(quotes.containsKey(id)){
            id++;
            System.out.println(id);
        }
        q.setId(id);
        
        System.out.println("Creating Quote");
        
        quotes.putIfAbsent(id, q);
        return q;
    }
    
    public static Quote editQuote(Quote quote){
        quotes.put(quote.getId(), quote);
        return quotes.get(quote.getId());
    }
    
    public static boolean deleteQuote(Quote q){
        if(quotes.containsKey(q.getId())){
            quotes.remove(q.getId());
            System.out.println("Quote removed!");
            return true;
        }
        return false;
    }
    
    public static Collection<Quote> getAllQuotes(){
        return quotes.values();
    }

    public static Quote getRandomQuote() {
        
        if(quotes.size() == 0) return null;
        int i = r.nextInt(quotes.size());
        
        return (Quote) quotes.values().toArray()[i];
    }
    
    
}
