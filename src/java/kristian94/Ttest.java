/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kristian94;

import entity.Quote;
import entity.QuoteFacade;
import exceptionhandling.NoQuotesCreatedException;

/**
 *
 * @author Kristian Nielsen
 */
public class Ttest {
    public static void main(String[] args) throws NoQuotesCreatedException {
        QuoteEndpoint qe = new QuoteEndpoint();
        System.out.println(qe.getAllQuotes());
        Quote q = QuoteFacade.getQuote(1);
        System.out.println(q.getQuote());
    }
}
