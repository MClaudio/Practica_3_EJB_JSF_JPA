Desarrollo de una aplicación JEE basado en EJB, JSF y JPA para el intercambio de datos en una aplicación empresarial.

OBJETIVO ALCANZADO:

•      Diseña y desarrolla modelos de software en diferentes niveles de abstracción y modelos de datos a nivel transaccional y analítico con entornos de desarrollo actuales

1.	Desarrollo de aplicación JEE basado en EJB, JSF y JPA para el intercambio de datos en una aplicación empresarial.

Lo primero que se hace es crear una aplicación web con tecnología JEE en el lenguaje de Java utilizando Apache NetBeans:

![image](https://user-images.githubusercontent.com/34308601/88236850-98ffd680-cc43-11ea-845d-4a146b23a285.png)

Luego de ello, creamos un repositorio en GitHub en el cual vamos a alojar nuestro proyecto llamado Practica_3_EJB_JSF_JPA, en la siguiente imagen se muestra el repositorio creado:

Enlace: https://github.com/MClaudio/Practica_3_EJB_JSF_JPA.git

![image](https://user-images.githubusercontent.com/34308601/88236868-9f8e4e00-cc43-11ea-9609-66d9785a8864.png)

Luego, en la misma imagen se puede observar el número de commits que se han generado, esto demuestra el trabajo realizado de cada integrante del grupo para realizar el proyecto:

![image](https://user-images.githubusercontent.com/34308601/88236878-a4eb9880-cc43-11ea-934d-ca74914a27c9.png)

Dentro del proyecto generado, existe el archivo llamado persistence.xml que muestra las entidades creadas para que se puedan relacionar con la base de datos:

![image](https://user-images.githubusercontent.com/34308601/88236887-a9b04c80-cc43-11ea-8a01-1fd713ff610b.png)

Nosotros utilizamos el servidor Glassfish para el despliegue de la aplicación, por ello, hay que configurar la base de datos en el servidor de la siguiente forma:

![image](https://user-images.githubusercontent.com/34308601/88236900-b2088780-cc43-11ea-9fe5-bfad3251d301.png)

Luego de ello, veamos las carpetas creadas en el proyecto, empecemos con la carpeta controlador y los archivos creados dentro de este. Todos los archivos generados son los Bean de las clases para que la base de datos pueda interactuar con la vista:

![image](https://user-images.githubusercontent.com/34308601/88236910-b765d200-cc43-11ea-96d8-397adab0aa8d.png)

Luego, dentro de la carpeta ejb, se muestran los archivos que se están la la siguiente imagen. Las clases facade son las encargadas de hacer la persistencia entre la base de datos y el controlador.

![image](https://user-images.githubusercontent.com/34308601/88236918-bc2a8600-cc43-11ea-9706-86aeb94180d5.png)

En el paquete modelo están los archivos de las clases necesarias para ejecutar el proyecto, en este caso, todas las entidades:

![image](https://user-images.githubusercontent.com/34308601/88236927-c056a380-cc43-11ea-8ddb-8813445f9772.png)

Luego, se muestra la parte de la vista, de la misma forma, dividimos en secciones como se muestra en la imagen a continuación:

![image](https://user-images.githubusercontent.com/34308601/88236936-c51b5780-cc43-11ea-9b85-37c478b25813.png)

En la carpeta admin, se crean todas las vistas necesarias para la gestión de la bodega desde la parte administrativa, en este caso la gestión de productos, de la bodega y las categorías pertenecientes a cada producto. 

![image](https://user-images.githubusercontent.com/34308601/88236946-ca78a200-cc43-11ea-8257-933357b81dce.png)

Luego de ello, se crea la carpeta empleado, la cual va a ser la encargada de gestionar los clientes y las facturas de venta:

![image](https://user-images.githubusercontent.com/34308601/88236954-cea4bf80-cc43-11ea-8d99-fbc4c512e940.png)

Luego, se muestra la interfaz grafica del empleado y la gestion de facturas y de los clientes, aqui se muestra:

![image](https://user-images.githubusercontent.com/34308601/88236959-d3697380-cc43-11ea-8d3c-1824b57d3e65.png)

![image](https://user-images.githubusercontent.com/34308601/88236963-d7959100-cc43-11ea-8d7f-7a721a6f924c.png)

Luego esta la parte del administrador, para la gestion de los productos, bodegas y categorias:

![image](https://user-images.githubusercontent.com/34308601/88236978-dcf2db80-cc43-11ea-8f51-380aebe5c756.png)

![image](https://user-images.githubusercontent.com/34308601/88236986-e11ef900-cc43-11ea-8011-063863b08c27.png)

![image](https://user-images.githubusercontent.com/34308601/88237005-e8460700-cc43-11ea-8328-cd0a91d2cd8e.png)

2. Desarrollar las aplicaciones JEE y Angular basado en EJB, JSF, JPA, y WS para el intercambio de datos en una aplicación empresarial. 

Para desplegar la aplicación en angular se hace los siguiente: npm install se utiliza para instalar las dependencias, luego ng build permite construir el proyecto, y la ultima linea se utiiza para mover la carpeta de deployed de angular hacia el servidor apache. 

![image](https://user-images.githubusercontent.com/34308601/88298941-65ff2680-ccc7-11ea-8338-602f0f79803a.png)

En la siguiente imagen se muestra el index con la lista de productos que se recuperan de la base de datos

![image](https://user-images.githubusercontent.com/34308601/88298968-70212500-ccc7-11ea-8c2b-b13c0cd7098e.png)

Luego, se muestra la interfaz de la lista de los pedidos que se han realizado. 

![image](https://user-images.githubusercontent.com/34308601/88298988-78796000-ccc7-11ea-962d-57edb161323d.png)

Tambien se muestra la lista de los clientes con sus localidades respectivas:

![image](https://user-images.githubusercontent.com/34308601/88299024-829b5e80-ccc7-11ea-91b0-e91e48050ffb.png)


3. Alojar la aplicación web que permita presentar servicios web Restful en una plataforma en la nube usando como front-end JSF y Angular 

Estamos utilizando la plataforma de Azure para crear un servidor Ubuntu

Lo primero que se hace es desplegar el servidor con la siguiente línea de comando

![image](https://user-images.githubusercontent.com/34308601/88244090-3bc25000-cc58-11ea-8a23-1793c5df30d5.png)

Lo que se debe hacer  es editar archivo xml del domain pare editar los archivos de la base de datos con la cual estamos trabajando.

![image](https://user-images.githubusercontent.com/34308601/88244093-40870400-cc58-11ea-8978-a4e40ac1cef4.png)

En Jenkins se debe configurar el archivo Maven para luego con la línea de comando que se muestra se mueve la aplicación al servidor de glassfish.

![image](https://user-images.githubusercontent.com/34308601/88244098-441a8b00-cc58-11ea-97b0-b7caaaa021cf.png)

La siguiente configuración hace que Jenkins pueda escuchar los cambios de push que tenemos en github.

![image](https://user-images.githubusercontent.com/34308601/88244102-48df3f00-cc58-11ea-852d-204b0ef1cce3.png)


CONCLUSIONES: 

La aplicación web se ha creado exitosamente, hemos cumplido con los requerimientos solicitados por nuestro docente, de la misa forma, cada integrante ha trabajado para generar un trabajo en equipo. 

La implementación de JSF se ha implementado correctamente y hemos creado nuestro proyecto con el servidor de glassfish. 

Tambien hemos implementado Angular para la parte publica del cliente, para la gestión de la compra de los productos. 

Finalmente, hemos desplegado nuestro proyecto en la web exitosamente desde una maquina virtual con servidor. 

INTEGRANTES:

Claudio Maldonado
Christian Mocha
Jonnathan Ochoa
Diego Duchimaza
