
public class Client {

	public static void main(String[] args) 
	{
		gen.ComputationService service = new gen.ComputationServiceService().getComputationServicePort();

		String result = service.hallo("Florian");
		System.out.println(result);
	}

}
