## webapp16

# FASE 1: 

## DEFINICIÓN DE LAS FUNCIONES DE LA WEB

  - CONCEPTO:
  Nuestra página web consiste en un blog de viajes para que los usuarios compartan sus experiencias con los demás.

  - ENTIDADES Y RELACIONES:
  Usuario: que hay de tres niveles
  
    Usuarios invitados (nivel 1): que podrán visualizar los viajes realizados por los usuarios registrados y los comentarios realizados por estos

    Usuarios registrados (nivel 2): que podrán realizar viajes (y publicarlos) y realizar comentarios sobre los viajes publicados (por ellos mismos y por los demás).

    Usuarios administradores (nivel 3): que pueden crear, editar y borrar destinos y configurar las características de los usuarios (no queremos que tengan nombre, avatares o publicaciones inadecuadas).

    Los usuarios de nivel 2 pueden hacer aquello que puedan hacer los de nivel 1, y los de nivel 3 pueden hacer aquello que puedan hacer los de nivel 2 (y por tanto también los de nivel 1).

  Destinos: a los que se realizan viajes.

  Viajes: realizados a un destino y publicados por los usuarios registrados.

  Comentarios: Realizados por los usuarios registrados y publicados sobre un destino.

  - Imágenes:
  Los usuarios podrán publicar sus avatares personalizados (imágenes propias) así como las fotos de sus viajes.

  - Gráfico:
  Los destinos contendrán información sobre los viajes realizados por los usuarios y las valoraciones realizadas de esos viajes. Los administradores tendrán acceso a gráficas que permitan determinar cuales son los mejores destinos de acuerdo con los usuarios.

  - Tecnología complementaria
  Las páginas de los destinos tienen acceso a google maps, y mostrarán un plano del destino gracias a un enlace embebido de este servicio.

  - Algoritmo avanzado
  Utilizaremos un algoritmo de ordenación para recomendar a los usuarios los mejores destinos.

## CAPTURAS DE PANTALLA

  - PANTALLA ADMINISTRADOR:
  A esta página solo tendrá acceso aquel usuario que se haya registrado como administrador. Podrá editar y añadir destinos y configurar los usuarios registrados en la       web.
  <img alt="Pantalla administrador" src="images/FASE 1/admin.png"> 
  
  - PANTALLA DESTINO: Pantalla que nuestra un destino concreto de la lista de destinos con información detallada del sitio.
  <img alt="Pantalla destino" src="images/FASE 1/destino.png">
  
  - PANTALLA PRINCIPAL: La pantalla principal de nuestra página web, desde aquí se podrá ver una lista de todos los destinos y navegar por las diferentes pantallas de    la página.
  <img alt="Pantalla principal" src="images/FASE 1/paginaPrincipal.png">
  
  - PANTALLA LOGIN: Desde aquí los usuarios podrán iniciar sesión con su nombre y contraseña.
  <img alt="Pantalla login" src="images/FASE 1/Log-In.png">
  
  - PANTALLA SIGNUP: Los usuarios que no estén registrados podran hacerlo a través de esta pantalla. Se registrarán con un nombre y una contraseña y además podrán        subir una imagen para ponerla de foto de perfil. 
  <img alt="Pantalla signup" src="images/FASE 1/SignUp.png">

  - PANTALLA AREA PERSONAL: A esta pantalla solo tendrán acceso los usuarios registrados. Desde aquí podrán ver todos los detalles de su viaje y subir los documentos          necesarios para ello (ticket de avión, reserva hotel...).
  <img alt="Pantalla area personal" src="images/FASE 1/areaPersonal.png">
  
  - PANTALLA VALORACIONES: Está pantalla esta pensada para que los usuarios que hayan terminado su viaje puedan subir información sobre este y asi que otros usuarios          puedan consultarla y puedan organizar su viaje de una forma más sencillla y cómoda.
  <img alt="Pantalla valoraciones" src="images/FASE 1/Valoraciones.png">
  
  ## DIAGRAMA DE NAVEGACIÓN
  <img alt="Diagrama de navegación" src="images/FASE 1/DiagramaDeNavegación.png">
  
  ## DIAGRAMA DE CLASES
  <img alt="Diagrama de clases" src="images/FASE 1/Diagrama de clases.png">
 
  #TRABAJO DE CADA MIEMBRO:
  #ALEJANDRO ROMERO
  -La tarea principal fue la creación de los objetos en la base de datos, inicialización de datos y mostrarlos en la página.
  -5 commits principales:
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/e58de4bc205b48cc6ad9743e840babe325781aa2
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/72d161adc48c5ca6cd05dc7c637836fcde291b10
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/f9938506135ea4054691976fc773cee11a8f1a1a
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/ad9d045c03be57c45c2f266ca25d44f84ecdec5e
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/5eb8e392f7cf3949e21cf57655abd8040d8ebb8a
   -5 ficheros en los que más he participado  
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Controller/testDataInitializer.java
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Controller/MustacheController.java
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/destino.html
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/index.html
    -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Entitys/Destination.java
  
  #PAULA CUENCA GIL:
  - Mi tarea principal ha sido ocuparme de la seguridad de la página asi como ayudar en la inicialización de la base de datos y en su correcto funcionamiento.
  - 5 commits principales: 
   - 1 de marzo, 2 commits creando todo lo de seguridad: https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/71f949338f518a907c1dad52e64ca879f7cf8e9c
   - 8 de marzo, funcionamiento, ejemplos BBDD y cambios htmls: https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/f9acc5a69452ae8436f0ad18b00c6463567659e4
   - 8 marzo, funcion destino/name : https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/82f1fdfe943151ced92f363e502bd142e3d4dfee
   - 11 marzo, admin list : https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/725626cb41359ea068cc7fe24aeb6f84411f79aa 
   - 11 marzo, agregar destinos BBDD: https://github.com/CodeURJCDAW-2022-23/webapp16/commit/548dc9cf2b51b6618e223c83a5aabc1165c7914
  
  - 5 ficheros en los que más he participado: 
   - https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/security/SecurityConfiguration.java
   - https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Controller/MustacheController.java
   - https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/Login.html
   - https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/agregarDestinos.html
   - https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/editarDestinos.html

  #ISMAEL ALBERT APARICIO:
  -Mi tarea principal ha sido la definición de los distintos objetos, arreglo de errores y la paginación.
  -5 commits principales:
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/5d4abd9e493cdd0e7d6b21fd6a3889bfe79224e7
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/45bce933eb62c6e7fa5c162160229c7b7a522e4b
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/7c8054b4eefd43f3df2c3f1d7de75c2d2e370cda
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/a75260757dd5bfdc199d0dacccbee7acfb0df757
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/f141436ee855c490525edda7d7337a8bba74388c
  
  -5 ficheros en los que más he participado:
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/personalArea.html
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Controller/MustacheController.java
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Services/DestinationService.java
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/security/SecurityConfiguration.java
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Repositories/DestinationRepository.java

  #ADRIÁN AGUILAR RODRIGUEZ
  -Tareas realizadas esta fase:
  -Implementación de la página de error
  -Diseño del esquema de la base de datos

  -5 commits principales
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/94c36c1f18c9ec8b0a738a131d4adf0da77c27d8
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/98f2ed14fabc4355f6d206a422892e00221be29a
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/23d76cdce543cd7d6ce9d6e44f742727fd2327b5
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/6986c62d205fefbf316393b10515fdb3a6d75101
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/commit/a6d6a61051d06dd824cf883e17815ab2312cb619

  -5 ficheros en los que más he trabajado
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/Error.html
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/footer.html
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/resources/templates/header.html
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Entitys/User.java
  -https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/templatemo_551_stand_blog/backend/helloword-vscode/src/main/java/es/codeurjc/hellowordvscode/Controller/MustacheController.java


# FASE 2: 
## NAVEGACIÓN: 
Se presenta una captura de cada pantalla actualizada de la aplicación 
- PANTALLA ADMINISTRADOR: En esta pantalla hemos añadido la lista de destinos para poder ver todos los que tenemos y asi ir directamente a editar el que se seleccione.
<img alt="Pantalla admin" src = "images/Nueva carpeta/ADMIN.jpeg">
- PANTALLA DESTINO: Hemos insertado fotos e información de cada destino
 <img alt="Pantalla destino" src="images/Nueva carpeta/DESTINO.jpeg"> 
- PANTALLA PRINCIPAL: En la página principal ahora podremos ver una lista de todos los detinos, cada uno con una foto y una breve descripción. Además, podemos observar que hemos añadido el botón de cargar más destinos.
 <img alt="Pantalla principal" src="images/Nueva carpeta/PRINCIPAL.png">
 <img alt = "Principal boton mostrar más" src = "images/Nueva carpeta/PRINCIPAL-2.png">
- PANTALLA LOGIN: Pantalla donde los usuarios podrán iniciar sesión.
<img alt="Pantalla login" src="images/Nueva carpeta/LOG-IN.jpeg">
- PANTALLA SIGNUP: Aqui los usuarios no registrados podrán unirse a nuestra aplicación.
<img alt="Pantalla signup" src="images/Nueva carpeta/SIGN-UP.jpeg">
- PANTALLA AREA PERSONAL: En esta pantalla se verá la información de cada usuario, sus viajes, reservas...
<img alt="Pantalla area personal" src="images/Nueva carpeta/AREA PERSONAL.png">
- PANTALLA VALORACIONES: Una vez los usuarios terminen su viaje podráwn subir información y dar su opinión sobre el mismo y así poder ayudar a otros usuarios que estén pensando realizar el mismo viaje.
<img alt="Pantalla valoraciones" src="images/Nueva carpeta/VALORACIONES.jpeg">

## INTRUCCIONES DE EJECUCIÓN
## Instrucciones para ejecutar el programa como aplicación web:
  -  Paso 1: Descargarse la aplicación del repositorio de github.
  -  Paso 2: Iniciar la base de datos.
  -    Paso 2.1: Crear una base de datos con nombre de webapp16 y conectarla al puerto 3306.
  -    Paso 2.2: Introducir datos iniciales a la base de datos.
  -      El código del repositorio ya tiene datos por defecto.
  -  Paso 3: Iniciar la aplicación como aplicación de SpringBoot.
  -  Paso 4: Iniciar el navegador y conectarse a la aplicación.
  -    Si se está ejecutando en el mismo ordenador el programa y el navegador, se puede acceder a la aplicación introduciendo como dirección "https://localhost:8443" (Si está con la configuración por defecto).

## DIAGRAMA CON LAS ENTIDADES DE LA BASE DE DATOS
  <img alt="Diagrama de bases de datos" src="images/FASE 1/Diagrama base de datos.png">


