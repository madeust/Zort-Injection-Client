//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

public class Timer {
    private long prevMS = 0L;

    public boolean delay(double d) {
        return (this.getTime() - this.prevMS) >= d;
    }

    public void reset() {
        this.prevMS = this.getTime();
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public long getDifference() {
        return this.getTime() - this.prevMS;
    }
}