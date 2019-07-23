Приложение для работы с сотрудниками и их зарплатами. 

Как запустить?

  MacOs/Linux

Есть два способа - production mode и develop mode.

 production mode - без докера

    В файле backend/src/main/resources/application.yml указать адрес postgres.
    2 модуля - frontend и backend, собираются в один исполняемый jar файл командой ./mvnw clean install. JAR находится по пути    backend/target/*.jar

    запуск командой java -jar backend-0.1.0-SNAPSHOT.jar

 production mode - c докером

    запустить postgres на порту localhost:5433
    собрать приложение командой ./mvnw clean install
    задеплоить образ докера командой docker build -t homework/prod
    запустить образ docker run -p 80080:8080 -p 5433:5433 -t homework/prod
   
 develop mode
 
  backend 
  
    Как обычно через IDE или в папке backend командой ../mvnw spring-boot run 
  
  fronend
    
    для первого запуска понадобится скачать и установить node и yarn в папке frontend командой 
    ../mvnw frontend:install-node-and-yarn frontend:yarn 
    затем будет доступен запуск через yarn командой yarn start



