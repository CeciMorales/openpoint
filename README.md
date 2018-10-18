# OpenPoint

For this project I used [IntelliJ](https://www.jetbrains.com/idea/), 
you can download it and get a free student license with your ITESM email account.

For creating this project I followed the following steps:

## Steps:

### 1. Create New Project
Create a new project from the menu and select **Java Enterprise** and check the **Web Application** option, 
also make sure that in the Application Server you select **Tomcat**.

![First Step](https://res.cloudinary.com/dmrgfufa4/image/upload/v1539838622/1.png)

### 2. Download JSTL Library
From `File -> Project Structure` select `Libraries` and then from **`Maven`**

![Second Step](https://res.cloudinary.com/dmrgfufa4/image/upload/v1539838621/2.png)

Then write and select **javax.servlet:jstl:1.2** and make sure that the **Download** option and **Transitive Dependencies**
are checked. Also make sure that it will be downloaded into `web/WEB-INF/lib/`, **if it's in other folder, it won't work**.

![Third Step](https://res.cloudinary.com/dmrgfufa4/image/upload/v1539838622/3.png)

### 3. Add JDBC MySQL Connector

First download the connector from [here](https://dev.mysql.com/downloads/connector/j/5.1.html).

Then You have to add it to `web/WEB-INF/lib/`.

## Extras:
- In the root folder is the SQL dump that you can import into your sql in order to test the program.
- Also, in the root folder is the war file so you can add it directly to the apache server and test it.
(The test user is **emirock@email.com** and **soyemirock**)

Made with :heart: for:
- Emirock
- Ahiram
- Ceci
