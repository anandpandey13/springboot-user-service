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
