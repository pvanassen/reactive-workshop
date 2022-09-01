# Reactive workshop

Clone this repo, open the project in your favorite IDE and run the docker-compose file

## To run
Start `nl.pvanassen.reactive.workshop.ReactiveWorkshopApplication`

To save in the database: 
`curl -X PUT http://localhost:8080/saveToDatabase -H "content-type: plain/text" --data "testput"`

To get all from the database:
`curl http://localhost:8080/getFromDatabase`

To get all from webservice:
`curl http://localhost:8080/getFromWebservice`

## TODO
- General explanation
- Demo
- Implement: http client (with config)
- Implement: database save
- Implement: getAll endpoint
- Implement: streaming endpoint
