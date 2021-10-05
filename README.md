READ ME
=======

This is a sample app that takes a JSON data source, parses it, and displays its contents.

This app uses RetroFit to download the data.
The URL used to download is configured in the BuildConfig, where any variables are set in the defaultConfig in the app's build.gradle file.

The actual value for the URL is stored in the local gradle.properties file. On *nix machines, this is ~/.gradle/gradle.properties, in the form:
<p>
CAR_JSON_DOMAIN=http://www.example.com <br />
CAR_JSON_PATH=/path/to/cars.json
</p>

Issues
======
The JSON data format was unfamiliar and not ideal for marshalling. I had to convert the models to another model (SearchResult) to make the data manageable.

This demo was for a specific purpose, with a given endpoint and its specific JSON response format.
To use this app on another API, you will need to modify the data models and fit them into the app.
