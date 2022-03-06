# poolobject
 
[![Java CI](https://github.com/dab0012/poolobject/actions/workflows/ci.yml/badge.svg)](https://github.com/dab0012/poolobject/actions/workflows/ci.yml) [![Build Status](https://app.travis-ci.com/vpr1004/poolobject.svg?branch=master)](https://app.travis-ci.com/vpr1004/poolobject) [![codecov](https://codecov.io/gh/dab0012/poolobject/branch/master/graph/badge.svg)](https://codecov.io/gh/dab0012/poolobject)

Codacy
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/0d0e504956d546738c2a4f38cf336084)](https://www.codacy.com/gh/dab0012/poolobject/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dab0012/poolobject&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/0d0e504956d546738c2a4f38cf336084)](https://www.codacy.com/gh/dab0012/poolobject/dashboard?utm_source=github.com&utm_medium=referral&utm_content=dab0012/poolobject&utm_campaign=Badge_Coverage)
 
Java code example of creational design pattern pool object
 
Workshop to use good practices in software developmemnt: testing and measurement.
 
 
## Authors:
 
- Daniel Alonso Báscones
- Victor Pascual Rodríguez
 
## Questions:
 
**¿Se ha realizado trabajo en equipo?**   
El trabajo se ha realizado colaborando entre los miembros. 
Se puede apreciar en https://github.com/dab0012/poolobject/graphs/contributors
 
 
**¿Tiene calidad el conjunto de pruebas disponibles?**   
Sí, hemos intentado que todos los métodos se vean representados y probar con todas las opciones que se nos ocurrían. 
Además de esto los tests de JUnit se pasan correctamente como se puede apreciar en la integración continua, concretamente en las acciones de GitHub gracias a la integración con Ant. 
También hemos logrado una cobertura del 76%, lo que nos indica que un gran porcentaje del código se ejecuta. El resto del porcentaje se debe a las sentencias try/catch y la clase Client que contiene el main y no se puede testear.
 
**¿Cuál es el esfuerzo invertido en realizar la actividad?**   
Se ha invertido un esfuerzo de nivel medio, lo más complejo a mi parecer ha sido la integración con travis debido a que no lo hemos conseguido integrar por problemas con la cuenta gratuita. 
También hemos tenido problemas al intentar separar los test en distintas clases, debido a que la ejecución en concurrencia de los test provocaba fallos, debido al uso del patrón de diseño Singleton en la clase ReusablePool
 
 
**¿Cuál es el número de fallos encontrados en el código?**   
Se han encontrado 0 fallos 
 
----
 
## Proceso de realización de la práctica 
 
Lo primero que hicimos fue hacer un fork del repositorio original y preparar el esquema de la clase de test.
Después nos registramos en Travis y Codecov. Con Codecov no tuvimos ningún problema, pero Travis ha supuesto un problema, debido a que la opción de cuenta gratuita para estudiantes no podía ser seleccionada en nuestro caso (ya que nos salía un mensaje de error )   
![Imagen de error en Travis ](https://imgur.com/ZMf01wa.png)  
 
El siguiente paso fue dividir el trabajo y la realización de los métodos de test.
 
Una vez realizados estos pasos, hicimos el primer comit para probar si funciona bien la integración con las acciones de GitHub, en concreto si se pasan los test unitarios.
 
Lo siguiente fue realizar la implementación de los test de los métodos requeridos.
 
Por último se ha intentado 'optimizar' el código para obtener unos mejores resultados en la cobertura de Codecov
 
![Informacion de Codecov ](https://imgur.com/lcDJbjd.png)  
 
Eclipse nos proporciona estos resultados respecto a la cobertura  
 
[![https://imgur.com/RrYew4y.png](https://imgur.com/RrYew4y.png)](https://imgur.com/RrYew4y.png)
 
 
 
 
 
 


