/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kristian94;

import exceptionhandling.QuoteNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Quote;
import entity.QuoteFacade;
import exceptionhandling.NoQuotesCreatedException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Kristian Nielsen
 */
@Path("quote")
public class QuoteEndpoint {

    Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteEndpoint
     */
    public QuoteEndpoint() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of kristian94.QuoteEndpoint
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String getQuote(@PathParam("id") int id) throws QuoteNotFoundException {
        Quote q = null;

        q = QuoteFacade.getQuote(id);

        if (q == null) {
            throw new QuoteNotFoundException();
        }

        return gson.toJson(q, Quote.class);
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public String getAllQuotes() throws NoQuotesCreatedException {

        List<Quote> quotes = new ArrayList(QuoteFacade.getAllQuotes());

        if (quotes.size() == 0) {
            throw new NoQuotesCreatedException();
        }

        return gson.toJson(quotes);
    }

    @GET
    @Path("/random")
    @Produces("application/json")
    public String getRandomQuote() throws NoQuotesCreatedException {
        Quote quote = QuoteFacade.getRandomQuote();
        if (quote == null) {
            throw new NoQuotesCreatedException();
        }
        return gson.toJson(quote);
    }

    @POST
    @Consumes("text/plain")
    @Produces("application/json")
    public String postQuote(String quote) {
        Quote q = QuoteFacade.createQuote(quote);
        System.out.println(gson.toJson(q, Quote.class));
        return gson.toJson(q, Quote.class);
    }

    /**
     * PUT method for updating or creating an instance of QuoteEndpoint
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public String editQuote(String content) throws QuoteNotFoundException {
        Quote quote = gson.fromJson(content, Quote.class);
        quote = QuoteFacade.editQuote(quote);
        if (quote == null) {
            throw new QuoteNotFoundException();
        }
        return gson.toJson(quote);
    }

    @DELETE
    @Consumes("application/json")
    public void deleteQuote(String content) throws QuoteNotFoundException {
        Quote quote = gson.fromJson(content, Quote.class);
        if (!QuoteFacade.deleteQuote(quote)) {
            throw new QuoteNotFoundException();
        }
    }

}
