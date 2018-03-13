# A file that I created for Git hub Purposes like a help file

## Docker command to run an image on local docker composer
docker build . --tag <DESIRED_REPO_NAME>:<TAG_NAME>
docker run -p <DESIRED_PORT>:8080 <DESIRED_REPO_NAME>:<TAG_NAME>

## Example to use teh env variable
docker run -p 8080:8080 -e SERVER_PORT=8080  <DESIRED_REPO_NAME>:<TAG_NAME>


## Use below to see sample swagger config
http://localhost:<APP_PORT>/swagger-ui.html

## Samples for using the API's

## GET an item
localhost:8088/myretail/items/1

## GET all items
localhost:8088/myretail/items

## POST create an item
Content-Type: application/json
body: {
      	"itemName":"ipod",
      	"itemPrice": 150,
      	"itemCurrencyType": "INR"
      }
localhost:8088/myretail/items

## DELETE an item
localhost:8088/myretail/items/4

## PUT an item
localhost:8088/myretail/items

## Run a runnable JAR
java -DSERVER_PORT=8080 -jar app.jar