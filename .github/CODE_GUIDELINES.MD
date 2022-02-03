# GUÍA DE ESTILO DE JAVA

### Tabla de contenidos

# 1. Introducción

Está guía está basada en la [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) añadiendo algunas modificaciones para este proyecto concreto.

## 1.1. Notas de terminología

En este documento, a no ser que se clarifique:

- El termino _clase_ se utilizará para hablar de clases, enums o interfaces.
- El término _miembro_ (de una clase) se usará para clases anidadas, métodos y demás contenidos incluidos dentro de una clase excepto comentarios e inicializadores.
- El termino _comentario_ se refiere a comentarios de implementación. En caso de referirse a "comentarios de documentación" hablaremos de _javadoc_.

# 2. Bases de los ficheros fuente

## 2.1. Nombre del fichero

El nombre del fichero consistirá del nombre de la clase de mayor nivel que contenga, igualado en mayúsculas y minúsculas, más la extensión ` .java`

# 3. Estructura de archivos

## 3.1 Declaraciones de clases

Cada clase debe encontrarse en su propio archivo.

### 3.1.1 Ordenación de los contenidos de una clase

Esto se decidirá en algún momento, mi sugerencia es hacerlo por

- Atributos
- Constructores
- Getters / setters
- Métodos ordenados por tipo de return

# 4. Formato

## 4.1. Llaves

### 4.1.1. Llaves en controles de lógica

Utilizaremos las llaves en `if`, `else`, `for`, `do` y `while`, incluso cuando el cuerpo esté vacío o solo contenga una línea.

### 4.1.2. Bloques no vacíos: estilo K & R

Las llaves seguirán el [estilo Kernighan y Ritchie](https://blog.codinghorror.com/new-programming-jargon/) para todos los bloques no vacíos de código.

- Sin salto de línea antes de la primera llave.
- Salto de línea tras la primera llave.
- Salto de línea antes de la última llave.
- Salto de línea tras la última llave, solo si se termina el bloque o el método, constructor o clase.

Ejemplo:

```java


class MyClass {
    metodo1() {
        while(condition()) {
            metodo();
        }
    }
}
```

### 4.1.3. Bloques vacíos: mejor ser conciso

Para los bloques vacíos intentaremos ser lo más concisos posible, utilizando el modelo [K & R](http://www.codinghorror.com/blog/2012/07/new-programming-jargon.html), o poniendo en la misma línea que el comienzo del bloque ambas llaves `metodo() {}`

Ejemplos:

```java
// Esto es aceptable
void medoto() {}
// Esto también
void metodo2(){
}
```

## 4.2. Identación de bloques: +4 espacios

Cada vez que introduzcamos un bloque dentro de otro introduciremos 4 espacios al identado. Cuando el bloque termina volveremos al nivel de identación anterior. (Mirar el ejemplo en la sección 4.1.2. [Bloques no vacíos: estilo Allman](#4.1.2.-Bloques-no-vacíos:-estilo-Allman).)

## 4.3. Una declaración por línea

Tras cada `;` añadiremos un salto de línea.

## 4.4. Espacios en blanco

### 4.4.1. Espacios verticales

Dejaremos una sola linea en blanco cuando:

- Acabemos un bloque de un método.
- Cuando cambiemos de grupo de organización (un espacio entre el conjunto de atributos y constructores, por ejemplo).
- En cualquier sitio donde mejore la legibilidad del código.

### 4.4.2. Espacios horizontales

A parte de donde lo requiera el lenguaje para sus palabras reservadas, comentarios y javadoc:

- Separando los condicionales y bucles del parentesis de la condición.
- A ambos lados de un operador ternario `if( this && that)`
- Detrás de un `//` para comenczar un comentario

## 4.5. Declaración de variables

Se declarará una variable por linea: declaraciones como `int a, b;` no se usarán. Como unica excepción será la declaración de varaibles para un for.

# 5. Nombres

## 5.1. Reglas por tipo de identificador

### 5.1.1. Paquetes

Los paquetes tendrán nombres totalmente en minúsuclas, con todas las palabras del paquete juntas sin espacios ni barras bajas.

### 5.1.2. Nombres de clases

Los nombres de las clases los pondremos en `UpperCamelCase`. Ejemplo: `MyClass`.

### 5.1.3. Nombres de constantes

Las variables constantes usaran `CONSTANT_CASE`: todo en mayúscula con cada palabra separada por una barra baja. `String CONSTANT_MESSAGE`.

### 5.1.4. Nombres de atributos no constantes

Los atributos no constantes utilizaran `lowerCamelCase` precedidos de una barra baja. Ejemplo: `int cantidadDinero`.

### 5.1.5. Varaibles locales y parámetros de funciones

Utilizarán `lowerCamelCase`.

# 6. Prácticas de programación

## 6.1. `@Override`: siempre usado

Todos los métodos que puedan utilizar legalmente la notación `@Override` de forma legal deberán usarlo. Esto inclute cuando el método de una clase anula el de una clase superior o el de una interfaz.

## 6.2. Excepción controlada: no ignorada

Si en un `try/catch` controlamos una excepción, siempre debemos hacer algo con ella.

## 6.3. Miembros estáticos: siempre desde la clase

Cuando referenciemos una miembro estático de una clase, debemos hacerlo desde la clase y no desde una instancia de la misma.

Ejemplo:

```java
MyClass aClass = ...;
MyClass.metodoEstatico() // bien
aClass.metodoEstatico() // mal
algoQueInstanciaaClass().metodoEstatico() // bastante mall
```

# 7. Javadoc

## 7.1. Formato

### 7.1.1. Forma general

El formato básico de Javadoc será:

```java
/**
 * Varias lineas de javadoc,
 * escritas asi
 */
public void method(){...}
```

O en una sola línea:

```java
/** Un Javadoc muy corto*/
```

### 7.1.2. Paragrafo

Para diferenciar entre dos paragrafos dejaremos una linea en blanco con un `*`.

### 7.1.3. Etiquetas de bloque

Utilizaremos los bloques `@param`, `@return`, `@throws`, en ese orden. Si la descripción ocupa más de una línea dejaremos un espacio para alinear la linea con el `@`.

### 7.1.4. El resumen

Todo Javadoc tiene que empezar con un resumen de lo que hace la función o clase que se quiera documentar. Este fragmento es importante ya que es lo que se mostrará en los indices, en la documentación y en el autocompletado.

### 7.2. Donde usar Javadoc

Javadoc debe estar presente en el comienzo de las clases para explicar que hacen y antes de métodos.
