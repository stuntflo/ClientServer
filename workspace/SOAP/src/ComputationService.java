import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

		@WebService(name = "ComputationService", targetNamespace = "http://localhost:1234/ComputationService")
		@SOAPBinding(style = SOAPBinding.Style.RPC)

public class ComputationService 
{
			@WebMethod(operationName="hallo")  
			@WebResult(name="halloresult")
			
			public String hallo(@WebParam(name="name") String name)
			{
				return "Hallo " + name;
			}
}
