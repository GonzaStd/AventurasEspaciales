# Diagrama de clases (Mermaid)

digraph G {}

```mermaid
classDiagram
    class Jugador {
        - String nombre
        - int porcentajeEnergia
        - int creditosEspaciales
        - Nave naveElegida
        - Planeta planetaActual
        - ArrayList<Mision> misionesCompletadas
        + Jugador(String, Nave)
        + minar()
        + viajar(Planeta)
        + descansar()
        + adquirirCreditos(int)
        + utilizarCreditos(int)
        + getNave()
        + getNombre()
        + getCreditos()
        + getEnergia()
        + yaCompletada(Mision)
    }

    class Nave {
        - int vida
        - String nombre
        - Velocidad velocidad
        - Bodega bodega
        + Nave(String, Velocidad, int)
        + getVelocidad()
        + getVida()
        + getBodega()
        + reparar(int)
        + aterrizar()
    }

    class Bodega {
        - ArrayList<Recurso> recursos
        - int capacidadMaxima
        + guardarRecurso(Recurso)
        + puedeGuardar(Recurso)
        + getCargaActual()
        + getRecursos()
        + retirarRecursos(Recurso, int)
        + venderTodo()
    }

    class Planeta {
        - Recurso[] recursos
        - double[] probabilidades
        + minado()
    }

    class Mision {
        + completar(Jugador)
        + getRecursosRequeridos()
        + getCantidadesRequeridas()
        + getRecompensa()
    }

    class Comerciante {
        - Jugador jugador
        + venderRecurso(Entrada)
        + repararNave(Entrada)
        + prepararViaje(Entrada)
        + verMisionesDisponibles()
        + completarMision(Entrada)
    }

    class Entrada {
        - Scanner s
        + seleccionarElemento(T[])
        + ingresarEntero(int,int)
        + ingresarTexto()
    }

    class Utilidades {
        + generarElementoProbabilidad(double[], T[])
        + generarRandom(int,int)
    }

    enum Recurso {
        MINERAL_COMUN, CRISTAL, NUCLEO_ENERGETICO, GAS, PLASMA, LAVA, OBSIDIANA
    }

    enum Velocidad {
        BAJA, MEDIA, ALTA
    }

    %% Relaciones
    Jugador "1" o-- "1" Nave : posee
    Nave "1" o-- "1" Bodega : contiene
    Jugador "1" o-- "*" Mision : completó
    Planeta "1" <|-- Rocoso
    Planeta "1" <|-- Gaseoso
    Planeta "1" <|-- Volcanico
    Mision <|-- RepararCasco
    Mision <|-- EstabilizarReactor
    Mision <|-- NucleoPrincipal
    Nave <|-- Fenix
    Nave <|-- Eclipse
    Nave <|-- Galaxian
    Peligro <|-- PirataEspacial
    Peligro <|-- Renegado
    Peligro <|-- TormentaCosmica
```
