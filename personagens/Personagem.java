
    public abstract class Personagem {

        private TipodeLuta TipodeLuta;

        public Personagem(TipodeLuta TipodeLuta) {
            this.TipodeLuta = TipodeLuta;
        }
        public void lutar(){
            TipodeLuta.Lutar();
        }

        public void setTipodeLuta(TipodeLuta TipodeLuta) {
            this.TipodeLuta = TipodeLuta;
        }
    }

