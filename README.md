# timedateextraction

This Project includes java wrapper for wit.ai (Duckling).
==================================================================================
[Note: duckling jar is already in resource folder,if you want your own follow steps below]

Steps to follow:
1.  Duckling library is written in clojure, to convert it into jar you need to download its library from githubrepo: https://github.com/wit-ai/duckling
2.  Download and install leiningen from https://leiningen.org/ 
3. On console hit cmd : lein uberjar ,to make jar
4. Copy jar into resources in your project.
5. Gradle dependencies to include local jar:

   repositories {
        flatDir {
            dirs './src/main/resources' //local jar path
        }
    }
    dependencies {
        compile name: 'duckling-0.4.23-standalone' //local jar from step 3
    }
    compile "org.clojure:data.json:0.2.6" //Since clojure return result in clojure data format,to convert it into json you need to include org.clojure.data.json library
=======================================================================================    
To run:
Run Application.java

