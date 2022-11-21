
<!-- PROJECT LOGO -->
<br />
<div align="center">
<h3 align="center">AndroidImageGalery</h3>

  <p align="center">
    Galeria de imagenes gratuitas para Android
    <br />
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## Sobre el Proyecto

Este proyecto a sido programado usando Android Studio usando lenguaje Java. 

El objetivo de esta aplicacion era aprender a usar los conceptos basicos de Android Studio Aprendidos durante el primer trimestre
del modulo de Desarroyo de Aplicaciones Movil.

La aplicacion en cuestion busca imagenes en base a una palabra (en ingles) y permite la descarga de estas.



<!-- GETTING STARTED -->
## Requisitos

Para el uso de la aplicacion necesitaremos los siguientes requisitos



* Emulador android con version 31 (Preferible usar un movil fisico, con el emulador las imagenes renderizan muy lento)
  con permisos de descarga.

* Java Versión 8

* Gradle version 7.3.3

## Instalacion

1. Obten llave publica de la API [https://www.pexels.com/](https://www.pexels.com/)
2. Clonar el repo
   ```sh
   git clone https://github.com/unailobo8/AndroidFreeImageGalery.git
   ```
3. Introducir clave de api en el `MainActivity.java`
   ```js
   private final String API_KEY = '563492ad6f9170000100000178b2ac16f5b5446a9f3817fa46c5088d';
   ```



<!-- USAGE  -->
## Uso

En este apartado explicare brevemente como usar la aplicación:

* Nada mas abrir la aplicación aparecera un TextFiel donde pondremos la palabra a buscar, seguido de un 
  boton de buscar.

* Una vez dado a Buscar, aparecera un nuevo layout con el listado de imagenes buscadas, las cuales al hacer un 
  click largo, nos mostrara un menu con la opcion de descargar la imagen.

* Al descargar la imagen, aparecera una notificación de que la imagen se esta descargando, y una vez finalizado
  aparecera otra notificacion de que esta terminado.



<!-- DEPENDENCIES -->

## Dependencias
He aquí ciertas dependencias de Android que se han usado: 

* Volley (Para hacer peticiones a una API)

* Picasso (Para renderizar imagenes)

* NotificationConpact y NotificationChannel (Para crear notificaciones y mostrarlas correcamente)

Para más informacion ver en el `build.gradle`

<!-- CONTACT -->

## Código
Más Informacion respecto al codigo de la aplicacion:

* Para hacer el listado de imagenes he usado un FragmentList

* En la descarga de la imagen he tenido que crear un Thread para 
  mejorar la velodidad de descarga

* Los nombres de las imagenes se crean en base a un generador de Strings aleatorios
```sh
  String name = UUID.randomUUID().toString() + ".jpg";
```


## Contacto

unasangui7@gmail.com

Project Link: [https://github.com/unailobo8/AndroidFreeImageGalery.git](https://github.com/unailobo8/AndroidFreeImageGalery.git)

