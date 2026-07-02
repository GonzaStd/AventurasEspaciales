package Principal;

import Peligros.*;
import Misiones.*;
import Planetas.*;
import Naves.*;

public class Constantes {
    public static final Peligro[] PELIGROS = {
            new PirataEspacial(),
            new Renegado(),
            new TormentaCosmica()
    };

    public static final Mision[] MISIONES = {
            new RepararCasco(),
            new EstabilizarReactor(),
            new NucleoPrincipal()
    };

    public static final Planeta[] PLANETAS = {
            new Rocoso(),
            new Gaseoso(),
            new Volcanico()
    };

    public static final Nave[] NAVES = {
            new Fenix(),
            new Eclipse(),
            new Galaxian()
    };
}
