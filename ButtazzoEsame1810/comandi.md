# Comandi utili per l'esame di domani

### 1. Comandi Per runnare il pacchetto java

- prendi il file .jar dalla classe generata in /target e copiatelo in una cartella a piacere
- apri il terminale e vai nella cartella dove hai copiato il file .jar
- Ora scrivi il comando: 
```bash
  java -jar nomefile.jar 
  ```
- ora il programma dovrebbe essere in esecuzione


### 2. Comandi per fare l'immagine di docker e runnarla

- Su intellij nella root del progetto premi col destro su "NomeProgetto" > new > Dockerfile
- Ora scrivi il seguente codice nel Dockerfile:
```dockerfile
FROM openjdk:17
ADD target/nomefilejargenerato.jar nomefile.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "nomefile.jar"]
```
- Ora, sempre su intellij, apri il terminale e scrivi il comando:
```bash
docker build -t nomeimmagine .
```
- Per runnare l'immagine appena creata scrivi il comando:
```bash
docker run --name nomerunnabile -p 8080:8080 nomeimmagine
```

- In alternativa, se non vuoi fare tutto tramite comandi, una volta creata l'immagine, puoi runnarla direttamente da docker desktop cliccando su "run" sull'immagine appena creata (consigliato)
- bisogna peró dare il nome al container e fare il port mapping