/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1utt;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vsa
 */
public class T1utt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t1uttPU");
        EntityManager em = emf.createEntityManager();
        
        //Query q = em.createNativeQuery("select * from KNIHA", Kniha.class);
        //List<Kniha> knihy = q.getResultList();
                        
        
        //em.getTransaction().begin();      /// zaciatok transakcie
        
        /*for(Kniha k: knihy){
            System.out.println("" + k);
            k.setCena(k.getCena()*0.5);
            System.out.println(""+k);
        }*/
        //em.getTransaction().commit();     /// koniec transakcie pre commit novych hodnot do databazy
        //em.refresh(knihy.get(0));         /// vratenie povodnych hodnot do databazy
        //System.out.println(""+knihy.get(0));
        //System.out.println(""+knihy.get(1));
        
        
        //Kniha k = em.find(Kniha.class, "The Guards of the Galaxy");
        //System.out.println(k);
        
                            /*** PRIKLAD NA CLEAR() ***/
                            
        /**Kniha k = em.find(Kniha.class, "The Guards of the Galaxy");
        System.out.println(k);
        k.setCena(0.5 * k.getCena());
        System.out.println(k);
        em.clear();           /// clear() prestanu byt menezovane, em nacita udaje, kt. su v databaze
        
        Kniha k2 = em.find(Kniha.class, "The Guards of the Galaxy");
        System.out.println(k);
        System.out.println(k2);
        System.out.println(k==k2); /// vrati true, ak odstranime em.clear(), inak false**/
        
        
                            /*** PRIKLAD NA Detach() ***/
                           
        Kniha k = new Kniha();
        em.getTransaction().begin();
        k.setNazov("Smely Zajko");
        k.setCena(1.8);
        k.setDostupnost(Kniha.Dostupnost.DO3DNI);
        em.persist(k);
        em.getTransaction().commit();
        
        
        
        /**
         * Pozor!
         * Entity manager pracuje s operacnou pamatou
         * v liste knihy zmeni hodnoty, a s nimi pracuje
         * automaticky neuklada hodnoty do databazy
         * pre ulozenie je potrebne pouzit: 'em.getTransaction().commit();'
         **/
    }
    
}
