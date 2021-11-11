//package ar.edu.unahur
//
//import org.scalatest.BeforeAndAfterEach
//import org.scalatest.freespec.AnyFreeSpec
//import org.scalatest.matchers.should.Matchers
//
//class Estudiante(val name: String, var age: Int)
//
//class Etapa1Tests extends AnyFreeSpec with Matchers with BeforeAndAfterEach {
//  var repo: RepositorioEnMemoria[Estudiante] = null;
//
//  val guido = new Estudiante("Guido", 20)
//  val angel = new Estudiante("Angel", 25)
//
//  override protected def beforeEach(): Unit = {
//    super.beforeEach()
//    repo = new RepositorioEnMemoria[Estudiante]()
//  }
//
//  "Get" - {
//    "Get devuelve [] si no se agregó nada" in {
//      repo.get().size should be (0)
//    }
//
//    "Get devuelve Lista con 1 elemento si se agrego solo 1" in {
//      repo.store(guido)
//      val estudiantes = repo.get()
//      estudiantes.size should be (1)
//      estudiantes.head should be (guido)
//    }
//  }
//
//  "Store" - {
//    "Deberia guardar" in {
//      repo.store(guido)
//      val estudiantes = repo.get()
//      estudiantes.size should be (1)
//    }
//
//    "No deberia guardar 2 veces al mismo" in {
//      repo.store(guido)
//      repo.store(guido)
//      val estudiantes = repo.get()
//      estudiantes.size should be (1)
//    }
//  }
//
//  "Has" - {
//    "Has en repo vacio deberia dar false" in {
//      repo.has(guido) should be (false)
//    }
//
//    "Has devuelve true si esta guardado" in {
//      repo.store(guido)
//      repo.has(guido) should be (true)
//    }
//
//    "Has devuelve false si no esta guardado" in {
//      repo.store(guido)
//      repo.has(angel) should be (false)
//    }
//  }
//
//  "Delete" - {
//    "Delete en repo sin datos no debe fallar" in {
//      val cantidadInicial = repo.get().size
//      repo.delete(guido)
//      val cantidadFinal = repo.get().size
//      cantidadFinal should be (cantidadInicial)
//    }
//
//    "Delete en repo solo con ese elemento debe eliminarlo" in {
//      repo.store(guido)
//      val cantidadInicial = repo.get().size
//      repo.delete(guido)
//      val cantidadFinal = repo.get().size
//      cantidadFinal should be (cantidadInicial - 1)
//    }
//
//    "Delete en repo sin ese elemento no debe fallar" in {
//      repo.store(guido)
//      val cantidadInicial = repo.get().size
//      repo.delete(angel)
//      val cantidadFinal = repo.get().size
//      cantidadFinal should be (cantidadInicial)
//    }
//
//    "Delete en repo con varios elementos debe eliminarlo" in {
//      repo.store(guido)
//      repo.store(angel)
//      val cantidadInicial = repo.get().size
//      repo.delete(guido)
//      val cantidadFinal = repo.get().size
//      cantidadFinal should be (cantidadInicial - 1)
//    }
//  }
//}
