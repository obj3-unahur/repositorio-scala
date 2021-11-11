package ar.edu.unahur

import java.util.NoSuchElementException

class RepositorioEnMemoria[T] extends Repositorio[T] {
  override def get(): List[T] = ???

  override def has(t: T): Boolean = ???

  override def store(t: T): Unit = {}

  override def delete(t: T): Unit = throw new NoSuchElementException

  override def get(condicion: Function[T, Boolean]): List[T] = ???

  override def update(actualizacionARealizar: T => Unit, condicion: Function[T, Boolean]): Unit = ???

  override def delete(condicion: Function[T, Boolean]): Unit = ???

  override def get(id: Int): T = ???

  override def update(actualizacionARealizar: T => Unit, id: Int): Unit = ???
}
