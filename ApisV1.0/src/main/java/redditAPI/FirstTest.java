package redditAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.PoliteHttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

public class FirstTest {

	public Resizer resizer = new Resizer();
	
	public FirstTest() {
		List<String> login;
		List<Submission> subredd;
		List<String> alreadyDownloaded = new ArrayList<String>();
		
		login = readLogin("C:\\Users\\elach\\git\\Eclipse\\ApisV1.0\\src\\main\\resources\\Login.txt");
		System.out.println("Login sucessfully read.");
		
		subredd = connectUser(login.get(0), login.get(1));
		
		
		for (Submission submission : subredd) {

				System.out.println("Download <" + submission.getTitle() + "> startet...");
				downloadUrl(submission.getUrl(),submission.getTitle());
				System.out.println("Download <" + submission.getTitle() + "> finished.");
				System.out.println();
				
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirstTest t = new FirstTest();
	}

	public List<Submission> connectUser(String userName, String pass) {
		// Initialize REST Client
		RestClient restClient = new PoliteHttpRestClient();
		restClient.setUserAgent("bot");

		// Connect the user
		User user = new User(restClient, userName, pass);
		try {
			user.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Handle to Submissions, which offers the basic API submission functionality
		Submissions subms = new Submissions(restClient, user);
		
		// Retrieve submissions of a submission
		List<Submission> submissionsSubreddit = subms.ofSubreddit("memes", SubmissionSort.HOT, -1, 100, null,
				null, true);
		submissionsSubreddit.remove(0);
		return submissionsSubreddit;
	}
	
	public void downloadUrl(String url,String name) {
		URL website;
		try {
			name = name.replaceAll("[^a-zA-Z0-9\\s]", "");
			//name = name.replaceAll("\\s", "_");
			
			String[] dateiEndung = url.split("[.]");
			//System.out.println(dateiEndung[dateiEndung.length-1] + " name: " + name);
			
			website = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			String imagePath = "C:\\Users\\elach\\Pictures\\Reddit\\" + name + "."+dateiEndung[dateiEndung.length-1];
			FileOutputStream fos = new FileOutputStream(imagePath);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			resizer.resize(imagePath, imagePath, 1080, 1350);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<String> readLogin(String filename) {

		List<String> login = new ArrayList<String>();

		File file = new File(filename);

		if (!file.canRead() || !file.isFile())
			System.exit(0);

		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(filename));
			String line = null;

			while ((line = in.readLine()) != null) {
				login.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
					return login;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return login;
	}
}
