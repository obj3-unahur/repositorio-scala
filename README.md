# Repositorio - scala

![portada](assets/cover.jpeg)

En este TP tenemos definido el **trait Repositorio** (cuyos métodos **NO** se pueden modificar). Este trait nos brinda los métodos necesarios para poder interactuar desde el programa con distintos tipos de Repositorios (abstrayéndonos de cómo y dónde guarden los datos de la base de datos).

Lean bien en el enunciado y en el trait qué se espera que reciba y devuelva cada uno de estos métodos.

La implementación que debemos realizar es la de un **RepositorioEnMemoria** que va a poder ser instanciado para distintas clases que querramos utilizar. Este Repositorio va a contener los elementos que vayamos guardando durante la ejecución del programa, pero al momento de finalizar la ejecución, se perderán los datos.

## Etapa 1

En la Etapa 1 vamos a tener que implementar los siguientes métodos:

1. Hacer el método `get` sin parámetros, que nos debe devolver toda la lista de elementos que contenga el Repositorio.
2. Hacer el método `has` (ver si está) que devuelve `true` o `false` dependiendo si el elemento se encuentra guardado en el Repositorio.
3. Hacer el método `store`, que nos permite guardar un nuevo elemento en el Repositorio. Este método devuelve `true` si pudo guardar el nuevo elemento o `false` si el mismo elemento ya se encontraba en el Repositorio.
4. Hacer el método `delete` que recibe el elemento a eliminar, y lo remueve de la base de datos.

## Etapa 2

En esta segunda Etapa vamos a tener que implementar los métodos que trabajan con condiciones:

1. Implementar el método `get` que recibe la condición que deben cumplir los elementos.
2. Implementar el método `update`, que además de la condición, recibe la forma en que deben actualizarse dichos elementos.
3. Implementar el método `delete` que recibe la condición.

## Etapa 3

En la Etapa 3 vamos a implementar los métodos del trait que trabajan sobre una instancia específica, que se identifica por un número de id:

1. Realizar el método `get` que recibe un id y devuelve el elemento con la misma identificación.
2. Realizar el método `update`, que además del id, recibe la forma en que debe actualizarse dicho elemento.

---

Al finalizar, deberían poder ejecutar algo así:

```scala
class Estudiante(var nombre: String, var edad: Int)

val repoEstudiantes = new RepositorioEnMemoria[Estudiante]

val juancito = new Estudiante("Juan Pérez", 28)

repoEstudiantes.store(juancito)
repoEstudiantes.get(e => e.nombre.contains("Juan"))
// devuelve una lista que contiene a juancito
```