
package gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ComputationService", targetNamespace = "http://localhost:1234/ComputationService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ComputationService {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "halloresult", partName = "halloresult")
    @Action(input = "http://localhost:1234/ComputationService/ComputationService/halloRequest", output = "http://localhost:1234/ComputationService/ComputationService/halloResponse")
    public String hallo(
        @WebParam(name = "name", partName = "name")
        String name);

}
