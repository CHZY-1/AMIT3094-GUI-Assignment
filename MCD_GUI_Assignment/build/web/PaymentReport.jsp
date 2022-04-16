<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment Report</title>
                <style>
               div{
                height: 900px;
                border: 5px solid;
                display: flex;
                flex-direction: column;
                padding: 20px;
                position: relative;
                margin: 20px;
                border-radius: 10px;
                background-color: white;
                }
               body{
                background-color:#f2f2f2;
                }
               p{
                margin:20px 0px;
                }
              .border1{
                margin: auto;
                width: 500px;
                border: 5px solid #FFFFFF;
                padding: 10px 20px;
                height: 700px;
                }
              input[type=text]{
                padding: 12px 10px;
                margin: -10px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 2px;
                box-sizing: border-box;
                }
             h1{
                color: #f3ad12;
                margin:0;
                }
            .button {
                background-color: red;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border:none;
                width:100%;
                }
             .button:hover{
                    background-color:white;
                    border-color:red;
                    border:2px;
                    color:red;
                }                
        </style> 
    </head>
    <body>     
        <div class="border1">
            <h1>Payment Report</h1>
            <p>Payment ID:</p>
            <input type="text" name=""  value="" style="width:500px;" />
            <p>Payment Method:</p>
            <input type="text" name=""  value="" style="width:500px;"/>
            <p>Total Payment Amount:</p>
            <input type="text" name="customeremail" value="" style="width:500px;" />
            <p>Date and Time:</p>
            <input type="text" name="customerpn"  value="" style="width:500px;" />
            <p>Order Status:</p>
            <input type="text" name="Street"  value=""style="width:500px;" />
            <p>Customer ID:</p>
            <input type="text" name="State"  value="" style="width:500px;" />
            <p>Card Number:</p>
            <input type="text" name="Postcode"  value="" style="width:500px;" />
            <br/>
            <br/>
            <input type="button" name="submit" class="button" value="Confirm Payment" />
        </div>
    </body>
</html>
