## webapp16

# DEFINICIÓN DE LAS FUNCIONES DE LA WEB

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

# CAPTURAS DE PANTALLA

  - PANTALLA ADMINISTRADOR:
  A esta página solo tendrá acceso aquel usuario que se haya registrado como administrador. Podrá editar y añadir destinos y configurar los usuarios registrados en la       web.
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/admin.png 
  
  - PANTALLA DESTINO: Pantalla que nuestra un destino concreto de la lista de destinos con información detallada del sitio.
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/destino.png
  
  - PANTALLA PRINCIPAL: La pantalla principal de nuestra página web, desde aquí se podrá ver una lista de todos los destinos y navegar por las diferentes pantallas de    la página.
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/paginaPrincipal.png
  
  - PANTALLA LOGIN: Desde aquí los usuarios podrán iniciar sesión con su nombre y contraseña.
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/Log-In.png
  
  - PANTALLA SIGNUP: Los usuarios que no estén registrados podran hacerlo a través de esta pantalla. Se registrarán con un nombre y una contraseña y además podrán        subir una imagen para ponerla de foto de perfil. 
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/SignUp.png
  
  - PANTALLA AREA PERSONAL: A esta pantalla solo tendrán acceso los usuarios registrados. Desde aquí podrán ver todos los detalles de su viaje y subir los documentos          necesarios para ello (ticket de avión, reserva hotel...).
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/areaPersonal.png
  
  - PANTALLA VALORACIONES: Está pantalla esta pensada para que los usuarios que hayan terminado su viaje puedan subir información sobre este y asi que otros usuarios          puedan consultarla y puedan organizar su viaje de una forma más sencillla y cómoda.
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/Valoraciones.png
  
  # DIAGRAMA DE NAVEGACIÓN
  https://github.com/CodeURJC-DAW-2022-23/webapp16/blob/main/images/DiagramaDeNavegaci%C3%B3n.png
  
  
  
  

