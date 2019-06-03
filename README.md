# Inspection Application

## Installation
Install the project:

`mvn install`

## Run the project:
Execute class: ```Main.java```

## Request Example
### Inspect Piece:
URI: `http://localhost:8080/spot_check`

Method: `POST`

Content-Type: `application/json`

Body: 
```
{
    "squares": "[[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]"
}
```

## Unit Tests

`mvn test`
