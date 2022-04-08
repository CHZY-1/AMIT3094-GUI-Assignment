<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.domain.Product, model.domain.ProductCategory"%>
<%@page import="model.da.ProductDA"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="HTML_parts/Meta.jsp" %>
        
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
          <style type="text/css">	 
body { 
 font-family: 'Poppins', sans-serif; 
} 
.wrapper{
    width: 1200px;
    margin: 100px auto;
}

.title{
    text-align: center;
    margin-bottom: 60px;
}

.title h4{
    text-transform: captitalize;
    font-size: 36px;
    position: relative;
    display: insline-block;
    padding-bottom: 20px;
} 

.title h4 span{
    display: block;
    font-size: 18px;
    font-style: italic;
    margin-bottom: -15px;    
}

.title h4:before{
    position: absolute;
    content: "";
    width: 100px;
    height: 2px;
    background-color: yellow;
    bottom: 0;
    left:50%;
    transform: translateX(-50%);
}

.menu{
    display: flex ;
    flex-wrap: wrap;
    justify-content: space-between;
}

.single-menu{
    flex-basis:580px;
    margin-bottom: 20px;
    padding-bottom: 20px;
    border-bottom: 1px solid #ddd;
}

.single-menu:nth-child(5),.single-menu:nth-child(6){
    border-bottom: 0;
}

.single-menu{
    display: flex;
    flex-direction: row;
    align-items: center;
}

.single-menu h4{
    text-transform: capitalize;
    font-size: 22px;
    border-bottom: 1px dashed #333;
    margin-bottom: 5px;
    padding-bottom: 5px;
}

.single-menu h4 span{
    float: right;
    color: #ff9900;
    font-style: italic;
}

.sidebar{
    box-sizing:border-box;
    list-style: none;
    width:55%;
    display: flex;
    text-align: center;
    background-color:#fcba03;    
}

#catalog{
    color: black;
    font-size:30px;
    letter-spacing: 4px;
    padding: 15px;
}

.sidebar a{
    text-decoration: none;
    color:black;
    font-size: 18px;
    letter-spacing: 2px;
    display: list-item;
    padding: 20px;
}

.sidebar a:hover{
    background-color: white;
    transition: 0.5s;
    letter-spacing: 4px;
    text-transform: uppercase;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #00B4CC;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #00B4CC;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

</style> 

    </head>
   
    <body class="d-flex flex-column min-vh-100">
        
        <%@ include file="HTML_parts/Header.jsp" %>
        
        <div class="sidebar">
            <h2 id="catalog">Category</h2>
            <a href="#">All</a>
            <a href="#">Burgers</a>
            <a href="#">Drinks</a>
            <a href="#">Desserts</a>
            <a href="#">Others</a>
        </div>
        
                <div class="search">
           <input type="text" class="searchTerm" placeholder="What are you looking for?">
           <button type="submit" class="searchButton">
             <i class="fa fa-search"></i>
          </button>
        </div>

        <div class="wrapper">
            <div class ="title">
                <h4>McDonald<span>Menu</span></h4>
                     
        <form method="post" action="MenuS.java">
         <div class="menu">
             <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
                <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
               <div class="single-menu">
                 <h4>Big Mac <span>RM11.79</span></h4> 
                 <p>Classic McDonald burger with toasted sesame seed bum
                 two beef patties with pickles, onions, lettuce, cheese and 
                 special sauce. 
                </p>
             </div>
             
         </div>
        </form>
                
                 <%@ include file="HTML_parts/Footer.jsp" %>
    </body>
</html>

