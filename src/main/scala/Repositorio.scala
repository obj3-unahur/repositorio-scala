package ar.edu.unahur

trait Repositorio[T] {
  // Devuelve todos los elementos
  def get(): List[T]

  // Te permite chequear la existencia de un elemento.
  def has(t: T): Boolean

  // Te permite guardar un nuevo elemento.
  def store(t: T): Unit

  // Te permite eliminar al elemento t.
  def delete(t: T): Unit

  // Te devuelve todos los elementos que cumplan la condición.
  def get(condicion: Function[T, Boolean]): List[T]

  // Te permite actualizar todos los elementos que cumplan la condicion.
  def update(
              actualizacionARealizar: T => Unit,
              condicion: Function[T, Boolean]
            ): Unit

  // Te permite eliminar a todos los elementos que cumplan la condicion.
  def delete(condicion: Function[T, Boolean]): Unit

  // Te devuelve el elemento t que tenga el id pasado.
  def get(id: Int): T

  // Te permite actualizar el elemento que tenga el id pasado.
  def update(
              actualizacionARealizar: T => Unit,
              id: Int
            ): Unit
}