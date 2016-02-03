package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @see LonelyTwitterActivity LonelyTwitterActivity <br>
 *
 * This is the controller for the LonelyTwitterActivity <br>
 *     This object holds member variables:<br>
 *     <ul>
 *         <li>FILENAME: to track where to save data</li>
 *         <li>bodytext: reference to the EditText onscreen</li>
 *         <li>oldTweetsList: reference to the list onscreen</li>
 *         <li>tweets: reference to all the tweets</li>
 *         <li>adapter: facilitates displaying the tweets in the oldTweetsList</li>
 *     </ul>
 * <br>
 *     This object holds the methods:
 *     <ul>
 *         <li>onCreate</li>
 *         <li>onStart</li>
 *         <li>loadFromFile</li>
 *         <li>saveInFile</li>
 *     </ul>
 *
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();   // NEW LINE
    private ArrayAdapter<Tweet> adapter;


	/**
	 * Called when the activity is first created.
	 * Overrding method.
	 * Establishes reference for<br>
	 *     <ul>
	 *         <li>bodyText</li>
	 *         <li>oldTweetsList</li>
	 *         <li>saveButton</li>
	 *         <li>clearButton</li>
	 *     </ul>
	 * <br>
	 * Reads info in from the file.
	 * <br>
	 * Initializes listeners for:
	 *     <ul>
	 *         <li>clearButton</li>
	 *         <li>saveButton</li>
	 *     </ul>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);				// instantiation of components
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);     // reference to clear button

        loadFromFile();

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                tweets.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
                tweets.add(latestTweet);                                        // NEW LINE
                adapter.notifyDataSetChanged();
                saveInFile();

				// saveInFile(text, new Date(System.currentTimeMillis()));         // call to method that saves data.
				// finish();
			}
		});
	}

	/**
	 * May be called many times; file can be stopped without being destroyed.
	 * Responsible for ensuring reference across periods of focus.
 	 */

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method coverts a Gson file into objects LonelyTwitter can use.
	 * Establishes a file input stream at the FILENAME location.
	 * Calls gson to perform the conversion.
	 * Initializes the array, tweets, to an empty array if no file exists at FILENAME.
	 * @exception FileNotFoundException sets tweets to a new ArrayList.
	 * @exception IOException thrown if some other error in IO.
	 */
	private void loadFromFile() {
		// ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Code from:
            // https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            // Date: Jan 19, 2016
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

			// String line = in.readLine();
			// while (line != null) {
			// 	tweets.add(line);
			// 	line = in.readLine();
			// }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
            tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
            throw new RuntimeException();
		}
		// return tweets.toArray(new String[tweets.size()]);
	}

	/** Saves data as a GSON file.
	 * Establishes a file output stream, and a buffered writer to do the writing.
	 * establishes a gson object to perform conversion from objects in use to strings that can be
	 * written to file.
	 * @exception FileNotFoundException thrown when file not found.
	 * @exception IOException thrown if some error in IO found.
	 */
	private void saveInFile() {
		try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweets, out);       // Tweets are parsed into JSON, and sent to writer.
            out.flush();
            fos.close();

            // FileOutputStream fos = openFileOutput(FILENAME,
            // 		Context.MODE_PRIVATE);
			// fos.write(new String(date.toString() + " | " + text)
			// 		.getBytes());
            // fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
            throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
            throw new RuntimeException();
		}
	}
}