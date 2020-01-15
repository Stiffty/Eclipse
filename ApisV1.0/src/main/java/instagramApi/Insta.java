package instagramApi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

public class Insta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Login to instagram
		try {
			Instagram4j instagram = Instagram4j.builder().username("eli.ach@gmx.de").password("Elias.acht").build();
			instagram.setup();
			
			//instagram.login();
			
			
			instagram.sendRequest(new InstagramUploadPhotoRequest(
			        new File("C:\\Users\\elach\\Pictures\\Reddit\\I choose you.jpg"),
			        "Posted with Instagram4j, how cool is that?"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
