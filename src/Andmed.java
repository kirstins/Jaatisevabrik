import java.util.ArrayList;

/**
 * Created by kirstin on 02/02/2017.
 */
public class Andmed {
    ArrayList<Integer> saadetud=new ArrayList<>();
    ArrayList<Integer> araostetud =new ArrayList<>();
    ArrayList<Integer> maksumus = new ArrayList<>();
    ArrayList<Integer> paevaKasum = new ArrayList<>();
    int kokkuValja;
    int kokkuOstetud;
    int omahind = 2;
    int indeks;
    int suurimaPaevaMuuk;


    public void lisaAndmed (int a, int b, int c){
        saadetud.add(a);
        araostetud.add(b);
        maksumus.add(c);
        paevaKasum.add((c-omahind)*b);

        for (int i=0; i<saadetud.size(); i++){
            System.out.println("Välja saadetud: " + saadetud.get(i) + " ,ostetud: " + araostetud.get(i) + " ,hind: " + maksumus.get(i)+ " ,päevakasum: "+paevaKasum.get(i));

            }

        }

    public int kokkuValjaSaadetud(){
        kokkuValja=0;
        for (int i=0; i<saadetud.size(); i++){
            kokkuValja +=saadetud.get(i);
        }
        return kokkuValja;
    }
    public int kokkuAraOstetud(){
        kokkuOstetud=0;
        for (int i=0; i<araostetud.size(); i++){
            kokkuOstetud +=araostetud.get(i);
        }
        return kokkuOstetud;

    }
    public int seisevKaup(){
        int seisev=kokkuValja-kokkuOstetud;
        return seisev;
    }
    public int statistikatPeetud(){
        int statistika = saadetud.size();
        return statistika;
    }

    public int kasumKokku(){
        int kasum=0;
        for (int i=0; i<saadetud.size(); i++){
            kasum += (maksumus.get(i)-omahind)*araostetud.get(i);

        }
        return kasum;
    }

   public int ideaalneHind(){

        int maxKasum=Integer.MIN_VALUE;

        for (int i=0; i<paevaKasum.size(); i++){
            if (paevaKasum.get(i)>maxKasum){
                maxKasum=paevaKasum.get(i);
                indeks=i;
                System.out.println(suurimaPaevaMuuk);
            }
        }
        return maksumus.get(indeks);

    }


}
