
var app = angular.module('myapp', []);

	app.controller('myappcontroller', function($scope, $http) {
		
		$scope.ProductInventory = []
		$scope.Exception = []
		$scope.PProducts = []
		$scope.usersINFO = []
		$scope.Carts = []
		$scope.orderDetails = []
		$scope.SendMessage = []
		$scope.Messagez = []
		$scope.products = []
		$scope.product = []
		$scope.Messageform = { message:""}
		$scope.productform = {
		productCode : "",
				productName : "",
				
				productDescription : "",
				productPrice : "",
				
				productVolume : "",
				productVolumeType : "",
				
				productExpDate : "",
				productCategoryCode : "",
				
				brandCode : "",
				productImage : "",
				
			}
		
		$scope.InventoryProduct = []
		$scope.InventoryProductform = {
				
				
				productCode : "",
				productName : "",
				
				productDescription : "",
		
				
				productVolume : "",
				productVolumeType : "",
				
				productExpDate : "",
			
				productQuantity : "",
				
				
			}
		
		

		$scope.Payment = []
				$scope.Paymentform = {
								
				cardNumber : "",
								
								cardType : "",
							
								
								cvv2 : "",
								expDate : ""
									
								}
						
		
		$scope.CartEmail = []
		
		$scope.Cartproduct = []
		$scope.Cartproductform = {
				product_name: "",quantity: "",price: "",
				product_code : "", user_email : ""	
				
				}
		
		$scope.UserInfo = []
		$scope.UserInfoForm = {
				
				email: ""
		}
		 
		 $scope.Driver = []
			$scope.DriverForm = {
				
				driverId : "",
				username : "",
				license_exp_date : "",
					license_code: ""
					 
			}
			$scope.CustomerInfo = []
			$scope.CustomerInfoForm = {
				
				
				custNumber : "",
				user_email : "",
				 custAddress : "",
				 province : "",
					 city : "",
					 zip_code : ""
			}
		 
		$scope.Category = []
		$scope.CategoryForm = {
				
				productCategoryCode : "",
					categotyDescription : ""
		}
			$scope.Delivery = []
			$scope.DeliveryForm = {
					
				
				 driverId : "",
				 orderNum : ""
			}
		$scope.totalAmount = 0
		
		 
		
		;
                $scope.saveItem = function ()
                {
                    console.log($scope.saveItem);
                    
                }
       

        //Get User Information        
                
                getUserInfo();
                function getUserInfo(){
                	
                	$http({
        				method : 'GET',
        				url : '/viewUser'
        			}).then(function successCallback(response) {
        				$scope.UserInfo = response.data;
        			}, function errorCallback(response) {
        				console.log(response.statusText);
        			});
                }
             
                
                
     //Get All The Products in the Product Table and Inventory Table      
                
                getAllProductDetails();

		function getAllProductDetails() {
			$http({
				method : 'GET',
				url : '/GetProducts'
			}).then(function successCallback(response) {
				$scope.products = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
	
			});
		}
			
	        getProductDetails();

			function getProductDetails() {
				$http({
					method : 'GET',
					url : '/GetInventoryProducts'
				}).then(function successCallback(response) {
					$scope.InventoryProduct = response.data;
					
					var num = 0;
					
					for (var x = 0 ; x < $scope.InventoryProduct.length ; x++  )
					{
					
					if ($scope.InventoryProduct[x].productCode == $scope.products[x].productCode)
						{
							 var products = 
								 {

										"productCode" : $scope.products[x].productCode,
										"productName" : $scope.products[x].productName,
										
										"productDescription" : $scope.products[x].productDescription,
										"productPrice" : $scope.products[x].productPrice,
										
										"productVolume" : $scope.products[x].productVolume,
										"productVolumeType" : $scope.products[x].productVolumeType,
										
										"productExpDate" : $scope.products[x].productExpDate,
										"productCategoryCode" : $scope.products[x].productCategoryCode,
										
										"brandCode" : $scope.products[x].brandCode,
										"productImage" : $scope.products[x].productImage,
										"productQuantity" : $scope.InventoryProduct[x].productQuantity
									 
								 };
							 
							
							 $scope.PProducts[num] = products;
							 
							 console.log($scope.PProducts[num]);
							 
							 num++
						};
					};
					
				}, function errorCallback(response) {
					console.log(response.statusText);
		
					
					
					
				
				});
				
	  			
		}
			
			
			//Get User Email/User-name
		getCartEmail();
		function getCartEmail(){
			$http({
				method : 'GET',
				url : '/username'
			}).then(function successCallback(response) {
				$scope.CartEmail=response.data;
			}, function errorCallback(response) {
				//console.log(response.statusText);
			});
		}
		

		//Get User Email/User-name
		getException();
		function getException(){
			$http({
				method : 'GET',
				url : '/ExHandling'
			}).then(function successCallback(response) {
				$scope.Exception=response.data;
				console.log($scope.Exception);
			}, function errorCallback(response) {
				//console.log(response.statusText);
			});
		}
		
		
        //Get All the Information about the customer
        getCustomerInfo();
        function getCustomerInfo(){
        	
        	$http({
				method : 'GET',
				url : '/GetCustomerInfo'
			}).then(function successCallback(response) {
				$scope.CustomerInfo = response.data;
		
				
			});
        }
     
		//View the cart/basket
		getCartDetails();
		function getCartDetails() {
		
		
			
			$http({
				method : 'GET',
				url : '/viewCart'
			}).then(function successCallback(response) {
				$scope.Cartproduct = response.data;
				
				
				
					var totalAmt = 0;
					var number = 0;
				
				 for (var x = 0; x < $scope.Cartproduct.length ; x++)
					 {
					 
					 if ($scope.Cartproduct[x].orderNum == 0)
						 {
						 $scope.Carts[number] =  $scope.Cartproduct[x];
						 console.log($scope.Carts[x]);
						 totalAmt = totalAmt + $scope.Cartproduct[x].price;
						 number++;
						 
						 };
				
					
					//	console.log($scope.Cartproduct[x].price);
					 
					 };
					 $scope.totalAmount = totalAmt ;
					 console.log($scope.totalAmount);
	
		
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
			
		
		
		}
		
		console.log(name);
		
	
		//Get The Product Category
		   getCategory();

	  		function getCategory() {
	  			
	  			$http({
	  				method : 'GET',
	  				url : '/GetProductCategory'
	  			}).then(function successCallback(response) {
	  				$scope.Category = response.data;
	  			}, function errorCallback(response) {
	  				console.log(response.statusText);
	  			});
	  			
	  		}
	  		
	         
	  		//Add Customer Details
			$scope.AddCustomer = function()
			{
			
			var customerInfomation = {
				
					"custNumber" : $scope.UserInfo[0].id,
					"user_email" : $scope.UserInfo[0].email,
					"custAddress" : $scope.CustomerInfoForm.custAddress,
					"province"  : $scope.CustomerInfoForm.province,
						"city" : $scope.CustomerInfoForm.city,
						"zip_code" : $scope.CustomerInfoForm.zip_code
						
			};
				
			console.log(customerInfomation);
				
			
			
				
					$http({
						method : 'POST',
						url : '/InsertCustomerInfo',
						data : angular.toJson(customerInfomation),
						headers : {
							'Content-Type' : 'application/json'
						}
					})
					  .success(function(data){
						$scope.CustomerInfo= data;
						
						alert("Customer Added/Updated ");
						location.reload(true);
						
				    });
					
					///UpdateCustomerInfo/{custNumber}
					
			}
				
			
			//Get All The Products based on the Product Code

	  		$scope.getProducts = function(AllProducts) 
	  		{
	  	
	  			var PrdoductCode = AllProducts.productCategoryCode;
	  			console.log(PrdoductCode);
	  			
	  			$http({
	  				method : 'GET',
	  				url : '/GetAllProducts/' +PrdoductCode
	  			}).then(function successCallback(response) {
	  				$scope.product = response.data;
	  			}, function errorCallback(response) {
	  				console.log(response.statusText);
	  			});
	  			
	
	  		}
	  		
		
		
  			//CheckOut
  			
	  		$scope.AddPayment = function(cardTyp) {
	  			var date = $scope.Paymentform.expDate;
	  			
				
	  			
	  			var cardNum = $scope.Paymentform.cardNumber;
	  			var ccv2 = $scope.Paymentform.cvv2;
	  			var CardDate = $scope.Paymentform.expDate;
	  			console.log(CardDate);
	  			
	  			
	  			
	  			if (cardNum.toString().length != 16)
	  			{
	  				alert( "The card Number must have 16 digits");
	  				location.reload(true);
	  				
	  			}
	  	
	  			else
	  			{
	  					
	  				console.log( ccv2.toString().length);
	  				if( ccv2.toString().length != 3 )
	  				{
	  					alert( "The Card Verification Code must have 3 digits");
	  					location.reload(true);
	  				}
	  				else
	  				{
	  					if (cardTyp == undefined)
	  					{
	  						alert( "Select A Card Type");
	  						location.reload(true);
	  					}
	 
	  					else
	  					{
	  					
	  			var cardTyp = $scope.CardType;
	  			var today = new Date();
	  			var dd = today.getDate();
	  			var mm = today.getMonth()+1; //January is 0!
	  			var yyyy = today.getFullYear();
	  			
	  		 Currentdate = yyyy + '-' + mm + '-' + dd ;
	  	
	  			var orderDetail =
	  			{

	  				"orderdate" : Currentdate,
	  				"orderTotalprice" : $scope.totalAmount,
	  				"orderStatus" : "pending",
	  				"user_id" : $scope.UserInfo[0].id

	  			};
	  			
	  		
	  			console.log(orderDetail);
	  		
	  		$http({
					method : 'POST',
					url : '/CreateOrder',
					data : angular.toJson(orderDetail),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function successCallback(response) {
	  				 $scope.orderDetails = response.data;

	  				 
					  $http({
			  				method : 'GET',
			  				url : '/GetOrder'
			  			}).then(function successCallback(response) {
			  				 $scope.orderDetails = response.data;
			  				console.log($scope.orderDetails);
			  			
			  			
			  				var orderNum = 0;
			  				
			  				for (var x = 0; x < $scope.orderDetails.length ; x++)
			  				{
			  					
			  					if ($scope.orderDetails[x].user_id == $scope.UserInfo[0].id)
			  						{
			  						
			  						if ( $scope.orderDetails[x].orderNum > orderNum )
			  							{
			  							
			  							orderNum = $scope.orderDetails[x].orderNum;
			  							
			  							}
			  						
			  						
			  						};
			  				};
			  			
			  			
			  			console.log( orderNum);
			  			
			  			
			  				var paymentDetails = {
				  					
				  					"cardNumber" : $scope.Paymentform.cardNumber,
				  					"cardType" : cardTyp,
				  					"cvv2"	: $scope.Paymentform.cvv2,
				  					 "user_email" : $scope.UserInfo[0].email,
				  					"expDate" :	$scope.Paymentform.expDate,
				  					"orderNum" : orderNum
				  					
				  		  			
				  			};
			  				
			  				console.log(paymentDetails);
			  				
			  				
			  					$http({
								method : 'POST',
								url : '/processPayment',
								data : angular.toJson(paymentDetails),
								headers : {
									'Content-Type' : 'application/json'
								}
							})
							  .success(function(data){
								  
								$scope.Payment= data
								
						    });
			  				
			  			
			  			var cartNum = 0;
			  			var number = 0;
			  				
			  				$http({
			  					method : 'GET',
			  					url : '/viewCart'
			  				}).then(function successCallback(response) {
			  					$scope.Cartproduct = response.data;
			  					
			  					
			  					for (var x = 0; x < $scope.Cartproduct.length; x++ )
			  						
			  						{
			  						if ($scope.Cartproduct[x].orderNum == 0)
			  							{
			  							
			  							
			  						var cartData = {
			  								
			  								"orderCartNum" : $scope.Cartproduct[x].orderCartNum,
			  								"product_name": $scope.Cartproduct[x].product_name,
			  								"quantity" : $scope.Cartproduct[x].quantity ,
			  								"price": $scope.Cartproduct[x].price,
			  							  "product_code": $scope.Cartproduct[x].product_code,
			  							  "user_email" : $scope.Cartproduct[x].user_email,
			  							  "orderNum" : orderNum,
			  							  "user_image" :  $scope.Cartproduct[x].user_image
			  						}; 
			  						
			  						cartNum = $scope.Cartproduct[x].orderCartNum;
			  						
			  						var ProductInventory = $scope.Cartproduct[x].product_code;
			  						var productQuantity =  $scope.Cartproduct[x].quantity;
			  						
						  			$http({
		  								method : 'GET',
		  								url : '/GetInventoryProducts'
		  							}).then(function successCallback(response) {
		  								$scope.InventoryProduct = response.data;
		  								
		  							});
		  								
		  								var quant = 0;
		  							
		  								for (var t = 0 ; t < $scope.InventoryProduct.length ;  t++ ) 
		  									{
		  										
		  										if ( $scope.InventoryProduct[t].productCode == ProductInventory )
		  											{
		  											
		  											quant = $scope.InventoryProduct[t].productQuantity -  productQuantity;
		  											
		  											
		  											
		  											 var products = 
		  											 {

		  													"productCode" : $scope.InventoryProduct[t].productCode,
		  													"productName" : $scope.InventoryProduct[t].productName,
		  													
		  													"productDescription" : $scope.InventoryProduct[t].productDescription,
		  												
		  													
		  													"productVolume" : $scope.InventoryProduct[t].productVolume,
		  													"productVolumeType" : $scope.InventoryProduct[t].productVolumeType,
		  													
		  													"productExpDate" : $scope.InventoryProduct[t].productExpDate,
		  												
		  													"productQuantity" : quant
		  													
		  													
		  												 
		  											 };
		  											 
		  												 var name =  $scope.InventoryProduct[t].productCode;
		  											 
		  											 console.log(products);
		  											 
		  													$http({
		  												method : 'PUT',
		  												url : '/UpdateInventoryProduct/' + name,
		  												data : angular.toJson(products),
		  												headers : {
		  													'Content-Type' : 'application/json'
		  												}
		  											})
		  											  .success(function(data){
		  												
		  												  
		  											$scope.InventoryProduct= data;
		  										
		  											
		  											
		  										    });
		  											
		  											};
		  											
		  									};
		  									
		  							
					  				
			  						
			  							number++;
			  							
			  						
			  						
			  							$http({
			  							method : 'PUT',
			  							url : '/UpdateCart/' + cartNum,
			  							data : angular.toJson(cartData),
			  							headers : {
			  								'Content-Type' : 'application/json'
			  							}
			  						})
			  						  .success(function(data){
			  							$scope.Cartproduct= data
			  							
			  						  });
			  											
			  										

			  							};
			  							
			  							
			  					
			  			
			  						};
			  						
			  						
			  					
			  						alert("Order Succefully Made and your order is order Number " + orderNum);
  				  					location.reload(true);
  							
			  				});
			  				
			  				
			  			
			  				
			  			
			  			 
			  			});
			  		
			  			
					
	  		
	  			});
	  						
	  					}
	  				
	  						
	  				}
	  						
	  			}
	  					
	
	  			
	  			
	 
	  		
				  
	  	
				}

	  		
	  		//Add Products To Cart
		
		$scope.addCart = function(products,quant)
		{
			
			
			var a =  Number(quant);
			
			if( a > 0)
			{
				console.log(quant);
				var userInfo = {
						"id":$scope.UserInfo.id,
						"email":$scope.UserInfo.email,
						"lastName":$scope.UserInfo.lastName
				};
				
				var productData = {
					
						"product_name": products.productName,
						"quantity" : quant ,
						"price": products.productPrice * quant,
					  "product_code": products.productCode,
					  "user_email" : $scope.UserInfo[0].email,
					  "orderNum" : null,
					  "user_image" :  products.productImage
				}; 
				
			
				
					$http({
						method : 'POST',
						url : '/InsertCart',
						data : angular.toJson(productData),
						headers : {
							'Content-Type' : 'application/json'
						}
					}).then(getCartDetails(), clearForm())
					  .success(function(data){
						$scope.Cartproduct= data
				    });
			}
			else
			{
				alert("Add 1 or more Quantities");
				location.reload(false);
			}
			
			
				
				
				
		}
		

	//ADD Product Category
		$scope.AddCategory= function() {
			
			console.log($scope.productform);
				$http({
					method : 'POST',
					url : '/InsertCategory',
					data : angular.toJson($scope.CategoryForm),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(getCategory(), clearForm())
				  .success(function(data){
					$scope.Category= data;
					

					alert("Product Category Added/Updated");
					location.reload(true);
					
			    });
			}
		
		$scope.Checkout= function(totalAmnt) {
			
			console.log(totalAmnt);
			
			console.log($scope.productform);
				$http({
					method : 'POST',
					url : '/InsertCategory',
					data : angular.toJson($scope.CategoryForm),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(getCategory(), clearForm())
				  .success(function(data){
					$scope.Checkout= data
			    });
			}
		
         
		
		//Add Products
	$scope.processProduct = function(image) {
		
		var file = document.getElementById('img');
		 var name = "/images/" + file.files.item(0).name;
		//var file = $scope.image.name;
		
		$scope.InventoryProductform.productCode = $scope.productform.productCode;
		$scope.InventoryProductform.productName  = 	$scope.productform.productName ;
        $scope.InventoryProductform.productDescription =  $scope.productform.productDescription;
        $scope.InventoryProductform.productVolume =   $scope.productform.productVolume ;
        $scope.InventoryProductform.productVolumeType =     $scope.productform.productVolumeType ;
        $scope.InventoryProductform.productExpDate =     $scope.productform.productExpDate ;
        $scope.productform.productImage = name;
    	 
	
    
		console.log(  $scope.productform.productImage );
		
		
			$http({
				method : 'POST',
				url : '/InsertInventoryProducts',
				data : angular.toJson($scope.InventoryProductform),
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			  .success(function(data){
				$scope.InventoryProduct = data;
				
				$http({
					method : 'POST',
					url : '/InsertProducts',
					data : angular.toJson($scope.productform),
					headers : {
						'Content-Type' : 'application/json'
					}
				})
				  .success(function(data){
					$scope.product = data;
					

					alert("Products Successfully Added/Updated");
					location.reload(true);
					
					
			
			    });
				
				
		    });
			
		}
	
	
	//Search For Pending Orders
	$scope.PendingOrders = [];
	
	GetOrder();
	
	function GetOrder(){
	  $http({
			method : 'GET',
			url : '/GetOrder'
		}).then(function successCallback(response) {
			 $scope.orderDetails = response.data;
			
			
			var number = 0;
		for (var x = 0; x < $scope.orderDetails.length;x++)
			{
			
			if ($scope.orderDetails[x].orderStatus == "pending" )
			{
				
				$scope.PendingOrders[number]  = $scope.orderDetails[x];
				number++;
				
			};
			
			};
			
			});
			
		}
	
	
	$scope.pendingDriver = [];
	
	
	//Get Driver Information
	
	getDriver();
	function getDriver(){
		$http({
			method : 'GET',
			url : '/GetDriver'
		}).then(function successCallback(response) {
			$scope.Driver=response.data;
			
			
			var number = 0;
		for (var x = 0; x < $scope.Driver.length;x++)
			{
			
			if ($scope.Driver[x].driverStatus == "Available" )
			{
				
				$scope.pendingDriver[number]  = $scope.Driver[x];
				number++;
				
			};
			
			};
			
		
			console.log($scope.Driver);
			
	
		});
	}

//Process delivery
$scope.ProcessDelivery = function() {
	
var driverID;


		$http({
			method : 'GET',
			url : '/GetDriver'
		}).then(function successCallback(response) {
			$scope.Driver=response.data;
		
			for (var x = 0; x < $scope.Driver.length; x++  )
				
				{
				if ($scope.Driver[x].driverId == $scope.UserInfo[0].id )
					
					{
				driverID = $scope.Driver[x].driverId;
					
					}
				}
				
			console.log(driverID);
		
	
		
		
		
		 
					
		  			var today = new Date();
		  			var dd = today.getDate();
		  			var mm = today.getMonth()+1; //January is 0!
		  			var yyyy = today.getFullYear();
		  			
		  		 Currentdate = yyyy + '-' + mm + '-' + dd ;
		  		 
				 
		var DeliveryInfor = 
		{
			"deliveyDate" : Currentdate,
			"driverId" : driverID,
			"orderNum" : $scope.DeliveryForm.orderNum
		};
		
		var driverID = $scope.DeliveryForm.driverId;
		var orderID = $scope.DeliveryForm.orderNum;
		
		$http({
				method : 'POST',
				url : '/ProcessDelivery',
				data : angular.toJson(DeliveryInfor),
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			  .success(function(data){
				  $scope.Delivery= data;
				  
				  
			
			//Get Order Details
			 
				  $http({
						method : 'GET',
						url : '/GetOrder'
					}).then(function successCallback(response) {
						 $scope.orderDetails = response.data;
						
						
						for (var x = 0; x <  $scope.orderDetails.length; x++ )
						  {
						  
						  if ( $scope.orderDetails[x].orderNum == orderID)
						{
							  
						var UpdateOrder =  {
								 
									 "orderNum" : $scope.orderDetails[x].orderNum,
									 "orderdate" : $scope.orderDetails[x].orderdate,
									 "orderTotalprice" : $scope.orderDetails[x].orderTotalprice,
									 "orderStatus" : "Delivered",
									"user_id" : $scope.orderDetails[x].user_id
									 
							 };
							  
						
							  };
							  
						  
						  };
						  
console.log(UpdateOrder);
						  
						  //Update Order Status
						  
						$http({
									method : 'PUT',
									url : '/UpdateOrder/' + orderID,
									data : angular.toJson(UpdateOrder),
									headers : {
										'Content-Type' : 'application/json'
									}
								})
								  .success(function(data){
									
								
										
										  
								$scope.orderDetails= data;
							
								

								alert("Done");
								location.reload(true);
		
						
					});
						
				  
					    });	
						
				
		    });
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		});
		
	
		}


	//Add a New Driver
	$scope.AddDriver = function(code) {
	
		var DriverInfor = 
		{
			"driverId" : $scope.UserInfo[0].id,
			"driverStatus" : "Available",
			"license_exp_date" : $scope.DriverForm.license_exp_date,
				"license_code" : code
					
		};
		
		
	
			$http({
				method : 'POST',
				url : '/AddDriver',
				data : angular.toJson(DriverInfor),
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			  .success(function(data){
				  $scope.Driver= data;
				  
					alert("Driver Added/Updated");
					location.reload(true);
					
					
		    });
			
		}
	
	$scope.Processmessage = function(){
		
	var mac = {
		"message" : $scope.Messageform.message
	};
		
	
	
	
			$http({
				method : 'POST',
				url : '/SendMessage',
				data : angular.toJson(mac),
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			  .success(function(data){
				  $scope.SendMessage= data;
				  
				  console.log(mac);
					
					
		    });

		}
	
GetMessage();
	
	function GetMessage(){
	  $http({
			method : 'GET',
			url : '/GetMessage'
		}).then(function successCallback(response) {
			 $scope.Messagez = response.data;
			 
		});
		
		
		}
	

	$scope.selectOrder = function(PendingOrder)
	{
		
		 $scope.DeliveryForm.orderNum = PendingOrder.orderNum;
	
		
     disableName();
     
	}
	

	
	//Edit Product
		$scope.editProduct = function(products) {
			$scope.productform.productCode = products.productCode;
			$scope.productform.productName = products.productName;
            $scope.productform.productDescription = products.productDescription;
            $scope.productform.productPrice = products.productPrice;
            $scope.productform.productVolume = products.productVolume;
            $scope.productform.productVolumeType = products.productVolumeType;
            $scope.productform.productExpDate = products.productExpDate;
            $scope.productform.productCategoryCode = products.productCategoryCode;
            $scope.productform.brandCode = products.brandCode;
            $scope.productform.productImage = products.productImage;
            $scope.InventoryProductform.productQuantity =  products.productQuantity;
           
           disableName();
           
   		
		}         
          
		
		//Edit Customer
		$scope.editCustomer = function(customer) {
			$scope.CustomerInfoForm.custNumber = customer.productCode;
			$scope.CustomerInfoForm.user_email = customer.user_email;
			$scope.CustomerInfoForm.custAddress= customer.custAddress;
			$scope.CustomerInfoForm.province = customer.province;
			$scope.CustomerInfoForm.city = customer.city;
			$scope.CustomerInfoForm.zip_code = customer.zip_code;
			
         disableName();
		} 

		
		
		//Edit Product Category
		$scope.editProductCategory = function(productCategory){
			
			
					
					 $scope.CategoryForm.productCategoryCode = productCategory.productCategoryCode;
					 $scope.CategoryForm.categotyDescription  =  productCategory.productCategoryCode;
			
			
         disableName();
		}
		
		
		$scope.SelectCategory = function(category)
		{
			
			 $scope.productform.productCategoryCode = category.productCategoryCode;
		
			
         disableName();
         
		}
		
		
		
		//Delete Cart
		$scope.deleteCart = function(cartInfo) {
			
			var CartId = cartInfo.orderCartNum;
			
				$http({
					method : 'DELETE',
					url : '/DeleteCart/' + CartId,
					data : angular.toJson(cartInfo),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(getCartDetails());
				

				alert("Deleted");
			location.reload(true);
			}
		
		
		//delete Driver
$scope.DeleteDriver = function(driverInfo) {
			
			var driverID = driverInfo.driverId;
			
				$http({
					method : 'DELETE',
					url : '/DeleteDriver/' + driverID,
					data : angular.toJson(driverInfo),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(getDriver());
				

				alert("Driver Deleted");
			location.reload(true);
			
			}


//Delete Product
$scope.DeleteProduct = function(productInfo) {
	
	var code = productInfo.productCode;
	
	
	var products = 
	 {

			"productCode" : productInfo.productCode,
			"productName" : productInfo.productName,
			
			"productDescription" : productInfo.productDescription,
			"productPrice" : productInfo.productPrice,
			
			"productVolume" : productInfo.productVolume,
			"productVolumeType" : productInfo.productVolumeType,
			
			"productExpDate" : productInfo.productExpDate,
			"productCategoryCode" : productInfo.productCategoryCode,
			
			"brandCode" : productInfo.brandCode,
			"productImage" : productInfo.productImage
			
		 
	 };
	
	var product = 
	 {

			"productCode" : productInfo.productCode,
			"productName" : productInfo.productName,
			
			"productDescription" : productInfo.productDescription,
			
			
			"productVolume" : productInfo.productVolume,
			"productVolumeType" : productInfo.productVolumeType,
			
			"productExpDate" : productInfo.productExpDate,
			
			"productQuantity" : productInfo.productQuantity
		 
	 };
	
	console.log(product);
	console.log(code);
	console.log(products);
	

	
		$http({
			method : 'DELETE',
			url : '/DeleteInventoryProduct/' + code,
			data : angular.toJson(product),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then( );
		{
			$http({
				method : 'DELETE',
				url : '/DeleteProduct/' + code,
				data : angular.toJson(products),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getProductDetails());
			{
				
				alert("product Deleted");
				location.reload(true);
			}
		
		
			
		}

	
		
	}

	});