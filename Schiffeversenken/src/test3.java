
public class test3 {

	public test3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if ( System.console() != null )
		{
		  String passwd = new String( System.console().readPassword() );
		  System.out.println( passwd );
		}
	}

}
