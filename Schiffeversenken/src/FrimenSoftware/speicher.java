package FrimenSoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class speicher {

	private List<String> daten = new LinkedList<String>();
	public speicher() {
		// TODO Auto-generated constructor stub
		
	}

	public void Speichern(firma f) {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
		  fos = new FileOutputStream(f.getFirmenname()+ ".ser");
		  oos = new ObjectOutputStream(fos);
		  oos.writeObject(f);
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		finally {
		  if (oos != null) try { oos.close(); } catch (IOException e) {}
		  if (fos != null) try { fos.close(); } catch (IOException e) {}
		}
	}
	
	public firma Laden(String name) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
		  fis = new FileInputStream(name+ ".ser");
		  ois = new ObjectInputStream(fis);
		  Object obj = ois.readObject();
		  if (obj instanceof firma) {
		    firma so = (firma)obj;
		    return so;
		  }
		 
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
		  e.printStackTrace();
		}
		finally {
		  if (ois != null) try { ois.close(); } catch (IOException e) {}
		  if (fis != null) try { fis.close(); } catch (IOException e) {}
		}
		return null;
	}
	
	public String encryptThisString(String input) 
    { 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            return hashtext; 
        } 
   
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
	
	public void registrieren(String name,String pass) {
		try {
			File daten = new File("LoginDatenFirma.txt");
			FileWriter fw = new FileWriter(daten,true);
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader in = new BufferedReader(new FileReader("LogindatenFirma.txt"));

			bw.write(name+ ":" + pass);
			bw.newLine();
			bw.flush();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String name, String pass) {
		auslesen();
		for (int i = 0; i < daten.size(); i++) {
			String[] split = daten.get(i).split(":");
			
			if(split[0].equals(name)) {
				if(split[1].equals(pass)) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	public void auslesen() {
		try {
			String line;
			FileReader fr = new FileReader("LoginDatenFirma.txt");
			BufferedReader br = new BufferedReader(fr);
			
			 while (null != (line = br.readLine())) {
		           daten.add(line);
		          } 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
