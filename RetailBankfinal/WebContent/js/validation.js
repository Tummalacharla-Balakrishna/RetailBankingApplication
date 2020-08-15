// For Login Screen

function validate() {
  var letterNumber = /^[0-9a-zA-Z]+$/;
  
  username = document.form.username.value;
  password = document.form.password.value;
  if( username == "" || !username.match(letterNumber) || username.length <8) {
	  if(username == ""){
    	  alert("UserName should not be empty");
    	  return false;
      }
	  if(!username.match(letterNumber)){
		  alert("UserName should not be Alphabets are AlphaNumeric");
    	  return false;
	  }
	  if(username.length <8){
		  alert("UserName should not be less than 8 characters");
    	  return false;
	  }
   }
  
  if( password == "" || !password.match(letterNumber) || password.length <8) {
	  if(password == ""){
    	  alert("password should not be empty");
    	  return false;
      }
	  if(!password.match(letterNumber)){
		  alert("password should not be Alphabets are AlphaNumeric");
    	  return false;
	  }
	  if(password.length <8){
		  alert("password should not be less than 8 characters");
    	  return false;
	  }
   }
  
}
function validateCustomerID(){
	customerId = document.myform.CustomerID.value; 
	if(customerId.length != 9)
	{
		 alert("Customer Id must have 9 digits.");  
		 document.getElementById("CustomerID").value="";
		  return false;  
	}
}

//
function validateUpdateScreenID(event){
	
	var number = /^[0-9]+$/;
	customerId = document.form.CustomerId.value; 
	
	if(customerId.length != 9 || customerId.match(number))
	{
		 if(customerId.length != 9){
			 alert("Customer Id must have 9 digits.");  
			 event.preventDefault();
			 document.getElementById("CustomerID").value="";
			  return false;  
		 }else if(!customerId.match(number)){
			 alert("Customer Id must have digits only.");
			 event.preventDefault();
			 document.getElementById("CustomerID").value="";
			  return false;
		 }
	}
}



function validateAccountType()
{
	var type = document.getElementById("AccountType").value;
	if(type.toLowerCase()=="current" || type.toLowerCase() =="saving")
	{
		
		  return true; 
	}
	else
		{
		alert("Enter a valid account type Current or Saving");  
		 document.getElementById("AccountType").value="";
		 
		  return false; 
		}
}

//For CreateCustomerScreen and DeleteCustomer
function createCustomerValidate(event){
	var number = /^[0-9]+$/;
	var alphabets = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;;
	var letterNumber = /^[0-9a-zA-Z]+$/;
	var letterNumberSpace = /^[a-zA-Z0-9\s]*$/;
	customerSSNID = document.form.CustomerSSNID.value;
	name = document.form.Name.value;
	age = document.form.age.value;
	address = document.form.Address.value;
	check = 0;
	if(customerSSNID == null || customerSSNID.length !=9 || !customerSSNID.match(number)){
		if(customerSSNID == null){
			alert("CustomerSSNID must not be Empty");
			event.preventDefault();
			return false;
		}
		if(customerSSNID.length !=9){
			alert("CustomerSSNID must be 9 digits only");
			event.preventDefault();
			return false;
		}
		if(!customerSSNID.match(number)){
			alert("CustomerSSNID must  be number only");
			event.preventDefault();
			return false;
		}
		
		
	}else if(name == "" || !name.match(alphabets) ){
		if(name == ""){
			alert("Name must not be Empty");
			event.preventDefault();
			return false;
		}
		if(!name.match(alphabets)){
			alert("Name must alphabets only");
			event.preventDefault();
			return false;
		}
	}else if(age <=17 || age >=100){
		if(age <=17){
			alert("Age must be greather than 17");
			event.preventDefault();
			return false;
		}
		if(age >=100){
			
			alert("Age must be less than 100")
			event.preventDefault();
			return false;
		}
		
	}else if(!address.match(letterNumberSpace)){
		alert("Address must be Alphabets and numbers only");
		event.preventDefault();
		return false;
	}
	customerid = document.form.CustomerId.value;
	if(!customerid.match(number) || customerid.length !=9){
		if(!customerid.match(number)){
			alert("customerid must not be number only");
			event.preventDefault();
			return false;
		}
		if(customerid.length !=9){
			alert("customerid must be 9 digits only");
			return false;
		}
		
	}
}

//For customerSearch Screen
function customerSearchValidation(){
	customerSSNID = document.form.CustomerSSNID.value;
	customerID = document.form.CustomerID.value;
	checkSSNID = 1;
	checkId = 1;
	var number = /^[0-9]+$/;
	
	if(customerSSNID == "" && customerID == ""){
		alert("Atleast on field must be fieled");
		return false;
	}else{
		if(customerSSNID == ""){
			checkSSNID = 0;
		}
		if(customerID == ""){
			checkId = 0;
		}
		if(checkSSNID == 1){
			if(!customerSSNID.match(number) || customerSSNID.length != 9){
				if(!customerSSNID.match(number)){
					alert("CustomerSSNID must be Number only"+checkSSNID);
					return false;
				}
				if(customerSSNID.length != 9){
					alert("CustomerSSNID must be 9 digits only");
					return false;
				}
			}
			return
		}
		else if(checkId == 1){
			if(!customerID.match(number) || customerID.length != 9){
				if(!customerID.match(number)){
					alert("customerID must be Number only");
					return false;
				}
				if(customerID.length != 9){
					alert("customerID must be 9 digits only");
					return false;
				}
			}
			return
		}
	}
}

//For search Account Screen
function searchAccountValidation(){
	customerID = document.form.CustomerID.value;
	accountID = document.form.AccountID.value;
	checkAccId = 1;
	checkId = 1;
	var number = /^[0-9]+$/;
	
	if(customerID == "" && accountID == ""){
		alert("Atleast on field must be fieled");
		return false;
	}else{
		if(customerID == ""){
			checkId = 0;
		}
		if(accountID == ""){
			checkAccId = 0;
		}
		if(checkAccId == 1){
			if(!accountID.match(number) || accountID.length != 9){
				if(!accountID.match(number)){
					alert("AccountID must be Number only");
					return false;
				}
				if(accountID.length != 9){
					alert("AccountID must be 9 digits only");
					return false;
				}
			}
			return
		}
		else if(checkId == 1){
			if(!customerID.match(number) || customerID.length != 9){
				if(!customerID.match(number)){
					alert("customerID must be Number only");
					return false;
				}
				if(customerID.length != 9){
					alert("customerID must be 9 digits only");
					return false;
				}
			}
			return
		}
	}
}

//UpdateCustomer
function updateCustomerValidation(){
	newName = document.form.NewName.value;
	newAddress = document.form.NewAddress.value;
	newAge = document.form.NewAge.value;
	var alphabets = /^[a-zA-Z]+$/;
	var letterNumber = /^[0-9a-zA-Z]+$/;
	
	if(newName == "" || !newName.match(alphabets) ){
		if(newName == ""){
			alert("Name must not be Empty");
			return false;
		}
		if(!newName.match(alphabets)){
			alert("Name must alphabets only");
			return false;
		}
	}else if(newAge <=17 || newAge >=100){
		if(newAge <=17){
			alert("Age must be greather than 17");
			return false;
		}
		if(newAge >=100){
			alert("Age must be less than 100")
		}
		
	}else if(!newAddress.match(letterNumberSpace)){
		alert("Address must be Alphabets and numbers only");
		return false;
	}
}

//onload for viewStatement list Initilization

function initialize(){
	num = 10;
	for(i=2;i<=num;i++){
		  x = document.getElementById("Transaction");
		  option = document.createElement("option");
		  option.text = ""+i;
		  x.add(option);
	}
}

//validate AccountId
function validateAccountId(){
	accountId = document.form.AccountID.value; 
	if(accountId.length != 9)
	{
		 alert("Account Id must have 9 digits."); 
		 return false;  
	}
}



//Download table as Pdf
function downloadPdf(){
    $("#example").tableHTMLExport({
        type:'pdf',
        filename:'sample.pdf'
      });
}

function downloadCsv(){

    $("#example").tableHTMLExport({
          type:'csv',
          filename:'sample.csv'
    });

}
