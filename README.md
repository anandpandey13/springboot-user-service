## springboot-user-service

echo "# springboot-user-service" >> README.md  
git init  
git add README.md  
git commit -m "first commit"  
git branch -M main  
git remote add origin https://github.com/anandpandey13/springboot-user-service.git  
git push -u origin main  


## Implemented basic controller and dto (Data transfer object)
### Requests can me made now - 
- GET http://localhost:8080/  
This is Default Display page  
- GET http://localhost:8080/hello  
Hello buddy, this is user micro service  
- POST http://localhost:8080/user  
Request payload  
{  
  "name": "Anand",  
  "age": 29,  
  "id":1  
}  
If we do not put any of these 3 fields then that value becomes null.  

## Implemented service and entity  
### Below Requests can me made now -  
- GET http://localhost:8080/users  
No available users  
OR  
Available users are [User [id=1, name=Anand, age=2], User [id=2, name=Kumar, age=4]]  
- POST http://localhost:8080/user  
Request payload  
{  
  "name": "Anand",  
  "age": 29,  
  "id":1  
}  
User is created User [id=2, name=Kumar, age=4]  
If we do not put any of these 3 fields or with invalid value then that user will not be created  
It will show message as Invalid User/name/id respectively.  
  
## Implemented ApiResponse instead of normal String for better structured response.  
### Response has now changed as below -  
- GET http://localhost:8080/users  
{  
    "data": null,  
    "message": "No available users",  
    "status": "SUCCESS"  
}  
OR  
{  
    "data": [  
        {  
            "age": 4,  
            "id": 4,  
            "name": "Kumar"  
        },  
        {  
            "age": 2,  
            "id": 2,  
            "name": "Anand"  
        }  
    ],  
    "message": "Available users are ",  
    "status": "SUCCESS"  
}  
- POST http://localhost:8080/user  
Request payload  
{  
  "name": "Anand",  
  "age": 29,  
  "id":1  
}  
Response1 -  
{  
    "data": {  
        "age": 4,  
        "id": 4,  
        "name": "Kumar"  
    },  
    "message": "User is created ",  
    "status": "SUCCESS"  
}  
Response2 -  
{
    "data": null,
    "message": "Invalid age",
    "status": "FAILURE"
}
The Data has now become structured.  

## Implemented Exception handling centrally
- POST http://localhost:8080/user  
{  
  "name": "Anand",  
  "age": 2  
}  
We did not put id here, so this request should not be processed. Below is the output  
{  
    "data": {  
        "age": 2,  
        "id": 0,  
        "name": "Anand"  
    },  
    "message": "Invalid id",  
    "status": "FAILURE"  
}  
Note - We did not enter id in request payload so user was not created but in side our code we have mentioned primitive data type int of id, hence default value zero was assigned. We will fix this using Integer wrapper class in next commmit.  

### Implemented ResponseEntity to return status code as part of HTTP response metadata
- ResponseEntity = manual control over HTTP response metadata + body  
(HTTP protocol meta data means status code (200, 404, 500), headers, content type, response body(payload))  
- In case of throw Exception, we can return anything, it is not mandatory to return a ResponseEmtity or ApiResponse type.  
Because when exception occurs, the flow of program comes out of the method without expecting to return anything.  
After these chnages, we have status also like 400:Bad Request or 200:OK or 201:Created  
