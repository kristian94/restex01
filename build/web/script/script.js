$(document).ready(function () {
    var Quote = function (id, quote) {
        this.id = id;
        this.quote = quote;
    };
    
    var q1 = new Quote("1234567", "fler");
    var json = JSON.stringify(q1);
    console.log(json);
    
    
    $.ajax({  
             url:'http://localhost:8080/RestEx/api/quote',  
             type:'post',  
             contentType: 'application/json',
             data: json , 

             
         });  
    
});


