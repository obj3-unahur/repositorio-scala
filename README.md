# Repositorio - scala

![portada](assets/cover.jpeg)

## Descripción del dominio

En muchas de las aplicaciones que construimos a diario, tarde o temprano surge la necesidad de _persistir_ los datos con los que se trabaja, para poder seguir utilizándolos más tarde. Imaginensé un sistema de facturación al que haya que cargarle los productos y clientes todos los días o una red social en la que día a día tengamos que volver a agregar a nuestras amistades... 🙄

Cuando trabajamos con el paradigma de objetos, un patrón común para persistir la información es modelar un objeto que va a oficiar de **repositorio** de los modelos de nuestra aplicación. Este repositorio tiene que soportar las operaciones comunes para acceder a los datos: guardar, cargar, buscar, eliminar, etc. e idealmente debería, _de alguna forma_ asegurarse de que esos objetos no se pierdan cuando el programa deja de ejecutarse. 

En este trabajo exploraremos la implementación de un `RepositorioEnMemoria`, que va a poder ser instanciado para distintas clases que querramos utilizar. Este Repositorio va a contener los elementos que vayamos guardando durante la ejecución del programa, pero al momento de finalizar la ejecución se perderán los datos. De todos modos, el ejercicio será útil para entender cómo podría construirse esta abstracción.


### Etapa 1 - métodos básicos

En el código que viene con el TP tenemos definido el **trait Repositorio**, cuyos métodos **NO** se pueden modificar (al menos hasta la etapa 3). Este trait nos brinda una posible interfaz que debería tener un repositorio para poder interactuar con él desde el programa, abstrayéndonos de cómo y dónde se guarden esos datos.

En esta etapa tienen que crear una clase `RepositorioEnMemoria[T]`, que implemente los siguientes métodos:

1. `get()`, que nos debe devolver toda la lista de elementos que contenga el Repositorio.
2. `has(element)` que devuelve `true` si el elemento se encuentra guardado en el Repositorio o `false` en caso contrario.
3. `store(element)`, que guarda el elemento en el Repositorio. **Ojo:** si el elemento ya existía no debe volver a guardarse. Para informar el resultado, el método devuelve `true` si pudo guardar el nuevo elemento o `false` si el mismo elemento ya se encontraba en el Repositorio.
4. `delete(element)` que recibe el elemento a eliminar, y lo elimina del repositorio.

☝️ Para que terminen de comprender cómo se tiene que comportar el repositorio, les dejamos una suite completa de tests en el archivo `Etapa1Tests.scala`. Esas pruebas deberían pasar cuando completen esta etapa.

### Etapa 2 - métodos con condiciones

Vamos a agregar a nuestro repositorio algunos métodos que reciben funciones por parámetro:

1. `get(condicion)`, que devuelve una lista con los elementos que cumplen la `condición`,
2. `update(condicion, actualizacion)`, que aplica la función de `actualización` **únicamente** a los elementos que cumplen con la `condición`,
3. `delete(condicion)`, que elimina todos los elementos que cumplen la condición.

Para más detalles sobre qué deben devolver estos métodos, lean los comentarios que están en el trait `Repositorio[T]`.

### Etapa 3 - elementos con id

Vamos a agregar ahora una restricción a nuestro repositorio: todos los elementos que allí se guarden deberán tener un atributo `id` de tipo entero. 

1. Modificar el trait `Repositorio[T]` para que solamente acepte objetos que tengan un atributo `id` de tipo entero.
1. Agregar el método `get(id)`, que devuelve el elemento cuyo id coincide con el parámetro.
2. Agregar el método `update(id, actualizacion)`, que aplica la función de `actualizacion` sobre el elemento que coincida con el `id` especificado.

Para más detalles sobre qué deben devolver estos métodos, lean los comentarios que están en el trait `Repositorio[T]`.

### Bonus: Etapa 4

En esta etapa se busca la posibilidad de realizar una forma de **OneToMany**. Para esto, se debe agregar la siguiente definición al trait **Repositorio**
```scala
def oneToMany[U](elementos: List[(Int, U)]): mutable.HashMap[T, List[U]]
```

En este método, recibimos una lista de tuplas, donde cada tupla contiene el id del elemento T y un elemento de clase U. Al ejecutarlo, debemos retornar un HashMap en donde cada instancia de T que estén guardados en el repositorio sean las claves, y como valor, debe poseer una Lista de elementos U que contenga todos los valores que corresponden con su id (o una lista vacía si no había elementos U para el id del elemento T correspondiente).
