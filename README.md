# weather-report
This is a spring boot mvc application that fetches  realtime data from open-weather-apis
By default caching is disabled as mongo connection is not available from remote servers.

To enable chacing change the properties in application.properties
mongo-hostname= <<your mongo hostname>>
dbName = <<your db name>>
enableCaching=true

Deployment details:
This is currently deployed on:
https://weatherind-app.herokuapp.com/#


