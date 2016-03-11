/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Kristian Nielsen
 */
public class Quote {
    private String quote;
    private int id;

    public Quote(int id, String quote) {
        this.quote = quote;
        this.id = id;
    }

    
    
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
}
