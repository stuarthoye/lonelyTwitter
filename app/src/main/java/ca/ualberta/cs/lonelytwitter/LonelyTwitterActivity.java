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

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;							// reference to editbox onscreen
	private ListView oldTweetsList;						// reference to list onscreen

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();   // NEW LINE
    private ArrayAdapter<Tweet> adapter;


	/** Called when the activity is first created. */
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

	// May be called many times; file can be stopped without being destroyed.
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

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

    // Saves data as a string; should be saved as GSON file.
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