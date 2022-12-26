My project about online shop for notebooks;
I have parsing all notebooks from enter.kg and saving all to my database;
In my case in project im parsing around 2k notebooks;(name, model, vendor code, prize and image);

The main page is contain only notebooks with the buttons and we can move through the pages:(back/next);

![image](https://user-images.githubusercontent.com/76080041/207892852-c461fea8-018d-4706-b5e8-2b757d4e6f9d.png)

And we can open the image of notebook by clicking the image:
![image](https://user-images.githubusercontent.com/76080041/207893040-0afb04ff-d9c1-47b5-a83d-8a3bf6aa7f4a.png)
 when we will try to buy the product we can see:
 ![image](https://user-images.githubusercontent.com/76080041/207893272-dd82944c-501c-4222-a2d4-25a3086d26b0.png)
![image](https://user-images.githubusercontent.com/76080041/207893401-192abd7b-42e9-422d-bd65-2867b07345fa.png)

The application sending to client the information about purchase from Admin account(in my case its my personal account)
![image](https://user-images.githubusercontent.com/76080041/207894469-01511422-aae8-4f94-b1ac-14a373326cef.png)

then we go to the main page automatically;

about company page:
![image](https://user-images.githubusercontent.com/76080041/207895476-b96b9a02-a503-4a7e-b72d-8880889d3df7.png)

Delivery page:
![image](https://user-images.githubusercontent.com/76080041/207895564-ba44c47b-567a-41e7-863d-78f88b44a894.png)

Credit page:
![image](https://user-images.githubusercontent.com/76080041/207895615-0d70d687-4d71-4a76-9a20-8cf12d59c25d.png)

guarantee page:
![image](https://user-images.githubusercontent.com/76080041/207895779-396ddf75-0121-4827-a105-839f3256d528.png)




How run the project:

Just download pgAdmin4 and postgresql + Intellij idea ultimate
then setup application.proporties for database


```properties
spring_profile_active=prod
PROD_DB_HOST=containers-us-west-28.railway.app
PROD_DB_PORT=7938
PROD_DB_NAME=railway
PROD_DB_PASSWORD=xNjoH2LBi7758uk4itUd
PROD_DB_USERNAME=postgres
```
