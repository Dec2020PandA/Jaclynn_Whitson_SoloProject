/**
 $(document).ready(function(){
    $('img').click(function(){
        var backup = $(this).attr('backup-src');
        var current = $(this).attr('src');
        $(this).attr('src', backup);
        $(this).attr('backup-src', current);
    })

});
 */
 document.ready(function(){
	

document.getElementById("quantity").onchange = function() {updatePrice()};

	function updatePrice(){
			var price = document.getElementById("price").value;
			console.log(price);
			var quantity = document.getElementById("quantity").value;
			document.getElementById("total").innerHTML = "$" + (price*quantity)+"0";
	
	}
	

	
});