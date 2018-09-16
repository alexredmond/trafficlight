!!! Unpack application to folder !!!

C:/iwona

This location is required for H2-server database access:
jdbc:h2:tcp://localhost/c:/iwona/h2_database/globoforce
Otherwise application.properties needs to be modified and application repacked


To run application, start database first, then run app. See output in logs folder
1_runDatabase.bat
2_runTrafficLightsApp.bat