package resources;

public enum Endpoints {

	login("/proxy/sfcc/customers/auth"),
	registration("/proxy/sfcc/customers"),
	profileUpdate("/proxy/sfcc/customers"),
	refresh("/proxy/sfcc/customers/auth"),
	dev("https: dev-tapestry.litmus7.com"),
	uat("https: staging-na01-coach.demandware.net");


	private String resourceName;
	
 	Endpoints(String resourceName) {
 	
 		this.resourceName=resourceName;
 	}

 	public String getName() {
 		
 		return resourceName;
 	}
	
	Endpoints(){
		
	}
	
	
	
	
	
	
}
