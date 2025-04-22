public interface TipodeLuta {
    void lutar();
}

public class LutaComArco implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("lutando com arco e flecha");
    }
}

public class LutaComEspada implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("Lutando com espada");
    }
}

public class LutaComMachado implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("lutando com machado");
    }
}
public class LutaComFaca implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("lutando com faca");
    }
}
public class LutaComFoice implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("lutando com foice");
    }
}
public class LutaComMagia implements TipodeLuta {
    @Override
    public void lutar() {
        System.out.println("lutando com magia");
    }
}
