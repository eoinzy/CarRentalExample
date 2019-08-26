READ ME
=======

This is a sample app that takes a JSON data source, parses it, and displays its contents.

This app uses RetroFit to download the data.
The URL used to download is configured in the BuildConfig. The actual value for the URL is stored in the local gradle.properties file.

On *nix machines, this is ~/.gradle/gradle.properties.

Issues
======
The JSON data format was unfamiliar and not ideal for marshalling. I had to convert the models to another model (SearchResult) to make the data manageable.


