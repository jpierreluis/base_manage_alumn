# Instrucciones para instalar
# Eclipse:
para bajar el repositorio solo basta con insertar el comando " git clone https://github.com/jpierreluis/base_manage_alumn.git ".
Posteriormente a eso es nesesario tener instalado el eclipse, ademas de un plugin llamado Spring tools 4, 
para poder agregar este plugin deberas dirigirte a Help> Eclipse MarketPlace,
en la barra de busqueda escribiras: Spring tools 4
nos mostrara el siguiente elemento
![Image text](https://github.com/jpierreluis/base_manage_alumn/blob/main/ImgExample/spring_tools_4.PNG)
en la parte inferior nos mostrara un boton para instalar,
precionamos instalar y seguimos los pasos que nos indique hasta que se reinicie el IDE.
# versiones:
las versiones que se requieren para poder trabajar dentro del aplicativo es:
- JDK 8 configurado dentro del eclipse (lo tiene instalado por defecto).
- node version 12.5.0
- ng version 11.2.0

recuerda que para poder levantar el aplicativo angular deberas colocarte en la ruta del proyecto y 
escribir el siguiente comando "ng server -o"
y para desplegar el proyecto de java solo basta con darle click derecho al proyecto, 
seleccionar Run as y seleccionar la opcion para levantar spring
![Image text](https://github.com/jpierreluis/base_manage_alumn/blob/main/ImgExample/levantar_el_proyecto_java.png)

# angular:
**importante: no es nesesario utilizar el proyecto de angular, si gustas podras utilizar algun frontEnd de tu preferencia o inclusive una pagina html con sus scripts y hojas de estilo si asi lo prefieres**
el proyecto angular se encuentra dentro de este mismo repositorio esta ubicado en /grade-management-ws/src/main/resources/management-alumn
dentro del aplicativo de angular en la ruta: src\app\utils\config.ts
se encuentra una variable en la cual puedes configurar el path de hacia donde quieres apuntar a los servicios APIS
de tu local, por defecto podras colocarlo de la siguiente manera export const URL_BACKEND = 'http://localhost:8080';
para hacer prueba en tu ambiente local.
tenras un ejemplo de como se consigue realizar un CRUD de las materias.
ademas si desas colocar dentro del mismo proyecto la parte visual solo basta con agregar un compilado de angular dentro de la carpeta 
src/main/resources/static del proyecto java, ten la libertad de eliminar lo que exista en esa carpeta y poner tus cambios.
![Image text](https://github.com/jpierreluis/base_manage_alumn/blob/main/ImgExample/static.PNG)
> **recuerda que antes de compilar el proyecto deberas remover 'http://localhost:8080' de tu constante URL_BACKEND en el archivo src\app\utils\config.ts**

Para poder hacer un compilado solo basta colocarte en el path del proyecto y escribir el comando ng build 
te creara una carpeta a nivel del proyecto angular llamada dist, dentro de ella otra que se llamara management-alumno y puedes copiar su contenido hacia la carpeta static para que una vez que levantes el servicio con spring este pueda mostrar las paginas en 
el path principal.

Nota: si no te quiere instalar las librerias, con el npm install, te recomiendo usar el comando npm install --force.
Ademas te recomiendo utilizar heroku para cargar tu aplicativo en un host.

# Base de datos
por defecto ya esta configurado para  conectarse a una base de datos llamada grade_management, esto para el gestor de base de datos Mysql, pero no estas limitado a configurar el proyecto en el gestor de base que prefieras, debes tomar en cuenta que el proyecto te creara de forma automatica las tablas que piden las instrucciones.


