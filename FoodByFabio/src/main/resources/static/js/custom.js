
 $(document).ready(function(){
    
 meatChange = function (event){ 
   if(event.target.value == "1"){
   		document.getElementById("meatimage").src = "/images/steak2.jpg";
   	
   }
   if(event.target.value == "2"){   		
   		document.getElementById("meatimage").src = "/images/grilledchicken.jpg";
   		}
   if(event.target.value == "3"){
   		document.getElementById("meatimage").src = "/images/Turkey_Meatballs.jpg";
   }
   if(event.target.value == "4"){
   		document.getElementById("meatimage").src = "/images/salmon.jpg";
   }
   if(event.target.value == "5"){
   		document.getElementById("meatimage").src = "/images/tofu.jpg";
 	}

  }


	


updatePrice = function (event){
			var price = event.target.value;
			var quantity = document.getElementById("quantity").val();
			var totalPrice = (price * quantity);
			document.getElementById("total") = totalPrice;
	
	}
	




})